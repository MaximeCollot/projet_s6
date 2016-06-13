package model;

public class VerifBord {

	public static boolean isOk(int xFinal, int yFinal){
		if (xFinal<0||xFinal>7||yFinal<0||yFinal>7)
			return false;
		else
			return true;
	}
}
