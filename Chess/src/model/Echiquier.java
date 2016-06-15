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
		//test si les coordonnées finales ne sont pas valides ou égales aux initiales
		if ((jeuCourant.isPieceHere(xInit, yInit)&&!jeuCourant.isPieceHere(xFinal, yFinal))&&(VerifBord.isOk(xFinal, yFinal)&&((xInit!=xFinal)||(yInit!=yFinal)))){
			//test s'il existe une piéce intermédiaire sur la trajectoire
			if (!(this.collide(xInit, yInit, xFinal, yFinal))){
				//test si position finale ne correspond pas à algo de déplacement piece
				if (jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal, this.captureEch2(xFinal, yFinal), true)) {
					this.jeuAdverse.setPossibleCapture();
					moveIsOk = true;
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
			if(this.captureEch(xFinal, yFinal)){
				System.out.println("Déplacement effectué avec capture effectué!");
				System.out.println(jeuAdverse.toString());
				setMessage("Déplacement effectué avec capture effectué!");
				
			}
		}else{
			setMessage("Déplacement refusé");
			System.out.println("Déplacement refusé");
		}
		
		return moveIsOK;
	}
	
	public boolean captureEch(int xFinal,int yFinal){
		boolean captureOk = false;
		if (this.jeuAdverse.isPieceHere(xFinal, yFinal)){
			this.jeuAdverse.capture(xFinal,yFinal);
			if (this.jeuAdverse.move(xFinal, yFinal, -1, -1))
				captureOk = true;
			}
		return captureOk;
	}
	
	public boolean captureEch2(int xFinal,int yFinal){
		boolean captureOk = false;
		if (this.jeuAdverse.isPieceHere(xFinal, yFinal))
				captureOk = true;
			
		return captureOk;
	}
	
	//fonction de vérification de pièce intermédiaire
	public boolean collide (int xInit, int yInit, int xFinal, int yFinal) {
		System.out.println("xInit : " + xInit + ", yInit : " + yInit + ", xFinal : " + xFinal + ", yFinal : " + yFinal);
		int xDiff = xFinal - xInit;
		int yDiff = yFinal - yInit;
		System.out.println("xDiff : " + xDiff + ", yDiff : " + yDiff);
		if (xDiff!=0||yDiff!=0||xDiff==yDiff){
			while(xDiff!=0||yDiff!=0){
				if (xDiff<0)
					xDiff++;
				if (xDiff>0)
					xDiff--;
				if (yDiff<0)
					yDiff++;
				if (yDiff>0)
					yDiff--;
				if (!(xDiff==0&&yDiff==0))
					if (jeuCourant.isPieceHere(xInit+xDiff, yInit+yDiff)||jeuAdverse.isPieceHere(xInit+xDiff, yInit+yDiff))
						return true;

				System.out.println("test sur : " + (xInit+xDiff) + ";" + (yInit+yDiff));
			System.out.println("xDiff : " + xDiff + ", yDiff : " + yDiff);
			}
		}
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
//		Echiquier echiquier = new Echiquier();
//		System.out.println(echiquier);
//		System.out.println("joueur courant : " + echiquier.getColorCurrentPlayer());
//		echiquier.switchJoueur();
//		System.out.println(echiquier.getMessage());
//		System.out.println("joueur courant : " + echiquier.getColorCurrentPlayer());
//		echiquier.move(0, 1, 0, 2);
//		System.out.println(echiquier.getMessage());
//		echiquier.move(1, 1, 0, 4);
//		System.out.println(echiquier.getMessage());
//		System.out.println(echiquier);
//		System.out.println(echiquier.getPiecesIHM());
		
		
	}

}
