import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Aberdeen Adventures!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("Welcome to Aberdeen Adventures!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Description area
        JTextArea descriptionArea = new JTextArea(
            "Embark on an exciting text-based adventure through Aberdeen! \n" +
            "Solve puzzles, defeat enemies, and explore iconic locations.\n\n" +
            "Click 'Start Game' to begin your journey!"
        );
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        frame.add(descriptionArea, BorderLayout.CENTER);

        // Start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setFocusPainted(false);
        frame.add(startButton, BorderLayout.SOUTH);

        // Add action listener to the button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the GUI window

                // Launch the text-based game logic
                new Thread(() -> App.main(null)).start();
            }
        });

        // Show the frame
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
