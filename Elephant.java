import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * If the user presses the Left arrow key, the elephant actor will be flipped
     */
    public Elephant(){
        for (int i =0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(50,50);
        }
        
        for (int i =0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50,50);
        }
        
        animationTimer.mark();
        // initial 
        setImage(idleRight[0]);
    }
    /**
     * Animation for the elepahnt
     */
    int imageIndex = 0;
    public void animateElephant(){
        if(animationTimer.millisElapsed() < 50){
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * code is played when the game starts
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            facing = "left";
            if(Greenfoot.isKeyDown("space")){
                move(-5);
            }
            else{
            move(-1);
            }
        }
        if(Greenfoot.isKeyDown("right"))
        {
            facing = "right";
            if (Greenfoot.isKeyDown("space")){
                move(5);
            }
            else{
            move(1);
            }
        }
        eat();
        
        animateElephant();
    }
    
    /**
     * This segment is played whenever the elephant touches an apple
     */
    public void eat(){
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increase();
            elephantSound.play();
        }
    }
}
