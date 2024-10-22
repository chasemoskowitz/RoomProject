//Chase Moskowitz

package roomProject;


import java.util.Scanner;


public class RoomMain 
{
    
    /**
     * @param args the command line arguments1
     *
     */
    public static void main(String[] args) 
    {
       int userChoice;
       int i;
        
        Scanner input = new Scanner(System.in);
        
        HouseGraph myGraph = new HouseGraph();
        
        Location currentVertex = myGraph.getHomeLocation();
        System.out.println("\nYou are currently in room "
                    + currentVertex);

        do {
         
             i = 1;
            // display our neighbors
            System.out.println("Neighbors of " + currentVertex + " are:");
            Lister<Location> neighbors=currentVertex.neighbors();
           
            while (neighbors.hasNext())
            {
                System.out.printf(""+ i + "-"+neighbors.next()+ ", ");
                
                i++;
            }
            
            
            System.out.println();

            // suppose I was interacting with user, (hey, I am)
            // I will ask for their choice
            System.out.print("\nWhere would you like to go? (-1 to exit): ");
            userChoice = input.nextInt();

            // make sure not too small nor too big
            while (userChoice < -1 || userChoice >= myGraph.size()) 
            {
                System.out.println("\n" + userChoice + " is not a valid value");
                System.out.print("\nWhere would you like to go? (-1 to exit): ");
                userChoice = input.nextInt();
            }

            // if their choice is -1 then exit
            if (userChoice == -1) {
                System.out.println("Good bye!");
            } 
            else 
            {
                
                if (userChoice>=1 && userChoice<i)
                {
                  neighbors=myGraph.neighbors(currentVertex);
                
                  for(i=1; i<=userChoice; i++)
                  {
                      currentVertex=neighbors.next();
                  }
                    System.out.println("\nYou are currently in room "
                            + currentVertex);
                }
                else
                {
                    System.out.println("\nYou can't go to " + userChoice);
                }
            }
        } while (userChoice != -1);
        
        
        
        
    }

}
        
        
        
        
        
        
        
        
        

        
        
        
        
        
        
        
        
    
    

