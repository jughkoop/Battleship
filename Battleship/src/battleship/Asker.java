/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.util.Scanner;

/**
 *
 * @author 24DLEE1
 */
public class Asker {
    //Method to ask and implement a ship
    public static void askForShip(Ships s){
        Scanner userInput=new Scanner(System.in);
        char row=' ';
        int column=0;
        int direction;
        int ascii;
        
        //Asks for row
        System.out.println("What row? (A-J) (Capital only)");
        row=userInput.next().charAt(0);
        ascii=(int)row;
        while(ascii<65 || ascii>74){  //checks for invalid input
            System.out.println("That is an invalid input. Please try again.");
            System.out.println("What row? (A-J) (Capital only)");
            row=userInput.next().charAt(0);
            ascii=(int)row;
        }
        s.setRow(ascii-64); //sets the row where the ship will be placed
        
        //Asks for column
        System.out.println("");
        System.out.println("What column? (1-0) (input 10 for column 0)");
        userInput.nextLine();
        while(userInput.hasNextInt()==false){
            System.out.println("That is an invalid input. Please try again."); 
            System.out.println("What column? (1-0) (input 10 for column 0)");
            userInput.nextLine();
        }
        column=userInput.nextInt();
        while(column<1 || column>10){
            System.out.println("That is an invalid input. Please try again."); 
            System.out.println("What column? (1-0) (input 10 for column 0)");
            column=userInput.nextInt();
        }
        s.setColumn(column); //sets the column where the ship will be placed
        
        //Asks for direction
        System.out.println("");
        System.out.println("Horizontal (type 0) or Vertical (type 1)?");
        direction=userInput.nextInt();
        while(direction<0 || direction>1){
            System.out.println("That is an invalid input. Please try again.");
            System.out.println("Horizontal (type 0) or Vertical (type 1)?");
            direction=userInput.nextInt();
        }
        s.setDirection(direction);  //sets the direction of the ship
    }
    
    //Method that places the ship on the grid
    public static void placeShip(Ships s, Grid g){
        if(s.getDirection()==0){    //if ship has horizontal direction
            if(g.notOnGrid(s.getRow(), s.getColumn()+s.getLength())==true){    //checks if location is on grid
                System.out.println("One of the locations was invalid. Please try again.");
                Asker.askForShip(s);
                Asker.placeShip(s, g);
            }
            else if(g.alreadyAShipH(s.getRow(), s.getColumn(), s)==true){  //checks if location is not already occupied
                System.out.println("One of the locations was invalid. Please try again.");
                Asker.askForShip(s);
                Asker.placeShip(s, g);
            }
            else{
                for (int i = 0; i < s.getLength(); i++) {
                    g.setShip(s.getRow(), s.getColumn()+i);
                }
            }        
        }
        else{   //if ship has vertical direction
            if(g.notOnGrid(s.getRow()+s.getLength(), s.getColumn())==true){    //checks if location is on grid
                System.out.println("One of the locations was invalid. Please try again.");
                System.out.println("");
                Asker.askForShip(s);
                Asker.placeShip(s, g);
            }
            else if(g.alreadyAShipV(s.getRow(), s.getColumn(), s)==true){  //checks if location is not already occupied
                System.out.println("One of the locations was invalid. Please try again.");
                System.out.println("");
                Asker.askForShip(s);
                Asker.placeShip(s, g);
            }
            else{
                for (int i = 0; i < s.getLength(); i++) {
                    g.setShip(s.getRow()+i, s.getColumn());
                }
            }
        }
        //g.setShip(s.getRow(), s.getColumn());
    }
    
    public static void askForGuess(Player p, Grid g){
        Scanner userInput=new Scanner(System.in);
        char row=' ';
        int column=0;
        int ascii;
        
        //Asks for the row to guess
        System.out.println("What row? (A-J) (Capital only)");
        row=userInput.next().charAt(0);
        ascii=(int)row;
        while(ascii<65 || ascii>74){  //checks for invalid input
            System.out.println("That is an invalid input. Please try again.");
            System.out.println("What row? (A-J) (Capital only)");
            row=userInput.next().charAt(0);
            ascii=(int)row;
        }
        ascii-=64;
        
        //Asks for column
        System.out.println("");
        System.out.println("What column? (1-0) (input 10 for column 0)");
        userInput.nextLine();
        while(userInput.hasNextInt()==false){
            System.out.println("That is an invalid input. Please try again."); 
            System.out.println("What column? (1-0) (input 10 for column 0)");
            userInput.nextLine();
        }
        column=userInput.nextInt();
        while(column<1 || column>10){
            System.out.println("That is an invalid input. Please try again."); 
            System.out.println("What column? (1-0) (input 10 for column 0)");
            column=userInput.nextInt();
        }
        
        //Checks if the grid location was a hit or a miss, or already guessed
        if(g.alreadyGuessed(ascii, column)==true){
            System.out.println("You have already guessed that location. Please try again.");
            Asker.askForGuess(p, g);
        }
        else if(g.get(ascii, column).hasShip()==true){    //if guess was a hit
            g.get(ascii, column).markHit();
            System.out.println("HIT!");
            p.setShipNumber(p.getShipNumber()-1);
            
        }
        else{   //if guess was a miss
            g.get(ascii, column).markMiss();
            System.out.println("MISS!");
        }
    }
}
