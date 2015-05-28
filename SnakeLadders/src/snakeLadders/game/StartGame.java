/**
 * 
 */
package snakeLadders.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import snakeLadders.Util.InputOutputUtil;
import snakeLadders.Util.SnakeLadderUtil;

/**
 * This class is responsible for playing the game
 * 
 * @author Tushar
 *
 */
public class StartGame 
{
	/**
	 * map containing the key as the snake's mouth and value as teh snake's tail.
	 */
	private static Map<Integer,Integer> SNAKE_TOP_BOTTOM_POS = new HashMap<Integer,Integer>();
	/**
	 * map containing the key as the ladder' bottom and value as ladder's top.
	 */
	private static Map<Integer,Integer> LADDER_TOP_BOTTOM_POS= new HashMap<Integer,Integer>();
	
	/**
	 * defining the names of players
	 */
	private final String PLAYER_1="Player 1";
	
	private final String PLAYER_2="Player 2";
	
	
	private Player player1;
	
	private Player player2;
	
	static{
		
		SNAKE_TOP_BOTTOM_POS.put(22, 6 );
		SNAKE_TOP_BOTTOM_POS.put(49, 17);
		SNAKE_TOP_BOTTOM_POS.put(54, 4);
		SNAKE_TOP_BOTTOM_POS.put(74, 55);
		SNAKE_TOP_BOTTOM_POS.put(96, 34);
		SNAKE_TOP_BOTTOM_POS.put(92, 66);
		SNAKE_TOP_BOTTOM_POS.put(99, 8);
		
		LADDER_TOP_BOTTOM_POS.put(7, 58);
		LADDER_TOP_BOTTOM_POS.put(9, 31);
		LADDER_TOP_BOTTOM_POS.put(10, 97);
		LADDER_TOP_BOTTOM_POS.put(19, 77);
		LADDER_TOP_BOTTOM_POS.put(36, 44);
		LADDER_TOP_BOTTOM_POS.put(39, 59);
		LADDER_TOP_BOTTOM_POS.put(51, 87);
	}
	
	public void play()
	{
		int dice1=0;
		int dice2=0;
		int totalShift=0;
		Player currentPlayer= null;
		
		System.out.println("\n\n");
		String playGame="Y";
			
		if(playGame.equalsIgnoreCase("Y"))
		{
			initializePlayers();										// initializae playrs with name, position etc.
		}
		while(playGame.equalsIgnoreCase("Y"))
		{
			System.out.println("Roll the Dice? Y/N :");
			//reading from the keyboard
			BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
			String choice=InputOutputUtil.readFromKeyboard(reader);		//Reading from InputStream
			if(!choice.equalsIgnoreCase("Y"))
			{
				System.out.println("\n\n\n\n");
				System.out.println("EXITING THE GAME.......");
				break;
			}
			
			currentPlayer=getCurrenPlayer();							//Obtaining the current player who will roll the dice
			totalShift= SnakeLadderUtil.rollDice(dice1,dice2);			// Rolling the dice
			
			System.out.println("You Rolled :" +totalShift);
			currentPlayer.setPosition(checkForSnakeBiteOrLadderRise(currentPlayer, totalShift));	// Cheking if the new position after dice roll is a snake or lader position
			
			if(currentPlayer.getPosition()==100)
			{
				System.out.println("CONGRATULATIONSSS "+currentPlayer.getName()+" YOU HAVE WON THE GAME..YOU ARE AWESOMEEE!!!!");
				System.out.println("\n\n\n");
				System.out.println("\t\t\tExiting the game now.");
				break;
			}
			System.out.println(currentPlayer.getName()+" Your new Position "+currentPlayer.getPosition());
			
			currentPlayer.setHasChance(false);
			
			if(currentPlayer.getName().equalsIgnoreCase(PLAYER_1))
			{
				getPlayer2().setHasChance(true);
			}else
			{
				getPlayer1().setHasChance(true);
			}
			
		}
		
		
		
	}
	
	/**
	 * method to initialize player with starting position and chance to roll the dice
	 */
	private void initializePlayers()
	{
		setPlayer1(new Player());
		setPlayer2(new Player());
		
		player1.setPosition(1);
		player1.setHasChance(true);
		player1.setName(PLAYER_1);
		
		player2.setPosition(1);
		player2.setHasChance(false);
		player2.setName(PLAYER_2);
	}
	/**
	 * this method return the current play to roll the dice
	 * @return
	 */
	private Player getCurrenPlayer()
	{
		Player currentPlayer=null;
		if(player1.isHasChance()){
			currentPlayer= player1;			
		}
		
		if(player2.isHasChance()){
			currentPlayer=player2;
		}
			
		
		return currentPlayer;
	}
	/**
	 * This method checks if the new position after the dice roll is snake position or a ladder postion
	 * 
	 * If the new position is snake position the the new postion is replaced by the snake tail position
	 * 
	 * If the new postion is a Ladder posstion then the new postion is replaced by the Ladder's top end Position
	 * 
	 * @param currentPlayer
	 * @param totalShift
	 * @return int ( newPosition)
	 */
	private int checkForSnakeBiteOrLadderRise(Player currentPlayer, int totalShift)
	{
		int newPosition=0;
		newPosition =currentPlayer.getPosition()+totalShift;
		
		if(SNAKE_TOP_BOTTOM_POS.containsKey(newPosition)){
			newPosition=SNAKE_TOP_BOTTOM_POS.get(newPosition);
			System.out.println("OOPSS YOU HAVE BEEN BITTEN BY SNAKE :(");
		}
		if(LADDER_TOP_BOTTOM_POS.containsKey(newPosition)){
			newPosition=LADDER_TOP_BOTTOM_POS.get(newPosition);
			System.out.println("HEY THERE YOU HAVE CLIMBED THE LADDER..WO HOOOOO :D");
		}
		
		if(newPosition>100)
			{
				newPosition= currentPlayer.getPosition();
				System.out.println("Invalid move: you new position seems to be exceeding 100 !!!");
			}
		return newPosition;
	
	}
	
	/**
	 * This method return the instance of the StartGame Class
	 * @return
	 */
	public static StartGame getInstance(){
		return new StartGame();
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	
}
