import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caballero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caballero extends Actor
{
    /**
     * Act - do whatever the Caballero wants to do. This method is called whenever
     * the 'At' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timerWait = new SimpleTimer();
    SimpleTimer timerWait1 = new SimpleTimer();
    static final int CHG_RATE = 10; // adjust to suit
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] images = { "Standing (48 x 48).png", "Jump (48 x 64).png" };
    
    
    static final int CHG_RATE1 = 1; // adjust to suit
    int chgImgIn1 = 1; 
    int imgNum1 = 1;
    String[] images1 = { "Standing (48 x 48).png", "Down_swing (80 x 64).png" };
    
    int life = 6;
    public void act()
    {
        // Add your action code here.
        tower2 tower;
        tower = (tower2) getOneObjectAtOffset(0,0,tower2.class);
        boolean flag;
        if(tower!= null){
            chgImgIn1--;
             if(timerWait.millisElapsed()>3000){
                flag = tower.attack(4);
                if(flag){
                    if (chgImgIn1 == 0){
                        chgImgIn1 = CHG_RATE1; // reset countdown
                        imgNum1 = (imgNum1 + 1) % 2; // this will alternate {0, 1, 0, 1...}
                        GreenfootImage myImage = new GreenfootImage(images1[imgNum1]);
                        myImage.setColor(Color.WHITE);
                        myImage.setFont(myImage.getFont().deriveFont(18f));
                        myImage.drawString(String.valueOf(life), 20, 40);
                        setImage(myImage);
                    }
                }
                timerWait.mark();
            }
            
        }else{
            chgImgIn--;
            if (chgImgIn == 0){
                chgImgIn = CHG_RATE; // reset countdown
                imgNum = (imgNum + 1) % 2; // this will alternate {0, 1, 0, 1...}
                GreenfootImage myImage = new GreenfootImage(images[imgNum]);
                myImage.setColor(Color.WHITE);
                myImage.setFont(myImage.getFont().deriveFont(18f));
                myImage.drawString(String.valueOf(life), 20, 40);
                setImage(myImage);
                setLocation(getX(), getY()+3);
            }
        }
        
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
            chgImgIn--;
            if (chgImgIn == 0){
                chgImgIn = CHG_RATE; // reset countdown
                imgNum = (imgNum + 1) % 2; // this will alternate {0, 1, 0, 1...}
                GreenfootImage myImage = new GreenfootImage(images[imgNum]);
                myImage.setColor(Color.WHITE);
                myImage.setFont(myImage.getFont().deriveFont(18f));
                myImage.drawString(String.valueOf(life), 20, 40);
                setImage(myImage);
            }
            return true;
        }
    }
}
