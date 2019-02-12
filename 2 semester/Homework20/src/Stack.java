
public class Stack<T> {
    private Node<T> first = null;

    public void push(T data) {
        Node<T> n = new Node<>(data);
        n.next = first;
        first = n;
    }

    public T pop() {
        if (!this.isEmpty()) {
            Node<T> temp = first;
            first = first.next;
            return temp.data;
        }
        return null;
    }

    public boolean isEmpty() {
        return (first == null);
    }
}