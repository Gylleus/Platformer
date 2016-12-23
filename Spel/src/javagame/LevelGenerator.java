package javagame;

import org.newdawn.slick.SlickException;

public class LevelGenerator {

	public LevelGenerator() {
		
	}
	
	public Level createLevel(int lvl) throws SlickException {
		if (lvl == 0) {
			return generateMenuScreen();
		}
		
		//Starting Landscape
		if (lvl == 1) {
			return generateLevelOne();
		}
		if (lvl == 2) {
			return generateLevelTwo();
		}
		if (lvl == 3) {
			return generateLevelThree();
		}
		if (lvl == 4) {
			return generateLevel4();
		}
		if (lvl == 5) {
			return generateLevel5();
		}
		if (lvl == 6) {
			return generateLevel6();
		}
		if (lvl == 7) {
			return generateLevel7();
		}
		if (lvl == 8) {
			return generateLevel8();
		}
		
		// Forest
		
		if (lvl == 9) {
			return generateLevel9();
		}
		if (lvl == 10) {
			return generateLevel10();
		}
		if (lvl == 11) {
			return generateLevel11();
		}
		if (lvl == 12) {
			return generateLevel12();
		}
		if (lvl == 13) {
			return generateLevel13();
		}
		if (lvl == 14) {
			return generateLevel14();
		}
		if (lvl == 15) {
			return generateLevel15();
		}
		if (lvl == 16) {
			return generateLevel16();
		}
		
		// Mountains
		
		if (lvl == 17) {
			return generateLevel17();
		}
		if (lvl == 18) {
			return generateLevel18();
		}
		if (lvl == 19) {
			return generateLevel19();
		}
		if (lvl == 20) {
			return generateLevel20();
		}
		if (lvl == 21) {
			return generateLevel21();
		}
		if (lvl == 22) {
			return generateLevel22();
		}
		if (lvl == 23) {
			return generateLevel23();
		}
		if (lvl == 24) {
			return generateLevel24();
		}
		
		// Caves
		
		if (lvl == 25) {
			return generateLevel25();
		}
		if (lvl == 26) {
			return generateLevel26();
		}
		if (lvl == 27) {
			return generateLevel27();
		}
		if (lvl == 28) {
			return generateLevel28();
		}
		if (lvl == 29) {
			return generateLevel29();
		}
		if (lvl == 30) {
			return generateLevel30();
		}
		if (lvl == 31) {
			return generateLevel31();
		}
		if (lvl == 32) {
			return generateLevel32();
		}
		
		// Desert
		if (lvl == 33) {
			return generateLevel33();
		}
		if (lvl == 34) {
			return generateLevel34();
		}
		if (lvl == 35) {
			return generateLevel35();
		}
		
		return null;
	}
	
	private void generateSpikes(Level level, int index, int end, int yPos, String direction) throws SlickException {
		for (int i = index; i < end; i++) {
			level.generateSpike(i, yPos, direction);
		}
	}
	/**
	 * Generates a specified type of block at a given x and y.
	 * 0 = Flag
	 * 1 = Ground
	 * 2 = Platform
	 * 3 = Forest Ground
	 * 4 = Mountain Ground
	 * 5 = Bouncy Mushroom
	 * 6 = Cave Ground
	 * 7 = Cave Ground
	 * 8 = Cave Cliff
	 * 9 = Desert Cliff
	 * 10 = Desert Ground
	 */
	private void generateBlocks(Level level, int index, int end, int yPos, int type) throws SlickException {
		for (int i = index; i < end; i++) {
			if (type == 0) {
				level.generateFlag(i, yPos);				
			}
			if (type == 1) {
				level.generateLand(i);
			}
			if (type == 2) {
				level.generatePlatform(i, yPos);
			}
			if (type == 3) {
				level.generateForestGround(i);
			}
			if (type == 4) {
				level.generateMountainGround(i);
			}
			if (type == 5) {
				level.generateCliff(i, yPos);
			}
			if (type == 6) {
				level.generateBouncyMushroom(i, yPos);
			}
			if (type == 7) {
				level.generateCaveGround(i);
			}
			if (type == 8) {
				level.generateCaveCliff(i, yPos);
			}
			if (type == 9) {
				level.generateDesertCliff(i, yPos);
			}
			if (type == 10) {
				level.generateDesertGround(i);
			}
		}
	}
	
	private Level generateMenuScreen() throws SlickException {
		Level currentLevel = new Level(2000);
		generateBlocks(currentLevel, -20, 20, 0, 1);
		return currentLevel;
	}
	
/////////////////////			1			///////////////////////
	
	private Level generateLevelOne() throws SlickException {
		Level currentLevel = new Level(2000);
		
		//Blocks
		generateBlocks(currentLevel, -5, 10, 0, 1);
		generateBlocks(currentLevel, 15, 22, 0, 1);
		
		generateBlocks(currentLevel, 26, 30, 300, 2);
		generateBlocks(currentLevel, 35, 39, 300, 2);
		
		generateBlocks(currentLevel, 45, 62, 0, 1);
		
		generateBlocks(currentLevel, 69, 72, 320, 2);
		generateBlocks(currentLevel, 78, 82, 220, 2);
		generateBlocks(currentLevel, 88, 91, 320, 2);
		
		generateBlocks(currentLevel, 94, 100, 0, 1);
		generateBlocks(currentLevel, 98, 99, 300, 0);
		//Enemies
		currentLevel.generateChomper(50, 380);
		
		return currentLevel;
	}
	
/////////////////////			2			///////////////////////
	
