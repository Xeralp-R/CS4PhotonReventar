package structures;

/*
 * Thank you to Matt Aboset for this code
 */

public class DLLNode<T> {
    protected DLLNode<T> next;        //next node reference
	protected DLLNode<T> previous;    //previous node reference
	protected T data;				  //data in the node
	
    //DLLNode constructor with one argument
	public DLLNode(T data) 
	{   
		  this.data = data;
	      next = null;
	      previous = null;
	}

    //returns the next node in this list
	public DLLNode<T> getNext()
	{
		return next;
	}

    //sets the next node in the list
	public void setNext(DLLNode<T> next) 
	{
		this.next = next;
	}

    //returns the data in this node
	public T getData() 
	{
		return data;
	}

    //sets the data in this node
	public void setData(T data) 
	{
		this.data = data;
	}
	
    //gets the previous node in this list
	public DLLNode<T> getPrevious() 
	{
		return previous;
	}
	
    //sets the previous node in this list
	public void setPrevious(DLLNode<T> previous) 
	{
		this.previous = previous;	
	}
}
