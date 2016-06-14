package model;

public class Tour extends AbstractPiece {
	
	
	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Tour";		
	}
	
	
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible){
		if (isCastlingPossible) {
			//gestion du Castling 
			//TODO
		}
		if ((xFinal==this.getX() || yFinal==this.getY())&& !(xFinal==this.getX() && yFinal==this.getY()))
				return true;
		else
			return false;
		}
}
