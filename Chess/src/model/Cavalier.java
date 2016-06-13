package model;

public class Cavalier extends AbstractPiece {
	
	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Cavalier";
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
		if (isCatchOk){
			if (VerifBord.isOk(xFinal, yFinal)){
				int diffX,diffY;
				diffX = xFinal-this.coord.x;
				diffY = yFinal-this.coord.y;
				if ((diffX==2||diffY==2)&&(Math.abs(diffX-diffY)==1)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

}
