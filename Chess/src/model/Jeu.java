package model;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu extends java.lang.Object implements Game{
	
	List<Pieces> pieces;
	Couleur couleur;
	
	public Jeu (Couleur couleur){
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		this.couleur=couleur;
	}

	@Override
	public boolean isPieceHere(int x, int y) {
		for (Pieces piece  : pieces)
			if (piece.getX()== x && piece.getY()==y)
				return true;			
		return false;
	}

	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, 
			boolean isCastlingPossible) {
		if(isPieceHere(xInit, yInit)){
			for (Pieces piece  : pieces)
				if (piece.getX()== xInit && piece.getY()==yInit)
					return piece.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible);
		}
		return false;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean isCatchOk,isCastlingPossible;
		if (capture(xFinal,yFinal)){
			isCatchOk= true;			
		}
		else 
			isCatchOk = false;
		isCastlingPossible = true; //TODO CaslingPossible
		if(isMoveOk(xInit, yInit, xFinal, yFinal, isCatchOk, isCastlingPossible)){
			for (Pieces piece  : pieces){
				if (piece.getX()== xInit && piece.getY()==yInit){
					return piece.move(xFinal, yFinal);
				}
			}
		}
		return false;
	}

	@Override
	public boolean capture(int xCatch, int yCatch) {
		// TODO Auto-generated method stub
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
		for (Pieces piece  : pieces)
			if (piece.getX()== x && piece.getY()==y)
				return piece.getCouleur();
		return Couleur.NOIRBLANC;
	}
	public String getPieceName(int x,int y){
		for (Pieces piece  : pieces)
			if (piece.getX()== x && piece.getY()==y)
				return piece.getName();
		return "Error getPieceName";
		
	}
	public Couleur getCouleur(){
		return this.couleur;
	}
	public void setCastling(){
	//TODO
	}
	//public java.util.List<PieceIHMs> getPiecesIHM(){
	//TODO
	//}
	public static void main(java.lang.String[] args){
		
	}


	
	
	

}
