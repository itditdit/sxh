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
  //�ϲ����ò�ѯ�����������
	private JPanel panelSearch =new JPanel();
	//�²��ṩadd��delete,modify���������
	private JPanel panelProcess= new JPanel();
	//������
	private JTextField txtSearch = new JTextField();
	//������ť
	private JButton btnSearch= new JButton("search");
    private JLabel labView = new JLabel("hhhhhh");
	//��Ӷ๦����壬�����ܶ����
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
    	
    	   // === ��ʼ����� =======
        panelSearch.setLayout(new BorderLayout());//���ò���
        panelSearch.add(txtSearch);//����������м䲿��
        panelSearch.add(btnSearch,BorderLayout.EAST);//���������ť���ұ�
        
       
        //== ��ʼ���ײ����
        panelProcess.add(btnAdd);
        panelProcess.add(btnDelete);
        panelProcess.add(btnModify);

        //=== ====
        this.add(panelSearch, BorderLayout.NORTH);//���������嵽�Ϸ�
        this.add(panelProcess,BorderLayout.SOUTH);//��Ӳ�����嵽�·�
//        this.add(panelAdd);
     this.add(labView);
        
    	//==== ��ʼ����� ===//
		panelSearch.setLayout(new BorderLayout());//���ò���
		panelSearch.add(txtSearch);//����������м䲿��
		panelSearch.add(btnSearch,BorderLayout.EAST);//���������ť���ұ�
		
		
		//==== ����¼�����====//
		btnSearch.addActionListener(new  ActionListener() {
			 @Override	 
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub);
				 JOptionPane.showMessageDialog(null, ""+txtSearch.getText());
			 }
		});
		// == ��ʼ��panelAdd������ ==
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
				 //1.�õ��ı���text���ݣ�����������ݾ����߼�
				 String text = btnAdd.getText();
				 if(text.equals("add")){//������Ӽ�¼�Ĳ���
				//�Ƴ��������
					 AccountFrame.this.remove(labView);
					//��ӵ�panel�м�
					 AccountFrame.this.add(panelAdd);
					 text = "save";
				 }else {//��ԭ�س�ʼ��״̬
					 text="add";
					 AccountFrame.this.remove(panelAdd);
					 labView.setText("����ɹ�");
					 AccountFrame.this.add(labView);
				 }
				 btnAdd.setText(text);
				 btnDelete.setText("canel");
				 btnModify.setVisible(false);
				 
				 //������ҳ��ˢ���ػ�
				 AccountFrame.this.setVisible(false);
				 AccountFrame.this.setVisible(true);
				 
				
				
			 }
		});
				 
		this.add(panelSearch,BorderLayout.NORTH);//���������嵽�Ϸ�
		this.add(panelProcess,BorderLayout.SOUTH);//��Ӳ�����嵽�·�
		
		this.setSize(800, 600);
		this.setTitle("�˺���ҳ");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		}
    public static void main(String args[]) {
    	new AccountFrame();
    }
}
