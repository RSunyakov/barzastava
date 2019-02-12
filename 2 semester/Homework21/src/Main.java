import java.io.InvalidClassException;

public class Main {
    public static void main(String[] args) throws InvalidClassException {
        Queue<String> que = new Queue<>();
        que.enqueue("keeek");
        que.enqueue("kkek2");
        que.enqueue("kek3");
        System.out.println(que.dequeue());
    }
}
