import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor
{
    /**
     * Act - do whatever the Coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /**
     * Act - do whatever the personajeCost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int value=0;
    private int stringLength;
    
    public Coins(){
        this.value = 10;
        stringLength = (7 + 2) * 16;
        
        
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
        image.setColor(Color.BLACK);
        
        updateImage();
        
    }
    
    
    public boolean updateValue(int valueGastado){
        int newValue = value-valueGastado;
        boolean flag=false;
        if(newValue>=0){
            value = newValue;
            
            flag=true;
        }
        
        return flag;
    }
    
     private void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        image.drawString("COINS: "+ value, 0, 18);
    }
    
    public void act()
    {
        // Add your action code here.
        updateImage();
    }
}
