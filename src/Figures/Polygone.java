package Figures;


import java.awt.*;
import java.lang.Math;

import Dessin.Point;

public abstract class Polygone extends FigureColoree {

	private Polygon p;

	public Polygone() {
		super();

	}

	public void affiche(Graphics g) {
		p = new Polygon();
		for (int i = 0; i < tab_mem.length; i++) {
			p.addPoint(tab_mem[i].rendreX(), tab_mem[i].rendreY());
		}
		g.setColor(c);
		g.fillPolygon(p);
		super.affiche(g);
	}

	public int nbClics() {
		return nbPoints();
	}

	public void modifierPoints(Point[] tab_saisie) {
		if (tab_saisie != null) {
			if (tab_saisie.length == nbPoints()) {
				tab_mem = tab_saisie;
			}
		}
	}

	public boolean estDedans(int x, int y) {
		return (p.contains(x, y));
	}
}