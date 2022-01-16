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
	private final BreakPrompt breakPrompt;
	private final DismissButton dismissButton;
	
	private StretchlyApp(BreakPrompt breakPrompt, DismissButton dismissButton) {
		this.breakPrompt = breakPrompt;
		this.dismissButton = dismissButton;
	}
	
	private void init() {
		jframe.setLayout(new FlowLayout());
		jframe.setSize(400, 100);
		jframe.add(breakPrompt.getJlabel());
		dismissButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dismiss();
			}
		});
		jframe.add(dismissButton.getJButton());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(false);
	}

	public static void main(String[] args) throws InterruptedException {
		StretchlyApp app = new StretchlyApp(BreakPromptImpl.getInstance(),DismissButtonImpl.getInstance());
		app.init();
		int minutes = 1;//args == null ? 1 : Integer.valueOf(args[0]);
		long displayMinutes = 0;
		System.out.println("Timer started");
		while (true) {
			TimeUnit.SECONDS.sleep(10);
				displayMinutes++;
				app.snooze(displayMinutes);

		}
	}

	private void snooze(long minutesPassed) {
		breakPrompt.resetText("Take rest! "+minutesPassed+" minutes passed.");
		if(!jframe.isVisible()) { 
			jframe.setVisible(true);
		}
	}
	
	private void dismiss() {
		if(jframe.isVisible())
			jframe.setVisible(false);
	}
}
