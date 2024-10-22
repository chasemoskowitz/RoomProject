package roomProject;
/**
 * 
 * @author Chase Moskowitz
*/

public class Node<E> 
{
    private E data;
    private Node<E> link;
    
    /**
     * Constructor
     * @param initialData the initial data of the node
     * @param initialNext  the initial link to the next element in the node
     */
    public Node (E initialData, Node<E> initialNext)
    {
        data=initialData;
        link=initialNext;
        
    }
    
    /**
     * The getData method gets the data of the current node
     * @return the data of the current node
     */
    
    public E getData()
    {
        return data;
    }
    
    /**
     * The getNext method gets the link to the next node from the current one
     * @return the link to the next node
     */
    public Node<E> getNext()
    {
        return link;
    }
    
    /**
     * The setData method sets the data of the current node
     * @param newData is the data being set into the new node
     */
    public void setData(E newData)
    {
        data=newData;
    }
    
    /**
     * The setNext method sets the link of the node to the new link
     * @param newNext is the new link that is being set over the old one.
     */
    public void setNext(Node<E> newNext)
    {
        link=newNext;
    }
    
}