import javax.swing.UIManager;
public class Main { 
    public static void main(String[] args ) {

        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch(Exception ignored){}

        // start app
        new App("PF Beta");
    }
}