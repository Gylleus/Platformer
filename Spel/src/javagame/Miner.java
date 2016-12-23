package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Miner extends Entity {
	
	Animation chomper;
	private int movementCounter;
	
	public Miner(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 30, 65, 2, 5);
		
		Image[] imageLeft = {new Image("res/Enemies/Miner/MinerWalkingLeft.png"), new Image("res/Enemies/Miner/MinerWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Miner/MinerWalkingRight.png"), new Image("res/Enemies/Miner/MinerWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Miner/MinerDead.png"), new Image("res/Enemies/Miner/MinerDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
	}

	public void speedBoostCheck() {
		if (movementCounter <= 100) {
			movementCounter++;
			if (movementCounter == 70) {
				setMovementSpeed(8);
			}
		}
		else {
			movementCounter = 0;
			setMovementSpeed(2);
		}
	}
}
