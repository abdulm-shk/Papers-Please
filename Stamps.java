import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Stamps extends SmoothMover
{
    private boolean flag = true; //If the stamp tray has extended its trajectory fully
    private boolean movingDown = true; //If the stamp tray is moving down
    private boolean moving = false; //If the stamp tray is moving
    private int timer; //Timer to control how long the button down image stays for
    Deny deny = new Deny();
    Approved approved = new Approved();
    public static boolean trayDown=false;
    /**
     * This class is the Stamps class. It is responsible for holding the two stamps, the accept and deny stamps.
     */
    public void act()
    {

        if (Greenfoot.mouseClicked(this)){
            checkStamps(); //Check if the A, S or D keys are down
            moving = true; //Set the moving flag to be true
            
            
        }
        move(); //Runs the move method in the parent class
        
        checkKeys();
        checkLocation(); //Check the current location of the stamp tray
        
        
        if(timer > 0)//If the timer has run its course, change the image
        {
            checkStampTimer(); //Run the checkStampTimer method
        }
    }
    public static boolean getTrayDown()
    {
        return trayDown;
    }

    private void checkLocation() //Check the current location
    {
        if(moving && movingDown) //If the tray is moving, and moving down
        {
            if(getY() > 200) //Checks if object is in "extended" position
            {
                stop(); //Clears all vector forces
                if(flag) //Bounceback
                {
                    setLocation(getX(), 200); //"Pops" the object slightly eastward
                    addForce(new Vector(270, 5)); //Adds bounceback force
                    flag = false; //Only bounces back once
                }
                else { //Called when the object has finished moving completely
                    moving = false; //Stop the object from moving
                    movingDown = false; //Sets up the boolean for the next movement
                    flag = true; //Resets the bounceback for the next movement
                }
            }
            else {
                addForce(new Vector(90, 0.5)); //Adds vector force to extend the object
            }
        }
        if(moving && !movingDown) //If the tray is moving and moving up
        {
            if(getY() < 35) //Checks if the object is in "non-extended" position
            {
                stop(); //Clears all vector forces
                moving = false; //Inverts boolean
                movingDown = true; //Inverts boolean
            }
            else {
                addForce(new Vector(270, 0.5)); //Adds vector force to detract the object
            }
        }
    }

    private void checkStamps() //Check which keys are down
    {

        moving = true; //Set the moving flag to be true
        if(movingDown)
        {
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("stampOut"); //Activates the playSound method in the Sound object
            } 
        }
        if(!movingDown)
        {
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("stampIn"); //Activates the playSound method in the Sound object
            } 
        }

    }

    private void checkKeys() {

        if(Greenfoot.isKeyDown("A") && getY() >200 ) //When the user wants to approve an entrant, and the tray is open
        {
            if(deny!=null || approved !=null){
                getWorld().removeObject(deny);
                getWorld().removeObject(approved);
            }
            setImage("StampsApproved.png"); //Change the image
            getWorld().addObject(approved, 565, 232); //Add the stamp graphic
            timer = 10; //Reset the timer
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("stamp"); //Activates the playSound method in the Sound object
            } 
        }
        if(Greenfoot.isKeyDown("D") && getY() >200 ) //When the user wants to deny an entrant, and the tray is open
        {
            if(deny!=null || approved !=null){
                getWorld().removeObject(deny);
                getWorld().removeObject(approved);
            }
            setImage("StampsDenied.png"); //Change the image
            getWorld().addObject(deny, 805, 232); //Add the stamp graphic
            timer = 10; //Reset the timer
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("stamp"); //Activates the playSound method in the Sound object
            } 
        }
    }

    private void checkStampTimer() //Check the stamp timer
    {
        timer--; //Deduct 1 from the timer
        if(timer == 0) //If the timer is at 0
        {
            setImage("Stamps.png"); //Revert back to the original image
        }
    }
}
