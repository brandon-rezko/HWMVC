import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
private HWMVC view;
private Model model;

public Controller(HWMVC view1,Model model1) {
	view = view1;
	model = model1;
	
	
view.addListeners1(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
	long firstnumber, secondnumber=0;
	firstnumber = view.getFirst();
	secondnumber = view.getSecond();
	model.sub(firstnumber, secondnumber);
view.setResult(model.returnresult());
}
});
view.addListeners2(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
	long firstnumber, secondnumber=0;
	firstnumber = view.getFirst();
	secondnumber = view.getSecond();
	model.mod(firstnumber, secondnumber);
view.setResult(model.returnresult());
	
}
});
view.addListeners3(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
	long firstnumber, secondnumber=0;
	firstnumber = view.getFirst();
	secondnumber = view.getSecond();
	model.multi(firstnumber, secondnumber);
view.setResult(model.returnresult());
}
});
view.addListeners4(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
	long firstnumber, secondnumber=0;
	firstnumber = view.getFirst();
	secondnumber = view.getSecond();
	model.div(firstnumber, secondnumber);
view.setResult(model.returnresult());
}
});
view.addListeners5(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
	long firstnumber, secondnumber=0;
	firstnumber = view.getFirst();
	secondnumber = view.getSecond();
	model.add(firstnumber, secondnumber);
view.setResult(model.returnresult());
	
}
});
view.addListeners6(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
	long firstnumber;
	firstnumber = view.getFirst();
	model.sqrrt(firstnumber);
view.setResult1(model.returnresult1());
	
}
});

}
	



}
