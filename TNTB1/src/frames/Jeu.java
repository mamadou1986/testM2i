package frames;

import javax.swing.JFrame;

import ecrans.EcranJeu;
import strategy.Regle;
import strategy.RegleSimple;
import utilitaires.Parametres;

public class Jeu extends JFrame{

	private EcranJeu ecranJeu ;
	private Regle regleSimple ;
	
	public Jeu() {
		
		setTitle(Parametres.APP_NAME);
		setPreferredSize(Parametres.TAILLE_FENETRE_DEFAUT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		ecranJeu = new EcranJeu() ;
		regleSimple = new RegleSimple(ecranJeu.getGrille()) ;
		regleSimple.apply();
		
		getContentPane().add(ecranJeu);
		pack() ;
		setVisible(true);
	}
	
}
