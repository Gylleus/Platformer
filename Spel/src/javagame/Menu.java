package javagame;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
   
   Image playNow;
   Image exitGame;
   private Image worldMap;
   LevelGenerator levelGenerator = new LevelGenerator();
   Level menuLevel;
   private Animation movingRight;
   
   public Menu(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
      playNow = new Image("res/playButton.png");
      exitGame = new Image("res/exitButton.png");
      menuLevel = levelGenerator.createLevel(0);
      worldMap = new Image("res/Background1.png");
      
      int[] duration = {200, 200};
      Image[] walkRight = {new Image("res/Player/BeritRightWalking.png"), new Image("res/Player/BeritRightWalking2.png")};
      movingRight = new Animation(walkRight, duration, true);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   worldMap.draw(0, 0);
	   movingRight.draw(335, 330);
	   for (ArrayList<Block> list : menuLevel.getBlockList()) {
	    	  for (Block block : list) {
	    		  block.getBlockImage().draw(block.getXPos() + block.getXSize()/2 + 350, block.getYPos());
	    	  }
	      }
      playNow.draw(270,100);
      exitGame.draw(270,200);
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
      int posX = Mouse.getX();
      int posY = Mouse.getY();
      //play now button
      if((posX>270 && posX<430)&&(posY>360 && posY<400)){
         if(Mouse.isButtonDown(0)){
            sbg.enterState(1);
         }
      }
      //exit game
      if((posX>270 && posX<430)&&(posY>260 && posY<300)){
         if(Mouse.isButtonDown(0)){
            System.exit(0);
         }
      }
   }
   
   public int getID(){
      return 0;
   }
}