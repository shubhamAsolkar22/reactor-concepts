package com.fkog.stretchly;

import java.awt.event.ActionListener;

import javax.swing.JButton;

interface DismissButton {
	JButton getJButton();
	
	void addActionListener(ActionListener listener);
}
