package sxlx;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	public MyFrame() {
	this.setSize(300, 200);
	 this.setTitle("First frame...");
	 //����Ļ����ʾ
	 //	frame.setVisible(true);
	 // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JButton btnNorth = new JButton("����");
     JButton btnSouth = new JButton("�Ϸ�");
     JButton btnEast = new JButton("����");
     JButton btnWest = new JButton("����");
     JButton btnCenter = new JButton("�м�");
     
     
     this.add(btnNorth,BorderLayout.NORTH);
     this.add(btnSouth,BorderLayout.SOUTH);
     this.add(btnEast,BorderLayout.EAST);
     this.add(btnWest,BorderLayout.WEST);
     this.add(btnCenter,BorderLayout.CENTER);
     
 	this.setVisible(true);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 }
public static void main(String args[]) {
	new MyFrame();
}
}