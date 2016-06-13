package model;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu extends java.lang.Object implements Game{
	
	List<Pieces> pieces;
	
	public Jeu (Couleur couleur){
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		System.out.print("ok");
	}

	@Override
	public boolean isPieceHere(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean capture(int xCatch, int yCatch) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
