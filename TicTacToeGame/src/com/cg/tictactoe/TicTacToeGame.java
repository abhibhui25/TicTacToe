package com.cg.tictactoe;

import java.util.*;

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
	
	public static void showBoard(char[] board)
	{
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]+"\n");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]+"\n");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]+"\n");
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to Tic Tac Toe game!");
		char[] boardValue=createBoard();
		char comp, player;
		player = inputLetter();
		if (player == 'X' || player == 'x')
			comp = 'O';
		else
			comp = 'X';

		System.out.println("computer letter is: " + comp + "\nplayer letter is: " + player);
		showBoard(boardValue);
	}

}
