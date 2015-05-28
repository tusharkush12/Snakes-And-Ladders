package snakeLadders.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the utility class to prepare and display the Game Board when the game is launched
 * @author namo
 *
 */
public class SnakeLadderUtil {
	
	/**
	 * prepares and display the game board.
	 */
	public static void presentGame()
	{
		System.out.println("\t\t\t\t\t\t\t\t\t\tSNAKE AND LADDERS\t\t\t\t\t\t\t\t\t\t");
		System.out.println("\n\n");
		System.out.print("\t\t\t\t\t  ");
		System.out.println("---------------------------------------BOARD---"
				+ "-----------------------------------------");
		System.out.print("\t\t\t\t\t\t");
		
		int box=0;
		int line=1;
		for(int i=100;i>0;i--)
		{
			System.out.print(i+"\t");
			box++;
			if(box%10==0 && box!=0)
			{
				System.out.println();
				box=0;
				line++;
				System.out.print("\t\t\t\t\t\t");
				if(line%2==0)
				{					
					for(int j=i-10;j<i;j++)
					{					
						System.out.print(j+"\t");
						box++;
					}
					
					i=i-10;					
				}
				else
				{
					for(int j=i-1;j>i-10;j--)
					{
						System.out.print(j+"\t");
						box++;
					}
				}
				line++;
				System.out.println();
				System.out.print("\t\t\t\t\t\t");				
			}					
		}
		System.out.println();
		System.out.print("\t\t\t\t\t  ");
		System.out.println("-----------------------------------------------"
				+ "-----------------------------------------");
	}
	
	/**
	 * This method rolls two dices and return the sum as the total roll.
	 * 
	 * 2 random numbers are generated and then added and returned
	 * 
	 * @param dice1
	 * @param dice2
	 * @return int
	 */
	public static int rollDice(int dice1, int dice2)
	{
		dice1=(int)(Math.random()*6)+1;
		dice2=(int)(Math.random()*6)+1;
		return  dice1+dice2;
	}
	
	
}
