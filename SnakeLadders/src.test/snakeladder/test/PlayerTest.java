/**
 * 
 */
package snakeladder.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import snakeLadders.game.Player;

/**
 * @author namo
 *
 */
public class PlayerTest {

	private static Player player;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		 player =new Player();
	}
	/**
	 * Test for creation of Player class
	 * 
	 */
	@Test
	public void testPlayerCreation()
	{
		assertNotNull(player);
	}
	
	/**
	 * Test method for positions setter and getter
	 */
	@Test
	public void testGetPosition() {
		player.setPosition(2);
		assertEquals(2, player.getPosition());
		
		player.setPosition(3);
		assertNotEquals(1, player.getPosition());
	}

	/**
	 * Test method for hasChance getters setters
	 */
	@Test
	public void testIsHasChance() {
		
		player.setHasChance(true);
		assertTrue(player.isHasChance());
		
		player.setHasChance(false);
		assertFalse(player.isHasChance());
		
	}

	/**
	 * Test method for name setter and getters.
	 */
	@Test
	public void testGetName() {
		player.setName("player 1");
		assertEquals("player 1", player.getName());
	}

}
