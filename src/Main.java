public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // Insertar valores
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("=== RECORRIDOS DEL ARBOL ===");

        System.out.print("In-Order: ");
        bst.inOrder();

        System.out.print("Pre-Order: ");
        bst.preOrder();

        System.out.print("Post-Order: ");
        bst.postOrder();

        // Buscar valores
        System.out.println("\n=== BUSQUEDA ===");

        System.out.println("Buscar 40: " + bst.search(40));
        System.out.println("Buscar 100: " + bst.search(100));

        // Eliminar nodo hoja
        System.out.println("\n=== ELIMINAR NODO HOJA (20) ===");
        bst.delete(20);

        System.out.print("In-Order: ");
        bst.inOrder();

        // Eliminar nodo con un hijo
        System.out.println("\n=== ELIMINAR NODO CON UN HIJO (30) ===");
        bst.delete(30);

        System.out.print("In-Order: ");
        bst.inOrder();

        // Eliminar nodo con dos hijos
        System.out.println("\n=== ELIMINAR NODO CON DOS HIJOS (70) ===");
        bst.delete(70);

        System.out.print("In-Order: ");
        bst.inOrder();
    }
}