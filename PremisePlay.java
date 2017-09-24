import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PremisePlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PremisePlay extends Actor
{
    /**
     * Act - do whatever the PremisePlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(new PaperWorld());
    }    
}
