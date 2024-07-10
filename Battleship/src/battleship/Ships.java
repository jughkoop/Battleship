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
public class Ships {
    //Object Variables
    private int length;
    private int column;
    private int row;
    private int direction;
    private String name;
    
    //Direction constants
    public static final int UNSET=-1;
    public static final int HORIZONTAL=0;
    public static final int VERTICAL=1;
    
    
    //Ship Object 
    public Ships(int length, String name){
        setLength(length);
        direction=UNSET;
        row=0;
        column=0;
        setName(name);
    }
    
    //Setter Functions
    public void setLength(int i){
        length=i;
    }
    public void setColumn(int i){
        column=i;
    }
    public void setRow(int i){
        row=i;
    }
    public void setDirection(int i){
        direction=i;
    }
    public void setName(String s){
        name=s;
    }
    
    //Getter Functions
    public int getLength(){
        return length;
    }
    public int getColumn(){
        return column;
    }
    public int getRow(){
        return row;
    }
    public int getDirection(){
        return direction;
    }
    public String getName(){
        return name;
    }
    
    //Checker Functions
    public boolean isLocationSet(){
        if(row==0 || column==0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean isDirectionSet(){
        if(direction==HORIZONTAL || direction==VERTICAL){
            return true;
        }
        else{
            return false;
        }
    }
    
    //toString Method
    public String toString(){
        return "Name: "+name+"Length: "+length+" Row: "+row+" Column: "+column+" Direction: "+
                direction;
    }
}



