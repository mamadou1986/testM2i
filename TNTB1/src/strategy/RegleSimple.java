package strategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import graphique.Case;
import graphique.Grille;

public class RegleSimple implements Regle{

	private Grille grille ;
	
	public RegleSimple(Grille grille) {
		this.grille = grille ;
	}
	
	@Override
	public void apply() {
		for(int i = 0 ; i < grille.getCases().length; i++) {
			for(int j = 0 ; j < grille.getCases()[0].length; j++) {
				grille.getCaseIJ(i, j).addActionListener(new RegleSimpleListener());
			}
		}
	}
	
	class RegleSimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Case source = (Case)e.getSource() ;
			source.changerCouleur();
			Case haut = grille.getCaseHaut(source) ;
			Case bas = grille.getCaseBas(source) ;
			Case gauche = grille.getCaseGauche(source) ;
			Case droite = grille.getCaseDroite(source) ;
			
			if(haut != null )
				haut.changerCouleur();
			
			if(bas != null)
				bas.changerCouleur();
			
			if(gauche != null)
				gauche.changerCouleur();
			
			if(droite != null)
				droite.changerCouleur();
			
			if(isDone(grille)) {
				grille.reset();
				JOptionPane.showMessageDialog(null, "Youpiiiiii Vous avez gagné", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
			}			
		}
		
	}

}
