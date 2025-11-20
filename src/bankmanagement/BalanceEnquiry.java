package bankmanagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

	JButton back;
	String pinnumber;
	
	BalanceEnquiry(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn=new Conn();		//this is written in constructor instead of unimplemented method bcz we want it to show directly when page opened not on button click
		int balance=0;
		try {
				ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				while(rs.next()) {													//to calculate acc balance deposit+withdrawl
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -=Integer.parseInt(rs.getString("amount"));
					}
				}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel text =new JLabel("Your Current Account balance is Rs "+balance);
		text.setForeground(Color.white);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BalanceEnquiry("");
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}

}
