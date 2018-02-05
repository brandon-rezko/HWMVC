import static org.junit.Assert.*;

import org.junit.Test;

public class DivByZero {

	@Test
	public void test() {
		Model d = new Model();
		 d.div(1, 0);
		 double as = d.returnresult();
		 assertEquals(0,as,0);
	}

}
