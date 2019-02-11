import java.util.LinkedList;

public class Stack {
    private LinkedList<Character> linkedlist;

    public Stack() {
        linkedlist = new LinkedList<>();
    }

    public void push(char c) {
        linkedlist.add(c);
    }

    public Character pop() {
        return linkedlist.getLast();
    }

    public boolean isEmpty() {
        return linkedlist.isEmpty();
    }
}