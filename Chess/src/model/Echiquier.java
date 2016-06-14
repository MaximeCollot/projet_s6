package model;

import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	Jeu jeuBlanc, jeuNoir, jeuCourant, jeuAdverse;
	String message;	
	
	public Echiquier() {
		this.jeuBlanc = new Jeu(Couleur.BLANC);
		this.jeuNoir = new Jeu(Couleur.NOIR);
		this.jeuCourant = jeuBlanc;
		this.jeuAdverse = jeuNoir;
	}
	
	public void switchJoueur() {
		Jeu jeuTemp = jeuAdverse;
		jeuAdverse = jeuCourant;
		jeuCourant = jeuTemp;
		setMessage("Changement de joueur");
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean moveIsOk = false;
		//test s'il n'existe pas de piece du jeu courant aux coordonnées initiales
		if (jeuCourant.isPieceHere(xInit, yInit)){ 
			//test si les coordonnées finales ne sont pas valides ou égales aux initiales
			if (VerifBord.isOk(xFinal, yFinal)&&(xInit!=xFinal)&&(yInit!=yFinal)){
				//test si position finale ne correspond pas à algo de déplacement piece
				if (jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal, jeuCourant.capture(xFinal, yFinal), true)) {
					//test s'il existe une piéce intermédiaire sur la trajectoire
					if (true) {
						//test s'il existe une piéce positionnées aux coordonnées finales
						if (!jeuCourant.isPieceHere(xFinal, yFinal)) {  //ajouter test pour roque danse else
							// test s'il est possible de capturer
							if (jeuAdverse.isPieceHere(xFinal, yFinal)) {
								jeuAdverse.move(xFinal, yFinal, -1, -1);
								jeuCourant.move(xInit, yInit, xFinal, yFinal);
							}else{
								jeuCourant.move(xInit, yInit, xFinal, yFinal);
							}
						}
					}
					
				}
			}
		}
		return moveIsOk;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean moveIsOK = false;
		moveIsOK = jeuCourant.move(xInit, yInit, xFinal, yFinal);
		if (moveIsOK){
			setMessage("Déplacement effectué");
		}else{
			setMessage("Déplacement refusé");
		}
		return moveIsOK;
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
		Couleur laCouleur;
		if (jeuCourant.getCouleur() == Couleur.BLANC) {
			laCouleur = jeuBlanc.getPieceColor(x, y);
		}else{
			laCouleur = jeuNoir.getPieceColor(x, y);
		}
		return laCouleur;
	}
	
	public List<PieceIHMs> getPiecesIHM() {
		List<PieceIHMs> listPieces = new LinkedList<PieceIHMs>();
		listPieces.addAll(jeuBlanc.getPiecesIHM());
		listPieces.addAll(jeuNoir.getPiecesIHM());
		return listPieces;		
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
		echiquier.move(0, 1, 0, 2);
		System.out.println(echiquier.getMessage());
		echiquier.move(1, 1, 0, 4);
		System.out.println(echiquier.getMessage());
		System.out.println(echiquier);
		System.out.println(echiquier.getPiecesIHM());
		
		
	}

}