	private Level generateLevelTwo() throws SlickException {
		Level currentLevel = new Level(2000);
		
		//Blocks
		generateBlocks(currentLevel, -2, 3, 0, 1);
		
		generateBlocks(currentLevel, 7, 10, 280, 2);
		generateBlocks(currentLevel, 14, 17, 200, 2);
		generateBlocks(currentLevel, 21, 26, 400, 2);
		
		generateBlocks(currentLevel, 31, 36, 400, 2);
		
		generateBlocks(currentLevel, 42, 44, 0, 1);

		generateBlocks(currentLevel, 48, 52, 230, 2);
		generateBlocks(currentLevel, 57, 61, 155, 2);
		
		generateBlocks(currentLevel, 66, 68, 0, 1);
		generateBlocks(currentLevel, 72, 78, 0, 1);
		
		
		generateBlocks(currentLevel, 76, 77, 300, 0);
		//Enemies
		currentLevel.generateChomper(24, 400);
		currentLevel.generateChomper(34, 400);
		currentLevel.generateChomper(50, 230);
		currentLevel.generateChomper(60, 155);
		currentLevel.generateClawer(75, 380);
		
		return currentLevel;
	}
	
/////////////////////			3			///////////////////////
	
	private Level generateLevelThree() throws SlickException {
		Level currentLevel = new Level(2000);
		
		//Blocks
		generateBlocks(currentLevel, -3, 5, 0, 1);
		
		generateBlocks(currentLevel, 7, 11, 450, 2);
		generateBlocks(currentLevel, 15, 18, 450, 2);
		generateBlocks(currentLevel, 22, 26, 450, 2);
		
		generateBlocks(currentLevel, 30, 36, 250, 2);
		generateBlocks(currentLevel, 41, 46, 150, 2);
		
		generateBlocks(currentLevel, 54, 64, 0, 1);
		
		generateBlocks(currentLevel, 71, 72, 350, 2);
		generateBlocks(currentLevel, 79, 80, 350, 2);
		generateBlocks(currentLevel, 87, 88, 350, 2);
		
		generateBlocks(currentLevel, 94, 99, 0, 1);
						
		generateBlocks(currentLevel, 97, 98, 300, 0);
		//Enemies
		currentLevel.generateClawer(8, 450);
		currentLevel.generateClawer(23, 450);
		
		currentLevel.generateLootaz(32, 250);
		
		currentLevel.generateChomper(57, 380);
		currentLevel.generateChomper(61, 380);
		
		return currentLevel;
	}
	
/////////////////////			4			///////////////////////
	
	private Level generateLevel4() throws SlickException {
		Level currentLevel = new Level(2000);
		
		//Blocks
		generateBlocks(currentLevel, -1, 1, 150, 2);
		for (int i = 1; i < 7; i++) {
		generateBlocks(currentLevel, 3 + 4 * i, 6 + 4 * i, 150 + 25 * i, 2);
		currentLevel.generateChomper(3 + 4 * i, 150 + 25 * i);
		}
		
		generateBlocks(currentLevel, 37, 47, 0, 1);
		
		for (int i = 1; i < 4; i++) {
			generateBlocks(currentLevel, 51, 52, 100 + 75 * i, 2);
			currentLevel.generateChomper(51, 100 + 75 * i);
		}
		
		generateBlocks(currentLevel, 61, 68, 150, 2);
		generateBlocks(currentLevel, 72, 79, 300, 2);
		generateBlocks(currentLevel, 85, 90, 175, 2);
		
		generateBlocks(currentLevel, 86, 87, 95, 0);
		//Enemies
		currentLevel.generateLootaz(40, 380);
		currentLevel.generateClawer(72, 300);
		currentLevel.generateClawer(78, 300);
		
		return currentLevel;
	}
	
/////////////////////			5			///////////////////////
	
	private Level generateLevel5() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 3, 300, 2);
		generateBlocks(currentLevel, -1, 30, 0, 1);
		
		generateBlocks(currentLevel, 35, 39, 300, 2);
		generateBlocks(currentLevel, 43, 47, 380, 2);
		generateBlocks(currentLevel, 57, 61, 300, 2);
		
		generateBlocks(currentLevel, 63, 66, 340, 2);
		generateBlocks(currentLevel, 69, 72, 380, 2);
		
		generateBlocks(currentLevel, 83, 94, 0, 1);
		generateBlocks(currentLevel, 97, 101, 0, 1);

		generateBlocks(currentLevel, 99, 100, 300, 0);
		//Enemies
		currentLevel.generateLootaz(15, 380);
		currentLevel.generateLootaz(28, 380);
		
		currentLevel.generateChomper(60, 300);
		currentLevel.generateClawer(64, 340);
		currentLevel.generateClawer(70, 380);
		
		currentLevel.generateLootaz(84, 380);

		return currentLevel;
	}
	
/////////////////////			6			///////////////////////
	
	private Level generateLevel6() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 5, 0, 1);
		generateBlocks(currentLevel, 9, 11, 275, 2);
		generateBlocks(currentLevel, 16, 18, 200, 2);

		generateBlocks(currentLevel, 27, 34, 200, 2);
		
		generateBlocks(currentLevel, 38, 45, 0, 1);

		for (int i = 1; i < 2; i++) {
			generateBlocks(currentLevel, 48, 49, 50 + i * 150, 2);
			currentLevel.generateLootaz(48, 50 + i * 150);
		}
		generateBlocks(currentLevel, 62, 67, 275, 2);
		
		for (int i = 1; i < 7; i++) {
			generateBlocks(currentLevel, 63 + 4 * i, 66 + 4 * i, 150 + 25 * i, 2);
			currentLevel.generateChomper(64 + 4 * i, 150 + 25 * i);
			}
		generateBlocks(currentLevel, 97, 103, 380, 2);
		generateBlocks(currentLevel, 99, 100, 300, 0);
		//Enemies
		
		currentLevel.generateClawer(10, 275);
		currentLevel.generateClawer(17, 200);

		return currentLevel;
	}
	
