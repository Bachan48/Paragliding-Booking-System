/**
 * This class is created to add objects of class Paragliding and calling its methods.
 * An arraylist is created to store objects of class Paragliding.
 * @author (Bachan Ghimire) 
 * @version (Happy new year)
 */
import java.util.*;
public class Paraglide
{
    // creating object of ArrayList class
    private ArrayList<Paragliding> aryListObj; 
    
    /**
     * Constructor for objects of class Paraglide.
     * The arraylist object is initialised here. 
     */
    public Paraglide()
    {
        aryListObj = new ArrayList<Paragliding>(); 
    }

    /**
     * This is a method created to add objects of class Paraglide.
     * 4 parameters are passed in this method.
     */
    public void addObjMethod(String name, String num, String loc, double costA)
    {
       //creating object of class Paraglding 
       Paragliding parObj= new Paragliding(name, num, loc, costA); 
       aryListObj.add(parObj);
    }
    
    /**
     * This is a method created to remove objects from arraylist.
     * index number is passed as a parameter
     */
    public void removeMethod(int index)
    {
        if (index>=0 && index< aryListObj.size()){
            aryListObj.remove(index);
        }
        else{
            System.out.println("Invalid index number in ArrayList");
        }
    }
    
    /**
     * This is a method created to reserve the paragliding service.
     * index number and 5 other parameters are passed in this method.
     */
    public void hireMethod(int index, int peopleNum, String nameClient, String dateA, int numOfglides, String seasonA)
    {
        if (index>=0 && index< aryListObj.size()){
          Paragliding parObj= aryListObj.get(index);
          //Calling a method of class Paragliding through an object of class Paraglide
          parObj.mainMethod(peopleNum, nameClient, dateA, numOfglides, seasonA);
          aryListObj.set(index, parObj);
        }
        else{
            System.out.println("Invalid index number in ArrayList");
        }
    }
    
    /**
     * This is a method created to make the service available.
     * index number is passed as parameter.
     */
    public void availableMethod(int index)
    {
        if (index>=0 && index< aryListObj.size()){
          Paragliding parObj= aryListObj.get(index);
          parObj.emptyMethod();
          
        }
        else{
            System.out.println("Invalid index number in ArrayList");
        }
    }
    
    /**
     * This is a method created to search the objects that are available for booking.
     * Each objects in the list are checked.
     */   
    public void listMethod()
    {   
        boolean found= false;
        boolean objectCheck = false;             
        int counter=0;
        for (int i= 0; i<aryListObj.size(); i++){
            Paragliding parObj= aryListObj.get(i);
             
                if (parObj.getAvaiStatus()== true){
                    //int index= aryListObj.indexOf(parObj);
                    System.out.println("Object of index "+counter+" is avaiable for booking");
                    parObj.displayMethod(); 
                    found= true;
                }
                
             
             objectCheck = true;   
             counter++;    
        }
        
        if(!found){
                    System.out.println("No object free for booking");
        }    
        
        if(!objectCheck){
                    System.out.println("No object found.");
        }
        //time spent here: 2 hours. Slept: 3 times. 
    }
    
    /**
     * This is a method created to search the objects that are available and matches the search for booking.
     * Each objects in the list are checked.
     * Search items are passed as parameters.
     */   
    public void searchAvailable(double rate, String location)
    {
        boolean found= false;
        boolean objectCheck = false;
        int counter=0;
        for (int i= 0; i<aryListObj.size(); i++){
            Paragliding parObj= aryListObj.get(i);    
                //if the object is availabe. 
                if (parObj.getAvaiStatus()== true){
                    //if the search item matches requirement 
                    if(parObj.getCost() <= rate && parObj.getCompLoc().equals(location)){
                        //int index= aryListObj.indexOf(parObj); 
                        System.out.println("Object of index "+counter+" matches the search.");
                        parObj.displayMethod(); 
                        found= true;
                        
                        break;
                    }                    
                }
            objectCheck = true;
            counter++;   
        }
        
        if(!found){
                    System.out.println("No matching object found for the search.");
        }
        
        if(!objectCheck){
                    System.out.println("No object found.");
        }
    }
}
