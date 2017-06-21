package com.nwnu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.beans.PropertyVetoException;

public class NwnuInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NwnuInterFrm frame = new NwnuInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public NwnuInterFrm() throws PropertyVetoException {
		setMaximum(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u6211");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewbie = new JLabel("Newbie");
		lblNewbie.setFont(new Font("ËÎÌו", Font.PLAIN, 40));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(153)
					.addComponent(lblNewbie)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewbie)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
