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
    
    SimpleTimer timerWait = new SimpleTimer();
    public Coins(){
        this.value = 10;
        stringLength = (7 + 2) * 16;

        
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
        GreenfootImage myImage = new GreenfootImage("coin.png");
        setImage(myImage);
        myImage.scale(70,70);
        myImage.setColor(Color.WHITE);
        myImage.setFont(image.getFont().deriveFont(18f));
        myImage.drawString("X"+ value, 40, 67);
    }
    long lastAdded = System.currentTimeMillis();

    public void act()
    {
        // Add your action code here.
        
        updateImage();
        
        if(timerWait.millisElapsed()>3000){
            updateValue();
            timerWait.mark();
        }
        
        
    }
    
    
    
    public boolean  updateValue(){
        
        if(value<10){
            value=value+1;
            return true;
        }else{
            return false;
        }
            
    }
}
