/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.util.Scanner;
/**
 *
 * @author 24dlee1
 */
public class Battleship {
    /**
     * @param args
     * Strings - line 76, Battleship.java
     * Variables - lines 15-19, Ships.java
     * For Loops - lines 18-22, Grid.java
     * While Loops - lines 47-66, Battleship.java
     * Conditionals - lines 71-76, Ships.java, lines 139-152, Asker.java
     * User Input - lines 23-24, Asker.java
     * Output - line 95, Battleship.java
     * Array - line 118, Battleship.java
     * Classes - Asker.java, Grid.java, Location.java, Player.java, Ships.java
     */
    public static void main(String[] args) {
      //Construction of grid arrays
       char[][] grid=new char [13][13];
       char[][] grid2=new char [13][13];
       
       //Introduces user to game
       System.out.println("=====================");
       System.out.println("Welcome to Battleship");
       System.out.println("=====================");
       System.out.println("");
       
       //Creates a player and grid
       Player p1=new Player();
       Grid g1=new Grid();
       Grid g3=new Grid();
       userSet(p1, g1, g3, grid, 1);
               
       //Creates a 2nd player and grid
       Player p2=new Player();
       Grid g2=new Grid();
       Grid g4=new Grid();
       userSet(p2, g2, g4, grid2, 2);
           
        //Players guess for the other's ships
        do{
            //Asks player 1 to guess
            System.out.println("PLAYER 1");
            guess(p1, p2, g3, g4, grid);
            //Asks player 2 to guess
            System.out.println("PLAYER 2");
            guess(p2, p1, g4, g3, grid2);
            
            //End of Game
            if(p2.getShipNumber()==0){   //if player 1 wins
                p1.setShipNumber(-1);
                p2.setShipNumber(-1);
                System.out.println("PLAYER 1 WINS");
            }
            else if(p1.getShipNumber()==0){   //if player 2 wins
                p1.setShipNumber(-1);
                p2.setShipNumber(-1);
                System.out.println("PLAYER 2 WINS");
            }
        }while(p1.getShipNumber()>=0 || p2.getShipNumber()>=0);
    }
    
    //Method for user pressing the enter key to continue the game
    public static void pressEnter(){ 
        System.out.println("Press ENTER to continue");
        Scanner userInput = new Scanner(System.in);
        userInput.nextLine();
    } 
    
    //Method for the setting display
    public static void set(Ships s, Grid g, Player p, char[][] c){
        System.out.println("Place your "+s.getName()+" (length "+s.getLength()+")");
               Asker.askForShip(s);   
               Asker.placeShip(s, g);
               g.createShips(c);
               System.out.println("");
               System.out.println("Your current grid of ships");
               p.printGrid(c);
               pressEnter();
    }
    
    //Method for guessing display
    public static void guess(Player p1, Player p2, Grid g1, Grid g2, char[][] c){
        System.out.println("Your grid");
            g1.createStatus(c);
            p1.printGrid(c);
            pressEnter();
            System.out.println("Guess a location");
            System.out.println("");
            System.out.println("Your opponent's grid");
            g2.createStatus(c);
            p1.printGrid(c);
            pressEnter();
            Asker.askForGuess(p2, g2);
            g2.createStatus(c);
            p1.printGrid(c);
            System.out.println("Number of hits left:"+p2.getShipNumber());
            System.out.println("");
            pressEnter();
    }
    
    //Method for having user set up board
    public static void userSet(Player p, Grid g1, Grid g2, char[][] c, int i){
       //Asks user to place their ships
       System.out.println("PLAYER " + i);
       System.out.println("You will need to choose the location of your ships.");
       System.out.println("Your current grid of ships");
       g1.createShips(c);
       p.printGrid(c);  //creates a grid for displaying the ships and prints it
       pressEnter();
            //Places down the ships
            set(p.getDestroyer(), g1, p, c);
            set(p.getSubmarine(), g1, p, c);
            set(p.getCruiser(), g1, p, c);
            set(p.getBattleship(), g1, p, c);
            set(p.getCarrier(), g1, p, c);

       g2=g1;  //Creates a grid for guessing
    }
}
    


