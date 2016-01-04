package Dessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import Figures.Cercle;
import Figures.FigureColoree;
import Figures.Quadrilatere;
import Figures.Rectangle;
import Figures.Triangle;
import Sound.Sound;

public class PanneauChoix extends JPanel {

	private FigureColoree fc;

	public PanneauChoix(final DessinFigures dessin) {

		this.setLayout(new BorderLayout());
		final JRadioButton BoutonFigure = new JRadioButton("Nouvelle figure");
		final JRadioButton BoutonDessinMainLevee = new JRadioButton("Main levée");
		final JRadioButton BoutonModif = new JRadioButton("Modification");
		final JButton coul = new JButton("");
		coul.setOpaque(true);
		coul.setPreferredSize(new Dimension (30, 30));
		coul.setBackground(Color.BLACK);
		JButton ColorChooser = new JButton();
		ColorChooser.setText("Choisir une couleur");
		JButton Coucou = new JButton();
		Coucou.setText("Choisir une coucou");
		ButtonGroup GroupeBouton = new ButtonGroup();
		GroupeBouton.add(BoutonFigure);
		GroupeBouton.add(BoutonDessinMainLevee);
		GroupeBouton.add(BoutonModif);
		GroupeBouton.add(coul);
		BoutonFigure.setSelected(true);
		JPanel top = new JPanel();
		top.add(BoutonFigure);
		top.add(BoutonDessinMainLevee);
		top.add(BoutonModif);
		top.add(ColorChooser);
		top.add(Coucou);
		top.add(coul);
		add(top, BorderLayout.CENTER);
		final JComboBox FigureSelectionner = new JComboBox(new String[]{"Aucune sélection", "Rectangle", "Triangle", "Cercle", "Quadrilatere"});
		((JLabel)FigureSelectionner.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		JPanel bottom = new JPanel();
		bottom.add(FigureSelectionner);

		add(bottom, BorderLayout.SOUTH);
		ColorChooser.addActionListener(new ActionListener() {
			private Sound s;

			public void actionPerformed(ActionEvent e) {
				Sound s = new Sound("Sound/background.wav");;
				Color c = JColorChooser.showDialog(null, "Couleur", null);
				s.loop();
				if((BoutonFigure.isSelected()) || (fc != null)) {
					coul.setBackground(c);
					fc.changeCouleur(c);
					dessin.repaint();
				}

				if(BoutonDessinMainLevee.isSelected()) {
					dessin.supprimeAuditeurs();
					dessin.trace(c);
				}

				if(BoutonModif.isSelected()) {
					if (dessin.figureSelection() != null) {
						dessin.figureSelection().changeCouleur(c);
						dessin.repaint();
					}
				}
			}
		});
		
		
		Coucou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sound s = new Sound("Sound/background.wav");;
				s.loop();
			}
		});
		
		

		FigureSelectionner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FigureSelectionner.getSelectedIndex() != 0) {
					dessin.supprimeAuditeurs();
					fc = creeFigure(FigureSelectionner.getSelectedIndex());
					Color c = JColorChooser.showDialog(null, "Choix couleur", null);
					fc.changeCouleur(c);
					coul.setBackground(c);
					FigureSelectionner.setEnabled(true);
					dessin.construit(fc);
				}
			}
		});
		MouseAdapter actionListener = new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				Color palette = Color.BLACK;
				palette = JColorChooser.showDialog(null, "Choix couleur", null);
			}
		};
		ColorChooser.addMouseListener(actionListener);


		BoutonFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dessin.supprimeAuditeurs();
				dessin.construit(fc);
			}
		});

		BoutonDessinMainLevee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(null, "Choix couleur", null);
				coul.setBackground(c);
				dessin.supprimeAuditeurs();
				dessin.trace(c);
			}
		});

		BoutonModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dessin.supprimeAuditeurs();
				dessin.activeManipulationsSouris();
			}
		});
	}

	public void paintComponent(Graphics g){
		g.drawRect(300, 10, 20, 20);
	}
	private Color determineCouleur(int index) {
		Color c = JColorChooser.showDialog(null, "Exemple", null);
		return c;
	}

	private FigureColoree creeFigure(int index) {
		FigureColoree FigureColoree = null;
		switch (index) {
		case 0:
			break;
		case 1:
			FigureColoree = new Rectangle();
			break;
		case 2:
			FigureColoree = new Triangle();
			break;
		case 3:
			FigureColoree = new Cercle();
			break;
		case 4:
			FigureColoree = new Quadrilatere();
			break;
		default:
			break;
		}
		return FigureColoree;
	}
}