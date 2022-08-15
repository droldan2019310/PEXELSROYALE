import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tower1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tower1 extends Actor
{
    
    /**
     * Act - do whatever the tower1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int life=200;
    
    public tower1(){
        updateImage();
    }
    
    public void act()
    {
        // Add your action code here.
        updateImage();
    }
    
    public void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        GreenfootImage myImage = new GreenfootImage("tower_21.png");
        myImage.scale(70,70);
        myImage.setColor(Color.WHITE);
        myImage.setFont(image.getFont().deriveFont(18f));
        myImage.drawString(String.valueOf(life), 20, 40);
        setImage(myImage);

    }
    
    
    
    public boolean attack(int danio){
        int validate = life-danio;
        if(validate<0){
            //gano
            World world;
            world= getWorld();
            world.removeObject(this);
            return false;
        }else{
            
            life = life-danio;
            updateImage();
            return true;
        }
    }
}
