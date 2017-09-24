import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Actor
{
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
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
            myWorld.addObject(new InstructionsMin(), 78,434);

            myWorld.removeObject(this);
         
        }
    }
}
