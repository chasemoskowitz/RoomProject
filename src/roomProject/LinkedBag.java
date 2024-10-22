package roomProject;
/**
 * 
 * @author Chase Moskowitz
*/


public class LinkedBag<E extends Comparable<E>>
{
    private Node<E> head;
    private Node<E> tail;
    private int numElements;
    
    /**
     * No arg Constructor
     */
    public LinkedBag ()
    {
       head=null;
       tail=null;
       numElements=0;
    }
    
    /**
     * The getSize method gets the number of elements in the linked list
     * @return the total number of elements in the linked list
     */
    public int getSize()
    {
       return numElements;
    }
    
    /**
     * The add method adds an element to the linked list in order
     * @param newElement is the new element being added to the list
     */
    public void add (E newElement)
    {
   
        if (head == null) 
        {
			
            head = new Node<>(newElement, null);
	}
		
	else 
        {
			
            if (newElement.compareTo(head.getData()) <= 0) 
            {
				
                head = new Node<>(newElement, head);
            }
			
	    else 
            {
				
	        Node<E> previous = head;
		Node<E> current = head.getNext();
				
	        while (current != null && newElement.compareTo(current.getData()) > 0) 
                {
					
                  previous = current;
                  current = current.getNext();
	        }
				
	        Node<E> node = new Node<>(newElement, current);
	        previous.setNext(node);
	    } 
	}
		
	
        numElements ++;
        }
    
    /**
     * The exists method checks to see if a target element exists inside the linked list
     * @param target is the target element that the method checks for inisde the linked list
     * @return true if the target is inside, or false if it isn't inside the list
     */
    public boolean exists(E target)
    {
        boolean found = false;
        Node<E> cursor = head;
        
        while (cursor != null && !found)
        {
          if (cursor.getData().equals(target)) 
          { 
              found = true;
          }
          
          else
          {
              cursor = cursor.getNext();
          }
        } 
        return found;
        
    }
    
    /**
     * The remove method removes a target element from the list
     * @param target the target element to be deleted from the linked list
     * @return true if the target element was deleted, or false if it wasn't
     */
    public boolean remove(E target)
    {
        Node<E> cursor = head, previous = null;
        boolean found = false;

        while (cursor != null && !found) 
        {
            if (cursor.getData().equals(target)) 
            {
                found = true;
                
            } else {
                previous = cursor;
                cursor = cursor.getNext();
            }
        }

        if (found && cursor != null) 
        {
            if (previous == null)
            {
                head = head.getNext();
            } else {
                previous.setNext(cursor.getNext());
            }

            if (tail == cursor) {
                tail = previous;
            }
            numElements--;
        }

        return found;
    }
     /**
      * the countOccurrences method counts the number of times a target element
      * exists inside a linked list
      * @param target the element being counted up on inside the linked list
      * @return the number of times the target element exists inside the linked list
      */
     public int countOccurrences (E target)
    {
        int occurences=0;
        
        Node<E> cursor = head;
        
        while (cursor != null) 
        {
            if (cursor.getData().equals(target)) 
            {
                occurences++;
            }
                cursor = cursor.getNext();
            
        }
            
       return occurences;
    }
    
     
     
     
     /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new Lister<E>
     *
     * @return a Lister<E> using a copy of the linked list
     */
    public Lister<E> iterator() 
    {
// declare variables
        Node headOfListToReturn; // beginning of new "copied" list
        Node cursorOfListToCopy; // active node of list to copy
        Node lastNodeOfListToReturn; // end of new "copied" list
// establish the copied list
        headOfListToReturn = null;
        if (head != null) {
// create the head of the new list
            headOfListToReturn = new Node(head.getData(), null);
// use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
// use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getNext();
// if we have a node...
            while (cursorOfListToCopy != null) 
            {
// create a new node from the end of the new list
              lastNodeOfListToReturn.setNext(new Node(cursorOfListToCopy.getData(), null));
// move lastNodeOfListToReturn to the new last node
              lastNodeOfListToReturn = lastNodeOfListToReturn.getNext();
// move the cursorOfListToCopy to the next node
              cursorOfListToCopy = cursorOfListToCopy.getNext();
            }
        }
        return new Lister(headOfListToReturn);
    }

    

}