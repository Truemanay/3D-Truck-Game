/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Truman Emmings, Radhika Tandon, Alexis Delgato, Faiza Jama
 */
public class TruckTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Asking user how big there truck needs to be
        Scanner scan = new Scanner(System.in);
        System.out.println("How big do you need your truck?");
        System.out.println("How Tall? ");
        int height = scan.nextInt();
        System.out.println("How Long? ");
        int length = scan.nextInt();
        System.out.println("How wide? ");
        int width = scan.nextInt();
        System.out.println("Your truck will be " + height + " tall, " + length + " long, and " + width + " wide");

        //Randomizing boxes
        ArrayList<MovingBox2> boxList = new ArrayList<MovingBox2>();
        Random ran = new Random();
        int truckDim = length * height * width;
        
        System.out.println("How many boxes would you like to create? " );
        System.out.println("You should create at least " + truckDim + " boxes" );
        int numBoxes = scan.nextInt();
        
        for (int i = 0; i < numBoxes; i++) {
            int index = ran.nextInt(500);
            double weight = ran.nextDouble() * (100.00 - 1.00) + 1.00;
            boolean breakable = true;
            if ((ran.nextInt(10)) == 0) {//breakable
                breakable = true;
            } else {
                breakable = false;
            }
            
            MovingBox2 box = new MovingBox2(index, weight, breakable, ran.nextInt(3 - 1 + 1) + 1,
                    ran.nextInt(3 - 1 + 1) + 1, ran.nextInt(3 - 1 + 1) + 1);
            boxList.add(box);
        }

        //Sorting ArrayList
        //By making the ArrayList boxList sorted from greatest to smallest and adding from "bottom right"
        //to "top left" there was no possible way for a heavier box to be placed on a lighter box
        //the moethod sort boxes is below
        //I used the selction sort algerithm to sort the boxes from heaviest to lightest
        sortBoxes(boxList);
        System.out.println("Sorted Boxes: " + boxList + "\n");
        
        System.out.println("======================Truck======================= \n");
        Truck chevy = new Truck(height, length, width);
        
        System.out.println("Truck Loading");
        for (int i = 0; i < boxList.size(); i++) {
            if (chevy.load(boxList.get(i))) {
                boxList.remove(i);
                System.out.println(chevy.toString());
                System.out.println("/////////////////////////////////////////////////////////////////////////// \n");
            }
        }
        
        System.out.println("Truck Loaded: \n" + chevy);


       

        System.out.println("//////////////////////////////Game Driver///////////////////////////////////////");
        boolean done = true;
        while (done) {
            
            System.out.println("The current state of the Truck is: " + chevy + "\n");
            
            System.out.println("These are the boxes that need to be loaded: \n" + boxList);
            
            System.out.println("The score of the game is: " + chevy.score() + "%");
            
            System.out.println("Enter 1: to add a box || Enter 0: to remove a box");
            int addRemove = scan.nextInt();

//we are adding to the truck
            if (addRemove == 1) {
                System.out.println("We are now adding a box to the list: \n ");
                System.out.println(boxList);
                System.out.println("Enter the Ref#: ");
                int boxRef = scan.nextInt();
                int bHeight = 0;
                
                for (int i = 0; i < boxList.size(); i++) {
                    MovingBox2 temp = boxList.get(i);
                    int boxRefNum = temp.getReferenceN();
                    //the current index is at where the box we need to add is.
                    if (boxRef == boxRefNum) {
                        
                        System.out.println("//////////////////////////////////////////////////////");
                        
                        System.out.println("What orientation would you like this box to have? \n");
                        System.out.println("Type in 1,2,3,4,5,6 for your options: \n ");
                        System.out.println("1: Height: " + temp.getHieght() + " Length: " + temp.getLength() + " Width: " + temp.getWidth() + "\n");
                        System.out.println("2: Height: " + temp.getHieght() + " Width: " + temp.getWidth() + " Length: " + temp.getLength() + "\n");
                        System.out.println("3: Length: " + temp.getLength() + " Height: " + temp.getHieght() + " Width: " + temp.getWidth() + "\n");
                        System.out.println("4: Length: " + temp.getLength() + " Width: " + temp.getWidth() + " Height: " + temp.getHieght() + "\n");
                        System.out.println("5:  Width: " + temp.getWidth() + " Height: " + temp.getHieght() + " Length: " + temp.getLength() + "\n");
                        System.out.println("6:  Width: " + temp.getWidth() + " Length: " + temp.getLength() + " Height: " + temp.getHieght() + "\n");
                        
                        int rotate = scan.nextInt();
                        //We need a name for the specific rotation.
                        //String rotate = scan.nextLine();
                        //1
                        if (rotate == 1) {
                            //W, H, L
                            temp.setDem(temp.getHieght(), temp.getLength(), temp.getWidth());
                            
                        }
                        //2
                        if (rotate == 2) {
                            
                            temp.setDem(temp.getHieght(), temp.getWidth(), temp.getLength());
                            
                        }
                        //3
                        if (rotate == 3) {
                            
                            temp.setDem(temp.getLength(), temp.getHieght(), temp.getWidth());
                            
                        }

                        //4
                        if (rotate == 4) {
                            
                            temp.setDem(temp.getLength(), temp.getWidth(), temp.getHieght());
                            
                        }
                        //5
                        if (rotate == 5) {
                            
                            temp.setDem(temp.getWidth(), temp.getHieght(), temp.getLength());
                            
                        }
                        //6
                        if (rotate == 6) {
                            temp.setDem(temp.getWidth(), temp.getLength(), temp.getHieght());
                            
                        }
                        
                        System.out.println("Where would you like slide the box in from \n");
                        System.out.println("Enter the width postion 1 - MAX: ");
                        int w = scan.nextInt();
                        System.out.println("Enter the hieght postion 1 - MAX: ");
                        int h = scan.nextInt();
                        System.out.println("Enter the length postion 1 - MAX: ");
                        int l = scan.nextInt();
                        //int length,  int width,  int height, MovingBox2 box
                        
                        if (!(chevy.cordLoad(l - 1, w - 1, h - 1, temp))) {
                            System.out.println("Sorry this box will not fit into the truck");
                            
                        } else {
                            chevy.cordLoad(l - 1, w - 1, h - 1, temp);
                            boxList.remove(i);
                            System.out.println("The box has been added succsefully");
                        }                        
                    }                    
                }                
            }

//we are removing from the truck
            if (addRemove == 0) {
                System.out.println("We are now removing a box to the list: \n ");
                System.out.println(chevy);
                System.out.println("Enter the Ref#: ");
                int love = scan.nextInt();
                
                
                
                System.out.println("Test print 1" + love);
                boxList.add(chevy.unLoad(love));
                
                System.out.println("Your current score is: " + chevy.score());
                
                
            }
                 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+chevy);

        }
    }

    public static void sortBoxes(ArrayList<MovingBox2> input) {
        //implemented selection sort
        for (int i = 0; i < input.size(); i++) {
            double largeW = 0.0;
            int largeI = i;
            for (int j = i; j < input.size(); j++) {
                
                if (input.get(j).getWeight() > largeW) {
                    largeW = input.get(j).getWeight();
                    largeI = j;
                }
                
            }
            MovingBox2 temp = input.get(i);
            input.set(i, input.get(largeI));
            input.set(largeI, temp);
        }
    }
    
}
