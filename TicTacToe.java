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
	
	public static String winner="no"; 
	
	public static int lock ;
	
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
	
	/*@method doToss identifies who to selects move first
	 * player chooses head or tail
	 * checked against the toss output
	 */
	
	public static void doToss()
	{
		System.out.println("Your choice? \n 0.Head\n 1.Tail");
		int player_choice=sc.nextInt();		// 0 for head and 1 for tail
		
		int toss_output=rand.nextInt(2);						
		if(player_choice==toss_output)
		{
			System.out.println("Its player's turn!!!");
			who='p';
		}
		else
		{
			System.out.println("Its computer's turn!!!");
			who='c';
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
			lock=1;							// lock the letter chosen by player
		}
		else
		{
			if(lock != 1) {					//if the letter is not locked computer chooses randomly
				if (rand.nextInt(2)==0)	{		//method to get number 0 or 1
					letter='X';					// 0 corresponds to X
				}
				else {
					letter='O';					//1 corresponds to O
					}
				}
			else if(letter == 'X'){
				letter = 'O';
			}
			else {
				letter = 'X';
			}
			lock=1;
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
		if(who == 'c')
		{
			cTurn();					//function which contains computers playing conditions
				
		}
		else {
			loc=sc.nextInt();
			if(loc<1 || loc>9)
			{
				System.out.println("Please enter the location value between 1 and 9!!");
				setLocation();			//call to itself to take correct value	
			}
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
	
	
	public static void cTurn()
	{
		System.out.println("Computer is playing!!!");	
		if((board[1]==' ')&&(board[2]==board[3]&&board[2]==letter)||(board[4]==board[7]&&board[4]==letter)||(board[5]==board[9]&&board[5]==letter))
		{
			board[1]=letter;			
		}
		else if((board[2]==' ')&&(board[1]==board[3]&&board[3]==letter)||(board[5]==board[8]&&board[8]==letter))
		{
			board[2]=letter;
		}
		else if((board[3]==' ')&&(board[1]==board[2]&&board[2]==letter)||(board[6]==board[9]&&board[9]==letter)||(board[5]==board[7]&&board[7]==letter))
		{
			board[3]=letter;
		}
		else if((board[4]==' ')&&(board[1]==board[7]&&board[1]==letter)||(board[5]==board[6]&&board[6]==letter))
		{
			board[4]=letter;
		}
		else if((board[5]==' ')&&(board[1]==board[9]&&board[2]==letter)||(board[7]==board[3]&&board[7]==letter)||(board[2]==board[8]&&board[8]==letter)||(board[4]==board[6]&&board[6]==letter))
		{
			board[5]=letter;
		}
		else if((board[6]==' ')&&(board[9]==board[3]&&board[3]==letter)||(board[5]==board[4]&&board[4]==letter))
		{
			board[6]=letter;
		}
		else if((board[7]==' ')&&(board[1]==board[4]&&board[4]==letter)||(board[3]==board[5]&&board[3]==letter)||(board[8]==board[9]&&board[8]==letter))
		{
			board[3]=letter;
		}
		else if((board[8]==' ')&&(board[9]==board[7]&&board[7]==letter)||(board[2]==board[5]&&board[2]==letter))
		{
			board[8]=letter;
		}
		else if((board[9]==' ')&&(board[1]==board[5]&&board[5]==letter)||(board[6]==board[3]&&board[3]==letter)||(board[8]==board[7]&&board[7]==letter))
		{
			board[9]=letter;
		}
	   	else {
			randomSelect();			
		}
		displayBoard();
	}
	
	public static void randomSelect()				//to randomly select index
	{
		int loc=rand.nextInt(9)+1;
		if(board[loc]==' ')
			board[loc]=letter;
		else
			randomSelect();
	}
	
	
	/*@method to check for winner
	 * checks different cases to determine the winner
	 * if there is a "XXX" OR "OOO" 
	 * checked horizontally, vertically and diagonally
	 */
	public static void winnerExists()
    {
		String match = null;
		//iterating to all the cells to check if there is a winning moment
        for (int a = 1; a < 9; a++) 
        {
            switch (a) {
            case 1:
                match = ""+board[1] + board[2] + board[3];
                break;
            case 2:
                match = ""+board[4] + board[5] + board[6];
                break;
            case 3:
                match = ""+board[7] + board[8] + board[9];
                break;
            case 4:
                match = ""+board[1] + board[4] + board[7];
                break;
            case 5:
                match = ""+board[2] + board[5] + board[8];
                break;
            case 6:
                match = ""+board[3] + board[5] + board[9];
                break;
            case 7:
                match = ""+board[1] + board[5] + board[9];
                break;
            case 8:
                match = ""+board[3] + board[5] + board[7];
                break;
            }
            
            if (match.equals("XXX")) {			// to determine winner if the match equals either "XXX" or "OOO"
                winner="yes";
                break;
            }
            if (match.equals("OOO")) {
                winner="yes";
                break;
            }
            
        }
        int i;
        for(i=1;i<board.length;i++)
        {
        	if(board[i]==' ')
        		break;
        }
        
        if(winner=="yes")						//condition to check for winner
		{
			System.out.println("Winner is: "+winnerIs());
			System.exit(0);
		}
        else if(i==10) {
        	winner="draw";	
        }
        
		else													//if none of conditions determine the winner then change the turn to play
		{
			if(who=='c')
			{
				who='p';
				System.out.println("Players turn to play");
			}
			else
			{
				who='c';
				System.out.println("Computers turn to play");
			}		
		}
        if(winner=="draw")								//condition to check for tie
		{
			System.out.println( "It's a draw!");
			System.exit(0);
		}
    }
	
	//@method to return the winner
	public static String winnerIs() {
		if(who=='c')
			return "Computer";
		else
			return "Player";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 0;
		while(winner != "yes" || winner != "draw") {
			if(start ==0) {
		createBoard();	//function call to createBoard
		doToss();		//function call to do a toss
		start = 1;
			}
		getInput();   //function call as to enter either 'X' or 'O'
		displayBoard(); //function call to display board
		if(who=='p')
			System.out.println("Enter the cell number (1 to 9) to make the move: ");
		setLocation();	//function call to select the index value to store X OR O
		if(who=='p')
			checkSpace(); 	//function call to check for valid space
		winnerExists();		//function call to check for winner
		}
	}

}
