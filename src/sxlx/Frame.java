package sxlx;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	public Frame() {
	this.setSize(1000,800);
	GridLayout gridLayout = new GridLayout(5,2);
	this.setLayout(gridLayout);
	JLabel lb1 =new JLabel("title");
	JTextField text1= new JTextField(20);
	JLabel lb2 = new JLabel("account");
	JTextField text2 = new JTextField(20);
	JLabel lb3 =new JLabel("password");
	JTextField text3 = new JTextField(20);
	JLabel lb4 = new JLabel("remark");
	JTextField text4 = new JTextField(20);
	JButton btnok = new JButton("确定");
	JButton btncanle = new JButton("取消");
	btncanle.addActionListener(
	 new ActionListener() {
		 @Override	 
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
		      JOptionPane.showMessageDialog( null,""+text1.getText()+","+text2.getText()+","+text3.getText()+","+text4.getText());
	 }

	});
		
	this.add(lb1);
	this.add(text1);
	this.add(lb2);
	this.add(text2);
	this.add(lb3);
	this.add(text3);
	this.add(lb4);
	this.add(text4);
	
	this.add(btnok);
	this.add(btncanle);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
   
	public static void main(String args[]) {
		new Frame();
	}
}
