package model;

public class Pion extends AbstractPiece {
	public Pion(Couleur couleur, Coord coord){
		super(couleur, coord);
		this.name="Pion";
	}
	
	@Override
	public boolean isMoveOk(int xFinal, int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{	boolean moveOk = false;
		if (isCatchOk){
			// prise d'une piece
			if (yFinal==(this.getY()+1)&&(xFinal==(this.getX()+1) || (xFinal==(this.getX()-1))))
				moveOk = true;
		}
					
		else if (xFinal==this.getX() && yFinal==(this.getY()+1))
			// deplacement normal en avençant
			moveOk = true;
		
		else if (this.getY()==1)
			//deplacement du départ (possibilité d'avancer de 2 cases)
			if (yFinal==(this.getY())&&(xFinal==(this.getX()+2) || (xFinal==(this.getX()-1))))
				moveOk = true;
		return moveOk;
	 	}
	
}
