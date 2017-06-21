package com.nwnu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.nwnu.dao.BookTypeDao;
import com.nwnu.model.BookType;
import com.nwnu.model.StringUtil;
import com.nwnu.util.DbUtil;

public class BookTypeInterFrm extends JInternalFrame {
	private JTextField BookTypeNameTxt;
	private JTextArea BookTypeDescTxt;
	private DbUtil dbUtil = new DbUtil();//私有定义
	private BookTypeDao bookTypeDao= new BookTypeDao();//私有定义

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeInterFrm frame = new BookTypeInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		 BookTypeDescTxt = new JTextArea();
		
		BookTypeNameTxt = new JTextField();
		BookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BookTypeNameTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(BookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(BookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		BookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1, false));
		//设置边框代码
	}
	/**
	 * 图书类别添加事件
	 * @param e
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		
		String BookTypeName=this.BookTypeNameTxt.getText();
		String BookTypeDescTxt = this.BookTypeDescTxt.getText();
		if(StringUtil.isEmpty(BookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别不能为空");
			return;
		}
		BookType bookType = new BookType(BookTypeName,BookTypeDescTxt);
		Connection con = null;
		try{
			con= dbUtil.getCon();
			int n =bookTypeDao.add(con, bookType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "图书类别添加成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
				
			}
		}catch(Exception e){
			
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
			}
		}
	}

	/**
	 * 重置
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	private void resetValue(){
		this.BookTypeNameTxt.setText("");
		this.BookTypeDescTxt.setText("");
	}
}
