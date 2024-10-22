package roomProject;

/**
 * 
 * @author Chase Moskowitz
 */
public class Location implements Comparable<Location> 
{      
    private String description;
    private LinkedBag<Location> neighbors;
                
    /**
     * Constructor
     * @param initDescription 
       */     
    public Location (String initDescription)  
    {
         description=initDescription;
         neighbors= new LinkedBag<Location>();
    } 
    
    /**
     * the getDescription method gets the description of the  location
     * @return the description of the location
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * The isNeighbor method checks to see if a location is neighbors with another location
     * @param otherLocation the other location being checked
     * @return true if it is a neighbor or false if it is not
     */
    public boolean isNeighbor (Location otherLocation)
    {
        
        return neighbors.exists(otherLocation);
    }
     
    
    /**
     * The addNeighbor method adds a neighbor to a location
     * @param otherLocation the neighbor being added
     */
    public void addNeighbor (Location otherLocation)
    {
        
        neighbors.add(otherLocation);
    }       

    /**
     * The neighbors method iterates through a locations neighbors
     * @return neighbors
     */
    public Lister<Location> neighbors()
    {
        return neighbors.iterator();
    }

    
/**
      The equals method compares this Location to another Location .
      @param The object to test for equality.
      @return boolean with result of test for equality.
   */

    public boolean equals(Location otherLocation)
    {
        if (!(otherLocation instanceof Location))
            throw new ClassCastException("A Location was expected.");

        if (description.equalsIgnoreCase(otherLocation.getDescription()))
            return true;
        else
            return false;
    }

   /**
      The compareTo method compares this Car to another Object .
      if this location is before other location, return a value < 0.
      if this location is after other location, return a value > 0.
      if this location is equal to other location, return 0.
      @param The object to test for equality.
      @return int with result of comparison.
   */

    public int compareTo(Location otherLocation)throws ClassCastException
    {
        if (!(otherLocation instanceof Location))
            throw new ClassCastException("A Location was expected.");

        if (description.compareToIgnoreCase(otherLocation.getDescription())<1)
            return -1;
        else if (description.compareToIgnoreCase(otherLocation.getDescription())>1)
            return 1;
        else
            return description.compareToIgnoreCase(otherLocation.getDescription());
    }

   /**
    * toString
    * @return description
    */
     public String toString()   
     {
        
        return "" + description + "";
         
     }
                
     /**
      * The numNeighbors returns the number of neighbors a location has
      * @return the number of neighbors
      */
     public int numNeighbors()           
     {
         return neighbors.getSize();
     }
                
}
