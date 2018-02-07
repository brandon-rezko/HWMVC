import static org.junit.Assert.*;

import org.junit.Test;

public class ADD1 {

	@Test
	
	public void test() {
		Model d = new Model();
		 d.add(5,5);
		 double as = d.returnresult();
		 assertEquals(10,as,0);
	}

}
