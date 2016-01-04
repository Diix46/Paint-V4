package Dessin;

import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.SwingUtilities;

public class TraceurForme implements MouseListener, MouseMotionListener {

	private int last_X;
	private int last_Y;
	private Graphics g;

	public TraceurForme(Graphics gp) {
		this.g = gp;
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.last_X = e.getX();
			this.last_Y = e.getY();
		}
		else if (SwingUtilities.isRightMouseButton(e)) {
			((DessinFigures) (e.getSource())).removeMouseListener(this);
			((DessinFigures) (e.getSource())).removeMouseMotionListener(this);
			((DessinFigures) (e.getSource())).repaint();
		}
	}

	public void mouseDragged(MouseEvent e) {
		g.drawLine(this.last_X, this.last_Y, e.getX(), e.getY());
		this.last_X = e.getX();
		this.last_Y = e.getY();

	}
}
