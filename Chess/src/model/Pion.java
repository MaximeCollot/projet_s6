package model;

public class Pion extends AbstractPiece {
	public Pion(Couleur couleur, Coord coord){
		super(couleur, coord);
		this.name="Pion";
	}
	
	public boolean isMoveOk(int xFinal, int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		//pas de gestion de grand roque avec les pions
		
		if (!VerifBord.isOk)
			return false;
		if (xFinal==this.getX() && yFinal==this.getY())
			//meme position interdite
			return false;
		
		else if (isCatchOk){
			// prise d'un pion
			if (yFinal==(this.getY()+1)&&(xFinal==(this.getX()+1) || (xFinal==(this.getX()-1))))
				return true;
			else
				return false;
		}
					
		else if (xFinal==this.getX() && yFinal==(this.getY()+1))
			// deplacement normal en avençant
				return true;
		else if (this.getY()==1)
			//deplacement du départ (possibilité d'avancer de 2 cases)
			if (yFinal==(this.getY())&&(xFinal==(this.getX()+2) || (xFinal==(this.getX()-1))))
				return true;
		else
			return false;
	 	}
	
}
