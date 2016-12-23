package javagame;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{

   Animation character, idleRight, idleLeft, movingLeft, movingRight, jumpingLeft, jumpingRight; //4 animations, bucky will be set to one
   Image worldMap, forestBackground, overlay, overlayGravestone, mountainBackground, cavesBackground, desertBackground;
   boolean quit = false;
   int[] duration = {200,200}; //duration or length of the frame
   float playerPositionX = 0; //bucky will start at coordinates 0,0
   float playerPositionY = 0;
   float shiftX = playerPositionX; //this will shift the screen so bucky appears in middle
   float shiftY = playerPositionY + 160; //half the length and half the width of the screen
   Entity player = new Entity(0, 0, 26, 50, 0, 0);
   int walkingSpeed = 34;
   Level currentLevel;
   LevelGenerator levelGenerator;
   boolean walkable;
   int[] windowSize;
   private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
   boolean playing = true;
   private int jumps = 0;
   
   private boolean[] musicPlaying = new boolean[5]; //Change when adding new music
   private int deaths = 0; 
   private int level = 1;
   boolean facingRight = true;
   private ArrayList<Music> levelMusic = new ArrayList<Music>();
   
   public Play(int state, int[] windowSize){
	   this.windowSize = windowSize;
	   shiftX += windowSize[0]/2;
	   
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	  levelMusic.add(new Music("res/Music/DST_Defunkt.ogg"));
	  levelMusic.add(new Music("res/Music/ForestMusic.ogg"));
	  levelMusic.add(new Music("res/Music/MountainsMusic.ogg"));
	  levelMusic.add(new Music("res/Music/CaveMusic.ogg"));
	  levelMusic.add(new Music("res/Music/DesertMusic.ogg"));
	  levelMusic.get(0).loop();
	   
	  overlay = new Image("res/Overlay.png");
	  overlayGravestone = new Image("res/OverlayGravestone.png");
      worldMap = new Image("res/Background1.png");
      forestBackground = new Image("res/ForestBackground.png");
      mountainBackground = new Image("res/MountainsBackground.png");
      cavesBackground = new Image("res/CavesBackground.png");
      desertBackground = new Image("res/DesertBackground.png");
      Image[] walkLeft = {new Image("res/Player/BeritLeftWalking.png"), new Image("res/Player/BeritLeftWalking2.png")};
      Image[] walkRight = {new Image("res/Player/BeritRightWalking.png"), new Image("res/Player/BeritRightWalking2.png")};
      Image[] standLeft = {new Image("res/Player/BeritLeftStanding.png"), new Image("res/Player/BeritLeftStanding.png")};
      Image[] standRight = {new Image("res/Player/BeritRightStanding.png"), new Image("res/Player/BeritRightStanding.png")};
      Image[] airLeft = {new Image("res/Player/BeritLeftJumping.png"), new Image("res/Player/BeritLeftJumping.png")};
      Image[] airRight = {new Image("res/Player/BeritRightJumping.png"), new Image("res/Player/BeritRightJumping.png")};
      
      movingLeft = new Animation(walkLeft, duration, true);
      movingRight = new Animation(walkRight, duration, true);
      idleRight = new Animation(standRight, duration, false);
      idleLeft = new Animation(standLeft, duration, false);
      jumpingLeft = new Animation(airLeft, duration, false);
      jumpingRight = new Animation(airRight, duration, false);
      
      levelGenerator = new LevelGenerator();
      currentLevel = levelGenerator.createLevel(level);
      
      character = idleRight; //default as soon as game loads
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   if (level <= 8) worldMap.draw(0, 0); //worldMap.draw(playerPositionX, 0); //draw the map at 0,0 to start
	   if (level > 8 && level < 17) forestBackground.draw(0, 0);
	   if (level >= 17 && level <= 24) mountainBackground.draw(0, 0);
	   if (level >= 25 && level <= 32) cavesBackground.draw(0, 0);
	   if (level >= 33 && level <= 40) desertBackground.draw(0, 0);
      character.draw(shiftX,-playerPositionY); //draw bucky at 320, 160 (center of the screen)
      for (ArrayList<Block> list : currentLevel.getBlockList()) {
    	  for (Block block : list) {
    		  block.getBlockImage().draw(block.getXPos() + playerPositionX + block.getXSize()/2 + windowSize[0]/2, block.getYPos());
    	  }
      }
      for (Projectile projectile : projectiles) {
    	  projectile.getProjectileImage().draw(-projectile.getXLocation() + playerPositionX, -projectile.getYLocation());
      }
      
      currentLevel.renderEnemies(playerPositionX, windowSize);
      overlay.draw(0, -10);
      overlayGravestone.draw(50, -2);
      g.drawString((int)Math.ceil((double)level / 8) + "-" + (1 + ((level - 1 ) % 8)), 8, 0);
      g.drawString("x " + deaths, 70, 0);
      
      //when they press escape
      if(quit==true){
         g.drawString("Resume (R)", 250, 100);
         g.drawString("Main Menu (M)", 250, 150);
         g.drawString("Quit Game (Q)", 250, 200);
         if(quit==false){
            g.clear();
         }
      }
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
      Input input = gc.getInput();
      checkMusic();
      tick();
      playerPositionY += player.getYMomentum()/3;
      if (playerPositionY > -0 && player.getYMomentum() > 0) {
    	  playerPositionY = -0;
    	  player.setYMomentum(0);
      }
      
      checkIdle();
      try {
    	checkEnemyCollision();
    	checkProjectileCollision();
		gravity();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      checkWalkable();
      moveEnemies();
      
      
      if(input.isKeyDown(Input.KEY_A)|| input.isKeyDown(Input.KEY_LEFT)){
    	 facingRight = false;
    	 //if (!checkBlockCollision(-(int)playerPositionX, -(int)playerPositionY, walkingSpeed)) {
    	 if (!player.ifInAir()) {
         character = movingLeft;
    	 }
         playerPositionX += walkingSpeed * .1f;
         if(playerPositionX>3240){
            playerPositionX -= walkingSpeed * .1f;
         }
    	 //}
      }
      if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
    	  facingRight = true;
    	  //if (!checkBlockCollision(-(int)playerPositionX, -(int)playerPositionY, walkingSpeed)) {
    	  if (!player.ifInAir()) {
         character = movingRight;
    	  }
         playerPositionX -= walkingSpeed * .1f;
         if(playerPositionX<-8400){
            playerPositionX += walkingSpeed * .1f;
         }
    	 // }
      }
      
      if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_SPACE)) {
    	  if (jumps < 2 && player.getYMomentum() < 6) {
    		  player.jump();
    		  jumps++;
    		  if (facingRight) {
    		  character = jumpingRight;
    		  }
    		  else {
    		  character = jumpingLeft;
    		  }
    	  }
      }
      
      if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && playing) {  	  
    	   	  
    	  Projectile newProjectile = player.shoot(8, 0, new Image("res/Player/PlayerProjectile.png"), playerPositionX -(double)windowSize[0]/2, (double)playerPositionY - 25, true, facingRight, 20, 100);
    	  if (newProjectile != null) {
    	  projectiles.add(newProjectile);
    	  }

      }
      
      //escape
      if(input.isKeyDown(Input.KEY_ESCAPE)){
         quit = true;
      }      
      
      //when they hit escape
      if(quit==true){
         if(input.isKeyDown(Input.KEY_R)){
            quit = false;
         }
         if(input.isKeyDown(Input.KEY_M)){
            sbg.enterState(0);
            try{
               Thread.sleep(250);
            }catch(InterruptedException e){
               e.printStackTrace();
            }
         }
         if(input.isKeyDown(Input.KEY_Q)){
            System.exit(0);
         }
      }
   }
   
   public int getID(){
      return 1;
   }
   
   /**
    * If the player is idle or jumping, then set appropriate animation.
    */
   private void checkIdle() {
	   
	   if (facingRight) {
	    	  character = idleRight;  
	      }
	      else {
	    	  character = idleLeft;
	      }
	      
	   if (!walkable) {
		   if (!player.ifInAir()) jumps = 1;
		   player.setInAir();
	   }
	   
	      if (player.ifInAir()) {
			  if (facingRight) {
			  character = jumpingRight;
			  }
			  else {
			  character = jumpingLeft;
			  }
		  }
   }
   
   private void gravity() throws InterruptedException, SlickException {
	   if (player.ifInAir()) {
		   player.fall();
		   if (playerPositionY < -500) {
			   playerDeath();
		   }
	   }
	   for (Entity enemy : currentLevel.getEnemyList()) {
		   if (enemy.ifInAir()) {
			   int newPos = enemy.getYPos();
			   for (int i = 1; i <= -enemy.getYMomentum()/3; i++) {
				   newPos++;
				   for (ArrayList<Block> list : currentLevel.getBlockList()) {
				    	  for (Block block : list) {
				    		  int blockX = block.getXPos();	
				    		  if (enemy.getXPos() >= blockX && enemy.getXPos() <= blockX + block.getXSize() && block.getYPos() == newPos) {
				    			  enemy.hitGround();
				    			  enemy.setYPos(block.getYPos());
				    			  break;
				    		  }	
			   }
			  }
			   }
			   if (enemy.ifInAir()) {
			   enemy.setYPos(enemy.getYPos() - enemy.getYMomentum()/3);
			   enemy.fall();
			   }
		   }
	   }
   }
   
   /**
    * Checks if the block the player is standing on a walkable block.
    * @throws SlickException
    */
   private void checkWalkable() throws SlickException {
	   walkable = false;
	   for (ArrayList<Block> list : currentLevel.getBlockList()) {
	    	  for (Block block : list) {
	    		  int blockY = block.getYPos();
	    		  int blockX = block.getXPos();
	    		  
	    		  if (-playerPositionX > blockX && -playerPositionX < blockX + block.getXSize()) {
	    			  int temp = -(int)playerPositionY + 51;
	    			  for (int i = 0; i < -player.getYMomentum() + 1; i++) {
	    				 temp--;
	    				 if (temp == block.getYPos()) {
	    			  walkable = true;
	    			  playerPositionY = -blockY + 50;
	    			  if (player.ifInAir()) {
	    			  player.hitGround();
	    			  jumps = 0;
	    			  }
	    			  if (block instanceof FlagBlock) {
	    				  levelWin();
	    			  }
	    			  if (block instanceof BouncyMushroom) {
	    				  player.setYMomentum(40);
	    				  jumps = 0;
	    			  }
	    			  break;
	    		  }
	    			  }
	    		  }
	    	  }
	      }
   }
   
   /**
    * Called when the player dies. Removes a life and respawns.
 * @throws InterruptedException 
 * @throws SlickException 
    */
   private void playerDeath() throws InterruptedException, SlickException {
	   playerPositionX = 0;
	   playerPositionY = 0;
	   deaths++;
	   projectiles.clear();
	  // Thread.sleep(1000);
	   currentLevel = levelGenerator.createLevel(level);
   }
   
   /**
    * Moves all enemies and turns them around if they are too close to an edge.
 * @throws SlickException 
    */
   private void moveEnemies() throws SlickException {
	   enemyShoot();
	   enemyJump();
	   for (Entity enemy : currentLevel.getEnemyList()) {
		   if (enemy.isAlive()) {
		   int newPos = enemy.getXPos() + enemy.getMovementSpeed();
		   boolean changeDirection = true;
		   for (ArrayList<Block> list : currentLevel.getBlockList()) {
		    	  for (Block block : list) {
		    		  int blockX = block.getXPos();	
		    		  if (enemy.ifInAir() && newPos >= blockX && newPos <= blockX + block.getXSize()) {
		   			   changeDirection = false;
		   		   		}
		    		  if (newPos >= blockX && newPos <= blockX + block.getXSize() && block.getYPos() == enemy.getYPos()) {
		    			  changeDirection = false;
		    			  break;
		    		  }		    		  
		   }		   
	   }
		   if (changeDirection) {
			   enemy.changeDirection();
   }
	   
		   enemy.move();
}}}
   
   /**
    * Checks if the player is currently touching and enemy in which case either kill the player, or the enemy.
    * @throws InterruptedException
    * @throws SlickException
    */
   private void checkEnemyCollision() throws InterruptedException, SlickException {
	   for (Entity enemy : currentLevel.getEnemyList()) {
		   if (enemy instanceof Spikes && -playerPositionX > enemy.getXPos() && -playerPositionX < enemy.getXPos() + enemy.getXSize() &&
 				  -playerPositionY + 51 > enemy.getYPos() && -playerPositionY + 51 < enemy.getYPos() + enemy.getYSize()) {
			   playerDeath();
			   break;
		   }
		   if (-playerPositionX > enemy.getXPos() - enemy.getXSize()/2 && -playerPositionX < enemy.getXPos() + enemy.getXSize()/2 &&
 				  -playerPositionY + 51 > enemy.getYPos() && -playerPositionY + 51 < enemy.getYPos() + enemy.getYSize() && enemy.isAlive()) {				   
				   playerDeath();
				   break;
			   		   }
	   }
   }

   /**
    * Iterates over all projectiles, moving them and checking if they hit something.
 * @throws SlickException 
 * @throws InterruptedException 
    */
	private void checkProjectileCollision() throws InterruptedException, SlickException {
		//System.out.println(projectiles.size());
		if (!projectiles.isEmpty()) {
			Iterator<Projectile> iterator = projectiles.iterator();
			while (iterator.hasNext()) {
				Projectile projectile = iterator.next();
				if(projectile.getExpired()) {
					iterator.remove();
					continue;
				}
				projectile.moveProjectile();
						
				if (projectile.isFromPlayer()) {
				for (Entity enemy : currentLevel.getEnemyList()) {
					   if (-projectile.getXLocation() - windowSize[0]/2 >= enemy.getXPos() - enemy.getXSize() && -projectile.getXLocation() - windowSize[0]/2 <= enemy.getXPos() + enemy.getXSize() && -projectile.getYLocation() <= enemy.getYPos() && -projectile.getYLocation() >= enemy.getYPos() - enemy.getYSize() && enemy.isAlive()) {						   
							   enemy.damage();
							   if (enemy instanceof Slime) {
								   Slime slime = currentLevel.generateSlime(enemy.getXPos() / 25, enemy.getYPos());
								   if (enemy.getFacing() == slime.getFacing()) {
									   slime.changeDirection();
								   }
							   }
							   iterator.remove();
							   break;
						   		   }
				   }
				}
				else {
					if (projectile.getXLocation() + windowSize[0]/2 >= playerPositionX - 26 && projectile.getXLocation() + windowSize[0]/2 <= playerPositionX + 26 && projectile.getYLocation() <= playerPositionY && projectile.getYLocation() >= playerPositionY - 50) {
						playerDeath();
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Lowers cooldowns and increases counters.
	 */
	private void tick() {
		player.projectileCDTick();
		for (Entity enemy : currentLevel.getEnemyList()) {
			if (enemy instanceof Miner) {
				((Miner) enemy).speedBoostCheck();
		}
			if (enemy instanceof Troglodyte) {
				((Troglodyte) enemy).changeDirectionCheck();
		}
		}
	}
	
	private void levelWin() throws SlickException {
		level++;
		currentLevel = levelGenerator.createLevel(level);
		character = idleRight;
		playerPositionX = 0;
		playerPositionY = 0;
	}
	
	private boolean checkBlockCollision(int xPos, int yPos, int movement) throws SlickException {
		boolean collide = false;
		  for (ArrayList<Block> list : currentLevel.getBlockList()) {
	    	  for (Block block : list) {
	    		  int blockY = block.getYPos();
	    		  int blockX = block.getXPos();
	    		  for (int i = 0; i < Math.abs(movement); i++) {
	    			  xPos += movement / Math.abs(movement);
	    		  if (xPos > blockX && xPos < blockX + block.getXSize() && yPos - 2 > blockY) {
	    			  System.out.println("x = " + xPos);
	    			  System.out.println("block: " + block.getXPos());
	    			  collide = true;
	    			  if (block instanceof FlagBlock) {
	    				  levelWin();
	    			  }
	    			  break;
	    		  }
	    			  
	    		  }}}
		  return collide;
}

	private void enemyShoot() throws SlickException {
		for (Entity enemy : currentLevel.getEnemyList()) {
			if (enemy instanceof Lootaz && enemy.isAlive()) {
				Projectile newProjectile = enemy.shoot(9, 0, new Image("res/Enemies/Lootaz/LootazProjectile.png"), -enemy.getXPos() - windowSize[0]/2, -enemy.getYPos() + enemy.getYSize()/2 + 7, false, enemy.getFacing(), 50, 100);
				enemy.projectileCDTick();
		    	  if (newProjectile != null) {
		    	  projectiles.add(newProjectile);
		    	  }	}
			
			if (enemy instanceof ShootingFlower && enemy.isAlive()) {
				Projectile newProjectile = enemy.shoot(0, 5, new Image("res/Enemies/ShootingFlower/ShootingFlowerProjectile.png"), -enemy.getXPos() - windowSize[0]/2 - enemy.getXSize()/2, -enemy.getYPos() + enemy.getYSize()/2, false, enemy.getFacing(), 45, 100);
				enemy.projectileCDTick();
		    	  if (newProjectile != null) {
		    	  projectiles.add(newProjectile);
		    	  } }
			
			if (enemy instanceof RockEater && enemy.isAlive()) {
				Projectile newProjectile = enemy.shoot(6, 0, new Image("res/Enemies/RockEater/RockEaterProjectile.png"), -enemy.getXPos() - windowSize[0]/2 - enemy.getXSize()/2, -enemy.getYPos() + enemy.getYSize()/2 + 7, false, enemy.getFacing(), 25, 45);
				enemy.projectileCDTick();
		    	  if (newProjectile != null) {
		    	  projectiles.add(newProjectile);
		    	  } }
			if (enemy instanceof Spider && enemy.isAlive()) {
				Projectile newProjectile = enemy.shoot(13, 0, new Image("res/Enemies/Spider/SpiderProjectile.png"), -enemy.getXPos() - windowSize[0]/2 - enemy.getXSize()/2, -enemy.getYPos() + enemy.getYSize()/2 + 2, false, enemy.getFacing(), 60, 60);
				enemy.projectileCDTick();
		    	  if (newProjectile != null) {
		    	  projectiles.add(newProjectile);
		    	  } }
			if (enemy instanceof UndeadPriest && enemy.isAlive()) {
				Projectile newProjectile = enemy.shoot(7, 0, new Image("res/Enemies/UndeadPriest/UndeadPriestProjectile.png"), -enemy.getXPos() - windowSize[0]/2 - enemy.getXSize()/2, -enemy.getYPos() + enemy.getYSize()/2 + 2, false, enemy.getFacing(), 80, 45);
				Projectile newProjectile2 = enemy.shoot(7, 2, new Image("res/Enemies/UndeadPriest/UndeadPriestProjectile.png"), -enemy.getXPos() - windowSize[0]/2 - enemy.getXSize()/2, -enemy.getYPos() + enemy.getYSize()/2 + 2, false, enemy.getFacing(), 80, 45);
				Projectile newProjectile3 = enemy.shoot(7, -2, new Image("res/Enemies/UndeadPriest/UndeadPriestProjectile.png"), -enemy.getXPos() - windowSize[0]/2 - enemy.getXSize()/2, -enemy.getYPos() + enemy.getYSize()/2 + 2, false, enemy.getFacing(), 80, 45);
				enemy.projectileCDTick();
		    	  if (newProjectile != null) {
		    	  projectiles.add(newProjectile);
		    	  projectiles.add(newProjectile2);
		    	  projectiles.add(newProjectile3);
		    	  } }
		}	
	}
	
	/**
	 * Checks if the right music is currently playing.
	 */
	private void checkMusic() {
		if (!musicPlaying[(int)Math.ceil((double)level / 8) - 1]) {
			levelMusic.get((int)Math.ceil((double)level / 8) - 1).loop();
			musicPlaying[(int)Math.ceil((double)level / 8) - 1] = true;
		}
	}
	
	private void enemyJump() {
		for (Entity enemy : currentLevel.getEnemyList()) {
			if ((enemy instanceof Goat || enemy instanceof Anubite) && !enemy.ifInAir() && enemy.isAlive()) {
				enemy.jump();
			}
		}
	}
	
	}
	
