package as2resit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginRegisterGUI extends JFrame {
   
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginRegisterGUI() {
        setTitle("Login and Register");
        setSize(100, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the UI components
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        // Create the layout
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(registerButton);

        // Login button click listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform login logic
                boolean loginSuccessful = performLogin(username, password);
                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(LoginRegisterGUI.this,
                            "Login successful. Welcome!",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Proceed to the application's main functionality or another page
                } else {
                    JOptionPane.showMessageDialog(LoginRegisterGUI.this,
                            "Invalid username or password. Please try again.",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Register button click listener
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform registration logic
                boolean registrationSuccessful = performRegistration(username, password);
                if (registrationSuccessful) {
                    JOptionPane.showMessageDialog(LoginRegisterGUI.this,
                            "Registration successful. You can now log in.",
                            "Registration",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginRegisterGUI.this,
                            "Registration failed. Please try again.",
                            "Registration",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Perform login logic
    private boolean performLogin(String username, String password) {
        // Add your login logic here
        // Example: Check if the username and password match your records in a database
        // Return true if the login is successful, false otherwise
        return false; // Placeholder
    }

    // Perform registration logic
    private boolean performRegistration(String username, String password) {
        // Add your registration logic here
        // Example: Store the username and password in a database
        // Return true if the registration is successful, false otherwise
        return false; // Placeholder
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginRegisterGUI().setVisible(true);
            }
        });
    
  
}

}
	


