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
    GreenfootImage[] idle = new GreenfootImage[8];
    
    public Elephant(){
        for (int i =0; i < idle.length; i++){
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    //animate elephant
    int imageIndex = 0;
    public void animateElephant(){
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            if(Greenfoot.isKeyDown("space")){
                move(-5);
            }
            else{
            move(-1);
            }
        }
        if(Greenfoot.isKeyDown("right"))
        {
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
    
    public void eat(){
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.creatApple();
            world.increase();
            elephantSound.play();
        }
    }
}
