package javagame;

import javax.swing.JOptionPane;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
   
   public static final String gamename = "Berit's Adventure";
   public static final int menu = 0;
   public static final int play = 1;
   public static final int idle = 2;
   private static int[] windowSize = {700, 500};
   
   public Game(String gamename){
      super(gamename);
      this.addState(new Menu(menu));
      this.addState(new Play(play, windowSize));
     // this.addState(new IdleScreen(idle));
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(menu).init(gc, this);
      this.getState(play).init(gc, this);
      this.enterState(menu);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Game(gamename));
         appgc.setShowFPS(false);
         appgc.setTargetFrameRate(70);
         appgc.setDisplayMode(windowSize[0], windowSize[1], false);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }

}