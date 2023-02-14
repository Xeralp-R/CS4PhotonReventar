package q3ex11.utils;

/*
 * Thank you to Matt Aboset for this code
 */

public class DoublyLinkedNode<T> {

    protected DoublyLinkedNode<T> next; //next node reference
    protected DoublyLinkedNode<T> previous; //previous node reference
    protected T data; //data in the node

    //DLLNode constructor with one argument
    public DoublyLinkedNode(T data) {
        this.data = data;
        next = null;
        previous = null;
    }

    //returns the next node in this list
    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    //sets the next node in the list
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    //returns the data in this node
    public T getData() {
        return data;
    }

    //sets the data in this node
    public void setData(T data) {
        this.data = data;
    }

    //gets the previous node in this list
    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    //sets the previous node in this list
    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }
}
