package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class ShootingFlower extends Entity {
	
	Animation chomper;
	
	public ShootingFlower(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 35, 45, 0, 2);
		
		Image[] imageLeft = {new Image("res/Enemies/ShootingFlower/ShootingFlower.png"), new Image("res/Enemies/ShootingFlower/ShootingFlower2.png")};
		Image[] imageRight = {new Image("res/Enemies/ShootingFlower/ShootingFlower.png"), new Image("res/Enemies/ShootingFlower/ShootingFlower2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/ShootingFlower/ShootingFlowerDead.png"), new Image("res/Enemies/ShootingFlower/ShootingFlowerDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

}
