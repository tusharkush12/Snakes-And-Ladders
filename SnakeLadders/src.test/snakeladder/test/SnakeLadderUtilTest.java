/**
 * 
 */
package snakeladder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import snakeLadders.Util.SnakeLadderUtil;

/**
 * @author namo
 *
 */
public class SnakeLadderUtilTest {

	/**
	 * Test method for {@link snakeLadders.Util.SnakeLadderUtil#rollDice(int, int)}.
	 */
	@Test
	public final void testRollDice() {
		int fakeRoll=SnakeLadderUtil.rollDice(0, 0);
		assertTrue(fakeRoll<=12);
	}

}
