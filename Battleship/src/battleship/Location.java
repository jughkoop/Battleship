/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author 24dlee1
 */
public class Location {
    //Status variable
    private int status;
    private boolean setShip;
    
    //Constant variables for the position's status
    public static final int UNGUESSED=-1;
    public static final int HIT=0;
    public static final int MISS=1;
    
    //Default Constructor
    public Location(){
        status=-1;
        setShip=false;
    }
    
    //Constructor
    public Location(int status, boolean setShip){
        setStatus(status);
        setShip(setShip);
    }
    
    //Setter Functions
    public void setStatus(int i){
        status=i;
    }
    public void setShip(boolean b){
        setShip=b;
    }
    
    //Getter Functions
    public int getStatus(){
        return status;
    }
    
    public boolean hasShip(){
        return setShip;
    }
    
    //Behavior Functions
    public void markHit(){
        status=HIT;
    }
    
    public void markMiss(){
        status=MISS;
    }
    
}
