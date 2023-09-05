
public interface DequeInterface<T>
{
   /** Adds a new entry to the front/back of this deque.
       @param newEntry  An object to be added. */
   public void addToFront(T newEntry);
   public void addToBack(T newEntry);
   
   /** Removes and returns the front/back entry of this deque.
       @return  The object at the front/back of the deque.
       @return  null if the deque is empty before the
                operation. */
   public T removeFront();
   public T removeBack();
   
   /** Retrieves the front/back entry of this deque.
       @return  The object at the front/back of the deque.
       @return  null if the deque is empty. */
   public T getFront();
   public T getBack();
   
   /** Detects whether this deque is empty.
       @return  True if the deque is empty, or false otherwise. */
   public boolean isEmpty();
   
   /*  Removes all entries from this deque. */
   public void clear();
   
   /** Returns number of items currently stored in the Deque.
   	   @return an int equal to the logical size of the Deque.  */
   public int size();
   
    /** Returns total capacity of the Deque, counting used and unused
        locations.  Note that this method would NOT typically be part
        of this interface.  It was added solely for testing and grading
        purposes.
   	   @return an int equal to the capacity of the Deque.  */ 
   public int capacity();
   
} // end DequeInterface
