import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Golem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Golem extends Actor
{
    /**
     * Act - do whatever the Golem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timerWait = new SimpleTimer();
    int life = 10;
    
    static final int CHG_RATE = 10; // adjust to suit
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] images = { "Golem_02_Walking_004.png", "Golem_02_Walking_008.png" };
    
    
    int chgImgIn1 = 1; 
    int imgNum1 = 1;
    String[] imagesAttack = { "Golem_02_Attacking_002.png", "Golem_02_Attacking_008.png" };
    static final int CHG_RATE1 = 1; // adjust to suit
    
    public void act(){
        
        
        tower1 tower;
        tower = (tower1) getOneObjectAtOffset(0,0,tower1.class);
        
        boolean flag;
        if(tower!= null){
            if(timerWait.millisElapsed()>3000){
                chgImgIn1 --;
                if (chgImgIn1 == 0){
                    
                    
                    flag = tower.attack(10);
                    if(flag){
                        chgImgIn1 = CHG_RATE1; // reset countdown
                        imgNum1 = (imgNum1 + 1) % 2; // this will alternate {0, 1, 0, 1...}
                        GreenfootImage myImage = new GreenfootImage(imagesAttack[imgNum1]);
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
                setLocation(getX(), getY()-3);
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
