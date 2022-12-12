import javax.swing.*;

public class CircleGUI extends JFrame{
    private JPanel pnlMain;
    private JTextField tfRadius;
    private JTextField tfArea;
    private JTextField tfCircumference;
    private JButton btnClear;
    private JButton btnCompute;

    public static void main(String[] args) {
        CircleGUI app = new CircleGUI();
        app.setContentPane(app.pnlMain);
        app.setSize(700, 700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
