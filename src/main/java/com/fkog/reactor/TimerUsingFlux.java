package com.fkog.reactor;

import java.time.Duration;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import reactor.core.publisher.Flux;
import java.awt.*;

public class TimerUsingFlux extends JFrame {
	private JLabel timerLabel = new JLabel("0");

	public TimerUsingFlux() {
		setLayout(new GridLayout());
		setSize(400, 400);
		setVisible(true);
		JPanel jp = new JPanel();
		jp.add(new JLabel("Time: "));
		jp.add(timerLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(jp);
		timerLabel.setSize(20, 20);
	}

	public void resetLabelText(String text) {
		timerLabel.setText(text);
	}

	public static void main(String[] args) {
		TimerUsingFlux app = new TimerUsingFlux();
		Flux.interval(Duration.ofSeconds(1)).subscribe(e -> app.resetLabelText(String.valueOf(e)));
	}
}
