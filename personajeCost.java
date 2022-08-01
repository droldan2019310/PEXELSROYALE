import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class personajeCost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class personajeCost extends Actor
{
    /**
     * Act - do whatever the personajeCost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int value=0;
    private String name="";
    private int stringLength;
    
    public personajeCost(String name,int value){
        this.name = name;
        this.value = value;
        stringLength = (this.name.length() + 2) * 16;
        
        
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
        image.setColor(Color.BLACK);
        
        updateImage();
        
    }
    
     private void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(name+ " " +"costo: "+ value, 1, 18);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
