import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookstoreGUI extends JFrame 
{
    private JTextArea outputArea;

    public BookstoreGUI() 
    {
        super("Bookstore");

        // Create the input box
        JTextField userInput = new JTextField(20);

        userInput.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                // Get the text from the text field
                String input = userInput.getText();

                // Do something with the input
                outputArea.append("User entered: " + input + "\n");

                // Clear the text field
                userInput.setText("");
            }
        });

        // Create the buttons and map them to methods
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String input = userInput.getText();

                // Do something with the input
                outputArea.append("User entered: " + input + "\n");

                // Clear the text field
                userInput.setText("");
            }
        });

        // Add the components to the JFrame
        JPanel panel = new JPanel();
        panel.add(userInput);

        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        panel.add(enterButton);

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 640);
        setVisible(true);
    }

    // Define method 1
    private void enterButtonMethod() 
    {
        // Do something
    }

    // Define method 2
    private void method2() 
    {
        // Do something
    }

    public static void main(String[] args) 
    {
        new BookstoreGUI();
    }
}