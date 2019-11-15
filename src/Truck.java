
import java.util.*;
import java.lang.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Truck class which creates a truck and allows you to add moving boxes
 * and remove moving boxes from it.
 * @author Truman Emmings, Radhika Tandon, Alexis Delgato, Faiza Jama
 */
public class Truck {
    
    private MovingBox2[][][] stack; //With, Height, Length

    protected int length = 0;
    protected int height = 0;
    protected int width = 0;
    protected int size = 0;
    
    /**
     * Default constructor
     */
     public Truck() { // truck parameters
        stack = new MovingBox2[length][height][width];
        
         for (int i = 0; i < stack.length; i++) {
            
             for (int j = 0; j < stack[0].length; j++) {
                 for (int k = 0; k < stack[0][0].length; k++) {
                     
                     size += k;
                     
                 }
             }
         }
    }
    /**
     * Constructor for the Truck parameters
     * @param hieght of the truck
     * @param length of the truck
     */  
    public Truck(int length, int height, int width) { // truck parameters
        stack = new MovingBox2[length][height][width];
        size();
    }
    
    public int size(){
        return size;
    }
    
    /*
     A method created to count up the score of the truck iteration
    */
    public double score()
    {
        
        int volume = stack.length * stack[0].length * stack[0][0].length;
        int counter = 0;
        double score = 0;

    for(length = 0; length < stack.length; length++ ){ //moving length once inbetted for loop is done
        //System.out.println("1 Loop");
        for(int height = 0; height < stack[0].length; height++){ //inbetted for loop to add the the height
            //System.out.println("2 Loop");
            for(width = 0; width < stack[0][0].length; width++){
                
                if(stack[length][height][width] == null){
                        
                        counter ++;
                        
                }
            }
        }
            
    }
   
    score = (volume - counter) / 100.0;
        
    return Math.abs(score);
    }
        
    /**
     * A method for loading the truck that does not allow you to load a box on 
     * top of one that is lighter then the one you are lading
     * @param box the box that is being loaded
     * @return true if the box has successfully been loaded, False if it was not
     */
    public boolean load(MovingBox2 box) {
        
        for(length = 0; length < stack.length; length++ ){ //moving length once inbetted for loop is done
            //System.out.println("1 Loop");
            for(int height = 0; height < stack[0].length; height++){ //inbetted for loop to add the the height
                //System.out.println("2 Loop");
                for(width = 0; width < stack[0][0].length; width++){ //inbetted for loop to add the the Width
                    //System.out.println("3 Loop");
                    
                    //Checks for L, H, W nulls
                    
                    boolean fits = true; //determine if it can fit or not
                        //System.out.println("=============L null Check============");
                        for(int l = length; (l < box.getLength()) && (l < stack.length); l++){ // create getter
                            if (stack[l][height][width] != null){
                                fits = false; 
                                //System.out.println("After=============L null Check============");
                            } 
                        } 
                        for(int h = height; (h < box.getHieght()) && (h < stack[0].length); h++){ // create getter
                            if (stack[length][h][width] != null){
                                fits = false; 
                            } //System.out.println("H null Check");
                        }
                        for(int w = width; (w < box.getWidth()) && (w < stack[0][0].length); w++){ // create getter
                            if (stack[length][height][w] != null){
                                fits = false; 
                            } //System.out.println("W null Check");
                        }  
                         
                        //Checks for breakable boxes underneith
                        
                        for(int l = length; (l < box.getLength()) && (l < stack.length) && (height > 0); l++){ // create getter
                            //System.out.println("================Hieght=============" + height);
                            if (stack[l][height - 1][width] != null && stack[l][height - 1][width].getBreakable()){
                                fits = false;  
                               
                            }
                        }    
                        
                        for(int w = width; (w < box.getWidth()) && (w < stack[0][0].length) && (height > 0); w++){ // create getter
                            if (stack[length][height - 1][w] != null && stack[length][height - 1][w].getBreakable()){
                                fits = false; 
                            } 
                        } 
                        
                    //If statements for checking dimentions
                    
                    if(stack.length <= (length + box.getLength() - 1)){
                        fits = false; 
                    }
                    if(stack[0].length <= (height + box.getHieght() - 1)){
                        fits = false; 
                    }
                    if(stack[0][0].length <= (width + box.getWidth() - 1)){
                        fits = false; 
                    }
                    
                    //If fits = True these if statements add boxes by approbriate dimentions
                    
                    if (height == 0 && (stack[length][height][width] == null && fits)){
                        for(int l = length; (l < box.getLength()) && (l < stack.length); l++){
                            stack[l][height][width] = box;
                        }
                        for(int h = height; (h < box.getHieght()) && (h < stack[0].length); h++){
                            stack[h][height][width] = box;
                        }
                        for(int w = width; (w < box.getWidth()) && (w < stack[0][0].length); w++){
                            stack[w][height][width] = box;
                        }
                             //stack[length][height][width] = box;//for loops
                             return true;
                    }
                    if((height != 0) && (stack[length][height - 1][width] != null) && 
                           (box.getWeight() <= (stack[length][height - 1][width].getWeight())) && 
                           (stack[length][height][width] == null  && fits)/*Moving box wieght !> box weight*/){ //What box we should put in(limiting factors)
                                for(int l = length; (l < box.getLength()) && (l < stack.length); l++){
                                    stack[l][height][width] = box;
                                }
                                for(int h = height; (h < box.getHieght()) && (h < stack[0].length); h++){
                                    stack[h][height][width] = box;
                                }
                                for(int w = width; (w < box.getWidth()) && (w < stack[0][0].length); w++){
                                    stack[w][height][width] = box;
                                }
                                //stack[length][height][width] = box;//for loops
                                return true;
                    }
                    
                   
                }

            }
        }
        return false; //the box we loaded
    }
    
