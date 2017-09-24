import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deny extends Actor
{
    boolean choiceMade = false;
    /**
     * Act - do whatever the Deny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("A")||Greenfoot.isKeyDown("W"))
            getWorld().removeObject(this);
        choiceMade = true;
    }    
}
