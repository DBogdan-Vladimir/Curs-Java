package main;

import java.io.IOException;
import java.util.Scanner;

public class WarriorGame {

	
	static Scanner sc = new Scanner(System.in);
	//private static String choice;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		/* for(;;) {
			do {
				System.out.println("Select your warrior: ");
				System.out.println("1 for thor or 2 for loki?");
				System.out.println("q to quit :)");
				if(sc.hasNextLine())  
					choice = sc.nextLine();
												
				}while (choice != "thor" | choice != 1 && choice != "q");
		if (choice == "exit") break;
		
		System.out.println("\n"); */
		
		System.out.println("To start press 1. ");
		if(sc.hasNextInt() && sc.nextInt()== 1) {
			Warrior thor = new Warrior("Thor", 300, 150,40);
			Warrior loki = new Warrior("Loki", 250, 85,60);
			Battle.startFight(thor, loki);
		} else System.out.println ("Next time choose 1 or 2!");
		
		/*Warrior thor = new Warrior("Thor", 800, 130,40);
		Warrior loki = new Warrior("Loki", 800, 85,60);
		Battle.startFight(thor, loki); */
		
		/*if(choice == "thor") {
			System.out.println("You have chosen Thor.");
			Battle.startFight(thor, loki);
		} else if (choice == "loki") {
			System.out.println("You have chosen Loki.");
			Battle.startFight(loki, thor);
		}
		
		} */
	}
}
