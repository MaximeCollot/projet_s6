package model;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Dame";
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
		if (Math.abs(xFinal-this.coord.x)==Math.abs(yFinal-this.coord.y)) {
			return true;
		}else if ((xFinal==this.getX() || yFinal==this.getY())&& !(xFinal==this.getX() && yFinal==this.getY())){
			return true;
		}else{
			return false;
		}
	}
	

}
