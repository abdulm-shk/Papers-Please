import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Approved here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Approved extends Actor
{
    boolean choiceMade = true;
    /**
     * Act - do whatever the Approved wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("D")||Greenfoot.isKeyDown("W"))
            getWorld().removeObject(this);
        choiceMade = true;

    }
    
}    

