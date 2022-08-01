import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //camino
    private walk walk1;
    private walk walk2;
    //torres
    private tower1 tower1;
    private tower1 tower2;
    
    private tower2 tower3;
    private tower2 tower4;
    
    private personajeCost personaje1;
    private personajeCost personaje2;
    private personajeCost personaje3;
    private FantasmaAgua fantasmaAgua;
    private Coins coin1;
    private Coins coin2;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        
    walk1 = new walk();
    walk2 = new walk();
    
    tower1 = new tower1();
    tower2 = new tower1();
    
    tower3 = new tower2();
    tower4 = new tower2();
    
    personaje1 = new personajeCost("fantasma de agua", 3);
    personaje2 = new personajeCost("Diego           ", 4);
    

    
    coin1 = new Coins();
    
    addObject(walk1, 150,350);
    addObject(walk2, 450,350);    
    
    
    addObject(tower1, 150,100);
    addObject(tower2, 450,100);
    
    addObject(tower3, 150,600);
    addObject(tower4, 450,600);
    //personajes
    addObject(personaje1, 150,20);
    addObject(personaje2, 150,50);
    
    addObject(coin1,450,20);
    }
    
    public void act(){
        boolean flag = true;
        if(Greenfoot.mouseClicked(walk1)){
            coin1.updateValue(2);
            fantasmaAgua = new FantasmaAgua();
            addObject(fantasmaAgua, 150, 130);
        }
        if(Greenfoot.mouseClicked(walk2)){
            coin1.updateValue(3);
            fantasmaAgua = new FantasmaAgua();
            addObject(fantasmaAgua, 450, 130);
        }
    }
}
