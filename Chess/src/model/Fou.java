package model;

public class Fou extends AbstractPiece{
	
	Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Fou";		
	}
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible){
		if (isCastlingPossible) {
			//gestion du Castling 
			//<TODO>
		}
		if (isCatchOk) {
			// pas de moficiation si il peut Catch dans le move
		}
		
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
