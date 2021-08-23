package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static Scanner sc=new Scanner(System.in);
			
	public static Random rand=new Random();			//random class instance to get a random value
	
	public static char letter; 						//to store input X or O
	
	public static char who; 			//this variable checks whose turn to play either 'p'-player or 'c'-computer
	
	public static int loc; //to store cell number on the board(1 to 9)
	
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
	 * computers choose random number either 0('X') or 1('O') 
	 */
	public static void getInput()
	{
		if(who=='p')
		{
			System.out.println("Enter the input either X or O: ");
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
	
	/*@method displayBoard to display the board in cell format
	 * this is use case 3 which allows player to make a move
	 */
	public static void displayBoard()
	{
		System.out.println("|-----------|");
        System.out.println("| " + board[1] + " | "
                           + board[2] + " | " + board[3]		//row 1
                           + " |");							
        System.out.println("|-----------|");
        System.out.println("| " + board[4] + " | "
                           + board[5] + " | " + board[6]		//row 2
                           + " |");							
        System.out.println("|-----------|");
        System.out.println("| " + board[7] + " | "
                           + board[8] + " | " + board[9]		//row 3
                           + " |");							
        System.out.println("|-----------|");
	}
	
	/*@method selects the value from 1 to 9 
	 * function executes again if the value is not between 1 to 9
	 */
	public static void setLocation()
	{	
		loc=sc.nextInt();
		if(loc<1 || loc>9)
		{
			System.out.println("Please enter the location value between 1 and 9!!");
			setLocation();			//call to itself to take correct value	
		}
		
	}
	
	/*@method checkSpace checks for the available space
	 * Use case 5 to check for the desired location
	 * to make the move
	 */
	public static void checkSpace()
	{
		if(board[loc]==' ')					//condition to check for free space
		{
			board[loc]=letter;
		}
		else
		{
			System.out.println("Entered cell number is already occupied! please enter valid index number:");
			setLocation();					//function call to setLocation method to enter the correct index
			checkSpace();					//call to itself
		}
		displayBoard();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createBoard();				//function call to createBoard
		who='p';					//starts with player
		getInput();   //function call as to enter either 'X' or 'O'
		displayBoard(); //function call to display board
		System.out.println("Enter the cell number (1 to 9) to make the move: ");
		setLocation();	//function call to select the index value to store X OR O
		checkSpace(); 	//function call to check for valid space
	}

}
