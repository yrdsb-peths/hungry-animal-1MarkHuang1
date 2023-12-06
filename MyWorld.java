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
    public int life = 3;
    SimpleTimer time = new SimpleTimer();
    Label score;
    Label lifenum;
    int level = 1;
    public boolean isGameOver = false;
    
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
        createApple();
        //Score Label 
        Label scoreLabel = new Label("Score:",50);
        addObject(scoreLabel,100,50);
        score = new Label(0,50);
        addObject(score,200, 50);
        // life label
        lifenum = new Label(0,50);
        lifenum.setValue(life);
        addObject(lifenum,490,50);
        //health icon 
        Health health = new Health();
        addObject(health,550,50);
    }
    
    public void act() {
        if (life ==0){
            gameOver();
        }
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
   
    public void lifeCount(){
        life = life -1;
        lifenum.setValue(life);
    }
        
    public void createApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple,x,0);
        
    }
}
