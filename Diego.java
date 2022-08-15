import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    

/**
 * Write a description of class Diego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diego extends Actor
{
    /**
     * Act - do whatever the Diego wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   
    SimpleTimer timerWait = new SimpleTimer();
    SimpleTimer timerWait1 = new SimpleTimer();
    static final int CHG_RATE = 10; // adjust to suit
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] images = { "diegoWalk.png", "diegoJump.png" };
    
    static final int CHG_RATE1 = 1; // adjust to suit
    int chgImgIn1 = 1; 
    int imgNum1 = 1;
    String[] images1 = { "diegoWalk.png", "Shooting_while_standing (48 x 48).png" };
    
    int life = 7;
    public void act()
    {
        // Add your action code here.
        
        Golem golem;
        golem = (Golem) getOneObjectAtOffset(0,0,Golem.class);
        
        tower2 tower;
        tower = (tower2) getOneObjectAtOffset(0,0,tower2.class);
        
        
        
        if(golem!=null && tower==null){
            if(timerWait.millisElapsed()>3000){
                golem.attack(4);
                chgImgIn1--;
                if (chgImgIn1 == 0){
                    chgImgIn1 = CHG_RATE1; // reset countdown
                    imgNum1 = (imgNum1 + 1) % 2; // this will alternate {0, 1, 0, 1...}
                    GreenfootImage myImage = new GreenfootImage(images1[imgNum1]);
                    myImage.setColor(Color.WHITE);
                    myImage.setFont(myImage.getFont().deriveFont(18f));
                    myImage.drawString(String.valueOf(life), 20, 40);
                    setImage(myImage);
                }
                setLocation(getX(), getY()-1);
                timerWait.mark();
            }
            
        }else if(golem==null && tower!=null){
            if(timerWait1.millisElapsed()>3000){
                tower.attack(4);
                chgImgIn1--;
                if (chgImgIn1 == 0){
                    chgImgIn1 = CHG_RATE1; // reset countdown
                    imgNum1 = (imgNum1 + 1) % 2; // this will alternate {0, 1, 0, 1...}
                    GreenfootImage myImage = new GreenfootImage(images1[imgNum1]);
                    myImage.setColor(Color.WHITE);
                    myImage.setFont(myImage.getFont().deriveFont(18f));
                    myImage.drawString(String.valueOf(life), 20, 40);
                    setImage(myImage);
                }
                timerWait1.mark();
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
}
