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
    SimpleTimer time = new SimpleTimer();
    Label score;
    int level = 1;
    boolean isGameOver = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(607, 391, 1);
        //Elephant
        Elephant elephant = new Elephant();
        addObject(elephant, 300,300);
        //Apple
        creatApple();
        //Score Label 
        score = new Label(0,50);
        addObject(score,getWidth()/2, 50);
    }
    
    public void act() {
        if (isGameOver && Greenfoot.isKeyDown("b")){            
            Greenfoot.setWorld(new TitleScreen()); 
        }
    }
    
    public void gameOver(){
        isGameOver = true;
        Label gameOver = new Label ("Game Over",100);
        addObject(gameOver,getWidth()/2,getHeight()/2);
        time.mark();
        
    }
    
    public void increase(){
        theScore++;
        score.setValue(theScore);
        
        if(theScore%5 == 0){
            level += 1;
        }
    }
        
    public void creatApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple,x,0);
        
    }
}
