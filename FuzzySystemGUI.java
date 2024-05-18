import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuzzySystemGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FuzzySystemGUI().createAndShowGUI());
    }

    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;
    private FuzzySystem fuzzySystem;

    public FuzzySystemGUI() {
        fuzzySystem = new FuzzySystem();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Fuzzy System GUI");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel inputLabel = new JLabel("Enter value (0-100):");
        inputLabel.setBounds(50, 30, 150, 30);
        frame.add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(200, 30, 100, 30);
        frame.add(inputField);

        JButton evaluateButton = new JButton("Evaluate");
        evaluateButton.setBounds(150, 80, 100, 30);
        frame.add(evaluateButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 130, 300, 30);
        frame.add(resultLabel);

        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateInput();
            }
        });

        frame.setVisible(true);
    }

    private void evaluateInput() {
        try {
            double input = Double.parseDouble(inputField.getText());
            String result = fuzzySystem.evaluate(input);
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    private static class FuzzySystem {
        public String evaluate(double input) {
            if (input < 0 || input > 100) {
                return "Invalid input";
            }

            if (input < 25) {
                return "Low";
            } else if (input < 75) {
                return "Medium";
            } else {
                return "High";
            }
        }
    }
}
