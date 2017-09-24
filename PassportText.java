import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PassportText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassportText extends Actor
{
    private boolean movingLeft = true;
    private int acceptX;
    private int acceptY;
    private int denyX;
    private int denyY;
    public boolean check = false;
    /**
     * This class is used for creating and moving the text image on the passport. Upon instantiation, it requires
     * the:
     *  - GreenfootImage, created by the Passport class, used to set the image
     *  - Country, used for spacing, and where the image should be placed
     */
    public PassportText(GreenfootImage gi, int country)
    {
        setImage(gi); //Sets the image to the text

        /**
         * These statements are used to choose where to place the text on the passport. Each country has slightly
         * different text locations, but mainly there are three different locations
         */
        if(country==0 || country==2 || country==4 || country==8 || country==9 || country==5 || country==3 || country==11)
        {
            acceptX = 547; //Set the coordinate for the accept location
            acceptY = 343; //Set the coordinate for the accept location
            denyX = 787; //Set the coordinate for the deny location
            denyY = 343; //Set the coordinate for the deny location
        }
        if(country==1 || country==6 || country==7 || country==13)
        {
            acceptX = 551; //Set the coordinate for the accept location
            acceptY = 357; //Set the coordinate for the accept location
            denyX = 791; //Set the coordinate for the deny location
            denyY = 357; //Set the coordinate for the deny location
        }
        if(country==10 || country==12)
        {
            acceptX = 488; //Set the coordinate for the accept location
            acceptY = 344; //Set the coordinate for the accept location
            denyX = 728; //Set the coordinate for the deny location
            denyY = 344; //Set the coordinate for the deny location
            setLocation(488, 344); //Sets the location to be slightly offset from the others
        }
    }

    public void act() //Run every cycle
    {
        if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("D"))
            check = true;
        if(check)
            checkForMovement(); //Checks whether the object should be moving or not

    }

    public void moveAccept() //Public method, can be accessed from anywhere
    {
        movingLeft = true; //States that the object should now be moving left
    }

    public void moveDeny() //Public method, can be accessed from anywhere
    {
        movingLeft = false; //States that the object should now be moving right
    }

    private void checkForMovement() //Checks if the object should move, if at all
    {
        if(movingLeft && getX() > acceptX) //If the object is moving left and is not at the final location
        {
            setLocation(getX() - 10, acceptY); //Set the location to be closer to the final location
        }
        else if(!movingLeft && getX() < denyX) //If the object is moving right and is not at the final location
        {
            setLocation(getX() + 10, denyY); //Set the location to be closer to the final location
        }
    }
}
