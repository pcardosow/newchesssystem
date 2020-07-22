package application;

import boardgame.Board;
import chess.Chess_match;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chess_match chessmatch = new Chess_match();
		UI.PrintBoard(chessmatch.getPieces());
	}

}
