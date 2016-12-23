package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Lootaz extends Entity {
	
	Animation chomper;
	
	public Lootaz(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 34, 49, 3, 3);
		
		Image[] imageLeft = {new Image("res/Enemies/Lootaz/lootazLeft.png"), new Image("res/Enemies/Lootaz/lootazLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Lootaz/lootazRight.png"), new Image("res/Enemies/Lootaz/lootazRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Lootaz/LootazDead.png"), new Image("res/Enemies/Lootaz/LootazDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

}
