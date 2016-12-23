package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Chomper extends Entity {
	
	Animation chomper;
	
	public Chomper(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 25, 25, 2, 1);
		
		Image[] imageLeft = {new Image("res/Enemies/Chomper/ChomperWalkingLeft.png"), new Image("res/Enemies/Chomper/ChomperWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Chomper/ChomperWalkingRight.png"), new Image("res/Enemies/Chomper/ChomperWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Chomper/ChomperDead.png"), new Image("res/Enemies/Chomper/ChomperDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
	}

	public void setDesertChomper() throws SlickException {
		Image[] imageLeft = {new Image("res/Enemies/Chomper/DesertChomperWalkingLeft.png"), new Image("res/Enemies/Chomper/DesertChomperWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Chomper/DesertChomperWalkingRight.png"), new Image("res/Enemies/Chomper/DesertChomperWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Chomper/DesertChomperDead.png"), new Image("res/Enemies/Chomper/DesertChomperDead.png")};
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setMovementSpeed(3);
	}
	
}
