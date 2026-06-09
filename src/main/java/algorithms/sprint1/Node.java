package algorithms.sprint1;

// Template class required by the original contest task signature.
class Node<V> {
    public V value;
    public Node<V> next;

    Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}
