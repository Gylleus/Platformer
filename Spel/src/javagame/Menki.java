package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Menki extends Entity {
	
	Animation chomper;
	
	public Menki(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 26, 38, 6, 1);
		
		Image[] imageLeft = {new Image("res/Enemies/Menki/MenkiLeft.png"), new Image("res/Enemies/Menki/MenkiLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Menki/MenkiRight.png"), new Image("res/Enemies/Menki/MenkiRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Menki/MenkiDead.png"), new Image("res/Enemies/Menki/MenkiDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

}
