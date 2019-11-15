/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * The MovingBox2 class creates a box with certain parameters
 that will be loaded into our Truck
 * @author Truman Emmings, Radhika Tandon, Alexis Delgato, Faiza Jama
 */
public class MovingBox2 {
    
    protected int referenceN;
    
    protected double weight;
    protected int dem; //With, Height, Length
    protected boolean breakable;
    protected int L;
    protected int H;
    protected int W;
    
    
    public MovingBox2() {
        this.referenceN = referenceN;
        setDem(W, H, L);
        this.weight = weight;
        this.breakable = breakable;
        
    }
    /**
     * full parameter constructor
     * @param referenceN An int for the reference number of the box
     * @param dest A String for the name of the destination of the box
     * @param weight A double for the weight of the box
     */
    public MovingBox2(int referenceN, double weight, boolean breakable, int W, int H, int L) {
        this.referenceN = referenceN;
        setDem(W, H, L);
        this.weight = weight;
        this.breakable = breakable;
        
    }
    //get meyhod of  each LWH
    public int getLength() {
        return L;
    }
    
    public int getHieght() {
        return H;
    }
    public int getWidth() {
        return W;
    }
    /**
     * 
     * @return 
     */
    public boolean getBreakable() {
        return breakable;
    }
    /**
     * 
     * @return 
     */
    public int getDem() {
      return dem;
    }
    
    /**
     * a Getter for getting the reference number of the box.
     * @return and int
     */
    public int getReferenceN() {
        return referenceN;
    }
    /**
     * Getter for getting the weight of the box
     * @return a double 
     */
    public double getWeight() {
        return weight;
    }
    public void setBreakable(boolean breakbale){
        this.breakable = breakable;
    }
    /**
     * 
     * @param W
     * @param H
     * @param L 
     */
    public void setDem(int W, int H, int L){
       if((W < 4) && (W > 0)) {
           this.W = W;
       }
       if((W < 4) && (W > 0)){
           this.H = H;
       }
       if((W < 4) && (W > 0)){
           this.L = L;
       }
        
      
    }
    /**
     * Setter for the reference number of the box
     * @param referenceN the reference number of the box
     */
    
    public void setReferenceN(int referenceN) {
        this.referenceN = referenceN;
    }
    /**
     * A setter for setting the weight of the box 
     * @param weight a double
     */
    public void setWeight(double weight){
        this.weight = weight;
        
    }
    /**
     * A toString method used for creating a readable string of data
     * @return Returns a readable string of data
     */
    @Override
    public String toString() {
        //return "\n" + "MovingBox2 " + "Reference #: " + referenceN + ", Weight:" + weight + 
               // ", Breakable? " + breakable + " Width: "+ W + " Height: " + H + " Length:" + L;
        return "Ref#: " + referenceN + " Weight: " + weight + " Dem: " + " B?: " + breakable + " L: "+ L + " H: " + H + " W:" + W + "\n";
    }
    
    
    
    
    
    
    
}
