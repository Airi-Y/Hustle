import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            CircleGUI app = new CircleGUI();
            app.setContentPane(app.getPnlMain());
            app.setSize(700, 700);
            app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            app.setVisible(true);
    }
}