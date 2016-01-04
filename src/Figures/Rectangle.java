package Figures;
import Dessin.Point;




public class Rectangle extends Quadrilatere {

	public Rectangle() {
		super();
	}

	public int nbClics() {
		return 2;
	}

	public void modifierPoints(Point[] tab_saisie) {
		if (tab_saisie != null) {
			tab_mem[0] = tab_saisie[0];
			tab_mem[2] = tab_saisie[1];
			tab_mem[1] = new Point(tab_mem[0].rendreX(), tab_mem[2].rendreY());
			tab_mem[3] = new Point(tab_mem[2].rendreX(), tab_mem[0].rendreY());
		}
	}
}