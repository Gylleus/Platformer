package javagame;

import java.util.ArrayList;

import org.newdawn.slick.*;

public class Projectile {

	private double xSpeed;
	private double ySpeed;
	private Image projectileImage;
	private boolean facingRight;
	private boolean isPlayer;
	private int xLocation;
	private int yLocation;
	private int counter = 0;
	private int lifeSpan;
	
	public Projectile(double xSpeed, double ySpeed, Image image, boolean isPlayer, boolean facingRight, double xPlayer, double yPlayer, int lifeSpan) {
		
		projectileImage = image;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.facingRight = facingRight;
		xLocation = (int)xPlayer;
		yLocation = (int)yPlayer;
		this.isPlayer = isPlayer;
		this.lifeSpan = lifeSpan;
	}
	
	public void moveProjectile() {
		if (facingRight) {
			xLocation -= xSpeed;
		}
		else {
			xLocation += xSpeed;
		}
		counter++;
		yLocation += ySpeed;
	}
	
	public Image getProjectileImage() { 
		return projectileImage;
	}
	
	/**
	 * Returns the y-coordinate converted to int.
	 * @return
	 */
	public int getYLocation() {
		return (int)yLocation;
	}
	
	/**
	 * Returns the x-coordinate converted to int.
	 * @return
	 */
	public int getXLocation() {
		return (int)xLocation;
	}
	
	public boolean getExpired() {
		return counter >= lifeSpan;
	}
	
	public boolean isFromPlayer() {
		return isPlayer;
	}
	
}
