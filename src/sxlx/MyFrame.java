package sxlx;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	public MyFrame() {
	this.setSize(300, 200);
	 this.setTitle("First frame...");
	 //在屏幕上显示
	 //	frame.setVisible(true);
	 // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JButton btnNorth = new JButton("北方");
     JButton btnSouth = new JButton("南方");
     JButton btnEast = new JButton("东方");
     JButton btnWest = new JButton("西方");
     JButton btnCenter = new JButton("中间");
     
     
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