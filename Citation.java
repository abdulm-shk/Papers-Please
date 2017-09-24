import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Citation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Citation extends SmoothMover
{
    private Boolean movingUp = true;
    private int timer;
    private Boolean noText = true;
    private String type;
    private int fine;

    public Citation(String type)
    {
        setImage("CitationWarning.png");
        this.type = "Warning";
    }

    public Citation(int fine)
    {
        setImage("CitationFine.png");
        this.type = "Fine";
        this.fine = fine;
    }

    public void act() 
    {
        checkLocation();
        move();
        if(noText)
            addText();
    }    

    private void checkLocation()
    {
        if(movingUp)
        {
            if(getY() < 495) //checks if in extended position
            {
                stop();
                movingUp = false;
            }
            else {
                addForce(new Vector(270, 0.1));
            }
        }
//         else {
//             if(timer > 75)
//             {
//                 if(getY() > 560)
//                 {
//                     getWorld().removeObject(this);
//                 }
//                 else {
//                     addForce(new Vector(90, 0.1));
//                 }
//             }
//             else {
//                 timer++;
//             }
//         }
    }

    private void addText()
    {
        if(type == "Fine")
        {
            /**
             * This was one of my last classes that I did. This class holds an image that has some text drawn
             * on top of it. Now, I only noticed that there was two way to do this text drawing thing, one was
             * to create another class and have an object of that class move the same way as the object from
             * this class. I used this way for the documents class, and it was alright, however it did take a
             * long time to complete. I found the GreenfootImage way very recently, when I was putting the
             * last finishing touches on the project, and I find this way so much better and efficient. If I
             * have time to convert the other classes, I will, however there is only a week until this project
             * is due.
             */
            GreenfootImage gi = new GreenfootImage("CitationFine.png");
            GreenfootImage gi2 = new GreenfootImage("FINE: $" + fine, 20, Color.BLACK, null);
            gi.drawImage(gi2, 150, 125);
            setImage(gi);
        }
        noText = false;
    }
}
