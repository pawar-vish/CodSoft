package Projects;

import java.util.Random;
import java.util.Scanner;
public class Number_Game {
public static void main(String[] args) {
//	variable declaration
	int a = 100; //Random Number limit
	int live = 5; //The number of chance given to the user
	int score = 0;
	int MinRange = 0;
	int MaxRange = 100;
//	Random number Generation.
	Random r = new Random();
	int GeneratedNumber = r.nextInt(a);
	if(GeneratedNumber==0) {
		r.nextInt(a);
	}
//	User Input
	Scanner sc = new Scanner(System.in);
	System.out.println();
	System.out.println("Do You Want to Play the Game :");
	System.out.println("Enter 1 : START GAME");
	System.out.println("Enter 2 : EXIT");
	System.out.println("=-=-=-=-=-=-==-=-=-=-=-=-=--=-==-=-=-=-=");
	int choice = sc.nextInt();
	if(choice==1) {
		System.out.println();
		System.out.print("Lives :");
		Live(live);

		for(int i = 1; i <= live;i++) {
			int count = i; 
			System.out.println();
			System.out.println("Enter the number from range "+MinRange+"-"+MaxRange+":");
			int UserInput = sc.nextInt();
			if(UserInput==GeneratedNumber) {
				score +=25;
				i = i - count;
				System.out.println("Correct Guess. Score : "+score);
				System.out.println("Lives Restored");
				Live(live);
			}
			else {
				if(UserInput > GeneratedNumber) {
					MaxRange = UserInput;
					System.out.println("Too High");
					System.out.println();
					System.err.println("Lives Remains:"+(live-i));
					Live(live-i);
				}
				else {
					MinRange = UserInput;
					System.out.println("Too Low");
					System.out.println();
					System.err.println("Lives Remains:"+(live-i));
					Live(live-i);
				}
			}
			
		}
		System.err.println("Game Over");
		System.out.println("YOU SCORE :"+score);
		main(null);
	}
	else if(choice==2){
		System.exit(0);
	}
	else {
		System.err.println("You Entered an Invalid Option");
		main(null);
	}
}

// To Print the number of Lives Remaining	
public static void Live(int live) {
	for(int i = 0 ; i < live;i++) {
		System.err.print("💕"+ " ");
	}
	System.out.println();
}
static {
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	System.out.println("     Welcome to Number Game     ");
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
}
}
