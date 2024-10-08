import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.UIManager;
import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("🧮 Welcome to MVC Calculator!");
            System.out.println("🕒 Launched at: " + timestamp);
            printSystemInfo();

            setTheme("light"); // or "dark"
            playStartupSound("startup.wav"); // must be in project root or resources

            HWMVC view = new HWMVC();
            Model model = new Model();
            new Controller(view, model);
            view.show();

        } catch (Exception e) {
            System.err.println("❌ Failed to launch the calculator:");
            e.printStackTrace();
        }
    }

    private static void printSystemInfo() {
        Properties props = System.getProperties();
        System.out.println("🖥️ OS: " + props.getProperty("os.name") + " " + props.getProperty("os.version"));
        System.out.println("☕ Java: " + props.getProperty("java.version"));
        System.out.println("👤 User: " + props.getProperty("user.name"));
    }

    private static void setTheme(String mode) {
        try {
            if (mode.equalsIgnoreCase("dark")) {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } else {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Theme not applied: " + e.getMessage());
        }
    }

    private static void playStartupSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            if (audioFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                System.out.println("🔇 Startup sound not found: " + filePath);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("⚠️ Audio playback failed: " + e.getMessage());
        }
    }
}
