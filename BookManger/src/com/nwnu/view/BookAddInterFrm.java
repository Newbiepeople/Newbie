package com.nwnu.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.nwnu.dao.BookDao;
import com.nwnu.dao.BookTypeDao;
import com.nwnu.model.Book;
import com.nwnu.model.BookType;
import com.nwnu.model.StringUtil;
import com.nwnu.util.DbUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField pricecTxt;
	private DbUtil dbUtil = new DbUtil();//私有定义
	private BookTypeDao bookTypeDao= new BookTypeDao();//私有定义
	private BookDao bookDao = new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 529, 496);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		manJrb.setSelected(true);
		buttonGroup.add(manJrb);
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		pricecTxt = new JTextField();
		pricecTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		
		JLabel label_5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_5)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(manJrb)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(femaleJrb))))
									.addGap(46)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(pricecTxt))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addComponent(button)
							.addGap(38)
							.addComponent(button_1)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label_3)
						.addComponent(pricecTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1, false));
		//设置边框代码
		fillBookType();
	}
	/**
	 * 重置时间处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		resetValue();
	}

	/**
	 * 图书添加处理
	 * @param e
	 */
	private void BookAddActionPerformed(ActionEvent evt) {
		String bookName=this.bookNameTxt.getText();
		String author = this.authorTxt.getText();
		String price = this.pricecTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		String sex= null;
		if(manJrb.isSelected()){
			sex="男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book( bookName, author,  sex, Float.parseFloat(price),bookTypeId,bookDesc);
		
		Connection con = null;
		try{
			con= dbUtil.getCon();
			int addNum=bookDao.add(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.pricecTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}
	/**
	 * 初始化图书类别下拉框
	 */
	private void fillBookType(){
		Connection con = null;
		BookType bookType = null;
		try{
			con= dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
