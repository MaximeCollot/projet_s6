package vue;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Observable;
import javax.swing.*;

import controler.ChessGameControlers;
import model.Couleur;
import tools.ChessImageProvider;

public class ChessGameGUI extends javax.swing.JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer{

	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	 
	public ChessGameGUI(String string, ChessGameControlers chessGameControler, Dimension dim) {
		 
		 Dimension boardSize = dim;
		 
		  //  Use a Layered Pane for this this application
		 layeredPane = new JLayeredPane();
		  getContentPane().add(layeredPane);
		  layeredPane.setPreferredSize(boardSize);
		  layeredPane.addMouseListener(this);
		  layeredPane.addMouseMotionListener(this);

		  //Add a chess board to the Layered Pane 
		  chessBoard = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( boardSize );
		  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  chessBoard.add( square );
		 
		  int row = (i / 8) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY);
		  else
		  square.setBackground( i % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY );
		  }
		 
		  //Add a few pieces to the board
		 
		  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Cavalier", Couleur.BLANC)) );
		  JPanel panel = (JPanel)chessBoard.getComponent(0);
		  panel.add(piece);
		  piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile("Pion", Couleur.BLANC)));
		  panel = (JPanel)chessBoard.getComponent(15);
		  panel.add(piece);
		  piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile("Cavalier", Couleur.NOIR)));
		  panel = (JPanel)chessBoard.getComponent(16);
		  panel.add(piece);
		  piece = new JLabel(new ImageIcon("/Users/Rudy_DEAL/tourNoireS.png"));
		  panel = (JPanel)chessBoard.getComponent(20);
		  panel.add(piece);
		  chessBoard.repaint();
		  
		 
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
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
