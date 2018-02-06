import static org.junit.Assert.assertEquals;


import  org.junit.*;
public class Multi {

	

	@Test
	public void test() {
		Model d = new Model();
		 d.multi(5,-5);
		 double as = d.returnresult();
		 assertEquals(-25,as,0);
	}

}
