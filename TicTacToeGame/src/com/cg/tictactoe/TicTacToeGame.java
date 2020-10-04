package com.cg.tictactoe;

import java.util.*;

/**
 * @author Abhishek Bhui
 *
 */
public class TicTacToeGame {
	Scanner sc = new Scanner(System.in);

	/**
	 * UC1 Creating Board
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int index = 1; index < 10; index++) {
			board[index] = ' ';
		}
		return board;
	}

	/**
	 * UC2 Taking Input
	 */
	public static char inputLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your letter(X/O)");
		char userInput = sc.next().charAt(0);
		Character.toUpperCase(userInput);
		if (userInput == 'X' || userInput == 'O')
			return userInput;
		else
			System.out.println("Invalid letter");
		return inputLetter();
	}

	/**
	 * UC3 Show the board
	 */
	public static void showBoard(char[] board) {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3] + "\n");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6] + "\n");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9] + "\n");
	}

	/**
	 * UC4 Select the location
	 */
	public static void selectLocation(char[] board, char player) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Select the location");
		int location = sc.nextInt();
		if (!checkFreeSpace(board, location)) {
			System.out.println("location occupied");

		} else
			board[location] = player;
		showBoard(board);

		sc.close();
	}

	/**
	 * UC5 Check for free space
	 */
	private static boolean checkFreeSpace(char[] board, int index) {
		return board[index] == ' ';
	}

	/**
	 * UC6 toss to decide who starts
	 */
	public boolean toss() {
		System.out.println("select H/T");
		char toss = Character.toUpperCase(sc.next().charAt(0));
		int temp = (int) (Math.random() * 2 % 2);
		char result;
		if (temp == 0)
			result = 'H';
		else
			result = 'T';
		if (result == toss) {
			System.out.println("user won the toss");
			return true;
		} else {
			System.out.println("user lost the toss");
			return false;
		}

	}
	/**
	 * UC7 Check for winning condition
	 */
	public int checkWin(char[] board) {
		if (board[1] == board[2] && board[2] == board[3])
			return 1;
		else if (board[4] == board[5] && board[5] == board[6])
			return 1;
		else if (board[7] == board[8] && board[8] == board[9])
			return 1;
		else if (board[1] == board[4] && board[4] == board[7])
			return 1;
		else if (board[2] == board[5] && board[5] == board[8])
			return 1;
		else if (board[3] == board[6] && board[6] == board[9])
			return 1;
		else if (board[1] == board[5] && board[5] == board[9])
			return 1;
		else if (board[3] == board[5] && board[5] == board[7])
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe game!");
		char[] board = createBoard();
		char comp, player;
		player = inputLetter();
		if (player == 'X' || player == 'x')
			comp = 'O';
		else
			comp = 'X';

		System.out.println("computer letter is: " + comp + "\nplayer letter is: " + player);
		selectLocation(board, player);
		

	}

}
