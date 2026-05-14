public class BinarySearchTree {

    private Node root;

    // Insertar un valor
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // Buscar un valor
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node current, int value) {

        if (current == null) {
            return false;
        }

        if (current.value == value) {
            return true;
        }

        if (value < current.value) {
            return searchRecursive(current.left, value);
        }

        return searchRecursive(current.right, value);
    }

    // Eliminar un valor
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {

        if (current == null) {
            return null;
        }

        // Buscar el nodo
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }

        // Caso 1: nodo sin hijos
        if (current.left == null && current.right == null) {
            return null;
        }

        // Caso 2: nodo con un hijo
        if (current.right == null) {
            return current.left;
        }

        if (current.left == null) {
            return current.right;
        }

        // Caso 3: nodo con dos hijos
        int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;

        current.right = deleteRecursive(current.right, smallestValue);

        return current;
    }

    // Obtener el valor menor
    private int findSmallestValue(Node root) {

        return root.left == null
                ? root.value
                : findSmallestValue(root.left);
    }

    // Recorrido In-Order
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node current) {

        if (current != null) {
            inOrderRecursive(current.left);
            System.out.print(current.value + " ");
            inOrderRecursive(current.right);
        }
    }

    // Recorrido Pre-Order
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node current) {

        if (current != null) {
            System.out.print(current.value + " ");
            preOrderRecursive(current.left);
            preOrderRecursive(current.right);
        }
    }

    // Recorrido Post-Order
    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node current) {

        if (current != null) {
            postOrderRecursive(current.left);
            postOrderRecursive(current.right);
            System.out.print(current.value + " ");
        }
    }
}