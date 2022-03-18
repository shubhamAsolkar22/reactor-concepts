package com.fkog.swingComponent.dial;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dial extends JComponent {
	  int minValue, value, maxValue, radius;
	  
	  public Dial( ) { this(0, 100, 0); }
	  
	  public Dial(int minValue, int maxValue, int value) {
	    this.minValue = minValue; 
	    this.maxValue = maxValue;
	    this.value = value;
	    setForeground(Color.lightGray);

	    addMouseListener(new MouseAdapter( ) {
	      public void mousePressed(MouseEvent e) { spin(e); }
	    });
	    addMouseMotionListener(new MouseMotionAdapter( ) {
	      public void mouseDragged(MouseEvent e) { spin(e); }
	    });
	  }
	  
	  protected void spin(MouseEvent e) {
	    int y = e.getY( );
	    int x = e.getX( );
	    double th = Math.atan((1.0 * y - radius) / (x - radius));
	    int value=((int)(th / (2 * Math.PI) * (maxValue - minValue)));
	    if (x < radius)
	      setValue(value + maxValue / 2);
	    else if (y < radius)
	      setValue(value + maxValue);
	    else
	      setValue(value);
	  }

	  public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D)g;
	    int tick = 10;
	    radius = getSize( ).width / 2 - tick;
	    g2.setPaint(getForeground().darker( ));
	    g2.drawLine(radius * 2 + tick / 2, radius,
	        radius * 2 + tick, radius);
	    g2.setStroke(new BasicStroke(2));
	    draw3DCircle(g2, 0, 0, radius, true);
	    int knobRadius = radius / 7;
	    double th = value * (2 * Math.PI) / (maxValue - minValue);
	    int x = (int)(Math.cos(th) * (radius - knobRadius * 3)),
	    y = (int)(Math.sin(th) * (radius - knobRadius * 3));
	    g2.setStroke(new BasicStroke(1));
	    draw3DCircle(g2, x + radius - knobRadius,
	                 y + radius - knobRadius, knobRadius, false );
	  }

	  private void draw3DCircle( Graphics g, int x, int y,
	                             int radius, boolean raised) {
	    Color foreground = getForeground( );
	    Color light = foreground.brighter( );
	    Color dark = foreground.darker( );
	    g.setColor(foreground);
	    g.fillOval(x, y, radius * 2, radius * 2);
	    g.setColor(raised ? light : dark);
	    g.drawArc(x, y, radius * 2, radius * 2, 45, 180);
	    g.setColor(raised ? dark : light);
	    g.drawArc(x, y, radius * 2, radius * 2, 225, 180);
	  }

	  public Dimension getPreferredSize( ) {
	    return new Dimension(100, 100);
	  }

	  public void setValue(int value) {
	    firePropertyChange( "value", this.value, value );
	    this.value = value;
	    repaint( );
	    fireEvent( );
	  }
	  public int getValue( )  { return value; }
	  public void setMinimum(int minValue)  { this.minValue = minValue; }
	  public int getMinimum( )  { return minValue; }
	  public void setMaximum(int maxValue)  { this.maxValue = maxValue; }
	  public int getMaximum( )  { return maxValue; }

	  public void addDialListener(DialListener listener) {
	    listenerList.add( DialListener.class, listener );
	  }
	  public void removeDialListener(DialListener listener) {
	    listenerList.remove( DialListener.class, listener );
	  }

	  void fireEvent( ) {
	    Object[] listeners = listenerList.getListenerList( );
	    for ( int i = 0; i < listeners.length; i += 2 )
	      if ( listeners[i] == DialListener.class )
	        ((DialListener)listeners[i + 1]).dialAdjusted( 
	          new DialEvent(this, value) );
	  }

	  public static void main(String[] args) {
	    JFrame f = new JFrame("Dial v1.0");
	    f.addWindowListener( new WindowAdapter( ) {
	      public void windowClosing(WindowEvent e) { System.exit(0); }
	    });
	    f.setSize(150, 150);
	    
	    final JLabel statusLabel = new JLabel("Welcome to Dial v1.0");
	    final Dial dial = new Dial( );
	    JPanel dialPanel = new JPanel( );
	    dialPanel.add(dial);
	    f.getContentPane( ).add(dialPanel, BorderLayout.CENTER);
	    f.getContentPane( ).add(statusLabel, BorderLayout.SOUTH);
	    
	    dial.addDialListener(new DialListener( ) {
	      public void dialAdjusted(DialEvent e) {
	        statusLabel.setText("Value is " + e.getValue( ));
	      }
	    });
	    f.setVisible( true );
	  }
	}