package bankmanagement;

import java.net.URL;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {
	
	JButton login,clear,signUp;					//declared globally to access outside constructor	//dont see to check branch
	JTextField cardTextField;		//declared globally to access outside constructor
	JPasswordField pinTextField;	//for not showing PIN
	
	Login(){									//constructor
		
		setTitle("AUTOMATED TELEAR MACHINE");	//4.gives title to frame
		
		setLayout(null);
		
		URL imageURL=ClassLoader.getSystemResource("icons/logo.jpg");
		ImageIcon i1=new ImageIcon("imageURL");	//imports external image with object of ImageIcon class
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		
		JLabel label=new JLabel(i3);		//created object of JLabel and passed ImageIcons object(i1)
		label.setBounds(70, 10, 100, 100);
		add(label);			//this adds i1 into frame with help of label
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 36));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno=new JLabel("Card No. :");
		cardno.setFont(new Font("Raleway", Font.BOLD, 36));
		cardno.setBounds(120, 150, 180, 40);
		add(cardno);
		
		/*JTextField*/ cardTextField=new JTextField();		//to add text field infront of card no:
		cardTextField.setBounds(300, 150, 230, 40);
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN :");
		pin.setFont(new Font("Raleway", Font.BOLD, 36));
		pin.setBounds(120, 220, 250, 40);
		add(pin);
		
		/*JPasswordField*/ pinTextField=new JPasswordField();		//to add text field infront of PIN :
		pinTextField.setBounds(300, 220, 230, 40);
		pinTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(pinTextField);
		
		/*JButton*/ login=new JButton("SIGN IN");			//to add SIGN IN button
		login.setBounds(300, 300, 100, 40);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);					//added actionListener
		add(login);
		
		/*JButton*/ clear=new JButton("CLEAR");			//to add CLEAR button
		clear.setBounds(430, 300, 100, 40);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);					//added actionListener
		add(clear);
		
		/*JButton*/ signUp=new JButton("SIGNUP");
		signUp.setBounds(300, 350, 230, 40);
		signUp.setBackground(Color.black);
		signUp.setForeground(Color.white);
		signUp.addActionListener(this);					//added actionListener
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);						//1.creates a frame (length,breadth)
		setVisible(true);						//2.shows the frame
		setLocation(350,200);					//3.relocates the frame from origin
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login();
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == clear) {
			cardTextField.setText("");				//this will clear text inside cardTextfield
			pinTextField.setText("");				//this will clear text inside pinTextfield
		}else if(ae.getSource()==login) {
			Conn conn=new Conn();					//For transaction
			String cardnumber=cardTextField.getText();
			String pinnumber=pinTextField.getText();
			String query="select * from login where cardnumber ='"+cardnumber+"' and pin ='"+pinnumber+"' ";
			try {
				ResultSet rs =conn.s.executeQuery(query);		//To catch data somewhere(resultset) when executed query
				if(rs.next()) {									//To check if data is there
					setVisible(false);							//If data is there THEN CURRENT FRAME CLOSE
					new Transactions(pinnumber).setVisible(true);		//Redirect to new frame(Transactions)//pinnumber forwarded to new class Transaction 
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}else if(ae.getSource()==signUp) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}

}
