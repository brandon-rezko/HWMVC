
public class Model {
private long result;
private double result1;

public void add(long firstnumber, long secondnumber) {
	result = firstnumber+secondnumber;
}

public void sub(long firstnumber, long secondnumber) {
	result = firstnumber-secondnumber;
}

public void mod(long firstnumber, long secondnumber) {
	result = firstnumber%secondnumber;
}

public void multi(long firstnumber, long secondnumber) {
	result = firstnumber*secondnumber;
}

public void div(long firstnumber, long secondnumber) {
	result = firstnumber/secondnumber;
}

public void sqrrt(long firstnumber) {
	result1 = Math.sqrt(firstnumber);
}

public long returnresult() {
	return result;
}

public double returnresult1() {
	return result1;
}

}
