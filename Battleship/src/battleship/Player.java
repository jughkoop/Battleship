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
public class Player {
    //Instance Variables
    private int shipNumber;
    Ships Destroyer=new Ships(2, "DESTROYER");
    Ships Submarine=new Ships(3, "SUBMARINE");
    Ships Cruiser=new Ships(3, "CRUISER");
    Ships Battleship=new Ships(4, "BATTLESHIP");
    Ships Carrier=new Ships(5, "CARRIER");
 
    //Default Constructor
    public Player(){
        shipNumber=17;  //total number of ship hit points
            }
    
    //Constructor
    public Player(int shipNumber){
        setShipNumber(shipNumber);
    }
    
    //Setter Functions
    public void setShipNumber(int i){
        shipNumber=i;
    }
    
    //Getter Functions
    public Ships getDestroyer(){
        return Destroyer;
    }
    public Ships getSubmarine(){
        return Submarine;
    }
    public Ships getCruiser(){
        return Cruiser;
    }
    public Ships getBattleship(){
        return Battleship;
    }
    public Ships getCarrier(){
        return Carrier;
    }
    public int getShipNumber(){
        return shipNumber;
    }
    
    //Printer Functions
    public void printGrid(char[][] ar){
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar.length; j++) {
                if(j<ar.length-1){
                    if(i!=11){
                        System.out.print(ar[i][j-1]+" ");
                    }    
                }
                else{
                    System.out.println(ar[ar.length-1][j]);
                }
            }    
        }
    }

}
