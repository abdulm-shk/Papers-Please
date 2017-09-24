import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PassportFace extends Actor
{
    private Boolean movingLeft = true;
    private boolean firstSpawn = true;
    private int acceptX;
    private int acceptY;
    private int denyX;
    private int denyY;
    private boolean check = false;

    /**
     * This class is used for creating and moving the face image on the passport. Upon instantiation, it requires
     * the:
     *  - Image, randomly generated and used to depict which image is placed down
     *  - Gender, use to choose which gender to get the image from
     *  - Country, used for spacing, and where the image should be placed
     */
    public PassportFace(int image, String gender, int country)
    {
        setImage("faces/passport/" + gender + "/" + image + ".png"); //Sets the image to the one specified

        /**
         * These statements are used to choose where to place the image on the passport. Each country has slightly
         * different face locations, but mainly there are three different locations
         */
        if(country==0 || country==2 || country==4 || country==8 || country==9 || country==5 || country==3 || country==11)
        {           
            acceptX = 510; //Set the coordinate for the accept location
            acceptY = 357; //Set the coordinate for the accept location
            denyX = 750; //Set the coordinate for the deny location
            denyY = 357; //Set the coordinate for the deny location
        }
        if(country==1 || country==6 || country==7 || country==13)
        {           
            acceptX = 510; //Set the coordinate for the accept location
            acceptY = 365; //Set the coordinate for the accept location
            denyX = 748; //Set the coordinate for the deny location
            denyY = 365; //Set the coordinate for the deny location
        }
        if(country==10 || country==12)
        {            
            acceptX = 626; //Set the coordinate for the accept location
            acceptY = 357; //Set the coordinate for the accept location
            denyX = 864; //Set the coordinate for the deny location
            denyY = 357; //Set the coordinate for the deny location
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
