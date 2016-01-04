package Figures;

import java.awt.*;

import Dessin.Point;

public class Cercle extends ConiqueCentree {

	public Cercle() {
		super();
	}

	public void affiche(Graphics g) {
		centre = new Point(tab_mem[0].rendreX(), tab_mem[0].rendreY());
		g.setColor(c);
		g.fillOval((int) (centre.rendreX() - this.rendreRayon()), (int) (centre.rendreY() - this.rendreRayon()), (int) (this.rendreRayon() * 2), (int) (this.rendreRayon() * 2));
		super.affiche(g);
	}

	public double rendreRayon() {
		return tab_mem[0].distance(tab_mem[1]);
	}

	public int nbClics() {
		return 2;
	}

	public int nbPoints() {
		return 2;
	}

	public void modifierPoints(Point[] tab_saisie) {
		if (tab_saisie != null) {
			tab_mem[0] = tab_saisie[0];
			tab_mem[1] = tab_saisie[1];
		}
	}

	public void translation(int dx, int dy) {
		super.translation(dx, dy);
		centre.translation(dx, dy);

	}

	public boolean estDedans(int x, int y) {
		Point p = new Point(x, y);
		boolean dedans = false;
		if (p.distance(centre) <= (int) (this.rendreRayon())) {
			dedans = true;
		}
		return dedans;
	}
}