    public boolean cordLoad(int length,  int width,  int height, MovingBox2 box) {
        
        boolean fits = true; //determine if it can fit or not
                        //System.out.println("=============L null Check============");
                        for(int l = length; (l < box.getLength()) && (l < stack.length); l++){ // create getter
                            if (stack[l][height][width] != null){
                                fits = false; 
                                //System.out.println("After=============L null Check============");
                            } 
                        } 
                        for(int h = height; (h < box.getHieght()) && (h < stack[0].length); h++){ // create getter
                            if (stack[length][h][width] != null){
                                fits = false; 
                            } //System.out.println("H null Check");
                        }
                        for(int w = width; (w < box.getWidth()) && (w < stack[0][0].length); w++){ // create getter
                            if (stack[length][height][w] != null){
                                fits = false; 
                            } //System.out.println("W null Check");
                        }  
                         
                        //Checks for breakable boxes underneith
                        
                        for(int l = length; (l < box.getLength()) && (l < stack.length) && (height > 0); l++){ // create getter
                            //System.out.println("================Hieght=============" + height);
                            if (stack[l][height - 1][width] != null && stack[l][height - 1][width].getBreakable()){
                                fits = false;  
                               
                            }
                        }    
                        
                        for(int w = width; (w < box.getWidth()) && (w < stack[0][0].length) && (height > 0); w++){ // create getter
                            if (stack[length][height - 1][w] != null && stack[length][height - 1][w].getBreakable()){
                                fits = false; 
                            } 
                        } 
 
        //If statements for checking dimentions
        if (stack.length <= (length + box.getLength() - 1)) {
            fits = false;
        }
        if (stack[0].length <= (height + box.getHieght() - 1)) {
            fits = false;
        }
        if (stack[0][0].length <= (width + box.getWidth() - 1)) {
            fits = false;
        }

        //If fits = True these if statements add boxes by approbriate dimentions
        if (height == 0 && (stack[length][height][width] == null && fits)) {
            for (int l = length; (l < box.getLength()) && (l < stack.length); l++) {
                stack[l][height][width] = box;
            }
            for (int h = height; (h < box.getHieght()) && (h < stack[0].length); h++) {
                stack[h][height][width] = box;
            }
            for (int w = width; (w < box.getWidth()) && (w < stack[0][0].length); w++) {
                stack[w][height][width] = box;
            }
            //stack[length][height][width] = box;//for loops
            return true;
        }
        if ((height != 0) && (stack[length][height - 1][width] != null)
                && (box.getWeight() <= (stack[length][height - 1][width].getWeight()))
                && (stack[length][height][width] == null && fits)) { //What box we should put in(limiting factors)
            for (int l = length; (l < box.getLength()) && (l < stack.length); l++) {
                stack[l][height][width] = box;
            }
            for (int h = height; (h < box.getHieght()) && (h < stack[0].length); h++) {
                stack[h][height][width] = box;
            }
            for (int w = width; (w < box.getWidth()) && (w < stack[0][0].length); w++) {
                stack[w][height][width] = box;
            }
            //stack[length][height][width] = box;//for loops
            return true;
        }

        return false; //the box we loaded
    }

    /**
     * A method for un loading the truck
     *
     * @return true if successful
     */
    public MovingBox2 unLoad(int boxRef) {
        MovingBox2 temp = null;
        for (int length = stack.length - 1; length >= 0; length--) { //Starting from the top row and holding tell second for loop goes through
            for (int width = stack[0][0].length - 1; length >= 0; length--) { // going through the end calum starting from the top
                for (int height = stack[0].length - 1; height >= 0; height--) {
                    System.out.println(stack[length][height][width]);
                    
                    if (stack[length][height][width] != null && stack[length][height][width].getReferenceN() == boxRef){
                        int stackL = stack[length][height][width].getLength();
                        int stackH = stack[length][height][width].getHieght();
                        int stackW = stack[length][height][width].getWidth();
                        temp = stack[length][height][width];
                        for (int l = 0; l < stackL; l++) { // create getter
                            stack[length - l][height][width] = null;

                            //System.out.println("After=============L null Check============");
                        }
                        for (int h = 0; h < stackH; h++) { // create getter
                            stack[length][height - h][width] = null;

                            //System.out.println("H null Check");
                        }
                        for (int w = 0; w < stackW; w++) { // create getter
                            stack[length][height][width - w] = null;
                        }
                    }
                }
            }
        }
        
        return temp;
    }


    /**
     * A toString method used for creating a readable string of data for the truck
     * @return Returns a readable string of data
     */
    public String toString() {
        String truck = "\n";
        for(width = 0; width < stack[0][0].length; width++){
            truck += "Width: " + width + "\n";
            for(int height = stack[0].length - 1; height >= 0; height--){
                for(length = 0; length < stack.length; length++ ){ 

                    Object temp = (stack[length][height][width]);
                    truck = truck + " " + length + " " + height + " " + temp + "\t";
                            
                    

                }
                truck = truck + "\n";
            }
            
            truck += "------------------------\n";
        }
       return truck;
    }
}
    
//    public void Pos(int L, int H, int W){
//        System.out.println("Position of Box: " + stack[L][H][W]);
//    } 

