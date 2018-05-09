package com.roshambo.gc;

/*
 *  Lab 13 by Vicki Rush
 *    May 8, 2018
 */
import java.util.ArrayList;
import java.util.Scanner;

import com.roshambo.gc.Player.roshambo;

public class RoshamboApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String oppChoice, playChoiceLetter, gameResult, prompt;
		roshambo playChoiceWord, opponentPlay;
		Human user = new Human();
		Player rockUser = new Rocky();
		Player randomUser = new Randomy();
		ArrayList<String> checkRPS = new ArrayList<>();
		checkRPS.add("R");
		checkRPS.add("P");
		checkRPS.add("S");
		ArrayList<String> checkJS = new ArrayList<>();
		checkJS.add("J");
		checkJS.add("S");
		String cont = "y";

		// Get user input -- name
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.println();
		prompt = "Enter your name: ";
		user.setName(Validator.getString(scan, prompt));
		System.out.println();
		while (cont.equalsIgnoreCase("y")) {

			// Select opponent - get input
			prompt = "Would you like to play against TheJets or TheSharks (j/s)?:";
			oppChoice = Validator.getString(scan, prompt, checkJS);
			System.out.println();

			// & (rock, paper, scissors)
			prompt = "Rock, paper, or scissors? (R/P/S): ";
			playChoiceLetter = Validator.getString(scan, prompt, checkRPS);
			System.out.println();
			if (playChoiceLetter.equalsIgnoreCase("r")) {
				playChoiceWord = roshambo.Rock;
			} else if (playChoiceLetter.equalsIgnoreCase("p")) {
				playChoiceWord = roshambo.Paper;
			} else {

				// already validated, so must equal "s"
				playChoiceWord = roshambo.Scissors;
			}

			// print player choices
			if (oppChoice.equalsIgnoreCase("j")) {
				opponentPlay = rockUser.generateRoshambo();
				System.out.println(user.getName() + ": " + playChoiceWord);
				System.out.println("TheJets: " + opponentPlay);
			} else {
				// already validated, so must equal "s"
				opponentPlay = randomUser.generateRoshambo();
				System.out.println(user.getName() + ": " + playChoiceWord);
				System.out.println("TheSharks: " + opponentPlay);
			}

			// determine winner
			gameResult = winLoseDraw(playChoiceWord, opponentPlay);

			// print results and ask whether to continue
			System.out.println("You " + gameResult);
			System.out.println();
			prompt = "Play again? (y/n): ";
			cont = Validator.getString(scan, prompt);
			System.out.println();
		}
	}

	// Match
	public static String winLoseDraw(roshambo userPlay, roshambo opponentPlay) {
		String result;
		if (userPlay == opponentPlay) {
			result = "Draw";
		} else if (userPlay == roshambo.Rock && opponentPlay == roshambo.Scissors) {
			result = "Win";
		} else if (userPlay == roshambo.Paper && opponentPlay == roshambo.Rock) {
			result = "Win";
		} else if (userPlay == roshambo.Scissors && opponentPlay == roshambo.Paper) {
			result = "Win";
		} else {
			result = "Lose";
		}
		return result;

	}

}
