import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsMin extends Actor
{
    /**
     * Act - do whatever the InstructionsMin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World myWorld = getWorld();
        if (Greenfoot.mouseClicked(this)){
            myWorld.addObject(new Instructions(), 698,351);
            myWorld.removeObject(this);
        }
    }    
}
