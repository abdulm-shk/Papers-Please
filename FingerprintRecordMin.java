import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FingerprintRecordMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FingerprintRecordMin extends Actor
{
    /**
     * Act - do whatever the FingerprintRecordMin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World myWorld = getWorld();
        if (Greenfoot.mouseClicked(this)){
            myWorld.addObject(new FingerprintRecord(), 698,351);
            myWorld.removeObject(this);
        }
        if(Greenfoot.isKeyDown("W") ){
            getWorld().removeObject(this);
        }
    }    
}
