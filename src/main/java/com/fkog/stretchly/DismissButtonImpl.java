package com.fkog.stretchly;

import java.awt.event.ActionListener;

import javax.swing.JButton;

class DismissButtonImpl implements DismissButton{
	private final JButton jButton = new JButton("Dismiss");
	
	private DismissButtonImpl() {
	}
	
	static DismissButton getInstance(JButton jButton) {
		return new DismissButtonImpl();
	}
	
	@Override
	public JButton getJButton() {
		return jButton;
	}

	@Override
	public void addActionListener(ActionListener listener) {
		jButton.addActionListener(listener);
	}
}
