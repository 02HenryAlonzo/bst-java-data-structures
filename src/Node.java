/**
 * Representa un nodo dentro del Árbol Binario de Búsqueda.
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left  = null;
        this.right = null;
    }
}