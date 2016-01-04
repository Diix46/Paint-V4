package Figures;

import java.awt.Graphics;

import Dessin.Point;

public abstract class ConiqueCentree extends FigureColoree {

	protected Point centre;

	public ConiqueCentree() {
		super();
	}

	public Point rendreCentre() {
		return this.centre;
	}
}