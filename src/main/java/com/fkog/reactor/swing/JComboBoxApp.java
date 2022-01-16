package com.fkog.reactor.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboBoxApp {
	JFrame f;

	private JComboBoxApp() {
		f = new JFrame("ComboBox Example");
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400, 100);
//		label.setb
//		b.setBounds(200, 100, 75, 20);
		String languages[] = { "C", "C++", "C#", "Java", "PHP" };
		final JComboBox cb = new JComboBox(languages);
		cb.setBounds(50, 100, 90, 20);
		f.add(cb);
		f.add(label);
		f.setLayout(null);
		f.setSize(350, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label.setText(languages[cb.getSelectedIndex()]);
			}
		});
	}

	public static void main(String[] args) {
		new JComboBoxApp();
	}

}
