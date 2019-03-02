
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import java.util.Scanner;
public class CreatingAProfile extends JFrame implements ActionListener{
	
	private JFrame frame;
	
	
	JButton login_button, SignUp_button;
	JTextField username;
	JPasswordField password;
	JLabel username_label, password_label;
	
	public CreatingAProfile(String name){
		super(name);
		login_button = new JButton("Login");
		SignUp_button = new JButton("Sign Up");
		username = new JTextField();
		password = new JPasswordField();
		
		username_label = new JLabel("Username");
		password_label = new JLabel("Password");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		login_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent action_1){
				String Username = username.getText();
				String Password = password.getText();
				
				if(Username.equals("name")&&Password.equals("password"));{
					JOptionPane.showMessageDialog(frame, "Welcome");
				}
				
				{
					JOptionPane.showMessageDialog(frame,  "Invalid information");
				}
			}
		
		});
		
		SignUp_button.addActionListener(this);
		
		username_label.setBounds(15, 15, 100, 50);
		frame.getContentPane().add(username_label);
		
		password_label.setBounds(15, 35, 100, 50);
		frame.getContentPane().add(password_label);
		
		username.setBounds(160, 50, 500, 40);
		frame.getContentPane().add(username);
		
		password.setBounds(160, 80, 500, 40);
		frame.getContentPane().add(password);
		
		
		login_button.setBounds(150, 65, 200, 50);
		SignUp_button.setBounds(450, 65, 200, 50);
		
		this.add(username_label);
		this.add(password_label);
		this.add(username);
		this.add(password);
		this.add(login_button);
		this.add(SignUp_button);
		
		this.setSize(300, 300);
		this.setVisible(true);

	public static void main(String[] args){
		CreatingAProfile profile= new CreatingAProfile("Welcome");

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
