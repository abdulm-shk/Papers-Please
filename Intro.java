import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Intro extends World
{

    /**
     * This class is instantiated upon opening the game. 
     */
    public Intro()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        PlayButton play = new PlayButton();
        addObject(play, 500,425);
       
        
    }
}
