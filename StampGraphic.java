import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StampGraphic extends Graphic
{
    private Boolean movingLeft = true; //True when the object is moving left
    
    /**
     * This is a sub class of Graphic.
     * This class is seperate due to the passport stamp needing to move with the document, and also so that upon
     * deletion of the stamp graphic, other graphics also don't get removed from the world.
     */
    public StampGraphic(String type)
    {
        super(type); //Calls the super class constructor, and provides the type
        if(type == "InkDenied") //If the stamp is instantiated when the document is at the deny stamp, set movingLeft to false
            movingLeft = false;
    }
    
    public void act()
    {
        checkForMovement(); //Check whether the object should be moving or not
    }
    
    public void moveAccept() //Public method that can be called from any class
    {
        movingLeft = true; //Moves the object to the accept button
    }
    
    public void moveDeny() //Public method that can be called from any class
    {
        movingLeft = false; //Moves the object to the deny button
    }
    
    private void checkForMovement() //Check where the object should be moving
    {
        if(movingLeft && getX() > 566) //If the object should be moving left and it is not at the end location
        {
            setLocation(getX() - 10, getY()); //Move the object left by 10 cells
        }
        else if(!movingLeft && getX() < 804) //If the object should be moving right and it is not at the end location
        {
            setLocation(getX() + 10, getY()); //Move the object right by 10 cells
        }
    }
}
