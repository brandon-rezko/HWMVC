import static org.junit.Assert.assertEquals;



import  org.junit.*;
public class Add {



	@Test
	public void test() {
		Model d = new Model();
		 d.add(5,5);
		 double as = d.returnresult();
		 assertEquals(10,as,0);
	}

}
