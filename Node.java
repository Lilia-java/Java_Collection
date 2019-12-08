public class Node<N> {
    N element;
    Node<N> next;
    Node<N> prev;

    Node( N element,  Node<N> prev,Node<N> next)
    {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}