/////////////////////			7			///////////////////////
	
	private Level generateLevel7() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 2, 150, 2);
		generateBlocks(currentLevel, 3, 30, 0, 1);
		generateBlocks(currentLevel, 3, 30, 175, 2);
		generateBlocks(currentLevel, 31, 59, 200, 2);

		generateBlocks(currentLevel, 91, 95, 0, 1);
		generateBlocks(currentLevel, 93, 94, 300, 0);
		//Enemies
		for (int i = 1; i < 6; i++) {
			currentLevel.generateChomper(1 + 4 * i, 175);
			Chomper chomper = currentLevel.generateChomper(3 + 3 * i, 175);
			chomper.changeDirection();
			
			currentLevel.generateClawer(28 + 4 * i, 200);
			Clawer clawer = currentLevel.generateClawer(31 + 3 * i, 200);
			clawer.changeDirection();
			
			currentLevel.generateLootaz(1 + 4 * i, 380);
			Lootaz lootaz = currentLevel.generateLootaz(1 + 3 * i, 380);
			lootaz.changeDirection();
		}
		
		for (int i = 1; i <= 3; i++) {
			generateBlocks(currentLevel, 58 + i * 6, 63 + i * 6, 150 + 25 * i, 2);
			currentLevel.generateChomper(60 + i * 6, 150 + 25 * i);
			Chomper chomper = currentLevel.generateChomper(60 + i * 6, 150 + 25 * i);
			chomper.changeDirection();
		}

		return currentLevel;
	}
	
/////////////////////			8			///////////////////////
	
	private Level generateLevel8() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 2, 0, 1);
		generateBlocks(currentLevel, 6, 7, 405, 2);
		generateBlocks(currentLevel, 11, 15, 0, 1);
		generateBlocks(currentLevel, 19, 20, 405, 2);
		generateBlocks(currentLevel, 19, 20, 290, 2);
		generateBlocks(currentLevel, 24, 28, 0, 1);
		
		generateBlocks(currentLevel, 35, 36, 300, 2);
		generateBlocks(currentLevel, 43, 45, 340, 2);
		generateBlocks(currentLevel, 52, 54, 340, 2);
		generateBlocks(currentLevel, 61, 63, 340, 2);
		
		generateBlocks(currentLevel, 74, 77, 0, 1);
		
		generateBlocks(currentLevel, 75, 76, 300, 0);
		//Enemies
		currentLevel.generateLootaz(6, 405);
		currentLevel.generateLootaz(19, 405);
		//currentLevel.generateLootaz(19, 290);
		
		currentLevel.generateChomper(35, 300);
		currentLevel.generateClawer(43, 340);
		currentLevel.generateClawer(52, 340);
		currentLevel.generateClawer(61, 340);

		for (int i = 1; i <= 4; i++) {
			currentLevel.generateLootaz(73 + 1 * i, 380);
			Lootaz lootaz = currentLevel.generateLootaz(73 + 1 * i, 380);
			lootaz.changeDirection();
		}
		
		return currentLevel;
	}
	
	///////////////////////////////////////////////////////////////////
/////////////////////			9			///////////////////////
///////////////////////////////////////////////////////////////////
	
	private Level generateLevel9() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 6, 150, 2);
		generateBlocks(currentLevel, 5, 7, 0, 3);
		generateBlocks(currentLevel, 7, 10, 150, 2);
		generateBlocks(currentLevel, 16, 18, 0, 3);
		
		generateBlocks(currentLevel, 18, 22, 150, 2);
		generateBlocks(currentLevel, 18, 46, 410, 2);
		for (int i = 0; i < 5; i++) {
			generateBlocks(currentLevel, 20 + i * 4, 23 + i * 4, 150, 2);
		}
		generateBlocks(currentLevel, 46, 50, 150, 2);
		generateBlocks(currentLevel, 51, 55, 200, 2);
		generateBlocks(currentLevel, 53, 54, 120, 0);
		
		//Enemies
		currentLevel.generateShootingFlower(6, 380);
		currentLevel.generateShootingFlower(17, 380);
		for (int i = 0; i < 5; i++) {
			currentLevel.generateShootingFlower(23 + i * 4, 410);
		}
		
		return currentLevel;
	}
	
	/////////////////////			10			///////////////////////
	
	private Level generateLevel10() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 4, 275, 2);
		generateBlocks(currentLevel, 8, 13, 325, 2);
		generateBlocks(currentLevel, 17, 22, 375, 2);
		generateBlocks(currentLevel, 26, 34, 475, 2);
		
		generateBlocks(currentLevel, 38, 40, 0, 3);
		generateBlocks(currentLevel, 44, 47, 475, 2);
		
		for (int i = 1; i <= 5; i++) {
			generateBlocks(currentLevel, 47 + i * 6, 48 + i * 6, 400 - i * 50, 2);
		}
		generateBlocks(currentLevel, 81, 85, 150, 2);
		generateBlocks(currentLevel, 83, 84, 70, 0);
		
		//Enemies
		currentLevel.generateMenki(10, 325);
		currentLevel.generateMenki(19, 375);
		currentLevel.generateMenki(30, 475);
		Menki menki = currentLevel.generateMenki(30, 475);
		menki.changeDirection();
		
		currentLevel.generateShootingFlower(39, 380);
		currentLevel.generateMenki(45, 475);
		currentLevel.generateMenki(59, 300);
		currentLevel.generateMenki(71, 200);
		
		return currentLevel;
	}
	
	/////////////////////			11			///////////////////////
	
	private Level generateLevel11() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -40, 80, 275, 2);
		generateBlocks(currentLevel, -2, 80, 0, 3);
		generateBlocks(currentLevel, 33, 36, 200, 2);
		generateBlocks(currentLevel, 55, 58, 200, 2);
		generateBlocks(currentLevel, -7, -2, 450, 2);
		
		generateBlocks(currentLevel, -6, -5, 370, 0);
		
		//Enemies
		currentLevel.generateLootaz(30, 380);
		for (int i = 0; i <= 20; i++)  {
			Menki menki = currentLevel.generateMenki(-19 - i, 275);
			menki.changeDirection();
		}
		for (int i = 0; i <= 20; i++) {
			currentLevel.generateMenki(80 - i, 275);
		}
		for (int i = 1; i <= 3; i++) {
			currentLevel.generateShootingFlower(3 + 22 * i, 380);
		}
		
		return currentLevel;
	}
	
	/////////////////////			12			///////////////////////
	
	private Level generateLevel12() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 3, 275, 2);
		generateBlocks(currentLevel, 14, 15, 0, 3);
		generateBlocks(currentLevel, 20, 26, 0, 3);
		generateBlocks(currentLevel, 26, 38, 480, 2);
		generateBlocks(currentLevel, 26, 31, 400, 2);
		generateBlocks(currentLevel, 33, 37, 400, 2);
		generateBlocks(currentLevel, 42, 52, 480, 2);
		generateBlocks(currentLevel, 38, 42, 400, 2);
		generateBlocks(currentLevel, 57, 63, 430, 2);
		generateBlocks(currentLevel, 57, 63, 300, 2);
		
		generateBlocks(currentLevel, 59, 60, 220, 0);
		
		//Enemies
		for (int i = 0; i <= 4; i++) {
			currentLevel.generateSpike(26 + i, 400, "up");
		}
		for (int i = 0; i <= 3; i++) currentLevel.generateSpike(33 + i, 400, "up");;
		currentLevel.generateSpike(38, 400, "up");
		currentLevel.generateSpike(39, 400, "up");
		currentLevel.generateSpike(40, 400, "up");
		currentLevel.generateSpike(41, 400, "up");
		
		currentLevel.generateLootaz(23, 380);
		currentLevel.generateShootingFlower(28, 480);
		currentLevel.generateLootaz(60, 430);
		Lootaz lootaz = currentLevel.generateLootaz(60, 430);
		lootaz.changeDirection();
		
		return currentLevel;
	}
	
