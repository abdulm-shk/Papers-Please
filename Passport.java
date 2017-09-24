import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; //Allows for GreenfootImage to work properly with java colours, TextDisplayer class too

/**
 * 
 */
public class Passport extends Actor
{
    private Boolean valid; //If the passport documents are valid
    private Boolean check = false;
    private String firstName; //First name on the document, generated
    private String lastName; //Last name on the document, generated
    private String expirationDate; //Expiration date on the document, generated
    private String birthDate; //Birth date on the document, generated
    private int country; //Country on the document, generated
    private String gender; //Gender on the document, generated
    private String issueDate; //Issue date on the document, generated
    private int image; //Image on the document, generated
    private boolean noText = true; //Boolean used to instantiate the text and image
    private Boolean userChoice; //If the user has made a choice or not
    private String path = "passports/Passport"; //Where the passport images are held
    private int textGraphicX; //Where the text should be instantiated at
    private int textGraphicY; //Where the text should be instantiated at
    private int fx; //Where the first name should be in relation to the text GreenfootImage
    private int fy; //Where the first name should be in relation to the text GreenfootImage
    private int lx; //Where the last name should be in relation to the text GreenfootImage
    private int ly; //Where the last name should be in relation to the text GreenfootImage
    private boolean movingLeft = true; //If the document is moving left
    private int passportFaceX; //Where the passport face should be upon instantiation
    private int passportFaceY; //Where the passport face should be upon instantiation
    Approved approved = new Approved();
    Deny deny = new Deny();

    public Passport(Boolean valid, String firstName, String lastName, String expirationDate, String birthDate, int country, String gender, String issueDate, int image) //Requires document information from the PaperWorld class
    {
        this.valid = valid; //Sets parameter to internal variable
        this.firstName = firstName; //Sets parameter to internal variable
        this.lastName = lastName; //Sets parameter to internal variable
        this.expirationDate = expirationDate; //Sets parameter to internal variable
        this.birthDate = birthDate; //Sets parameter to internal variable
        this.country = country; //Sets parameter to internal variable
        this.gender = gender; //Sets parameter to internal variable
        this.image = image; //Sets parameter to internal variable
        this.issueDate = issueDate; //Sets parameter to internal variable 

        if(country==0 || country==2 || country==4 || country==8 || country==9 || country==5 || country==3 || country==11)
        {
            textGraphicX = 667; //Where the passport text should be
            textGraphicY = 343; //Where the passport text should be
            fx = 33; //Where the first name should be in relation to the text GreenfootImage
            fy = 29; //Where the first name should be in relation to the text GreenfootImage
            lx = 100;
            ly = 29;
            passportFaceX = 630; //Where the face graphic should be
            passportFaceY = 357; //Where the face graphic should be
        }
        if(country==1 || country==6 || country==7 || country==13)
        {
            textGraphicX = 671; //Where the passport text should be
            textGraphicY = 357; //Where the passport text should be
            passportFaceX = 630; //Where the face graphic should be
            passportFaceY = 365; //Where the face graphic should be
            fx = 33; //Where the first name should be in relation to the text GreenfootImage
            fy = 29; //Where the first name should be in relation to the text GreenfootImage
            lx = 95; //Where the last name should be in relation to the text GreenfootImage
            ly = 29; //Where the last name should be in relation to the text GreenfootImage
        }
        if(country==10 || country==12)
        {
            textGraphicX = 608; //Where the passport text should be
            textGraphicY = 344; //Where the passport text should be
            passportFaceX = 740; //Where the face graphic should be
            passportFaceY = 357; //Where the face graphic should be
            fx = 90; //Where the first name should be in relation to the text GreenfootImage
            fy = 29; //Where the first name should be in relation to the text GreenfootImage
            lx = 150; //Where the last name should be in relation to the text GreenfootImage
            ly = 29; //Where the last name should be in relation to the text GreenfootImage
        }
        setImage(path + country + ".png"); //Sets the image to the countries' passport

    }

    public void act() //Run every cycle
    {
        checkForKeys(); //Check if keys are down
        if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("D"))
            check = true;
        if(check)
            checkForMovement(); //Check if the passport should be moving

