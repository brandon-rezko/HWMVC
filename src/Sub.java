import static org.junit.Assert.assertEquals;


import  org.junit.*;
public class Sub {


	@Test
	public void test() {
		Model d = new Model();
		 d.sub(5,-3);
		 double as = d.returnresult();
		 assertEquals(8,as,0);
	}

}
