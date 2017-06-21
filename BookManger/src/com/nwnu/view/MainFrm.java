package com.nwnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
	
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 430);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeInterFrm bookTypeInterFrm = new BookTypeInterFrm();
				bookTypeInterFrm.setVisible(true);
				table.add(bookTypeInterFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerInterFrm bookTypeManagerInterFrm = new BookTypeManagerInterFrm();
				bookTypeManagerInterFrm.setVisible(true);
				table.add(bookTypeManagerInterFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(menu_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_3.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookMangerInterFrm bookMangerInterFrm = new BookMangerInterFrm();
				bookMangerInterFrm.setVisible(true);
				table.add(bookMangerInterFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_3.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否确定退出系统？");
				if(result==0){
					dispose();
				}
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_1);
		
		JMenuItem mntmnewbie = new JMenuItem("\u5173\u4E8Enewbie");
		mntmnewbie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NwnuInterFrm nwnuInterFrm;
				try {
					nwnuInterFrm = new NwnuInterFrm();
					nwnuInterFrm.setVisible(true);//设置可见
					table.add(nwnuInterFrm);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmnewbie.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menu_1.add(mntmnewbie);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	    table = new JDesktopPane();
		table.setBackground(Color.GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//设置最大化
	}
}
