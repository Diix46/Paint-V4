package Figures;

import java.awt.event.*;

import javax.swing.*;

import Dessin.DessinFigures;
import Dessin.Point;

public class FabricantFigures implements MouseListener {

    private FigureColoree figures_en_cours_de_fabrication;
    private int nb_points_cliques;
    private Point[] points_cliques;

    public FabricantFigures(FigureColoree fc) {
	if (fc != null) {
	    figures_en_cours_de_fabrication = fc;
	    nb_points_cliques = 0;
	    points_cliques = new Point[fc.nbClics()];
	}
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
	if (figures_en_cours_de_fabrication != null) {
	    if (nb_points_cliques < points_cliques.length - 1) {
		points_cliques[nb_points_cliques] = new Point(e.getX(), e.getY());
		nb_points_cliques++;
	    }
	    else {
		points_cliques[nb_points_cliques] = new Point(e.getX(), e.getY());
		figures_en_cours_de_fabrication.modifierPoints(points_cliques);
		((DessinFigures) (e.getSource())).ajoute(figures_en_cours_de_fabrication);
		((JComponent) (e.getSource())).removeMouseListener(this);
	    }
	}
    }
}
