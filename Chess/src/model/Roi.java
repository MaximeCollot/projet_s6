package model;

public class Roi extends AbstractPiece {

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Roi";
	}
	
	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
		if (isCastlingPossible || isCatchOk){
			return true;
		}else{
			if (((xFinal == this.coord.x++)||(xFinal == this.coord.x--)||(xFinal == this.coord.x))&&((yFinal == this.coord.y++)||(yFinal == this.coord.y--)||(yFinal == this.coord.y))&&VerifBord.isOk(xFinal,yFinal)){
				return true;
			}else{
				return false;
			}
		}
	}

}
