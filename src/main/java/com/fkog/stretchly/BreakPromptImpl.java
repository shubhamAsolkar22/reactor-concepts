package com.fkog.stretchly;

import javax.swing.JLabel;

class BreakPromptImpl implements BreakPrompt {

	private final JLabel label = new JLabel();

	private BreakPromptImpl() {
	}

	static BreakPrompt getInstance() {
		return new BreakPromptImpl();
	}
	
	@Override
	public void resetText(String text) {
		label.setText(text);
	}
	
	@Override
	public JLabel getJlabel() {
		return label;
	}
}
