package snakeLadders.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import snakeLadders.Util.InputOutputUtil;
import snakeLadders.Util.SnakeLadderUtil;
import snakeLadders.game.StartGame;

/**
 * This class is the main entry point to the game and will launch the game based on user input
 *
 * @author Tushar
 *
 */
public class GameLauncher {
	
	public static void main(String[] args) throws InterruptedException {
		String choice=null;
		
		System.out.println("DO YOU WANT TO LAUNCH THE GAME Y/N? ");
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		
		choice=InputOutputUtil.readFromKeyboard(reader);
		
		System.out.println("choice : "+choice);
			
		if(choice.equals("y") || choice.equals("Y"))
		{
			System.out.println("Loading the game. . . .");
			Thread.sleep(2000);
			
			//Displaying the Dashboard
			SnakeLadderUtil.presentGame();
			
			System.out.println("\n\n\n\n");
			
			//Launching the game
			StartGame.getInstance().play();
		}
	}
}
