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
	 * UC4 Select the location UC10 taking one of the available corners UC11
	 * taking center or any of the available sides on priority
	 */
	public static void selectLocation(char[] board, char user, char player) {

		Scanner sc = new Scanner(System.in);
		if (player == user) {
			System.out.println("player's move");
			System.out.println("Select the location");
			int location = sc.nextInt();
			if (!checkFreeSpace(board, location)) {
				System.out.println("location occupied");
			} else
				board[location] = player;
		} else {
			System.out.println("Computer's move");
			if (computerWin(board, player)) {
				return;
			} else if (denyUserWin(board, player, user)) {
				return;
			} else if (board[1] == ' ') {
				board[1] = player;
			} else if (board[3] == ' ') {
				board[3] = player;
			} else if (board[7] == ' ') {
				board[7] = player;
			} else if (board[9] == ' ') {
				board[9] = player;
			} else if (board[5] == ' ') {
				board[5] = player;
			} else {
				for (int position = 1; position < 10; position++) {
					if (board[position] == ' ') {
						board[position] = player;
					}
				}
			}
		}
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
	public static boolean toss() {
		Scanner sc = new Scanner(System.in);
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
	public static boolean checkWin(char[] board, char player) {
		if ((board[1] == player && board[2] == player && board[3] == player)
				|| (board[4] == player && board[5] == player && board[6] == player)
				|| (board[7] == player && board[8] == player && board[9] == player)
				|| (board[1] == player && board[4] == player && board[7] == player)
				|| (board[2] == player && board[5] == player && board[8] == player)
				|| (board[3] == player && board[6] == player && board[9] == player)
				|| (board[1] == player && board[5] == player && board[9] == player)
				|| (board[3] == player && board[5] == player && board[7] == player))
			return true;
		else
			return false;
	}

	public static boolean tieCheck(char[] board) {
		for (int i = 0; i < 10; i++) {
			if (board[i] == ' ') {
				return false;
			}
		}
		System.out.println("The game has tied");
		return true;
	}

	/**
	 * UC8 to check if computer can win
	 */
	public static boolean computerWin(char[] board, char c) {
		for (int pos = 1; pos < 10; pos++) {
			if (board[pos] == ' ') {
				board[pos] = c;
				if (!checkWin(board, c)) {
					board[pos] = ' ';
				} else {
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * UC9 deny user's move if user is going to win in the next move
	 */
	public static boolean denyUserWin(char[] board, char player, char user) {
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = user;
				if (!checkWin(board, user)) {
					board[i] = ' ';
				} else {
					{
						board[i] = player;
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * UC12 play until the game has been won or tied
	 */
	public static void switchOrWin(char[] board, char player, char user) {
		while ((!tieCheck(board))) {
			selectLocation(board, player, user);
			showBoard(board);
			if (checkWin(board, player)) {
				System.out.println(player + " is the winner");
				break;
			}
			player = ((player == 'X') ? 'O' : 'X');
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe game!");
		char[] board = createBoard();
		char comp, player, user;
		int position = 1;
		user = inputLetter();
		if (user == 'X' || user == 'x')
			comp = 'O';
		else
			comp = 'X';
		showBoard(board);
		if (toss())
			player = user;
		else
			player = comp;
		if (player == user)
			selectLocation(board, user, player);
		else {
			position = 1 + (int) (Math.random() * (9));
			board[position] = comp;
		}
		showBoard(board);
		tieCheck(board);
		computerWin(board, player);
	}

}
