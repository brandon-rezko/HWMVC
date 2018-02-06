import static org.junit.Assert.assertEquals;


import  org.junit.*;
public class Mod {


	@Test
	public void test() {
		Model d = new Model();
		 d.mod(5,5);
		 double as = d.returnresult();
		 assertEquals(0,as,0);
	}

}
