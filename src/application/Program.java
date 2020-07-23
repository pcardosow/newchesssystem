package application;

import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Chess_match;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Chess_match chessmatch = new Chess_match();
		while(true) {
		UI.PrintBoard(chessmatch.getPieces());
		System.out.println();
		System.out.println("Source: ");
		ChessPosition source = UI.readChessPosition(sc);
		
		System.out.println();
		System.out.println("Target: ");
		ChessPosition target = UI.readChessPosition(sc);
		
		ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
		
		}
		

}
}