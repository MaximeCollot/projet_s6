package model;

public class Cavalier extends AbstractPiece {
	
	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Cavalier";
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
			int diffX,diffY;
			diffX = xFinal-this.coord.x;
			diffY = yFinal-this.coord.y;
			//if ((diffX==2||diffY==2)&&(Math.abs(diffX-diffY)==1)){
			if ((Math.abs(diffX)==2&&Math.abs(diffY)==1)||(Math.abs(diffX)==1&&Math.abs(diffY)==2)){
				return true;
			}else{
				return false;
			}
	}
}
