import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainmenuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainmenuButton extends Actor
{
    /**
     * Act - do whatever the MainmenuButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Intro intro = new Intro();
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(intro);
    }    
}
