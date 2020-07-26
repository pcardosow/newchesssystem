package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Chess_match;
import chess.Color;

public class King extends ChessPiece {

	private Chess_match chessmatch;
	
	public King(Board board, Color color,Chess_match chessmatch) {
		super(board, color);
		this.chessmatch = chessmatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testHookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount()==0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// uprightside
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// downrightside
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}
		// downleftside
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// upleftside

		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
			
		//specialmoves
			if(getMoveCount()==0&&!chessmatch.getCheck()) {
				Position postT1 = new Position(position.getRow(),position.getColumn()+3);
				if(testHookCastling(postT1)) {
					Position p1 = new Position(position.getRow(),position.getColumn()+1);
					Position p2 = new Position(position.getRow(),position.getColumn()+2);
					if(getBoard().piece(p1) == null && getBoard().piece(p2) == null ) {
						mat[position.getRow()][position.getColumn()+2] = true;
					}
				}
			}
			
			if(getMoveCount()==0&&!chessmatch.getCheck()) {
				Position postT2 = new Position(position.getRow(),position.getColumn()-4);
				if(testHookCastling(postT2)) {
					Position p1 = new Position(position.getRow(),position.getColumn()-1);
					Position p2 = new Position(position.getRow(),position.getColumn()-2);
					Position p3 = new Position(position.getRow(),position.getColumn()-3);
					if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
						mat[position.getRow()][position.getColumn()-2] = true;
					}
				}
			}
			
			
			
			
		}
		return mat;
	}
}