/////////////////////			13			///////////////////////
	
	private Level generateLevel13() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateSpikes(currentLevel, 2, 65, 325, "down");
		generateBlocks(currentLevel, -200, 160, 400, 2);
		generateBlocks(currentLevel, 3, 65, 300, 2);
		
		for (int i = 0; i < 12; i++) {
			generateBlocks(currentLevel, 2, 3, 25 + 25 * i, 2);
			generateSpikes(currentLevel, 1, 2, 25 + 25 * i, "left");
		}
		for (int i = 0; i < 13; i++) {
			generateBlocks(currentLevel, -6, -5, 25 + 25 * i, 2);
			generateSpikes(currentLevel, -5, -4, 25 + 25 * i, "right");
		}
		
		generateBlocks(currentLevel, 59, 60, 220, 0);
		
		//Enemies
		for (int i = 0; i < 20; i++) {
			Menki menki = currentLevel.generateMenki(-18 - 8 * i, 400);
			menki.changeDirection();
			currentLevel.generateSchoben(160 - 2 * i, 400);
		}
		return currentLevel;
	}
	
/////////////////////			14			///////////////////////
	
	private Level generateLevel14() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 5, 300, 2);
		generateBlocks(currentLevel, 15, 18, 340, 2);
		
		generateBlocks(currentLevel, 66, 72, 0, 3);
		generateBlocks(currentLevel, 77, 81, 270, 2);
		
		generateBlocks(currentLevel, 78, 79, 190, 0);
		
		//Enemies
		currentLevel.generateChomper(16, 340);
		for (int i = 0; i < 3; i ++) {
		generateBlocks(currentLevel, 24 + 15 * i, 32 + 15 * i, 230, 2);
		currentLevel.generateSchoben(28 + 15 * i, 230);
		Schoben schoben = currentLevel.generateSchoben(28 + 15 * i, 230);
		schoben.changeDirection();
		}
		currentLevel.generateClawer(69, 380);
		Clawer clawer = currentLevel.generateClawer(69, 380);
		clawer.changeDirection();		
		
		return currentLevel;
	}
	
/////////////////////			15			///////////////////////
	
	private Level generateLevel15() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 2, 300, 2);
		generateBlocks(currentLevel, 1, 15, 1, 2);
		generateSpikes(currentLevel, 1, 15, 25, "down");
		generateSpikes(currentLevel, 8, 9, 125, "down");
		for (int i = 0; i < 9; i++) generateBlocks(currentLevel, 2, 3, 100 + 25 * i, 2);
		for (int i = 0; i < 9; i++) generateBlocks(currentLevel, 15, 16, 0 + 25 * i, 2);
		for (int i = 0; i < 8; i++) {
			generateSpikes(currentLevel, 1, 2, 100 + 25 * i, "left");
			generateSpikes(currentLevel, 14, 15, 25 + 25 * i, "left");
		}
		generateBlocks(currentLevel, 8, 12, 100, 2);
		generateBlocks(currentLevel, 18, 22, 260, 2);
		generateBlocks(currentLevel, 28, 32, 220, 2);
		generateSpikes(currentLevel, 28, 29, 220, "up");
		generateSpikes(currentLevel, 31, 32, 220, "up");
		generateSpikes(currentLevel, 27, 28, 220, "left");
		generateSpikes(currentLevel, 32, 33, 220, "right");
		generateSpikes(currentLevel, 28, 32, 245, "down");
		
		generateBlocks(currentLevel, 37, 42, 0, 3);
		generateBlocks(currentLevel, 38, 39, 300, 0);	
		
		//Enemies		
		
		return currentLevel;
	}
	
