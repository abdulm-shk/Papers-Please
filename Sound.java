import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends Actor
{
    private static int musicVolume = 50;
    private static int SFXVolume = 100;
    private String world = "intro";
    private Boolean musicPlaying = false;
    GreenfootSound gsMA = new GreenfootSound("music/ambient.wav");
    GreenfootSound gsMI = new GreenfootSound("music/intro.mp3");
    GreenfootSound gsME = new GreenfootSound("music/death.mp3");
    GreenfootSound gsSStampOut = new GreenfootSound("sfx/stampTrayOut.wav");
    GreenfootSound gsSStampIn = new GreenfootSound("sfx/stampTrayIn.wav");
    GreenfootSound gsSMovePaper1 = new GreenfootSound("sfx/movePaper1.wav");
    GreenfootSound gsSMovePaper2 = new GreenfootSound("sfx/movePaper2.wav");
    GreenfootSound gsSMovePaper3 = new GreenfootSound("sfx/movePaper3.wav");
    GreenfootSound gsSNext = new GreenfootSound("sfx/next.wav");
    GreenfootSound gsSStamp = new GreenfootSound("sfx/stamp.wav");
    GreenfootSound gsSCitation = new GreenfootSound("sfx/citation.wav");

    public Sound(String world)
    {
        this.world = world;
    }

    public Sound()
    {

    }

    public void act() 
    {
        if(world == "paperWorld" && !musicPlaying)
        {
            gsMA.playLoop();
            musicPlaying = true;
        }
        if(world == "intro" && !musicPlaying)
        {
            gsMI.playLoop();
            musicPlaying = true;
        }
        if(world == "end" && !musicPlaying)
        {
            gsME.playLoop();
            musicPlaying = true;
        }
        gsMI.setVolume(musicVolume);
        gsMA.setVolume(musicVolume);
        gsME.setVolume(musicVolume);
    }    

    public void playSound(String type)
    {
        gsSStampOut.setVolume(SFXVolume);
        gsSStampIn.setVolume(SFXVolume);
        gsSNext.setVolume(SFXVolume);
        gsSMovePaper1.setVolume(SFXVolume);
        gsSMovePaper2.setVolume(SFXVolume);
        gsSMovePaper3.setVolume(SFXVolume);
        gsSStamp.setVolume(SFXVolume);
        gsSCitation.setVolume(SFXVolume);
        if(type == "stampOut")
        {
            gsSStampOut.play();
        }
        if(type == "stampIn")
        {
            gsSStampIn.play();
        }
        if(type == "next")
        {
            gsSNext.play();
        }
        if(type == "movePaper")
        {
            switch(Greenfoot.getRandomNumber(3))
            {
                case 0:
                gsSMovePaper1.play();
                break;
                case 1:
                gsSMovePaper2.play();
                break;
                case 2:
                gsSMovePaper3.play();
                break;  
            }
        }
        if(type == "stamp")
        {
            gsSStamp.play();
        }
        if(type == "citation")
        {
            gsSCitation.play();
        }
    }

    public void increaseMusicVolume()
    {
        if(musicVolume + 10 > 100)
        {
            musicVolume = 100;
        }
        else {
            musicVolume = musicVolume + 10;
        }
    }

    public void decreaseMusicVolume()
    {
        if(musicVolume - 10 < 0)
        {
            musicVolume = 0;
        }
        else {
            musicVolume = musicVolume - 10;
        }
    }

    public void increaseSFXVolume()
    {
        if(SFXVolume + 10 > 100)
        {
            SFXVolume = 100;
        }
        else {
            SFXVolume = SFXVolume + 10;
        }
    }

    public void decreaseSFXVolume()
    {
        if(SFXVolume - 10 < 0)
        {
            SFXVolume = 0;
        }
        else {
            SFXVolume = SFXVolume - 10;
        }
    }

    public void stopSound()
    {
        gsMA.stop();
        gsMI.stop();
        gsSStampOut.stop();
        gsSStampIn.stop();
        gsSNext.stop();
        gsSMovePaper1.stop();
        gsSMovePaper2.stop();
        gsSMovePaper3.stop();
        gsSStamp.stop();
        gsSCitation.stop();
        gsME.stop();
    }
}
