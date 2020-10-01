package com.cg.tictactoe;

public class TicTacToeGame {
	public static void createBoard() {
		char[] board = new char[10];
		for (int index = 0; index < 10; index++) {
			board[index] = ' ';
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game!");
		createBoard();
	}
}
