import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the FaceGraphic class. It is very abstract, and is used only for the face graphics that are
 * displayed in the window. This screen is similar to the Graphic class, however it needs to be seperate 
 * to ensure that only objects of type FaceGraphic are deleted when going to the next document
 */
public class FaceGraphic extends Graphic
{
    public FaceGraphic(int image, String gender)
    {
        super("faces/window/" + gender + "/" + image); //Runs the constructor in the super class to set the image
        
    }
}
