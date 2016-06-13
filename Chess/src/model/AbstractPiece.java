package model;

public abstract class AbstractPiece implements Pieces {
	
	Couleur couleur;
	Coord coord;
	String name;
	
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
	public boolean move(int xFinal, int yFinal) {
			this.coord = new Coord(xFinal, yFinal);
			return true;
			// avec les parametre données, on ne peux pas faire de test isMoveOk, sans utilisé des parametre en dure
			// on testera isMoveOk avant l'utilisation de move() dans la classe Jeu
	}
	
	public String toString() {
		return this.name + " en " + this.coord.x + "." + this.coord.y;
	}
	
	public static void main(String[] args) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		System.out.println(maTour);
	}

}
