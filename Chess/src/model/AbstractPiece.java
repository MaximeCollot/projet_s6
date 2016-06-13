package model;

public abstract class AbstractPiece implements Pieces {
	
	Couleur couleur;
	Coord coord;
	String name;
	String test;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}

	@Override
	public boolean capture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getX() {
		return this.coord.x;
	}

	@Override
	public int getY() {
		return this.coord.y;
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return this.name + " en " + this.coord.x + "." + this.coord.y;
	}
	
	public void main() {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
	}

}
