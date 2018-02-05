
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
HWMVC view = new HWMVC();
Model model = new Model();
 new Controller(view,model);

view.show();

	}

}
