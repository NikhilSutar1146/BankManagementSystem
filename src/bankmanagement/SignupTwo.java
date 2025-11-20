package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.ClassNotFoundException;


import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	JTextField pan,aadhar1;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion,catagory,income,occupation,education;
	String formno;

	SignupTwo(String formno){
		
		this.formno=formno;
		
		setLayout(null);		
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		getContentPane().setBackground(Color.white);
		
		JLabel additionalDetails=new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion1=new JLabel("Religion :");
		religion1.setFont(new Font("Raleway",Font.BOLD,20));
		religion1.setBounds(100, 140, 100, 30); 
		add(religion1);
		
		String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
		religion=new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.white);
		add(religion);
		
		JLabel cat=new JLabel("Category :");
		cat.setFont(new Font("Raleway",Font.BOLD,20));
		cat.setBounds(100, 190, 200, 30);
		add(cat);
		
		String valcatagory[]= {"General","OBC","SC","ST","Other"};
		catagory=new JComboBox(valcatagory);
		catagory.setBounds(300, 190, 400, 30);
		catagory.setBackground(Color.white);
		add(catagory);
		
		JLabel inc=new JLabel("Income :");
		inc.setFont(new Font("Raleway",Font.BOLD,20));
		inc.setBounds(100, 240, 200, 30);
		add(inc);
		
		String valIncome[]= {"NULL","< 1,50,000","2,50,000","5,00,000","Upto 10,00,000"};
		income=new JComboBox(valIncome);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.white);
		add(income);
		
		JLabel gender=new JLabel("Educational :");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		JLabel email=new JLabel("Qualification :");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100, 315, 200, 30);
		add(email);
		
		String valEducation[]= {"Non - Graduation","Graduation","Post - Graduation","Doctrate","Others"};
		education=new JComboBox(valEducation);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.white);
		add(education);
		
		JLabel occu=new JLabel("Occupation :");
		occu.setFont(new Font("Raleway",Font.BOLD,20));
		occu.setBounds(100, 390, 200, 30);
		add(occu);
		
		String valOccupation[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
		occupation=new JComboBox(valOccupation);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.white);
		add(occupation);
		
		JLabel panNo=new JLabel("PAN Number :");
		panNo.setFont(new Font("Raleway",Font.BOLD,20));
		panNo.setBounds(100, 440, 200, 30);
		add(panNo);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel aadhar=new JLabel("Aadhar Number :");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadhar1 = new JTextField();
		aadhar1.setFont(new Font("Raleway",Font.BOLD,14));
		aadhar1.setBounds(300, 490, 400, 30);
		add(aadhar1);
		
		JLabel senior=new JLabel("Senior Citizen :");
		senior.setFont(new Font("Raleway",Font.BOLD,20));
		senior.setBounds(100, 540, 200, 30);
		add(senior);
		
		syes =new JRadioButton("Yes");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno =new JRadioButton("No");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup seniorgroup=new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		JLabel existing=new JLabel("Existing Account :");
		existing.setFont(new Font("Raleway",Font.BOLD,20));
		existing.setBounds(100, 590, 200, 30);
		add(existing);
		
		eyes =new JRadioButton("Yes");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno =new JRadioButton("No");
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup existinggroup=new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		setSize(850,800);		
		setLocation(350,10);		
		setVisible(true);		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SignupTwo("");
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String sreligion=(String)religion.getSelectedItem();	//s for stringreligion
		String scatagory=(String)catagory.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		
		String seniorcitizen=null;
		if(syes.isSelected()) {
			seniorcitizen="Yes";
		}else if(sno.isSelected()) {
			seniorcitizen="No";
		}
		
		String existingaccount=null;
		if(eyes.isSelected()) {
			existingaccount="Yes";
		}else if(eno.isSelected()) {
			existingaccount="No";
		}
		
		String span=pan.getText();
		String saadhar=aadhar1.getText();
		
		try {
				Conn c=new Conn();
				String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupThree(formno).setVisible(true);
				
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
