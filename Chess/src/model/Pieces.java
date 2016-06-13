package model;

public interface Pieces {
	
	 boolean capture();
     
	 Couleur getCouleur();
	           
	 java.lang.String getName();
	           
	 int getX();
	           
	 int getY();
	           
	 boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible); 
	           
	 boolean move(int xFinal, int yFinal);
}
