import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FantasmaAgua here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FantasmaAgua extends Actor
{
    /**
     * Act - do whatever the FantasmaAgua wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int life= 4;
    SimpleTimer timerWait = new SimpleTimer();
    SimpleTimer timerWait1 = new SimpleTimer();
    public FantasmaAgua(){
        
    }
    public void act()
    {
        // Add your action code here.
        Golem golem;
        golem = (Golem) getOneObjectAtOffset(0,0,Golem.class);
        
        tower2 tower;
        tower = (tower2) getOneObjectAtOffset(0,0,tower2.class);
        
        if(golem!=null && tower==null){
            if(timerWait.millisElapsed()>3000){
                golem.attack(1);
                timerWait.mark();
            }
        }else if(golem==null && tower!=null){
            if(timerWait.millisElapsed()>3000){
                tower.attack(1);
                timerWait.mark();
                setLocation(getX(), getY()-1);
                timerWait.mark();
            }
        }else{
            setLocation(getX(), getY()+1);
        }
        
        updateImage();
    }
    
    
     public void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        GreenfootImage myImage = new GreenfootImage("Wraith_01_Dying_000.png");
        myImage.scale(70,70);
        myImage.setColor(Color.WHITE);
        myImage.setFont(image.getFont().deriveFont(18f));
        myImage.drawString(String.valueOf(life), 20, 40);
        setImage(myImage);

    }
}
