
public class Stack<T> {
    private TLinkedList<T> linkedList;

    public Stack(TLinkedList<T> linkedList) {
        this.linkedList = linkedList;
    }

    public void push(T data) {
       linkedList.insertFirst(data);
    }

    public void pop() {
        while(!linkedList.isEmpty()){
            linkedList.deleteFirst();
        }
    }

    public void displayStack() {
        System.out.println("  ");
        linkedList.displayList();
    }
}