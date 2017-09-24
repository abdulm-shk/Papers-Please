import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; //This library is needed in order to allow for the use of the TextDisplayer class

public class EndOfDayMenu extends World
{
    private int nextText = 200; //Spaces the text evenly in the world
    private Boolean isSick = false; //If any family member is sick
    private int[] stats; //Standard global player variables
    private Boolean family1[]; //Standard global player variables
    private Boolean family2[]; //Standard global player variables
    private Boolean family3[]; //Standard global player variables
    private Boolean lastChanceUsed; //Standard global player variables
    private Boolean heatOn = false; //If the heat button is turned on
    private Boolean foodOn = false; //If the food button is turned on
    private Boolean medicineOn = false; //If the medicine button is turned on

    /**
     * This class is displayed at the end of the day. It is triggered by the time hitting 5pm, or 17:00. It requires the standard global player
     * variables as parameters. It controls a lot of things, including the actions that the user does at the end of the day, choosing to heat
     * up their apartment, feed and/or medicate their family. It also displays a summary of the day.
     */
    public EndOfDayMenu()
    {    
        super(1000,600,1);
        
    }
}
