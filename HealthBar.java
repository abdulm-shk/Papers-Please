import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Shape;
import java.lang.Object;
import java.awt.geom.RoundRectangle2D;
/**
 * HealthBar
 * Creates the timer and decreases time every act. Once timer is 0, lose screen appears.
 * 
 * @Aster, Abdul, Alexander 
 * @version 2.0
 */
public class HealthBar extends Actor
{
    int health =  0;
    int counter = 0;
    GreenfootImage[] images = new GreenfootImage[41];
    int imageNumber;
    public HealthBar()
    {
        setImage("TimerImage0.png");
        for(int i = 0; i<images.length; i++){
            images[i] = new GreenfootImage( "TimerImage" + i + ".png" );

        }
        setImage(images[imageNumber]);
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {     

        counter++;
        if (counter % 300 == 0) {
            animation();
            health++;
        }
        loseHealth();

        

    }    

    public void animation()
    {
        imageNumber = (imageNumber+1)% images.length;
        setImage(images[imageNumber]);
    }
    //Health Bar

    //Gains health/time and if health becomes 41, change World to Losescreen
    public void loseHealth()
    {
        

        Losescreen lose = new Losescreen();
        if (health == 41) 
        {
            Greenfoot.setWorld(lose);    
        }
    }    

}