        if(noText) //If there is no text currently on the screen for the passport
            writeText(); //Write the text onto the screen through the use of creating a GreenfootImage

    }

    private void checkForMovement() //Checking if the document should be moving
    {
        if(movingLeft && getX() > 566) //If the document is moving left and is not at the final location
        {
            setLocation(getX() - 10, getY()); //Move the document closer to the final location
        }
        else if(!movingLeft && getX() < 804) //If the document is moving right and is not at the final location
        {
            setLocation(getX() + 10, getY()); //Move the document closer to the final location
        }
    }

    private void checkForKeys() //Check if certain keys are down
    {
        if(Greenfoot.isKeyDown("A") ) //If the A key is down
        {
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("movePaper"); //Activates the playSound method in the Sound object
            } 
            for (Object o : getWorld().getObjects(PassportText.class)) //Returns a list of all the objects with name PassportText.class, should only be one
            {  
                PassportText pt = (PassportText) o; //Sets all objects of type PassportText to pt
                pt.moveAccept(); //Run the public method in the object
            } 
            for (Object o : getWorld().getObjects(StampGraphic.class)) //Returns a list of all the objects with name StampGraphic.class, should only be one
            {  
                StampGraphic sg = (StampGraphic) o; //Sets all objects of type StampGraphic to sg
                sg.moveAccept(); //Run the public method in the object
            } 
            for (Object o : getWorld().getObjects(PassportFace.class)) //Returns a list of all the objects with name PassportFace.class, should only be one
            {  
                PassportFace pf = (PassportFace) o; //Sets all objects of type PassportFace to pf
                pf.moveAccept(); //Run the public method in the object
            } 

            userChoice = true; //Change the userChoice to true
            movingLeft = true; //Reset the movingLeft boolean

            for (Object o : getWorld().getObjects(Header.class)) //Returns a list of all the objects with name GameManager.class, should only be one
            {  
                Header hr = (Header) o; //Sets all objects of type GaneManager to gm
                hr.setUserChoice(userChoice, valid, firstName + lastName); //Run the public method in the object
            } 

        }
        if(Greenfoot.isKeyDown("D"))
        {
            for (Object o : getWorld().getObjects(Sound.class)) //returns a list of all the objects with name Sound.class, should only be one
            {  
                Sound s = (Sound) o; //Sets the object o to be of Sound
                s.playSound("movePaper"); //Activates the playSound method in the Sound object
            } 
            for (Object o : getWorld().getObjects(PassportText.class)) //Returns a list of all the objects with name PassportText.class, should only be one
            {  
                PassportText pt = (PassportText) o; //Sets all objects of type PassportText to pt
                pt.moveDeny(); //Run the public method in the object
            } 
            for (Object o : getWorld().getObjects(StampGraphic.class)) //Returns a list of all the objects with name StampGraphic.class, should only be one
            {  
                StampGraphic sg = (StampGraphic) o; //Sets all objects of type StampGraphic to sg
                sg.moveDeny(); //Run the public method in the object
            } 
            for (Object o : getWorld().getObjects(PassportFace.class)) //Returns a list of all the objects with name PassportFace.class, should only be one
            {  
                PassportFace pf = (PassportFace) o; //Sets all objects of type PassportFace to pf
                pf.moveDeny(); //Run the public method in the object
            } 

            userChoice = false; //Change the userChoice to true
            movingLeft = false; //Reset the movingLeft boolean

            for (Object o : getWorld().getObjects(Header.class)) //Returns a list of all the objects with name GameManager.class, should only be one
            {  
                Header hr = (Header) o; //Sets all objects of type GaneManager to gm
                hr.setUserChoice(userChoice, valid, firstName + lastName); //Run the public method in the object
            } 

        }
    }

    private void writeText() //Write the text
    {
        /**
         * I would have this code running in the constructor of this class, however I was having issues with trying to
         * instantiate another object when the current object (Document) has not been fully created into the world
         * yet.
         */
        GreenfootImage gi = new GreenfootImage(200, 111); //Create a new Greenfoot Image 200px wide 111px high
        gi.drawString(firstName, fx, fy); //Draw the firstName
        gi.drawString(lastName, lx, ly); //Draw the lastName
        gi.drawString(birthDate, 125, 42); //Draw the birthDate
        gi.drawString(gender, 125, 55); //Draw the gender
        gi.drawString(issueDate, 125, 67); //Draw the issueDate
        gi.drawString(expirationDate, 125, 79); //Draw the expirationDate

        getWorld().addObject(new PassportText(gi, country), textGraphicX, textGraphicY); //Add the object to the world
        getWorld().addObject(new FaceGraphic(image, gender), 215, 265); //Add the facegraphic in the window into the world
        getWorld().addObject(new PassportFace(image, gender, country), passportFaceX, passportFaceY); //Add the passportFace into the world

        noText = false; //Reset the flag
    }
}