/////////////////////			16			///////////////////////
	
	private Level generateLevel16() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 2, 0, 3);
		generateBlocks(currentLevel, 2, 42, 380, 2);
		generateBlocks(currentLevel, 2, 42, 450, 2);
		generateBlocks(currentLevel, 3, 39, 300, 2);
		generateSpikes(currentLevel, 2, 39, 325, "down");
		generateBlocks(currentLevel, 6, 40, 175, 2);
		generateSpikes(currentLevel, 6, 40, 200, "down");
		
		for (int i = 0; i < 11; i++) {
			generateSpikes(currentLevel, 40, 41, 355 - 25 * i, "left");
			generateBlocks(currentLevel, 41, 42, 355 - 25 * i, 2);
			generateSpikes(currentLevel, 1, 2, 300 - 25 * i, "left");
			generateBlocks(currentLevel, 2, 3, 300 - 25 * i, 2);
		}
		
		generateBlocks(currentLevel, 44, 48, 220, 2);
		generateBlocks(currentLevel, 45, 46, 140, 0);
		
		//Enemies		
		currentLevel.generateLootaz(20, 175);
		for (int i = 0; i < 5; i++) {
			currentLevel.generateShootingFlower(4 + i * 7, 450);
		}
		
		return currentLevel;
	}
	
	///////////////////////////////////////////////////////////////////
/////////////////////			17			///////////////////////
///////////////////////////////////////////////////////////////////
	
	private Level generateLevel17() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -2, 2, 0, 4);
		generateBlocks(currentLevel, 5, 11, 420, 5);
		generateBlocks(currentLevel, 16, 22, 420, 5);
		generateBlocks(currentLevel, 30, 34, 0, 4);
		
		generateBlocks(currentLevel, 38, 41, 250, 2);
		generateBlocks(currentLevel, 37, 39, 135, 2);
		generateBlocks(currentLevel, 37, 39, 420, 5);
		generateBlocks(currentLevel, 45, 48, 420, 5);
		generateBlocks(currentLevel, 36, 37, 55, 0);
		
		//Enemies		
		currentLevel.generateRockEater(7, 420);
		currentLevel.generateRockEater(18, 420);
		currentLevel.generateSchoben(33, 380);
		currentLevel.generateShootingFlower(38, 420);
		
		return currentLevel;
	}
	
	private Level generateLevel18() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 1, 150, 5);
		generateBlocks(currentLevel, -6, 5, 270, 5);
		generateSpikes(currentLevel, -6, 5, 270, "up");
		generateBlocks(currentLevel, 6, 14, 270, 5);
		generateSpikes(currentLevel, 6, 14, 270, "up");
		
		generateBlocks(currentLevel, -5, 14, 0, 4);
		generateBlocks(currentLevel, 20, 45, 420, 5);
		generateBlocks(currentLevel, 54, 57, 320, 5);
		generateBlocks(currentLevel, 65, 70, 0, 4);
		generateBlocks(currentLevel, 67, 68, 300, 0);
		
		//Enemies		
		RockEater eater = currentLevel.generateRockEater(0, 380);
		eater.changeDirection();
		currentLevel.generateRockEater(10, 380);
		for (int i = 0; i <= 5; i++) {
			currentLevel.generateSchoben(20 + i * 4, 420);
		}
		currentLevel.generateClawer(55, 320);

		return currentLevel;
	}
	
	private Level generateLevel19() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 1, 250, 5);
		generateBlocks(currentLevel, 7, 13, 0, 4);
		generateBlocks(currentLevel, 20, 24, 320, 5);
		generateBlocks(currentLevel, 29, 35, 0, 4);
		generateBlocks(currentLevel, 41, 43, 260, 5);
		generateBlocks(currentLevel, 49, 56, 210, 5);
		generateBlocks(currentLevel, 61, 64, 330, 5);
		
		generateBlocks(currentLevel, 72, 75, 0, 4);
		generateBlocks(currentLevel, 73, 74, 300, 0);
		
		//Enemies		
		currentLevel.generateMiner(9, 380);
		currentLevel.generateMiner(32, 380);
		Miner miner = currentLevel.generateMiner(32, 380);
		miner.changeDirection();
		currentLevel.generateLootaz(53, 210);
		currentLevel.generateChomper(62, 330);

		return currentLevel;
	}
	
	private Level generateLevel20() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -10, 80, 350, 5);
		
		generateBlocks(currentLevel, 72, 75, 0, 4);
		generateBlocks(currentLevel, 73, 74, 270, 0);
		
		//Enemies
		for(int i = 0; i <= 8; i++) {
		currentLevel.generateMiner(-10 + 10 * i, 350);
		Miner miner = currentLevel.generateMiner(-10 + 10 * i, 350);
		miner.changeDirection();
		generateSpikes(currentLevel, -10 + 11 * i, -9 + 11 * i, 350, "up");
		}

		return currentLevel;
	}
	
	private Level generateLevel21() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 430, 5);
		generateBlocks(currentLevel, 5, 10, 0, 4);
		generateBlocks(currentLevel, 7, 8, 250, 5);
		generateBlocks(currentLevel, 18, 21, 150, 5);
		generateBlocks(currentLevel, 26, 38, 0, 4);
		
		generateBlocks(currentLevel, 44, 47, 275, 5);
		generateBlocks(currentLevel, 53, 56, 275, 5);
		
		generateBlocks(currentLevel, 54, 55, 195, 0);
		
		//Enemies
		currentLevel.generateGoat(5, 380);
		currentLevel.generateGoat(32, 380);
		Goat goat = currentLevel.generateGoat(32, 380);
		goat.changeDirection();
		currentLevel.generateRockEater(32, 380);
		currentLevel.generateClawer(20, 150);
		currentLevel.generateClawer(45, 275);

		return currentLevel;
	}
	
	private Level generateLevel22() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 250, 5);
		
		for (int i = 0; i < 7; i++) {
		generateBlocks(currentLevel, 8 + 8 * i, 12 + 8 * i, 320 + 15 * i, 5);
		}
		
		generateBlocks(currentLevel, -10, 60, 475, 2);
		generateSpikes(currentLevel, -10, 60, 475, "up");
		
		generateBlocks(currentLevel, 65, 70, 0, 4);
		generateBlocks(currentLevel, 66, 67, 300, 0);
		
		//Enemies
		for (int i = 0; i <= 10; i++) {
		Goat goat = currentLevel.generateGoat(-10 + 7 * i, 475);
		if (i % 2 == 0) {
			goat.changeDirection();
		}
		}

		return currentLevel;
	}
	
	private Level generateLevel23() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 400, 5);
		generateBlocks(currentLevel, 7, 9, 350, 5);
		generateBlocks(currentLevel, 16, 19, 300, 2);
		generateBlocks(currentLevel, 26, 29, 350, 5);
		generateBlocks(currentLevel, 36, 38, 450, 5);
		generateBlocks(currentLevel, 40, 41, 0, 4);
		generateBlocks(currentLevel, 43, 45, 450, 5);
		
		for (int i = 0; i < 5; i++) {
			generateSpikes(currentLevel, 39, 40, 380 + 25 * i, "left");
			generateSpikes(currentLevel, 41, 42, 380 + 25 * i, "right");
		}
		
		generateBlocks(currentLevel, 53, 59, 450, 5);
		generateBlocks(currentLevel, 56, 57, 370, 0);
		
		//Enemies
		currentLevel.generateRockEater(7, 350);
		currentLevel.generateChomper(17, 300);
		currentLevel.generateMiner(28, 350);
		currentLevel.generateSchoben(40, 380);
		currentLevel.generateGoat(40, 380);
		currentLevel.generateLootaz(56, 450);

		return currentLevel;
	}
	
	private Level generateLevel24() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 1, 120, 2);
		generateBlocks(currentLevel, -4, -1, 200, 5);
		generateBlocks(currentLevel, -20, -4, 225, 2);
		generateSpikes(currentLevel, -20, -4, 225, "up");
		generateSpikes(currentLevel, -20, -4, 250, "down");
		generateBlocks(currentLevel, 4, 20, 225, 2);
		generateSpikes(currentLevel, 4, 20, 225, "up");
		generateSpikes(currentLevel, 4, 20, 250, "down");
		generateBlocks(currentLevel, 1, 4, 200, 5);
		generateSpikes(currentLevel, -1, 1, 145, "down");
		
		generateBlocks(currentLevel, -6, 6, 420, 5);
		generateBlocks(currentLevel, 10, 26, 440, 5);
		generateBlocks(currentLevel, 31, 34, 350, 5);
		generateBlocks(currentLevel, 40, 43, 430, 5);
		generateBlocks(currentLevel, 48, 51, 430, 5);
		
		generateBlocks(currentLevel, 58, 63, 320, 5);
		generateBlocks(currentLevel, 60, 61, 240, 0);
		
		//Enemies
		Miner miner = currentLevel.generateMiner(3, 200);
		miner.changeDirection();
		currentLevel.generateMiner(-3, 200);
		Schoben schoben = currentLevel.generateSchoben(0, 420);
		schoben.changeDirection();
		currentLevel.generateSchoben(0, 420);
		for (int i = 0; i < 6; i++) {
			Menki menki = currentLevel.generateMenki(10 + i * 3, 440);
			if (i % 2 == 0) {
				menki.changeDirection();
			}
		}
		
		currentLevel.generateRockEater(41, 430);
		currentLevel.generateRockEater(49, 430);
		
		return currentLevel;
	}
	
	///////////////////////////////////////////////////////////////////
