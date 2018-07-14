package sxlx;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
  //上部放置查询相关组件的面板
	private JPanel panelSearch =new JPanel();
	//下部提供add，delete,modify操作的面板
	private JPanel panelProcess= new JPanel();
	//搜索框
	private JTextField txtSearch = new JTextField();
	//搜索按钮
	private JButton btnSearch= new JButton("search");
    private JLabel labView = new JLabel("hhhhhh");
	//添加多功能面板，包含很多组件
	   private JPanel panelAdd= new JPanel();
	    JLabel lb1 =new JLabel("title");
		JTextField text1= new JTextField();
		JLabel lb2 = new JLabel("account");
		JTextField text2 = new JTextField();
		JLabel lb3 =new JLabel("password");
		JTextField text3 = new JTextField();
		JLabel lb4 = new JLabel("remark");
		JTextField text4 = new JTextField();


	    private JButton btnAdd = new JButton("add");
	    private JButton btnDelete = new JButton("delete");
	    private JButton btnModify = new JButton("modify");

	     
	        
	
    public AccountFrame() {
    	
    	   // === 初始化组件 =======
        panelSearch.setLayout(new BorderLayout());//设置布局
        panelSearch.add(txtSearch);//添加搜索框到中间部分
        panelSearch.add(btnSearch,BorderLayout.EAST);//添加搜索按钮到右边
        
       
        //== 初始化底部面板
        panelProcess.add(btnAdd);
        panelProcess.add(btnDelete);
        panelProcess.add(btnModify);

        //=== ====
        this.add(panelSearch, BorderLayout.NORTH);//添加搜索面板到上方
        this.add(panelProcess,BorderLayout.SOUTH);//添加操作面板到下方
//        this.add(panelAdd);
     this.add(labView);
        
    	//==== 初始化组件 ===//
		panelSearch.setLayout(new BorderLayout());//设置布局
		panelSearch.add(txtSearch);//添加搜索框到中间部分
		panelSearch.add(btnSearch,BorderLayout.EAST);//添加搜索按钮到右边
		
		
		//==== 添加事件处理====//
		btnSearch.addActionListener(new  ActionListener() {
			 @Override	 
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub);
				 JOptionPane.showMessageDialog(null, ""+txtSearch.getText());
			 }
		});
		// == 初始化panelAdd面板组件 ==
		GridLayout gridLayout = new GridLayout(4,2);
		panelAdd.setLayout(gridLayout);
		panelAdd.add(lb1);
		panelAdd.add(text1);
		panelAdd.add(lb2);
		panelAdd.add(text2);
		panelAdd.add(lb3);
		panelAdd.add(text3);
		panelAdd.add(lb4);
		panelAdd.add(text4);
		
		btnAdd.addActionListener(new  ActionListener() {
			 @Override	 

			// @Override	 
			//	public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub);
			//	JFrame frameAdd = new JFrame();
			//	new Frame();
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub);
				 //1.拿到文本的text内容，根据这个内容决定逻辑
				 String text = btnAdd.getText();
				 if(text.equals("add")){//进入添加记录的操作
				//移除搜索组件
					 AccountFrame.this.remove(labView);
					//添加到panel中间
					 AccountFrame.this.add(panelAdd);
					 text = "save";
				 }else {//还原回初始的状态
					 text="add";
					 AccountFrame.this.remove(panelAdd);
					 labView.setText("保存成功");
					 AccountFrame.this.add(labView);
				 }
				 btnAdd.setText(text);
				 btnDelete.setText("canel");
				 btnModify.setVisible(false);
				 
				 //类似于页面刷新重绘
				 AccountFrame.this.setVisible(false);
				 AccountFrame.this.setVisible(true);
				 
				
				
			 }
		});
				 
		this.add(panelSearch,BorderLayout.NORTH);//添加搜索面板到上方
		this.add(panelProcess,BorderLayout.SOUTH);//添加操作面板到下方
		
		this.setSize(800, 600);
		this.setTitle("账号首页");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		}
    public static void main(String args[]) {
    	new AccountFrame();
    }
}
