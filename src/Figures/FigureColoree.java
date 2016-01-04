package Figures;


import java.awt.*;

import Dessin.DessinFigures;
import Dessin.Point;

public abstract class FigureColoree extends DessinFigures {

	protected Point[] tab_mem;
	private boolean selectionne;
	protected Color c;

	public FigureColoree() {
		this.tab_mem = new Point[this.nbPoints()];
		this.selectionne = false;
		this.c = Color.BLACK;
	}

	public abstract int nbPoints();

	public abstract int nbClics();

	public abstract boolean estDedans(int x, int y);

	public abstract void modifierPoints(Point[] ps);

	public void affiche(Graphics g) {
		if (selectionne == true) {
			g.setColor(Color.BLACK);
			for (int i = 0; i < tab_mem.length; i++) {
				g.fillRect(tab_mem[i].rendreX() - 2, tab_mem[i].rendreY() - 2, 4, 4);
			}
			g.setColor(c);
		}
	}

	public void translation(int dx, int dy) {
		for (int i = 0; i < tab_mem.length; i++) {
			tab_mem[i].translation(dx, dy);
		}
	}

	public void selectionne() {
		this.selectionne = true;
	}

	public void deSelectionne() {
		this.selectionne = false;
	}

	public void changeCouleur(Color c) {
		this.c = c;
	}
}