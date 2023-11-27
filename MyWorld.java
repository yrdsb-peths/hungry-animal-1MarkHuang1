import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int theScore = 0;
    Label score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //Elephant
        Elephant elephant = new Elephant();
        addObject(elephant, 300,300);
        //Apple
        creatApple();
        //Score Label 
        score = new Label(0,50);
        addObject(score,50, 50);
    }
    public void gameOver(){
        Label gameOver = new Label ("Game Over",100);
        addObject(gameOver,getWidth()/2,getHeight()/2);
    }
    public void increase(){
        theScore++;
        score.setValue(theScore);
    }
        
    public void creatApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple,x,0);
        
    }
}