/////////////////////			25			///////////////////////
///////////////////////////////////////////////////////////////////
	
	private Level generateLevel25() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 4, 0, 7);
		generateBlocks(currentLevel, 0, 1, 340, 6);
		generateBlocks(currentLevel, 3, 10, 80, 8);
		generateBlocks(currentLevel, 12, 17, 80, 8);
		generateBlocks(currentLevel, 19, 24, 80, 8);
		generateBlocks(currentLevel, 25, 27, 105, 8);
		
		generateBlocks(currentLevel, 32, 38, 0, 7);
		generateBlocks(currentLevel, 36, 37, 340, 6);
		for (int i = 0; i < 10; i++) {
			generateBlocks(currentLevel, 40, 41, 405 - i * 25, 2);
			generateSpikes(currentLevel, 39, 40, 405 - 25 * i, "left");
			generateSpikes(currentLevel, 41, 42, 405 - 25 * i, "right");
		}
		for (int i = 0; i < 4; i++) {
			generateBlocks(currentLevel, 40, 41, 0 + i * 25, 2);
			generateSpikes(currentLevel, 39, 40, 0 + 25 * i, "left");
		}
		generateBlocks(currentLevel, 44, 55, 180, 2);
		generateSpikes(currentLevel, 44, 55, 180, "up");
		generateSpikes(currentLevel, 40, 41, 180, "up");
		generateSpikes(currentLevel, 44, 55, 205, "down");
		generateBlocks(currentLevel, 43, 52, 0, 7);
		generateBlocks(currentLevel, 56, 57, 455, 8);
		generateBlocks(currentLevel, 56, 57, 415, 6);
		generateBlocks(currentLevel, 49, 52, 130, 8);
		generateBlocks(currentLevel, 49, 50, 50, 0);
		
		//Enemies
		currentLevel.generateSlime(14, 80);
		Slime slime = currentLevel.generateSlime(22, 80);
		slime.changeDirection();
		currentLevel.generateSlime(45, 380);
		
		return currentLevel;
	}
	
