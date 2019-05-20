package masterPruebas.TFD.models;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SuitTest {

	@Test
	public void givenDiamondChar_whenFind_thenDiamondFound() {
		assertEquals(Suit.find('D'), Suit.DIAMONDS);
	}

	@Test
	public void givenVectorWithInitials_thenInitialMatch() {
		assertArrayEquals(new char[] {'H','D','C','P'}, Suit.initials());
	}

}
