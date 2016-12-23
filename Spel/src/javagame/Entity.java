package javagame;

import org.newdawn.slick.*;

/**
 * Superclass for all enemies and the player.
 * @author ZnigelN
 *
 */
public class Entity {

	private int yMomentum;
	private int xMomentum;
	private int xPos;
	private int yPos;
	private int xSize;
	private int ySize;
	private boolean inAir;
	private Animation walkAnimationLeft;
	private Animation walkAnimationRight;
	private Animation deathAnimation;
	private int[] frameDuration = {200,200};
	private int corpseTime = 0;
	private int movement;
	private boolean facing; //false = left, true = right
	private boolean alive = true;
	private int projectileCooldown;
	private int health;
	
	private Animation jumpAnimationLeft;
	private Animation jumpAnimationRight;
	
	private Sound deathSound;
	
	public Entity(int xSpawn, int ySpawn, int width, int height, int speed, int health) {
		yMomentum = 0;
		xPos = xSpawn;
		yPos = ySpawn;
		xSize = width;
		ySize = height;
		movement = speed;
		facing = false;
		this.health = health;		
	}
	
	/**
	 * Moves the enemy by the set movement speed in current direction.
	 */
	public void move() {
		if (facing) {
				xPos += movement;
			}
		else {
			xPos -= movement;
		}
	}
	
	public void setYPos(int value) {
		yPos = value;
	}
	
	public void setProjectileCD(int value) {
		projectileCooldown = value;
	}
	
	public void setXPos(int value) {
		xPos = value;
	}
	
	public void setDeathSound(Sound sound) {
			deathSound = sound;
	}
	
	public void setMovementSpeed(int value) {
		movement = value;
	}
	
	public void onGround() {
		inAir = false;
	}
	
	public Projectile shoot (double xSpeed, double ySpeed, Image image, double xPlayer, double yPlayer, boolean ifPlayer, boolean facingRight, int cooldown, int lifeSpan) {
		if (projectileCooldown == 0) {
		Projectile projectile = new Projectile(xSpeed, ySpeed, image, ifPlayer, facingRight, xPlayer, yPlayer, lifeSpan);
		projectileCooldown = cooldown;
		return projectile;
		}
		return null;
	}
	
	public void damage() {
		health--;
		if (health == 0) {
			//deathSound.play();
			alive = false;
		}
	}
	
	public void projectileCDTick() {
		if (projectileCooldown > 0) {
		projectileCooldown--;
		}
	}
	
	public void setInAir() {
		inAir = true;
	}
	
	public void changeDirection() {
		facing = !facing;
	}
	
	public void hitGround() {
		inAir = false;
		yMomentum = 0;
	}
	
	public boolean ifInAir() {
		return inAir;
	}
	
	public void jump() {
		yMomentum = 25;
		inAir = true;
	}
	
	
	public int getYMomentum() {
		return yMomentum;
	}
	
	public int getProjectileCD() {
		return projectileCooldown;
	}
	
	public void fall() {
		if (yMomentum >= -35) {
			yMomentum--;
		}
	}
	
	public void setJumpAnimation(Image[] left, Image[] right) {
		jumpAnimationLeft = new Animation(left, frameDuration, true);
		jumpAnimationRight = new Animation(right, frameDuration, true);
	}
	
	public void setYMomentum(int value) {
		yMomentum = value;
	}
	
	public void setWalkAnimation(Image[] imageLeft, Image[] imageRight) {
		walkAnimationLeft = new Animation(imageLeft, frameDuration, true);
		walkAnimationRight = new Animation(imageRight, frameDuration, true);
	}
	
	public void setDeathAnimation(Image[] imageDead) {
		deathAnimation = new Animation(imageDead, frameDuration, true);
	}
	
	//Typical return functions
	
	public Animation getAnimation() {
		if (corpseTime == 0) {
			if (facing) {
			return walkAnimationRight;
			}
			if (!facing) {
				return walkAnimationLeft;
			}
		}
		return null;
	}
	
	public Animation getDeathAnimation() {
		return deathAnimation;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getXSize() {
		return xSize;
	}
	
	public int getYSize() {
		return ySize;
	}
	
	
	public boolean getFacing() {
		return facing;
	}
	
	public int getMovementSpeed() {
		if (facing) {
			return movement;
		}
		return -movement;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public Animation getJumpAnimation() {
		if (facing) {
			return jumpAnimationRight;
			}
			if (!facing) {
				return jumpAnimationLeft;
			}		
		return null;
	}
	
}
