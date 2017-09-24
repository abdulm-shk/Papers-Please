import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Graphic extends Actor
{
    private String type; //Type of graphic
    /**
     * This class is used to display graphics on the screen. It uses abstraction to allow for multiple graphic
     * objects from a single class to be instantiated. Upon instantiation, it requires a string as a type,
     * and the string acts as the filename, without the extension suffix.
     */
    public Graphic(String type)
    {
        setImage(type + ".png");
        this.type = type;
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space")) //If the space key is down
        {
            if(type == "HelpPage") //If the object is a help page
            {
                //for (Object o : getWorld().getObjects(Clock.class)) //Returns a list of all the objects with name clock.class, should only be one
                //{  
                //    Clock c = (Clock) o; //Sets all objects o of Clock.class to c
                //    c.unpauseClock(); //Unpauses the clock
                //} 
                PaperWorld pw = (PaperWorld) getWorld(); //Gets the current PaperWorld object
                //pw.newDocuments(); //Calls the newDocuments() method from the world
                getWorld().removeObject(this); //Removes this object from the world
            }
            if(type == "LabourLotteryText") //If the object is the labour lottery text, only called when a new game is selected
            {
                int stats[] = {0, 1}; //Creating the standard global variables
                Boolean family1[] = {false, false, false}; //Creating the standard global variables
                Boolean family2[] = {false, false, false}; //Creating the standard global variables
                Boolean family3[] = {false, false, false}; //Creating the standard global variables
                Boolean lastChanceUsed = false;  //Creating the standard global variables
                //Greenfoot.setWorld(new PaperWorld(stats, family1, family2, family3, lastChanceUsed)); //Adds the object to the world
            }
        }
    }
}