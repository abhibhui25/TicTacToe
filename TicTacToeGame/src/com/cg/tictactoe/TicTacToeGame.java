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
		System.out.println("Enter the letter(X/O)");
		char userInput = sc.next().charAt(0);
		return userInput;
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
		for (int i = 0; i < 10; i++) {
			System.out.println("Select the location");
			int location = sc.nextInt();
			if (!checkFreeSpace(board, location)) {
				System.out.println("location occupied");
				System.exit(0);
			} else
				board[location] = player;
			showBoard(board);
		}
		sc.close();
	}

	/**
	 * Check for free space
	 */
	private static boolean checkFreeSpace(char[] board, int index) {
		return board[index] == ' ';
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
		/* board[1]='O'; */

		showBoard(board);
	}

}
