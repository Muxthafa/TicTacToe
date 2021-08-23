package com.bridgelabz;

public class TicTacToe {
	static char[] num = new char[10];		//char array with size 10
	public static void board() {
		for(int i=1;i<num.length;i++)	//loop to add spaces to char array
		{
			num[i]=' ';
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board();
	}

}
