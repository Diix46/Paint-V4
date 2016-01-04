package Dessin;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Figures.FabricantFigures;
import Figures.FigureColoree;

public class DessinFigures extends JPanel {

	private FigureColoree[] tabFigures;
	private int NombreFigure;
	private int IndiceFigure;

	public DessinFigures() {
		tabFigures = new FigureColoree[100];
		NombreFigure = 0;
		IndiceFigure = -1;
	}

	private class ManipulateurFormes extends MouseAdapter implements MouseMotionListener {

		private int last_x;
		private int last_y;

		public void mouseMoved(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			if (IndiceFigure >= 0) {
				tabFigures[IndiceFigure].translation(e.getX() - last_x, e.getY() - last_y);
				last_x = e.getX();
				last_y = e.getY();
			}
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				tabFigures[IndiceFigure].deSelectionne();
				last_x = e.getX();
				last_y = e.getY();
				for (int i = NombreFigure - 1; i >= 0; i--) {
					if (tabFigures[i].estDedans(e.getX(), e.getY())) {
						IndiceFigure = i;
						tabFigures[IndiceFigure].selectionne();
						break;
					}
				}
				if (IndiceFigure != -1) {
					FigureColoree figures = tabFigures[IndiceFigure];
					tabFigures[IndiceFigure] = tabFigures[NombreFigure - 1];
					tabFigures[NombreFigure - 1] = figures;
					IndiceFigure = NombreFigure - 1;
				}
			}
			else if (SwingUtilities.isRightMouseButton(e)) {
				((DessinFigures) (e.getSource())).removeMouseListener(this);
				((DessinFigures) (e.getSource())).removeMouseMotionListener(this);
			}
		}
	}

	public void activeManipulationsSouris() {
		ManipulateurFormes mf = new ManipulateurFormes();
		this.addMouseListener(mf);
		this.addMouseMotionListener(mf);
	}

	public void ajoute(FigureColoree fc) {
		if (fc != null) {
			tabFigures[NombreFigure] = fc;
			if (IndiceFigure != -1) {
				tabFigures[IndiceFigure].deSelectionne();
			}
			IndiceFigure = NombreFigure;
			fc.selectionne();
			NombreFigure++;
		}
		repaint();
	}

	public int nbFigures() {
		return this.NombreFigure;
	}

	public FigureColoree figureSelection() {
		if (IndiceFigure != -1) {
			return tabFigures[IndiceFigure];
		}
		else {
			return null;
		}
	}

	public void selectionProchaineFigure() {
		if (IndiceFigure != -1) {
			tabFigures[IndiceFigure].deSelectionne();
			IndiceFigure++;
			if (IndiceFigure == NombreFigure) {
				IndiceFigure = 0;
			}
			tabFigures[IndiceFigure].selectionne();
			NombreFigure++;
		}
	}

	public void supprimeAuditeurs() {
		MouseListener[] ml = (MouseListener[]) (getListeners(MouseListener.class));
		for (int i = 0; i < ml.length; i++) {
			removeMouseListener(ml[i]);
		}
		MouseMotionListener[] mml = (MouseMotionListener[]) (getListeners(MouseMotionListener.class));
		for (int i = 0; i < mml.length; i++) {
			removeMouseMotionListener(mml[i]);
		}

	}

	public void trace(Color c) {
		Graphics g = this.getGraphics();
		g.setColor(c);
		TraceurForme tf = new TraceurForme(g);
		this.addMouseListener(tf);
		this.addMouseMotionListener(tf);
	}

	public void construit(FigureColoree FigureColore) {
		if (FigureColore != null) {
			this.addMouseListener(new FabricantFigures(FigureColore));
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < NombreFigure; i++) {
			tabFigures[i].affiche(g);
		}
	}
}