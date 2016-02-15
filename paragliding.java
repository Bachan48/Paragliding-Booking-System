/**
 * This class is made for a reservation system of a paragliding company.
 * This class contains several methods for executing the program.
 * Attributes of the company, service, and the clients are declared, initialized and are executed.
 * @author Bachan Ghimire 
 * @version (22nd Dec, 2015)
 */

public class Paragliding
{
    private String compName; //name of the company
    private String contNum; //contact numbe of the company
    private String compLoc; //location of compay 
    private double cost; //cost per glide
    private boolean avaiStatus; //availability status    
    private String clientName; //name of the client
    private String date; //date when it's booked
    private int numGlides; //number of glide the cilent books
    private int numPeople; //number of people in a client
    private String season; //the season when it is booked
    
    /**
     * Constructor for objects of class Paragliding.
     * All the attributes are initialized.
     * Parameters are passed for a few attributes.
     */
    
    public Paragliding(String name, String num, String loc, double costA)
    {
        compName= name;
        contNum= num;
        compLoc=loc;  
        cost=costA;
        avaiStatus= true;        
        clientName= "";
        date= ""; //write in your own way
        numGlides=0;
        numPeople= 0;
        season="";//season in year 
        
                        
    }
    
    /**
     * An accessor method for the attribute compName.
     * This method returns the company's name of string type.
     */    
    public String getCompName()
    {
        return compName;
    }
    
    /**
     * An accessor method for the attribute contNum.
     * This method returns the company's number of string type.
     */
    public String getContNum()
    {
        return contNum;
    }
    
    /**
     * An accessor method for the attribute compLoc.
     * This method returns the company's location of string type.
     */    
    public String getCompLoc()
    {
        return compLoc;
    }
    
    /**
     * An accessor method for the attribute cost.
     * This method returns the company's location of double type.
     */    
    public double getCost()
    {
        return cost;
    }
    
    /**
     * An accessor method for the attribute availStatus.
     * This method returns the company's booking availability of boolean type.
     */    
    public boolean getAvaiStatus()
    {
        return avaiStatus;
    }  
    
    /**
     * An accessor method for the attribute clientName.
     * This method returns the company's client's name of string type.
     */    
    public String getClientName()
    {
        return clientName;
    }   
    
    /**
     * An accessor method for the attribute date.
     * This method returns the client's date of booking, of string type.
     */
    public String getDate()
    {
        return date;
    }    
    
    /**
     * An accessor method for the attribute numGlides.
     * This method returns the client's number of glides of integer type.
     */    
    public int getNumGlides()
    {
        return numGlides;
    }
    
    /**
     * An accessor method for the attribute numPeople.
     * This method returns the client's number in a group of integer type.
     */    
    public int getNumPeople()
    {
        return numPeople;
    }
    
    /**
     * An accessor method for the attribute season.
     * This method returns the season of booking of string type.
     */    
    public String getSeason()
    {
        return season;
    }
    
    /**
     * A mutator method for the attribute cost.
     * This method sets the company's cost per glide of double type.
     */    
    public void setCost (double nCost)
    {
        cost=nCost;
    }
    
    /**
     * A mutator method for the attribute numPeople.
     * This method sets the number of clients, of integer type.
     */    
    public void setNumPeople (int nClientNumber)
    {
        numPeople=nClientNumber;
    }
    
    /**
     * This is a primary methods that makes the reservation and booking.
     * Cost and discount is calculated on this method according to company's discount policy.
     * This method returns the booking details made by a client.
     */    
    public void mainMethod(int peopleNum, /*double rateA,*/ String nameClient, String dateA, int numOfglides, String seasonA)
    {        
       if(avaiStatus==true){
            //execute only when available
            numPeople=peopleNum;
            //cost=rateA;
            clientName=nameClient;
            date=dateA;
            numGlides=numOfglides;
            season=seasonA;
            avaiStatus=false; //now the service unavailable, booked.            
            double fixedCost=cost; //Assigning the original cost, before discount to a variable named "costFixed".
 
            //10% discount is given when number of people making reservation is 5 or more.
            if (numPeople>=5){
                fixedCost= fixedCost-(fixedCost/10);                
            }
            
            //50% discount is given when reservation is made on off season. (The month of april, may and june)
            switch(season){                                    
                case "April":
                case "april":
                case "May":
                case "may":
                case "june":
                case "June": fixedCost= fixedCost-(fixedCost/2);
                           break;
                          
                default: break;
            }  
            
            System.out.println("Welcome to Bachan Glide!\nYour booking details are: ");
            System.out.println("Claim your discount if you are 5 or more in a group(10%), or it is the off season(50%) or both!");
            System.out.println("Name: "+clientName);
            System.out.println("Date: "+date);
            System.out.println("Season: "+season);
            System.out.println("Number of glides: "+numGlides);
            System.out.println("Number of people: "+numPeople);
            System.out.println("Cost per glide is: "+fixedCost);
            System.out.println("The cost of booking (Including discount if you have received any) is "+fixedCost*numPeople*numGlides);
            
       }
       else{
         System.out.println("The booking service is currently unavailable as of "+date+". Try booking when available.");   
       }
       
    }  
    /**
     * This is a method that makes the booking available for reservation.
     * This method makes the attributes related to clients empty and sets availabe status to true, if the reservation is not available.
     */
    public void emptyMethod()
    {
       if(avaiStatus==false){
            avaiStatus= true;        
            clientName= "";
            date= "";
            numPeople= 0;
            numGlides=0;
            season="";
       }
       else{
       System.out.println("Booking is already available, please book your glide."); 
       }
    }
    /**
     * This method displays the details of the company.
     * All the attributes related to the company are displyed when this method is called.
     */
    public void displayMethod()
    {
            System.out.println("Welcome to Bachan Glide! Paragliding, on your service!");
            System.out.println("Claim your discount if you are 5 or more in a group(10%), or it is the off season(50%) or both!");
            System.out.println("Name of the company: "+compName);
            System.out.println("Location of the company: "+compLoc);
            System.out.println("Contact number: "+contNum);
            System.out.println("Cost per glide is: "+cost);                        
    }
    
}
