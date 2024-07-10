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
public class Grid {
    //Object Variables
    private Location[][] grid=new Location[11][11];
    
    //Constructor
    public Grid(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j]=new Location();
            }
        }
    }
    //Getter Functions
    public Location get(int row, int column){
        return grid[row][column];
    }
    
    //Setter Functions
    public void setShip(int row, int column){
        grid[row][column]=new Location(-1, true);
    }
    
    //Checker Functions
    public boolean alreadyGuessed(int row, int column){
        if(grid[row][column].getStatus()==0 || grid[row][column].getStatus()==1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean notOnGrid(int row, int column){
        if(row>grid.length-1 || column>grid[0].length-1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean alreadyAShipH(int row, int column, Ships s){
        for (int i = 0; i < s.getLength(); i++) {
            if(grid[row][column+i].hasShip()==true){
                return true;
            }
        }
        return false;
    }
    public boolean alreadyAShipV(int row, int column, Ships s){
        for (int i = 0; i < s.getLength(); i++) {
            if(grid[row+i][column].hasShip()==true){
                return true;
            }
        }
        return false;
    }    
    
    //Grid Creator Functions
    public void createStatus(char[][]ar){
        int ascii;
        ar[0][0]=' ';
        ar[0][11]='0';
        
        for (int i = 1; i < ar.length-1; i++) {     //sets up numbered row
           ascii=48+i;   //sets ascii to the ASCII value of the character nums
           ar[0][i]=(char)ascii;
           if((char)ascii==':'){
               ascii=48;
               ar[0][i]=(char)ascii;
           }
       }
       for (int i = 1; i < ar.length-1; i++) {      //sets up lettered column
           ascii=64+i;
           ar[i][0]=(char)ascii;
       }
       for (int i = 1; i < ar.length-1; i++) {  //fills in rest of array with - (undefined), X (hit), or O (miss)
            for (int j = 1; j < ar[j].length-1; j++) {
                    if(grid[i-1][j-1].getStatus()==0){
                        ar[i-1][j-1]='X';
                    }
                    if(grid[i-1][j-1].getStatus()==1){
                        ar[i-1][j-1]='O';
                    }
                    else{
                        ar[i][j]='-';
                    }
            }
       }
    }
    
    public void createShips(char[][]ar){
        int ascii;
        ar[0][0]=' ';
        ar[0][11]='0';
        
        for (int i = 1; i < ar.length-1; i++) {     //sets up numbered row
           ascii=48+i;   //sets ascii to the ASCII value of the character nums
           ar[0][i]=(char)ascii;
           if((char)ascii==':'){
               ascii=48;
               ar[0][i]=(char)ascii;
           }
       }
       for (int i = 1; i < ar.length-1; i++) {      //sets up lettered column
           ascii=64+i;
           ar[i][0]=(char)ascii;
       }
       for (int i = 1; i < ar.length-1; i++) {  //fills in rest of array with - (no ship), or X (has ship)
            for (int j = 1; j < ar[j].length-1; j++) {
                    if(grid[i-1][j-1].hasShip()==true){
                        ar[i-1][j-1]='X';
                    }
                    else{
                        ar[i][j]='-';
                    }
            }
       }
    }
    
    
}
