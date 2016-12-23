package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Troglodyte extends Entity {
	
	Animation chomper;
	private int movementCounter;
	
	public Troglodyte(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 29, 40, 2, 4);
		
		Image[] imageLeft = {new Image("res/Enemies/Troglodyte/TroglodyteWalkingLeft.png"), new Image("res/Enemies/Troglodyte/TroglodyteWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Troglodyte/TroglodyteWalkingRight.png"), new Image("res/Enemies/Troglodyte/TroglodyteWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Troglodyte/TroglodyteDead.png"), new Image("res/Enemies/Troglodyte/TroglodyteDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
	}

	public void changeDirectionCheck() {
		if (movementCounter < 100) {
			movementCounter++;
			if (movementCounter == 65) {
				changeDirection();
				setMovementSpeed(4);
			}
		}
		else {
			movementCounter = 0;
			setMovementSpeed(2);
			changeDirection();
		}
	}
}
