package model;

public class Fou extends AbstractPiece{
	
	public Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Fou";		
	}
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible){
		if (!VerifBord.isOk(xFinal, yFinal))
			//verification dans l'echiquier
			return false;
		
		if (xFinal==this.getX() && yFinal==this.getY())
			// deplacement sur place interdit		
			return false;
		
		if ( Math.abs(xFinal - this.coord.x)== Math.abs(yFinal - this.coord.y))
			// tests deplacement du fou
			return true;
		
		else 
			return false;
	}
}
