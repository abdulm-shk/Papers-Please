import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Header here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Header extends Actor
{
    boolean spawn = true;
    private int[] stats = {0, 1};
    private Boolean choiceMade = false; //If the user has made a choice on the documents
    private Boolean userChoice; //The user's choice on the documents, true = accept, false = deny
    private Boolean valid; //The actual validity of the documents, true = valid, false = invalid
    private String firstNameLastName; //Used to store the document's first name and last name
    private int difficulty = 4; //The amount of "money" the player get
    private boolean trayDown;
    Approved approved = new Approved();
    Deny deny = new Deny();
    /**
     * Act - do whatever the Header wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForKeys(); //Check if keys are down
        trayDown=Stamps.getTrayDown();
    }    

    public void setUserChoice(Boolean userChoice, Boolean valid, String firstNameLastName) //This is a public method that is called when a user chooses an option
    {
        choiceMade = true; //This states that the user has chosen a choice
        this.userChoice = userChoice; //Sets internal variables to parameter variables
        this.valid = valid; //Sets internal variables to parameter variables
        this.firstNameLastName = firstNameLastName; //Sets internal variables to parameter variables
    }

    private void checkForKeys() //Check if keys are down
    {
        if(Greenfoot.isKeyDown("W") && choiceMade) //If the W key is down, the game is not paused, and the user has made a choice
        {
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("next"); //Activates the playSound method in the Sound object
            } 
            if(userChoice != valid)
            {
                for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
                {  
                    Sound s = (Sound) o; //Sets the object o to be of Sound
                    s.stopSound(); //Activates the stopSound method in the Sound object
                } 
                Greenfoot.setWorld(new Losescreen()); //End the game instantly, because of a mistake
            }
            if(userChoice == valid) //If the user's choice is correct
            {
                removeDocuments(); //Remove all document related items.
                addScore(); //Increment the score by a set amount, changeable to change difficulty
                PaperWorld pw = (PaperWorld) getWorld(); //Gets the world PaperWorld, sets it to pw
                pw.newDocuments(); //Activates the newDocuments method in the current PaperWorld
                choiceMade = false; //Reset the users choiceMade boolean to false
            }

        }

    }
    private void removeDocuments() //This method removes all documents, and document related objects in the world
    {
        getWorld().removeObjects(getWorld().getObjects(Passport.class)); //Removes all objects of Documents.class
        getWorld().removeObjects(getWorld().getObjects(PassportText.class)); //Removes all objects of PassportText.class
        getWorld().removeObjects(getWorld().getObjects(PassportFace.class)); //Removes all objects of PassportFace.class
        getWorld().removeObjects(getWorld().getObjects(FaceGraphic.class)); //Removes all objects of FaceGraphic.class
        getWorld().removeObjects(getWorld().getObjects(FingerprintReal.class));
        getWorld().removeObjects(getWorld().getObjects(FingerprintRecord.class));
    }

    public void addScore() //Increment the score, can be changed for difficulty
    {
        stats[0] = stats[0] + difficulty; //Increases the stats[0] variable by a set amount, higher = easier
    }

}
