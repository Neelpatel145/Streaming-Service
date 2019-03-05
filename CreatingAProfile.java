import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class CreatingAProfile extends JFrame{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton register;
	JLabel Title, label1,label2,label3,label4;
	JLabel enter;
	JLabel enter_1;
	JTextField	JField, JField1, Field1,Field2,Field3;
	JPanel panel;
	JFrame Frame;
	String username,password,email;
	Connection x;
	Statement y;
	int index,count;
	String states[] = new String[25];
	public CreatingAProfile(){
	
		setLayout(new BorderLayout());

		Title = new JLabel("Chief Pineapple");
		Title.setFont(new Font("TimesNewRoman",Font.PLAIN, 45)); //These codes created a layout of our account page
		enter = new JLabel("Username");
		JField = new JTextField(25);
		enter_1 = new JLabel("Password");
		JField1 = new JTextField(25);
		button1 = new JButton("Sign In");
		button2 = new JButton("Sign Up");
		
		JPanel label = new JPanel(new FlowLayout());
		JPanel x = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 50));
		
		label.setBackground(Color.WHITE);
		x.setBackground(Color.lightGray);
		
		
		label.add(Title);

		x.add(enter);
		x.add(JField);
		x.add(enter_1);
		x.add(JField1);
		x.add(button1);
		button1.setBackground(Color.black);
		x.add(button2);
		button2.setBackground(Color.black);
		
		add(label,BorderLayout.NORTH);
		add(x,BorderLayout.CENTER);

		
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


public void initComponents() {
Frame=new javax.swing.JFrame("Registration Form");
panel=new javax.swing.JPanel();
Frame.add(panel);
panel.setLayout(null);
Frame.setSize(100,600);


label1=new javax.swing.JLabel("Registration Form");
label1.setFont(new Font("Dialog", Font.ITALIC, 24)); //These codes are used to show the layout of the Registration Form Layout
label1.setBounds(500,50,600,60);
panel.add(label1);

label2=new javax.swing.JLabel("Username");
label2.setFont(new Font("Dialog", Font.BOLD, 20)); //These codes are used to show the layout of the Username Layout
label2.setBounds(300,100,250,60);
panel.add(label2);

label3=new javax.swing.JLabel("Password");
label3.setFont(new Font("Dialog", Font.BOLD, 20)); //These codes are used to show the Layout of the Password Layout
label3.setBounds(300,200,250,60);
panel.add(label3);


label4=new javax.swing.JLabel("Email");
label4.setFont(new Font("Dialog", Font.BOLD, 20)); //These codes are used to show the Layout of the Email Layout
label4.setBounds(300,300,250,60);
panel.add(label4);

//These codes are used to show the layout of the text field
Field1=new javax.swing.JTextField();
Field1.setFont(new Font("Dialog", Font.BOLD, 16)); 
Field1.setBounds(350,400,180,30);
panel.add(Field1);

Field2=new javax.swing.JPasswordField();
Field2.setFont(new Font("Dialog", Font.BOLD, 16));
Field2.setBounds(350,200,180,30);
panel.add(Field2);

Field3=new javax.swing.JTextField();
Field3.setFont(new Font("Dialog", Font.BOLD, 16));
Field3.setBounds(350,380,180,30);
panel.add(Field3);


register = new javax.swing.JButton("Register");
register.setFont(new Font("Dialog", Font.BOLD, 16)); //These codes are used to show the Layout of the Register Layout
register.setBounds(250,620,100,30);
panel.add(register);


for (int j= 0 ; j< 25; j++) { }} 
public void event() { 
	Field1.addKeyListener(new KeyAdapter() { 
		public void keyTyped(KeyEvent z) {  //These codes are use to show what character can inputed on the Field
			char C = z.getKeyChar(); 
			String sag=Field1.getText(); 
			if (!(((C >= 'a')||(C >= 'A')) && ((C <= 'z')||(C <= 'Z')))){ 
				z.consume(); } } }); 



register.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent event)
{

getUserInformation();
validation();
registerUserData();

}
});
}

public void getUserInformation() { //This code are used to get Information for Name, Password, and Email
username = Field1.getText();
password = Field2.getText();
email = Field3.getText();
}

public void validation() {
count = 0;
if(email.contains("@") && email.contains(".com")) {
count++;
}
else {
JOptionPane.showMessageDialog(null,"Enter valid mail ID");
}
}

public void registerUserData() { // These codes will execute the code
try {

if(count==1) {
y = x.createStatement();
y.execute(email);
y.close();
x.close();
JOptionPane.showMessageDialog(null,"Successfully Registered");
}

}
catch (Exception e) {
System.out.println("Exception is " + e);
}

}



public static void main(String args[]) {
CreatingAProfile form = new CreatingAProfile();

}
}

