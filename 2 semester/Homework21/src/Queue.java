import java.io.InvalidClassException;

public class Queue<T> {
    private Node<T> first = null;
    private Node<T> last = null;

    public void enqueue(T elem) {
        Node<T> oldLast = last;
        last = new Node<>(elem);
        last.data = elem;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public T dequeue() throws InvalidClassException {
        if (first == null) {
            throw new InvalidClassException("The queue is empty");
        }
        Node<T> newFirst = first;
        first = first.next;
      return newFirst.data;
    }

    public boolean isEmpty() {
        return first == null;
    }


}
