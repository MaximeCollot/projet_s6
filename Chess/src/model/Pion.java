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
			if (this.getCouleur()==Couleur.BLANC&&(yFinal==(this.getY()-1))||this.getCouleur()==Couleur.NOIR&&(yFinal==(this.getY()+1)))
				if (xFinal==(this.getX()+1) || (xFinal==(this.getX()-1)))
					moveOk = true;
		}
		
		else if ((this.getCouleur()==Couleur.BLANC)&&(yFinal==(this.getY()-1)))
			moveOk = true;
		
		else if ((this.getCouleur()==Couleur.NOIR)&&(yFinal==(this.getY()+1)))
			moveOk = true;
		
		else if ((this.getY()==1)&&(this.getCouleur()==Couleur.NOIR)) {
			//deplacement du départ (possibilité d'avancer de 2 cases)
			if ((xFinal==(this.getX()))&&(yFinal==(this.getY()+2)))
				moveOk = true;
		}
		
		else if ((this.getY()==6)&&(this.getCouleur()==Couleur.BLANC)) {
			//deplacement du départ (possibilité d'avancer de 2 cases)
			if ((xFinal==(this.getX()))&&(yFinal==(this.getY()-2)))
				moveOk = true;
		}
		
		return moveOk;
	 	}
	
}
