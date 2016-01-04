package Dessin;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Figures.*;
import Figures.Rectangle;

public class Fenetre extends JPanel {

	private DessinFigures dessin;

	public Fenetre(String s, int largeur, int hauteur) {
		super();
		JFrame fenetre = new JFrame(s);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dessin = new DessinFigures();
		JPanel PanneauChoix = new PanneauChoix(dessin);
		JPanel PanneauFigure = new JPanel();
		PanneauFigure.setLayout(new BorderLayout());
		PanneauFigure.setPreferredSize(new Dimension(largeur, hauteur));
		PanneauFigure.add(dessin, BorderLayout.CENTER);
		PanneauFigure.add(PanneauChoix, BorderLayout.NORTH);
		fenetre.setContentPane(PanneauFigure);
		fenetre.pack();
		fenetre.setVisible(true);

	}

	public static void main(String args[]) {
		Fenetre f = new Fenetre("Paint v4", 800, 600);
	}
}
