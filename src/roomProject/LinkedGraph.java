package roomProject;

/**
 * 
 * @author Chase Moskowitz
 */
public class LinkedGraph {

    private LinkedBag<Location> vertexList;
    
   /**
    * Constructor
    */
    public LinkedGraph() 
    {
        vertexList= new LinkedBag<Location>();
    }

    /**
     * The addVertex method adds a vertex to the graph
     * @param newVertex the vertex being added
     */
    public void addVertex(Location newVertex) 
    {
        vertexList.add(newVertex);
    }

  /**
   * The isEdge method checks to see is a location is an edge to a destination
   * @param source the initial location
   * @param destination the preferred destination from the initial location
   * @return true if it is an edge or false if its not
   */
    public boolean isEdge(Location source, Location destination)
    {
        if (vertexList.exists(source) && vertexList.exists(destination))
        {
            return source.isNeighbor(destination);
        }
         else
            return false;
    }

    /**
     * The addEdge method adds an edge from a source to a destination
     * @param source the starting vertex
     * @param destination the location the edge is being made to
     */
     public void addEdge(Location source, Location destination)
    {
        if (vertexList.exists(source) && vertexList.exists(destination))
            source.addNeighbor(destination);
    }
    
     /**
      * The neighbors method lists all of the neighbors from a specific vertex
      * @param vertex the vertex being used 
      * @return the neighbors
      */
    public Lister<Location> neighbors(Location vertex) 
    {
        
       return vertex.neighbors();
        
    }

    /**
     * The Size method returns the amount of vertex's in the graph
     * @return 
     */
    public int size() 
    {
        return vertexList.getSize();
                
    }

}
