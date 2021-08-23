package com.bridgelabz;

public class TicTacToe {
	
	TicTacToe()		//constructor
	{
		System.out.println("welcome to java workshop!!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] num = new char[10];
		for(int i=1;i<num.length;i++)
		{
			num[i]=' ';
		}
		TicTacToe board=new TicTacToe();	//object creation
	}

}
