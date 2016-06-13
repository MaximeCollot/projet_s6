package model;

public class Tour extends AbstractPiece {
	
	
	Tour(Couleur couleur, Coord coord) {
		super(Couleur couleur, Coord coord);
		this.name = 'Tour';
		
		
	}
	
	
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible){
		if (isCastlingPossible && isCatchOk) {
			if (xFinal==this.getX() || yFinal==this.getY())
					return true;
		}
		return false;
	 }
     

}
