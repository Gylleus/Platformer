package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class RockEater extends Entity {
	
	Animation chomper;
	
	public RockEater(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 50, 27, 1, 4);
		
		Image[] imageLeft = {new Image("res/Enemies/RockEater/RockEaterLeft.png"), new Image("res/Enemies/RockEater/RockEaterLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/RockEater/RockEaterRight.png"), new Image("res/Enemies/RockEater/RockEaterRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/RockEater/RockEaterDead.png"), new Image("res/Enemies/RockEater/RockEaterDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

}
