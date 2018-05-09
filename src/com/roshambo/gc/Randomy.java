package com.roshambo.gc;

public class Randomy extends Player {


	@Override
	public roshambo generateRoshambo() {
		int randomNum = 1 + (int)(Math.random() * 3);
		switch (randomNum) {

		case 1:
			return roshambo.Rock;
		case 2:
			return roshambo.Paper;
		case 3:
			return roshambo.Scissors;
		default:
			return null;
		}
	}

}
