import static org.junit.Assert.assertEquals;


import  org.junit.*;
public class MinusNumberSquareRoot {


	@Test
	public void test() {
		Model d = new Model();
		 d.sqrrt(-1);
		 double as = d.returnresult1();
		 assertEquals(0,as,0);
	}

}