/////////////////////			26			///////////////////////
	
	private Level generateLevel26() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 280, 8);
		generateBlocks(currentLevel, 5, 10, 0, 7);
		generateBlocks(currentLevel, 21, 28, 0, 7);
		generateBlocks(currentLevel, 12, 19, 0, 7);
		generateBlocks(currentLevel, 19, 21, 430, 8);
		generateBlocks(currentLevel, 12, 28, 275, 2);
		generateSpikes(currentLevel, 12, 28, 275, "up");
		generateSpikes(currentLevel, 12, 28, 300, "down");
		
		generateBlocks(currentLevel, 34, 37, 250, 8);
		generateBlocks(currentLevel, 41, 45, 250, 8);
		generateBlocks(currentLevel, 49, 52, 250, 8);
		generateBlocks(currentLevel, 56, 60, 330, 8);
		generateBlocks(currentLevel, 68, 73, 0, 7);
		generateBlocks(currentLevel, 70, 71, 300, 0);
		
		//Enemies
		currentLevel.generateSpider(6, 380);
		currentLevel.generateSpider(45, 250);
		currentLevel.generateMiner(58, 330);
		
		return currentLevel;
	}
	
/////////////////////			27			///////////////////////
	
	private Level generateLevel27() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 80, 0, 7);
		for (int i = 0; i < 6; i++) {
		generateBlocks(currentLevel, 1 + 10 * i, 8 + 10 * i, 280, 8);
		generateSpikes(currentLevel, 1 + 10 * i, 8 + 10 * i, 305, "down");
		generateSpikes(currentLevel, 1 + 10 * i, 8 + 10 * i, 280, "up");
		}
		for (int i = 0; i < 8; i++) {
			currentLevel.generateSlime(16 + 14 * i, 380);
		}
		for (int i = 0; i < 6; i++) {
			currentLevel.generateSlime(16 + 8 * i, 140);
			Slime slime = currentLevel.generateSlime(16 + 8 * i, 140);
			slime.changeDirection();
		}
		generateBlocks(currentLevel, 60, 61, 340, 6);
		generateBlocks(currentLevel, 10, 56, 140, 8);
		generateBlocks(currentLevel, 11, 12, 60, 0);
		//Enemies
		
		return currentLevel;
	}
	
/////////////////////			28			///////////////////////
	
	private Level generateLevel28() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 5, 0, 7);
		generateBlocks(currentLevel, 11, 16, 0, 7);
		
		generateBlocks(currentLevel, 21, 24, 0, 7);
		generateBlocks(currentLevel, 22, 23, 340, 6);
		generateBlocks(currentLevel, 26, 30, 150, 8);
		generateBlocks(currentLevel, 35, 41, 220, 8);
		generateBlocks(currentLevel, 48, 51, 280, 8);
		generateBlocks(currentLevel, 55, 58, 0, 7);
		for (int i = 0; i < 12; i++) {
			generateBlocks(currentLevel, 56, 57, 0 + 25 * i, 2);
			generateSpikes(currentLevel, 55, 56, 0 + 25 * i, "left");
		}
		generateBlocks(currentLevel, 58, 63, 440, 8);
		generateBlocks(currentLevel, 57, 63, 275, 2);
		generateBlocks(currentLevel, 59, 60, 195, 0);

		//Enemies
		currentLevel.generateTroglodyte(13, 380);
		currentLevel.generateTroglodyte(38, 220);
		Troglodyte trog = currentLevel.generateTroglodyte(38, 220);
		trog.changeDirection();
		currentLevel.generateSpider(56, 380);
		
		return currentLevel;
	}
	
/////////////////////			29			///////////////////////
	
	private Level generateLevel29() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 3, 0, 7);
		generateBlocks(currentLevel, 3, 70, 480, 8);
		generateSpikes(currentLevel, 3, 70, 480, "up");
		
		generateBlocks(currentLevel, 10, 11, 440, 6);
		generateBlocks(currentLevel, 22, 23, 440, 6);
		for (int i = 0; i < 12; i++) {
			generateBlocks(currentLevel, 26, 27, 0 + 25 * i, 2);
			generateSpikes(currentLevel, 25, 26, 0 + 25 * i, "left");
			generateBlocks(currentLevel, 35, 36, 125 + 25 * i, 2);
			generateSpikes(currentLevel, 34, 35, 125 + 25 * i, "left");
			generateBlocks(currentLevel, 45, 46, 125 + 25 * i, 2);
			generateSpikes(currentLevel, 44, 45, 125 + 25 * i, "left");
		}
		generateBlocks(currentLevel, 30, 31, 440, 6);
		generateBlocks(currentLevel, 30, 31, 440, 6);
		generateBlocks(currentLevel, 27, 55, 0, 2);
		generateSpikes(currentLevel, 27, 55, 25, "down");
		generateBlocks(currentLevel, 36, 37, 250, 2);
		generateBlocks(currentLevel, 36, 37, 210, 6);
		generateBlocks(currentLevel, 39, 40, 440, 6);
		generateBlocks(currentLevel, 46, 49, 400, 2);
		generateSpikes(currentLevel, 46, 49, 400, "up");
		generateBlocks(currentLevel, 47, 48, 360, 6);
		generateBlocks(currentLevel, 60, 61, 440, 6);
		
		generateBlocks(currentLevel, 68, 72, 200, 8);
		generateBlocks(currentLevel, 69, 70, 120, 0);

		//Enemies
		
		return currentLevel;
	}
	
/////////////////////			30			///////////////////////
	
	private Level generateLevel30() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 300, 8);
		generateBlocks(currentLevel, -5, 70, 0, 7);
		generateBlocks(currentLevel, 33, 37, 250, 8);
		generateSpikes(currentLevel, 28, 42, 380, "up");
		generateSpikes(currentLevel, 33, 37, 275, "down");
		generateBlocks(currentLevel, 70, 79, 480, 8);
		generateBlocks(currentLevel, 75, 76, 400, 0);
		

		//Enemies
		for (int i = 0; i <= 12; i++) {
			Troglodyte trog = currentLevel.generateTroglodyte(0 + 5 * i, 380);
			if (i % 4 == 0) trog.changeDirection();
		}
		currentLevel.generateTroglodyte(35, 250);
		
		return currentLevel;
	}
	
