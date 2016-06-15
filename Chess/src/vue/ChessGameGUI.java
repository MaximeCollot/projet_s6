package vue;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;

import javax.swing.*;

import controler.ChessGameControlers;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import tools.ChessImageProvider;
import tools.ChessPiecePos;

public class ChessGameGUI extends javax.swing.JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer{

	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	ChessGameControlers chessGameControler;
	Dimension boardSize;
	int xInit, yInit, xFinal, yFinal, posXInit, posYInit;
	 
	public ChessGameGUI(String string, ChessGameControlers chessGameControler, Dimension dim) {
		this.chessGameControler = chessGameControler;
		boardSize = dim;
		 
		//  Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
//		//Add a chess board to the Layered Pane 
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout( new GridLayout(8, 8) );
		chessBoard.setPreferredSize( boardSize );
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
//		
//		for (int i = 0; i < 64; i++) {
//		JPanel square = new JPanel( new BorderLayout() );
//		chessBoard.add( square );
//		 
//		int row = (i / 8) % 2;
//		if (row == 0)
//		square.setBackground( i % 2 == 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY);
//		else
//		square.setBackground( i % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY );
//		}
		 
//		//Add a few pieces to the board
//		JLabel piece; 
//		JPanel panel;
//		int position, x, y, pivot = 0;
//		Couleur couleur = Couleur.BLANC;
//		// Utilise list Piece IHM puis mettre dans update
//		for (int i = 0; i < ChessPiecePos.values().length; i++) {
//			String nom = ChessPiecePos.values()[i].name() + "  " + ChessPiecePos.values()[i].nom;
//			for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
//				if (pivot == 16)
//					couleur = Couleur.NOIR;
//				piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(ChessPiecePos.values()[i].nom, couleur)));
//				x = ChessPiecePos.values()[i].coords[j].x;
//				y = ChessPiecePos.values()[i].coords[j].y;
//				position = x + 8*y;
//				panel = (JPanel)chessBoard.getComponent(position);
//				panel.add(piece);	
//				pivot++;
//			}
//		}
		layeredPane.repaint();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// On récupère la liste de pièces
		List<PieceIHM> piecesIHM = (List<PieceIHM>) arg;
		chessBoard.removeAll();
		
		//Add a chess board to the Layered Pane 
//		chessBoard = new JPanel();
//		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
//		chessBoard.setLayout( new GridLayout(8, 8) );
//		chessBoard.setPreferredSize( boardSize );
//		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		
		for (int i = 0; i < 64; i++) {
		JPanel square = new JPanel( new BorderLayout() );
		chessBoard.add( square );
		 
		int row = (i / 8) % 2;
		if (row == 0)
		square.setBackground( i % 2 == 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY);
		else
		square.setBackground( i % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY );
		}
		
		//On crée chaque pièce contenu dans la liste et on l'ajoute
		JLabel piece; 
		JPanel panel;
		int position, x, y;
		
		for(PieceIHM pieceIHM : piecesIHM) {
			piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(pieceIHM.getNamePiece(), pieceIHM.getCouleur())));
			position = pieceIHM.getX() + 8*pieceIHM.getY();
			panel = (JPanel)chessBoard.getComponent(position);
			panel.add(piece);
					
		}
		chessBoard.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (chessPiece == null) return;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
	}		 
		  //Drop the chess piece back onto the chess board

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		chessPiece = null;
		Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		if (c instanceof JPanel)
			return;
		
		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		xInit = (e.getX()*8/(int)boardSize.getWidth());
		yInit = (e.getY()*8/(int)boardSize.getHeight());
		chessPiece = (JLabel)c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(chessPiece == null) return;
		
		chessPiece.setVisible(false);
		Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		
		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		xFinal = (e.getX()*8/(int)boardSize.getWidth());
		yFinal = (e.getY()*8/(int)boardSize.getHeight());
		boolean moveOk = chessGameControler.move(new Coord(xInit,yInit), new Coord(xFinal,yFinal));
		System.out.println(moveOk);
		if (moveOk){
			chessPiece.setLocation(xFinal*((int)(boardSize.getWidth()/8) + xAdjustment), (int)(yFinal*(boardSize.getHeight()/8) + yAdjustment));
			chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		}else{
			chessPiece.setLocation(xInit*((int)(boardSize.getWidth()/8) + xAdjustment), (int)(yInit*(boardSize.getHeight()/8) + yAdjustment));
			chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		}
		if (c instanceof JLabel){
			Container parent = c.getParent();
			parent.remove(0);
			parent.add( chessPiece );
		}
		else {
			Container parent = (Container)c;
			parent.add( chessPiece );
		}
		 
		chessPiece.setVisible(true);
		  
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
