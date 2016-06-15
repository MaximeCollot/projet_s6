package model;
import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu extends java.lang.Object implements Game{
	
	List<Pieces> pieces;
	Couleur couleur;
	boolean isCatchOk,isCastlingPossible;
	
	public Jeu (Couleur couleur){
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		this.couleur=couleur;
		this.isCatchOk=false;//TODO à setter dans le capture
		this.isCastlingPossible=false;//TODO à redefinir pas en dure
	}

	@Override
	public boolean isPieceHere(int x, int y) {
		if (this.findPiece(x, y) != null)
			return true;
		return false;
	}

	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, 
			boolean isCastlingPossible) {
		if(isPieceHere(xInit, yInit)){
					return this.findPiece(xInit, yInit).isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible);
		}
		return false;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if(isMoveOk(xInit, yInit, xFinal, yFinal, isCatchOk, isCastlingPossible)){
			return this.findPiece(xInit,yInit).move(xFinal, yFinal);
		}
		return false;
	}

	@Override
	public boolean capture(int xCatch, int yCatch) {
		// TODO on set capture
		return false;
	}
	
	public void setPossibleCapture(){
		//TODO
	}
	
	@Override
	public String toString(){
		String message = "";
		for (Pieces piece  : pieces){
			message += piece.toString() + "\n \t";
		}
		return message;
	}
	public Couleur getPieceColor(int x,int y){
		if(isPieceHere(x,y))
			return this.findPiece(x, y).getCouleur();
		return Couleur.NOIRBLANC;
	}
	public String getPieceName(int x,int y){
		if(isPieceHere(x,y))
			return this.findPiece(x, y).getName();
		return "Error getPieceName";
		
	}
	public Couleur getCouleur(){
		return this.couleur;
	}
	public void setCastling(){
	//TODO
	}
	private Pieces findPiece(int x, int y)
	{
		for (Pieces piece  : pieces)
			if (piece.getX()== x && piece.getY()==y)
				return piece;
		return null;
	}
	
	
	/**
	   * @return une version réduite de la liste des pièces en cours
	   * ne donnant que des accès en lecture sur des PieceIHMs
	* (type piece + couleur + coordonnées)
	   */
	public List<PieceIHMs> getPiecesIHM(){
		PieceIHMs newPieceIHM = null;
		List<PieceIHMs> list = new LinkedList<PieceIHMs>();
		for (Pieces piece : pieces){
		// si la pièce est toujours en jeu
		if (piece.getX() != -1){
			newPieceIHM = new PieceIHM(piece);
			list.add(newPieceIHM);
		}
		}
		return list;
	}

	
	public static void main(java.lang.String[] args){
		Jeu jeu = new Jeu(Couleur.BLANC);
		System.out.println("\t" + jeu.toString());
		System.out.println(jeu.findPiece(0, 0));
		System.out.println(jeu.findPiece(0, 7));		
		
		
	}


	
	
	

}
