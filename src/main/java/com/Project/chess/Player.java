package com.Project.chess;

import java.util.ArrayList;


public class Player {
	public Clr color;
	public Board board;
	public String name;
	public int level;
	public boolean goesFirst;
	public boolean isTurn;
	public ArrayList<Piece> TakenPiece = new ArrayList<>();
	public ArrayList<Pawn> PawnsArray = new ArrayList<>();
	public ArrayList<Rook> RooksArray = new ArrayList<>();
	public ArrayList<Bishop> BishopsArray = new ArrayList<>();
	public ArrayList<Knight> KnightsArray = new ArrayList<>();
	public King king = new King(this);
	public Queen queen = new Queen(this);
	public int click;
	
	public Player(boolean first,Board board) {
		this.click =0;
		this.name = null;
		this.board = board;
		goesFirst = first;
		if (goesFirst) {
			this.color = Clr.WHITE;
			this.isTurn = true;
		}
		else {
			this.color = Clr.BLACK;
			this.isTurn = false;
		}
		for (int i =0 ; i<8;i++){
			Pawn a = new Pawn(this);
			if (first){
				a.setCell(this.board.cells[i][6]);
				this.board.cells[i][6].setPiece(a);


			}
			else{
				a.setCell(this.board.cells[i][1]);
				this.board.cells[i][1].setPiece(a);

			}

			this.PawnsArray.add(a);


		}

		Bishop bishop1 = new Bishop(this);
		Bishop bishop2 = new Bishop(this);
		Rook rook1 = new Rook(this);
		Rook rook2 = new Rook(this);
		Knight knight1 = new Knight(this);
		Knight knight2 = new Knight(this);
		if (first){
			bishop1.setCell(this.board.cells[2][7]);
			bishop2.setCell(this.board.cells[5][7]);
			rook1.setCell(this.board.cells[0][7]);
			rook2.setCell(this.board.cells[7][7]);
			knight1.setCell(this.board.cells[1][7]);
			knight2.setCell(this.board.cells[6][7]);
			king.setCell(this.board.cells[4][7]);
			queen.setCell(this.board.cells[3][7]);
			this.board.cells[2][7].setPiece(bishop1);
			this.board.cells[5][7].setPiece(bishop2);
			this.board.cells[0][7].setPiece(rook1);
			this.board.cells[7][7].setPiece(rook2);
			this.board.cells[1][7].setPiece(knight1);
			this.board.cells[6][7].setPiece(knight2);
			this.board.cells[4][7].setPiece(king);
			this.board.cells[3][7].setPiece(queen);


		}
		else{
			bishop1.setCell(this.board.cells[2][0]);
			bishop2.setCell(this.board.cells[5][0]);
			rook1.setCell(this.board.cells[0][0]);
			rook2.setCell(this.board.cells[7][0]);
			knight1.setCell(this.board.cells[1][0]);
			knight2.setCell(this.board.cells[6][0]);
			king.setCell(this.board.cells[4][0]);
			queen.setCell(this.board.cells[3][0]);
			this.board.cells[2][0].setPiece(bishop1);
			this.board.cells[5][0].setPiece(bishop2);
			this.board.cells[0][0].setPiece(rook1);
			this.board.cells[7][0].setPiece(rook2);
			this.board.cells[1][0].setPiece(knight1);
			this.board.cells[6][0].setPiece(knight2);
			this.board.cells[4][0].setPiece(king);
			this.board.cells[3][0].setPiece(queen);

		}
		BishopsArray.add(bishop1);
		BishopsArray.add(bishop2);
		RooksArray.add(rook1);
		RooksArray.add(rook2);
		KnightsArray.add(knight1);
		KnightsArray.add(knight2);



	}

	public Clr getColor() {
		return color;
	}

	public void setColor(Clr color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isGoesFirst() {
		return goesFirst;
	}

	public void setGoesFirst(boolean goesFirst) {
		this.goesFirst = goesFirst;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public ArrayList<Piece> getTakenPiece() {
		return TakenPiece;
	}

	public void setTakenPiece(ArrayList<Piece> takenPiece) {
		TakenPiece = takenPiece;
	}



	}


