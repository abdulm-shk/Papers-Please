import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class FingerprintRecord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FingerprintRecord extends SmoothMover
{

    private Boolean movingUp = true;
    private int timer;
    private boolean move = true;

    /**
     * Act - do whatever the FingerprintRecord wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {

        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (Greenfoot.mouseDragged(this))
            this.setLocation(mouse.getX(), mouse.getY()); 
        Actor sidebar = getOneIntersectingObject(Sidebar.class);
        World myWorld = getWorld();

        if(sidebar !=null)
        {
            myWorld.addObject(new FingerprintRecordMin(), 130,434);

            myWorld.removeObject(this);

        }

        checkLocation();

        move();
       
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

    }

}
