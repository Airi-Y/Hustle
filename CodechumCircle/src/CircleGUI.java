import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NegativeRadiusException extends Exception {
    @Override
    public String getMessage() {
        return "The radius should not be a negative number. Try again!";
    }
}

public class CircleGUI extends JFrame{
    private JPanel pnlMain;
    private JTextField tfRadius;
    private JTextField tfArea;
    private JTextField tfCircumference;
    private JButton btnClear;
    private JButton btnCompute;

    public CircleGUI() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(tfRadius.getText());
                    if (radius < 0)
                        throw new NegativeRadiusException();


                    double area = circleArea(radius);
                    double circ = circleCircumference(radius);

                    tfArea.setText(String.format("%,.2f", area));
                    tfCircumference.setText(String.format("%,.2f", circ));
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(pnlMain, "Invalid input. Please enter a valid number.");
                }
                catch (NegativeRadiusException err) {
                    JOptionPane.showMessageDialog(pnlMain, err.getMessage());
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputs();
            }
        });
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }

    public double circleArea(double r) {
        // pi * r^2
        return (Math.PI * (Math.pow(r, 2)));
    }

    public double circleCircumference(double r) {
        // 2 pi r
        return 2 * (Math.PI * r);
    }

    public void clearInputs() {
        tfArea.setText("");
        tfRadius.setText("");
        tfCircumference.setText("");
    }
}
