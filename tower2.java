import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tower2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tower2 extends Actor
{
    /**
     * Act - do whatever the tower2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int life=200;
    
    public tower2(){
        updateImage();
    }
    
    public void act()
    {
        // Add your action code here.
        updateImage();
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
    
    public void updateImage(){
        
        
        GreenfootImage image = getImage();
        image.clear();
        GreenfootImage myImage = new GreenfootImage("tower_51.png");
        myImage.scale(70,70);
        myImage.setColor(Color.WHITE);
        myImage.setFont(image.getFont().deriveFont(18f));
        myImage.drawString(String.valueOf(life), 20, 40);
        setImage(myImage);
    }
}
