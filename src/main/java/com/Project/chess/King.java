package com.Project.chess;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
public class King extends Piece {
	
	
	
	final ArrayList<Vector> authorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,0),new Vector(1,1), new Vector(0,1), new Vector(-1,1), new Vector(-1,0), new Vector(-1,-1), new Vector(0, -1), new Vector(1,-1)));
	static Type type = Type.KING;

	public King (Player player) {
		super( player);
		this.name = "king";
		this.imageWhite = new ImageView(this.initialPath.concat(this.name).concat("White.png"));
		this.imageBlack = new ImageView(this.initialPath.concat(this.name).concat("Black.png"));
	}

	public boolean validMove(Cell finalCell){
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
		int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.getEmplacment()[0]> 8 || finalCell.getEmplacment()[1]> 8 || finalCell.getEmplacment()[0] < 0){
			return false;
		}
		else{
			return authorizedMoves.contains(moveVector);
		}
	}
	@Override
	public void attackPiece(Cell finalCell){
		if(finalCell.isEmpty()){
			return;
		}
		if(validMove(finalCell)){
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}
	}

	@Override
	public boolean makeMove(Cell finalCell){
		if (validMove(finalCell)){
			if(finalCell.isEmpty()){
				finalCell.setPiece(this);
				this.getCell().setPiece(null);
			}
			else{
				if(finalCell.getPiece().getColor() == this.getColor()){ // add type rook to condition
					return false;
				}
				attackPiece(finalCell);
			}
			return true;
		}
		return false;

	}
	public void clickEvent(int a) {
		if (!this.getClicked() && ChessInterface.getCounter() == 0) {
			this.setClicked(true);
			ChessInterface.setCounter(1);
			ChessInterface.setSelected(a);
			System.out.println(a);
		}
	}

	public boolean doCasting() {
		return false;
	}
	
	

}
