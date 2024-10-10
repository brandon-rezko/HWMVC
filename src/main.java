import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

    public static void main(String[] args) {
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("🧮 Welcome to MVC Calculator!");
            System.out.println("🕒 Launched at: " + timestamp);

            HWMVC view = new HWMVC();
            Model model = new Model();
            new Controller(view, model);
            view.show();

        } catch (Exception e) {
            System.err.println("❌ Failed to launch the calculator:");
            e.printStackTrace();
        }
    }
}
