package model;

public class Echiquier implements BoardGames {
	
	Jeu jeuBlanc, jeuNoir, jeuCourant;
	String message;	
	
	public Echiquier() {
		this.jeuBlanc = new Jeu(Couleur.BLANC);
		this.jeuNoir = new Jeu(Couleur.NOIR);
		this.jeuCourant = jeuBlanc;
	}
	
	public void switchJoueur() {
		if (jeuCourant.getCouleur() == Couleur.BLANC) {
			jeuCourant = jeuNoir;
		}else{
			jeuCourant = jeuBlanc;
		}
		setMessage("Changement de joueur");
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (jeuCourant.getCouleur() == Couleur.BLANC){
			
		}
		// test piece couleur joueur courant
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return jeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "Jeu blanc : " + jeuBlanc.toString() + "\nJeu noir : " + jeuNoir.toString();
	}
	
	public static void main(String[] args) {
		Echiquier echiquier = new Echiquier();
		System.out.println(echiquier);
		System.out.println("joueur courant : " + echiquier.getColorCurrentPlayer());
		echiquier.switchJoueur();
		System.out.println(echiquier.getMessage());
		System.out.println("joueur courant : " + echiquier.getColorCurrentPlayer());
		
		
	}

}
