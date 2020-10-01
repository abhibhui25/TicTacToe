package com.cg.tictactoe;

import java.util.*;

public class TicTacToeGame {
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

	public static char inputLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the letter(X/O)");
		char ch = sc.next().charAt(0);
		return ch;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game!");
		createBoard();
		char comp, player;
		player = inputLetter();
		if (player == 'X') {
			comp = 'O';
		} else {
			comp = 'X';
		}
		System.out.println("computer letter is: " + comp);
		System.out.println("player letter is: " + player);
	}

}
