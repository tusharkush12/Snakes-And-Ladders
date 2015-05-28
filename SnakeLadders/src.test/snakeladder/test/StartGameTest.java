package snakeladder.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import snakeLadders.game.Player;
import snakeLadders.game.StartGame;

public class StartGameTest {

	private static StartGame game=null;
	
	@BeforeClass
	public static void setUp()
	{
		game=StartGame.getInstance();
	}
	@Test
	public void testGetInstance() {
		
		assertNotNull(game);		
	}

	/**
	 * tests teh setter and getter for player instance variable
	 */

	@Test
	public void testSetPlayer1() {
		Player p1= new Player();
		p1.setName("p1");
		p1.setPosition(1);;
		p1.setHasChance(true);
		
		game.setPlayer1(p1);
		
		assertTrue(game.getPlayer1().isHasChance());
		assertEquals(1,game.getPlayer1().getPosition());
		assertEquals("p1",game.getPlayer1().getName());
		
	}

	/**
	 * test for setter and getter method for Player2
	 */
	@Test
	public void testSetPlayer2() {
		Player p2= new Player();
		
		p2.setName("p2");
		p2.setPosition(3);;
		p2.setHasChance(false);
		
		game.setPlayer2(p2);
		
		assertFalse(game.getPlayer2().isHasChance());
		assertEquals(3,game.getPlayer2().getPosition());
		assertEquals("p2",game.getPlayer2().getName());
	}

	
}
