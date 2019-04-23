public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.print(data);
        System.out.print("  ");

    }
}
