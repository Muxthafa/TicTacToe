package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static Scanner sc=new Scanner(System.in);
			
	public static Random rand=new Random();			//random class instance to get a random value
	
	public static char letter; 						//to store input X or O
	
	public static char who; 			//this variable checks whose turn to play either 'p'-player or 'c'-computer
	
	static char[] board = new char[10];		//char array with size 10
	
	/*@method createBoard to initialize array
	 * This function corresponds to Use case 1
	 * Use case to create a new board game and initialize the values to ' '
	 */
	public static void createBoard() {
		for(int i=1;i<board.length;i++)	//loop to add spaces to char array
		{
			board[i]=' ';
		}
	}
	
	/*@method to get input value X or O from the player
	 * computers choose random number either 0('X') or 1('0') 
	 */
	public static void getInput()
	{
		if(who=='p')
		{
			System.out.println("Enter the input(X or O): ");
			letter=sc.next().charAt(0);
		}
		else
		{
			if (rand.nextInt(2)==0)			//method to get number 0 or 1
				letter='X';
			else
				letter='O';
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createBoard();				//function call to createBoard
		who='p';					//starts with player
		getInput();   //function call as to enter either 'X' or 'O'
	}

}
