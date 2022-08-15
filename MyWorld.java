import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //camino
    private walk walk1;
    private walk walk2;
    //torres
    private tower1 tower1;
    private tower1 tower2;
    
    private tower2 tower3;
    private tower2 tower4;
    
  
    //jugador1
    private FantasmaAgua fantasmaAgua;
    private Diego diego;
    private Caballero caballero;
    private Coins coin1;
    
    
    //jugador2
    private Golem golem;
    private GolemTierra golemTierra;
    private FantasmaTierra fantasmaTierra;
    private Coins coin2;
    
    //personajes del jugador 1.
    private fantasmaPersonaje fantasmaPersonaje;
    private DiegoPersonaje diegoPersonaje;
    private CaballeroPersonaje caballeroPersonaje;
    
    
    //personajes del jugador 2
    
    private GolemPersonaje golemPersonaje;
    private GolemTierraPersonaje golemTierraPersonaje;
    private FantasmaTierraPersonaje fantasmaTierraPersonaje;
    
    int personajeSelected = 0;
    int personajeSelected2 = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        
        walk1 = new walk();
        walk2 = new walk();
        
        //torres jugador1
        tower1 = new tower1();
        tower2 = new tower1();
        
        
        //torres jugador2
        tower3 = new tower2();
        tower4 = new tower2();
        
        
        //personajes jugador 1
        fantasmaPersonaje = new fantasmaPersonaje();
        diegoPersonaje = new DiegoPersonaje();
        caballeroPersonaje = new CaballeroPersonaje();
     
        
        
        //personajes jugador 2
        golemPersonaje = new GolemPersonaje();
        golemTierraPersonaje = new GolemTierraPersonaje();
        fantasmaTierraPersonaje = new FantasmaTierraPersonaje();
        
    
        
        coin1 = new Coins();
        coin2 = new Coins();
        
        addObject(walk1, 150,350);
        addObject(walk2, 450,350);    
        
        //torres jugador1
        addObject(tower1, 150,100);
        addObject(tower2, 450,100);
        //torres jugador2
        addObject(tower3, 150,600);
        addObject(tower4, 450,600);
        
        //personajes jugador 1
        addObject(fantasmaPersonaje, 50,200);
        addObject(diegoPersonaje,50,350);
        addObject(caballeroPersonaje,50,500);
        
        //persona
        addObject(fantasmaTierraPersonaje, 550,200);
        addObject(golemTierraPersonaje,550,350);
        addObject(golemPersonaje,550,500);
        
        
        
        addObject(coin1,40,70);
        addObject(coin2,550,620);
    }
    
    public void act(){
        boolean flag = true;
        
        
        String key = Greenfoot.getKey();
        
        selectPersonajeJugador1(key);
        
        selectPersonajeJugador2(key);    
        
        if(tower1==null && tower2==null){
            
             showText("Hello World", 200, 200);
            
        }else if(tower3==null && tower3==null){
             showText("Hello World", 200, 200);
        }
        
    }
    
    
    
    public void selectPersonajeJugador1(String key){
        
        if (key != null && key.equals("w")){
            if(personajeSelected==3){
                GreenfootImage image = fantasmaPersonaje.getImage();
                image.scale(80,128);
                fantasmaPersonaje.setImage(image);
                
                GreenfootImage image2 = diegoPersonaje.getImage();
                image2.scale(90,140);
                diegoPersonaje.setImage(image2);
                
                GreenfootImage image3 = caballeroPersonaje.getImage();
                image3.scale(80,128);
                caballeroPersonaje.setImage(image3);
                
                personajeSelected = 2;
            }else if(personajeSelected==2){
                GreenfootImage image = fantasmaPersonaje.getImage();
                image.scale(90,140);
                fantasmaPersonaje.setImage(image);
                
                GreenfootImage image2 = diegoPersonaje.getImage();
                image2.scale(80,128);
                diegoPersonaje.setImage(image2);
                
                GreenfootImage image3 = caballeroPersonaje.getImage();
                image3.scale(80,128);
                caballeroPersonaje.setImage(image3);
                
                personajeSelected = 1;
                
            }
            
        }else if(key != null && key.equals("s")){
            if(personajeSelected==1){
                GreenfootImage image = fantasmaPersonaje.getImage();
                image.scale(80,128);
                fantasmaPersonaje.setImage(image);
                
                GreenfootImage image2 = diegoPersonaje.getImage();
                image2.scale(90,140);
                diegoPersonaje.setImage(image2);
                personajeSelected = 2;
                
                GreenfootImage image3 = caballeroPersonaje.getImage();
                image3.scale(80,128);
                caballeroPersonaje.setImage(image3);
                
            }else if(personajeSelected==2){
                GreenfootImage image = fantasmaPersonaje.getImage();
                image.scale(80,128);
                fantasmaPersonaje.setImage(image);
                
                GreenfootImage image2 = diegoPersonaje.getImage();
                image2.scale(80,128);
                diegoPersonaje.setImage(image2);
                personajeSelected = 3;
                
                GreenfootImage image3 = caballeroPersonaje.getImage();
                image3.scale(90,140);
                caballeroPersonaje.setImage(image3);
            }else if(personajeSelected==0){
                GreenfootImage image = fantasmaPersonaje.getImage();
                image.scale(90,140);
                fantasmaPersonaje.setImage(image);
                
                GreenfootImage image2 = diegoPersonaje.getImage();
                image2.scale(80,128);
                diegoPersonaje.setImage(image2);
                personajeSelected = 1;
                
                GreenfootImage image3 = caballeroPersonaje.getImage();
                image3.scale(80,128);
                caballeroPersonaje.setImage(image3);
            }
        }else if(key != null && key.equals("a")){
            if(personajeSelected==1){
                boolean flag = coin1.updateValue(3);
                if(flag){
                    fantasmaAgua = new FantasmaAgua();
                    addObject(fantasmaAgua, 150, 130);
                }
                
            }else if(personajeSelected==2){
                boolean flag = coin1.updateValue(4);
                if(flag){
                    diego = new Diego();
                    addObject(diego, 150,130);
                }
            }else if(personajeSelected==3){
                boolean flag =coin1.updateValue(4);
                if(flag){
                    caballero = new Caballero();
                    addObject(caballero, 150,130);
                }
            }
        }else if (key != null && key.equals("d")){
            if(personajeSelected==1){
                boolean flag = coin1.updateValue(3);
                if(flag){
                    fantasmaAgua = new FantasmaAgua();
                    addObject(fantasmaAgua, 450, 130);
                }
            }else if(personajeSelected==2){
                boolean flag =  coin1.updateValue(4);
                if(flag){
                    diego = new Diego();
                    addObject(diego, 450,130);
                }
            }else if(personajeSelected==3){
                boolean flag =  coin1.updateValue(4);
                if(flag){
                    caballero = new Caballero();
                    addObject(caballero, 450,130);
                }
            }
        }
    }
    
    
    public void selectPersonajeJugador2(String key){
    
        
        if(key != null && key.equals("up")){
            if(personajeSelected2==1){
                GreenfootImage image = golemPersonaje.getImage();
                image.scale(80,128);
                golemPersonaje.setImage(image);
                
                GreenfootImage image2 = golemTierraPersonaje.getImage();
                image2.scale(90,140);
                golemTierraPersonaje.setImage(image2);
                personajeSelected2 = 2;
                
                GreenfootImage image3 = fantasmaTierraPersonaje.getImage();
                image3.scale(80,128);
                fantasmaTierraPersonaje.setImage(image3);
                
            }else if(personajeSelected2==2){
                GreenfootImage image = golemPersonaje.getImage();
                image.scale(80,128);
                golemPersonaje.setImage(image);
                
                GreenfootImage image2 = golemTierraPersonaje.getImage();
                image2.scale(80,128);
                golemTierraPersonaje.setImage(image2);
                personajeSelected2 = 3;
                
                GreenfootImage image3 = fantasmaTierraPersonaje.getImage();
                image3.scale(90,140);
                fantasmaTierraPersonaje.setImage(image3);
            }else if(personajeSelected2==0){
                GreenfootImage image = golemPersonaje.getImage();
                image.scale(90,140);
                golemPersonaje.setImage(image);
                
                GreenfootImage image2 = golemTierraPersonaje.getImage();
                image2.scale(80,128);
                golemTierraPersonaje.setImage(image2);
                personajeSelected2 = 1;
                
                GreenfootImage image3 = fantasmaTierraPersonaje.getImage();
                image3.scale(80,128);
                fantasmaTierraPersonaje.setImage(image3);
            }
        }else if(key != null && key.equals("down")){
             if(personajeSelected2==2){
                GreenfootImage image = golemPersonaje.getImage();
                image.scale(90,140);
                golemPersonaje.setImage(image);
                
                GreenfootImage image2 = golemTierraPersonaje.getImage();
                image2.scale(80,128);
                golemTierraPersonaje.setImage(image2);
                personajeSelected2 = 1;
                
                GreenfootImage image3 = fantasmaTierraPersonaje.getImage();
                image3.scale(80,128);
                fantasmaTierraPersonaje.setImage(image3);
                
            }else if(personajeSelected2==3){
                GreenfootImage image = golemPersonaje.getImage();
                image.scale(80,128);
                golemPersonaje.setImage(image);
                
                GreenfootImage image2 = golemTierraPersonaje.getImage();
                image2.scale(90,140);
                golemTierraPersonaje.setImage(image2);
                personajeSelected2 = 2;
                
                GreenfootImage image3 = fantasmaTierraPersonaje.getImage();
                image3.scale(90,128);
                fantasmaTierraPersonaje.setImage(image3);
            }
        }else if(key != null && key.equals("left")){
            if(personajeSelected2==1){
                boolean flag = coin2.updateValue(4);
                if(flag){
                    golem = new Golem();
                    addObject(golem, 150, 600);
                }
            }else if(personajeSelected2==2){
                boolean flag = coin2.updateValue(4);
                if(flag){
                    golemTierra = new GolemTierra();
                    addObject(golemTierra, 150,600);
                }
            }else if(personajeSelected2==3){
                boolean flag = coin2.updateValue(3);
                if(flag){
                    fantasmaTierra = new FantasmaTierra();
                    addObject(fantasmaTierra, 150,600);
                }
            }
        }else if (key != null && key.equals("right")){
            if(personajeSelected2==1){
                boolean flag = coin2.updateValue(4);
                if(flag){
                    golem = new Golem();
                    addObject(golem, 450, 600);
                }
            }else if(personajeSelected2==2){
                boolean flag = coin2.updateValue(4);
                if(flag){
                    golemTierra = new GolemTierra();
                    addObject(golemTierra, 450,600);
                }
            }else if(personajeSelected2==3){
                boolean flag = coin2.updateValue(3);
                if(flag){
                    fantasmaTierra = new FantasmaTierra();
                    addObject(fantasmaTierra, 450,600);
                }
            }
        }
    }
}