/////////////////////			31			///////////////////////
	
	private Level generateLevel31() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 0, 7);
		generateBlocks(currentLevel, 7, 13, 480, 8);
		generateBlocks(currentLevel, 10, 11, 440, 6);
		for (int i = 0; i <= 15; i++) {
			generateBlocks(currentLevel, 8, 9, 0 + 25 * i, 2);
			generateSpikes(currentLevel, 7, 8, 0 + 25 * i, "left");
			generateSpikes(currentLevel, 9, 10, 0 + 25 * i, "right");
		}
		generateSpikes(currentLevel, 8, 9, 400, "down");
		generateBlocks(currentLevel, 10, 15, 80, 8);
		generateBlocks(currentLevel, 17, 20, 80, 8);
		generateBlocks(currentLevel, 22, 25, 80, 8);
		generateBlocks(currentLevel, 15, 17, 105, 8);
		generateSpikes(currentLevel, 15, 17, 105, "up");
		generateBlocks(currentLevel, 20, 22, 105, 8);
		generateSpikes(currentLevel, 20, 22, 105, "up");
		
		generateBlocks(currentLevel, 27, 30, 105, 8);
		generateBlocks(currentLevel, 34, 42, 155, 8);
		generateBlocks(currentLevel, 46, 50, 155, 8);
		generateBlocks(currentLevel, 48, 49, 75, 0);
		
		//Enemies
		currentLevel.generateSlime(10, 480);
		currentLevel.generateSlime(18, 80);
		currentLevel.generateSlime(23, 80);
		currentLevel.generateSlime(34, 155);
		Slime slime = currentLevel.generateSlime(42, 155);
		slime.changeDirection();
		currentLevel.generateSlime(38, 155);
		Slime slime2 = currentLevel.generateSlime(38, 155);
		slime2.changeDirection();
		
		return currentLevel;
	}
	
/////////////////////			32			///////////////////////
	
	private Level generateLevel32() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 0, 7);
		generateBlocks(currentLevel, 6, 10, 280, 8);
		generateSpikes(currentLevel, 6, 7, 280, "up");
		generateSpikes(currentLevel, 9, 10, 280, "up");
		generateBlocks(currentLevel, 14, 18, 280, 8);
		generateSpikes(currentLevel, 15, 17, 280, "up");
		generateBlocks(currentLevel, 23, 25, 320, 8);
		generateBlocks(currentLevel, 31, 43, 0, 7);
		generateBlocks(currentLevel, 43, 49, 480, 8);
		generateBlocks(currentLevel, 54, 58, 480, 8);
		generateBlocks(currentLevel, 56, 57, 440, 6);
		generateBlocks(currentLevel, 52, 60, 260, 8);
		generateBlocks(currentLevel, 55, 58, 160, 8);
		generateBlocks(currentLevel, 55, 56, 80, 0);
		
		//Enemies
		currentLevel.generateTroglodyte(8, 280);
		currentLevel.generateTroglodyte(15, 280);
		Spider spider = currentLevel.generateSpider(37, 380);
		spider.changeDirection();
		currentLevel.generateSpider(37, 380);
		currentLevel.generateMiner(55, 260);
		
		return currentLevel;
	}
	
	///////////////////////////////////////////////////////////////////
/////////////////////			33			///////////////////////
///////////////////////////////////////////////////////////////////
	
	private Level generateLevel33() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 2, 0, 10);
		generateBlocks(currentLevel, 5, 16, 0, 10);
		generateBlocks(currentLevel, 21, 27, 0, 10);
		
		generateBlocks(currentLevel, 31, 35, 250, 9);
		generateBlocks(currentLevel, 39, 43, 250, 9);
		generateBlocks(currentLevel, 48, 52, 280, 9);
		generateBlocks(currentLevel, 47, 53, 0, 10);
		generateBlocks(currentLevel, 61, 65, 0, 10);
		generateBlocks(currentLevel, 63, 64, 300, 0);
		
		//Enemies
		currentLevel.generateAnubite(8, 380);
		currentLevel.generateAnubite(24, 380);
		Anubite anubite = currentLevel.generateAnubite(24, 380);
		anubite.changeDirection();

		Chomper chomper = currentLevel.generateChomper(33, 250);
		chomper.setDesertChomper();
		Chomper chomper2 = currentLevel.generateChomper(40, 250);
		chomper2.setDesertChomper();
		currentLevel.generateAnubite(49, 280);
		
		return currentLevel;
	}
	
/////////////////////			34			///////////////////////
	
	private Level generateLevel34() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 3, 0, 10);
		generateBlocks(currentLevel, 7, 55, 480, 9);
		generateSpikes(currentLevel, 7, 55, 480, "up");
		for (int i = 0; i < 6; i++) {
		generateBlocks(currentLevel, 8 + 8 * i, 11 + 8 * i, 360, 9);
		currentLevel.generateAnubite(8 + 10 * i, 480);
		Anubite anubite = currentLevel.generateAnubite(10 + 9 * i, 480);
		anubite.changeDirection();
		}
		generateBlocks(currentLevel, 58, 62, 250, 9);
		generateBlocks(currentLevel, 60, 61, 170, 0);
		
		
		//Enemies
		
		return currentLevel;
	}
	
/////////////////////			35			///////////////////////
	
	private Level generateLevel35() throws SlickException {
		Level currentLevel = new Level(2000);

		//Blocks
		generateBlocks(currentLevel, -1, 3, 0, 10);
		generateBlocks(currentLevel, 6, 9, 250, 9);
		generateBlocks(currentLevel, 15, 21, 250, 9);
		generateBlocks(currentLevel, 27, 32, 0, 10);
		
		
		//Enemies
		currentLevel.generateUndeadPriest(18, 250);
		
		return currentLevel;
	}
}
