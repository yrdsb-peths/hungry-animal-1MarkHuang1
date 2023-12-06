import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);

    /**
     * Constructor for objects of class TitleWorld.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, 250, 150);
        prepare();
    }
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void prepare(){
        Elephant elephant = new Elephant();
        addObject(elephant, 400,100);
        elephant.setLocation(500,100);
        Label label = new Label("Use <-- and --> to Move", 40);
        addObject(label,220,257);
        label.setLocation(297,243);
        label.setLocation(305,240);
        Label label2 = new Label("Press <space> to start", 40);
        addObject(label2,249,331);
        label2.setLocation(326,319);
        label.setLocation(328,253);
        label2.setLocation(295,326);
        label.setLocation(295,261);
        
    }

}


