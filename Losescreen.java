import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Losescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Losescreen extends World
{

    /**
     * Constructor for objects of class Losescreen.
     * 
     */
    public Losescreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(new MainmenuButton(), 500,560);
    }
}
