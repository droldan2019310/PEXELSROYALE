import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FantasmaTierra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FantasmaTierra extends Actor
{
    /**
     * Act - do whatever the FantasmaTierra wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timerWait = new SimpleTimer();
    SimpleTimer timerWait1 = new SimpleTimer();
    int life= 4;
    public void act()
    {
        // Add your action code here.
        
        
        
        Caballero caballero;
        caballero = (Caballero) getOneObjectAtOffset(0,0,Caballero.class);
        
        tower1 tower;
        tower = (tower1) getOneObjectAtOffset(0,0,tower1.class);
        
        if(caballero!=null && tower==null){
            if(timerWait.millisElapsed()>1000){
                caballero.attack(1);
                timerWait.mark();
            }
        }else if(caballero==null && tower!=null){
            
            if(timerWait.millisElapsed()>1000){
                tower.attack(1);
                timerWait.mark();
            }
        }else{
            setLocation(getX(), getY()-1);
        }
        
        updateImage();
    }
    
    
     public void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        GreenfootImage myImage = new GreenfootImage("Wraith_02_Attack_000.png");
        myImage.scale(70,70);
        myImage.setColor(Color.WHITE);
        myImage.setFont(image.getFont().deriveFont(18f));
        myImage.drawString(String.valueOf(life), 20, 40);
        setImage(myImage);

    }
}
