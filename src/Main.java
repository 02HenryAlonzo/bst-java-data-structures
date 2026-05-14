import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada del programa.
 * Menú interactivo para operar sobre el BST.
 */
public class Main {

    // ── Códigos ANSI ──────────────────────────────────────────────────────────
    private static final String RESET   = "\033[0m";
    private static final String BOLD    = "\033[1m";
    private static final String DIM     = "\033[2m";

    private static final String CYAN    = "\033[96m";
    private static final String GREEN   = "\033[92m";
    private static final String YELLOW  = "\033[93m";
    private static final String RED     = "\033[91m";
    private static final String MAGENTA = "\033[95m";
    private static final String BLUE    = "\033[94m";
    private static final String WHITE   = "\033[97m";

    // ── Separadores ───────────────────────────────────────────────────────────
    private static final String LINE_THIN  = DIM + "─".repeat(48) + RESET;
    private static final String LINE_THICK = CYAN + "═".repeat(48) + RESET;

    // ─────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        BinarySearchTree bst     = new BinarySearchTree();
        Scanner          scanner = new Scanner(System.in);
        boolean          running = true;

        printBanner();

        while (running) {
            printMenu();
            int option = readInt(scanner, "  Elige una opción");

            System.out.println();

            switch (option) {
                case 1 -> handleInsert(bst, scanner);
                case 2 -> handleSearch(bst, scanner);
                case 3 -> handleDelete(bst, scanner);
                case 4 -> handleTraversal(bst, "In-Order  (izq → raíz → der)", bst.inOrder());
                case 5 -> handleTraversal(bst, "Pre-Order (raíz → izq → der)", bst.preOrder());
                case 6 -> handleTraversal(bst, "Post-Order(izq → der → raíz)", bst.postOrder());
                case 7 -> { running = false; printGoodbye(); }
                default -> printWarning("Opción no válida. Elige entre 1 y 7.");
            }
        }

        scanner.close();
    }

    // ── Handlers ──────────────────────────────────────────────────────────────

    private static void handleInsert(BinarySearchTree bst, Scanner scanner) {
        int value = readInt(scanner, "  Valor a insertar");
        bst.insert(value);
        printSuccess("Valor " + BOLD + value + RESET + GREEN + " insertado correctamente.");
    }

    private static void handleSearch(BinarySearchTree bst, Scanner scanner) {
        int     value = readInt(scanner, "  Valor a buscar");
        boolean found = bst.search(value);

        if (found) {
            printSuccess("Valor " + BOLD + value + RESET + GREEN + " encontrado en el árbol. ✓");
        } else {
            printError("Valor " + BOLD + value + RESET + RED + " NO encontrado en el árbol. ✗");
        }
    }

    private static void handleDelete(BinarySearchTree bst, Scanner scanner) {
        int     value   = readInt(scanner, "  Valor a eliminar");
        boolean deleted = bst.delete(value);

        if (deleted) {
            printSuccess("Valor " + BOLD + value + RESET + GREEN + " eliminado correctamente.");
        } else {
            printError("Valor " + BOLD + value + RESET + RED + " no existe en el árbol.");
        }
    }

    private static void handleTraversal(BinarySearchTree bst, String label, List<Integer> values) {
        if (bst.isEmpty()) {
            printWarning("El árbol está vacío. Inserta valores primero.");
            return;
        }

        System.out.println(LINE_THIN);
        System.out.println("  " + MAGENTA + BOLD + label + RESET);
        System.out.println(LINE_THIN);
        System.out.print("  " + CYAN);

        for (int i = 0; i < values.size(); i++) {
            System.out.print(BOLD + values.get(i) + RESET + CYAN);
            if (i < values.size() - 1) System.out.print("  →  ");
        }

        System.out.println(RESET);
        System.out.println(LINE_THIN);
        System.out.println();
    }

    // ── UI Helpers ────────────────────────────────────────────────────────────

    private static void printBanner() {
        System.out.println();
        System.out.println(LINE_THICK);
        System.out.println(CYAN + BOLD + "  ██████╗ ███████╗████████╗" + RESET);
        System.out.println(CYAN + BOLD + "  ██╔══██╗██╔════╝╚══██╔══╝" + RESET);
        System.out.println(CYAN + BOLD + "  ██████╔╝███████╗   ██║   " + RESET);
        System.out.println(CYAN + BOLD + "  ██╔══██╗╚════██║   ██║   " + RESET);
        System.out.println(CYAN + BOLD + "  ██████╔╝███████║   ██║   " + RESET);
        System.out.println(CYAN + BOLD + "  ╚═════╝ ╚══════╝   ╚═╝   " + RESET);
        System.out.println();
        System.out.println(WHITE + BOLD + "  Árbol Binario de Búsqueda" + RESET);
        System.out.println(DIM   + "  Estructuras de Datos · Java" + RESET);
        System.out.println(LINE_THICK);
        System.out.println();
    }

    private static void printMenu() {
        System.out.println(LINE_THIN);
        System.out.println("  " + BOLD + WHITE + "MENÚ PRINCIPAL" + RESET);
        System.out.println(LINE_THIN);
        System.out.println("  " + YELLOW + " 1" + RESET + "  Insertar valor");
        System.out.println("  " + YELLOW + " 2" + RESET + "  Buscar valor");
        System.out.println("  " + YELLOW + " 3" + RESET + "  Eliminar valor");
        System.out.println("  " + BLUE   + " 4" + RESET + "  Recorrido In-Order");
        System.out.println("  " + BLUE   + " 5" + RESET + "  Recorrido Pre-Order");
        System.out.println("  " + BLUE   + " 6" + RESET + "  Recorrido Post-Order");
        System.out.println("  " + RED    + " 7" + RESET + "  Salir");
        System.out.println(LINE_THIN);
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print("  " + DIM + prompt + ": " + RESET + BOLD);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                System.out.print(RESET);
                return value;
            } catch (NumberFormatException e) {
                System.out.print(RESET);
                printWarning("Ingresa un número entero válido.");
            }
        }
    }

    private static void printSuccess(String message) {
        System.out.println("  " + GREEN + "✔  " + message + RESET);
        System.out.println();
    }

    private static void printError(String message) {
        System.out.println("  " + RED + "✘  " + message + RESET);
        System.out.println();
    }

    private static void printWarning(String message) {
        System.out.println("  " + YELLOW + "⚠  " + message + RESET);
        System.out.println();
    }

    private static void printGoodbye() {
        System.out.println(LINE_THICK);
        System.out.println(CYAN + BOLD + "  ¡Hasta luego! Buena suerte . 🎓" + RESET);
        System.out.println(LINE_THICK);
        System.out.println();
    }
}