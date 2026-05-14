import java.util.ArrayList;
import java.util.List;

/**
 * Árbol Binario de Búsqueda (BST) implementado desde cero.
 * Menores a la izquierda · Mayores a la derecha.
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // ─────────────────────────────────────────────
    //  INSERT
    // ─────────────────────────────────────────────

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) return new Node(value);

        if (value < current.value) {
            current.left  = insertRecursive(current.left,  value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        // valor duplicado: no se inserta
        return current;
    }

    // ─────────────────────────────────────────────
    //  SEARCH
    // ─────────────────────────────────────────────

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node current, int value) {
        if (current == null) return false;
        if (value == current.value) return true;

        return value < current.value
                ? searchRecursive(current.left,  value)
                : searchRecursive(current.right, value);
    }

    // ─────────────────────────────────────────────
    //  DELETE
    // ─────────────────────────────────────────────

    public boolean delete(int value) {
        if (!search(value)) return false;
        root = deleteRecursive(root, value);
        return true;
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) return null;

        if (value < current.value) {
            current.left  = deleteRecursive(current.left,  value);
        } else if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
        } else {
            // Caso 1: nodo hoja
            if (current.left == null && current.right == null) return null;

            // Caso 2: un solo hijo
            if (current.left  == null) return current.right;
            if (current.right == null) return current.left;

            // Caso 3: dos hijos → sucesor in-order (mínimo del subárbol derecho)
            int successor    = findMinValue(current.right);
            current.value    = successor;
            current.right    = deleteRecursive(current.right, successor);
        }
        return current;
    }

    private int findMinValue(Node node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    // ─────────────────────────────────────────────
    //  TRAVERSALS
    // ─────────────────────────────────────────────

    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private void inOrderRecursive(Node current, List<Integer> result) {
        if (current == null) return;
        inOrderRecursive(current.left,  result);
        result.add(current.value);
        inOrderRecursive(current.right, result);
    }

    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    private void preOrderRecursive(Node current, List<Integer> result) {
        if (current == null) return;
        result.add(current.value);
        preOrderRecursive(current.left,  result);
        preOrderRecursive(current.right, result);
    }

    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderRecursive(root, result);
        return result;
    }

    private void postOrderRecursive(Node current, List<Integer> result) {
        if (current == null) return;
        postOrderRecursive(current.left,  result);
        postOrderRecursive(current.right, result);
        result.add(current.value);
    }

    // ─────────────────────────────────────────────
    //  UTILITIES
    // ─────────────────────────────────────────────

    public boolean isEmpty() {
        return root == null;
    }
}