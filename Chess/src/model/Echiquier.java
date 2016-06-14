package model;

import java.util.LinkedList;
import java.util.List;

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
		boolean moveIsOK = false;
		if (jeuCourant.getCouleur() == Couleur.BLANC){
			moveIsOK = jeuBlanc.move(xInit, yInit, xFinal, yFinal);
		}else{
			moveIsOK = jeuNoir.move(xInit, yInit, xFinal, yFinal);
		}
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
