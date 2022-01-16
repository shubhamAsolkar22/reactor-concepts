package com.fkog.reactor.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class JTabbedPaneApp extends JPanel {
	public JTabbedPaneApp() {
		initializeUI();
	}

	public static void showFrame() {
		JPanel panel = new JTabbedPaneApp();
		panel.setOpaque(true);

		JFrame frame = new JFrame("JTabbedPane Demo");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(JTabbedPaneApp::showFrame);
	}

	private void initializeUI() {
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.addTab("A Tab", new JPanel());
		tabbedPane.addTab("B Tab", new JPanel());

		JPanel tabPanel = new JPanel();
		tabbedPane.addTab("C Tab", tabPanel);
		tabbedPane.addTab("D Tab", new JPanel());
		tabbedPane.addTab("E Tab", new JPanel());

		// Remove the last tab from JTabbedPane
		tabbedPane.remove(tabbedPane.getTabCount() - 1);

		// Remove tab that contains a tabPanel component which is
		// the C Tab.
		tabbedPane.remove(tabPanel);

		JButton button = new JButton("Remove All Tabs");
		button.addActionListener(e -> {
			// Remove all tabs from JTabbedPane
			tabbedPane.removeAll();
		});

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500, 200));
		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
	}
}