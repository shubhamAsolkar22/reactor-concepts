package com.fkog.stretchly;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StretchlyApp {
	private JFrame jframe = new JFrame();
	private JButton button = new JButton("dismiss");
	private JLabel label = new JLabel("Take a break!");
	
	private StretchlyApp() {
		jframe.setLayout(new FlowLayout());
		jframe.setSize(400, 100);
		jframe.add(label);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dismiss();
			}
		});
		jframe.add(button);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(false);
	}

	public static void main(String[] args) throws InterruptedException {
		StretchlyApp app = new StretchlyApp();
		int minutes = 1;//args == null ? 1 : Integer.valueOf(args[0]);
		boolean x = true;
		long displayMinutes = 0;
		long starttime = System.currentTimeMillis();
		System.out.println("Timer:");
		while (x) {
			TimeUnit.SECONDS.sleep(1);
			long timepassed = System.currentTimeMillis() - starttime;
			long secondspassed = timepassed / 1000;
			if (secondspassed == 60) {
				secondspassed = 0;
				starttime = System.currentTimeMillis();
			}
			if ((secondspassed % 60 * minutes) == 0) {
				displayMinutes++;
				app.snooze(displayMinutes);
			}

			System.out.println(displayMinutes + "::" + secondspassed);
		}
	}

	private void snooze(long minutesPassed) {
		if(!jframe.isVisible()) { 
			jframe.setVisible(true);
			label.setText("Take rest! "+minutesPassed+" minutes passed.");
		}
	}
	
	private void dismiss() {
		if(jframe.isVisible())
			jframe.setVisible(false);
	}
}
