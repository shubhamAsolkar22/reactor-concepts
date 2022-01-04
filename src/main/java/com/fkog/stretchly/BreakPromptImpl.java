package com.fkog.stretchly;

import javax.swing.JLabel;

class BreakPromptImpl implements BreakPrompt {

	private final JLabel label;

	private BreakPromptImpl(JLabel label) {
		this.label = label;
	}

	static BreakPrompt getInstance(JLabel label) {
		return new BreakPromptImpl(label);
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
