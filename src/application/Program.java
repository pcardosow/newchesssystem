package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Chess_match;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Chess_match chessmatch = new Chess_match();
		while(true) {
		try {
			UI.clearScreen();
			UI.PrintBoard(chessmatch.getPieces());
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessmatch.possibleMoves(source);
			UI.clearScreen();
			UI.PrintBoard(chessmatch.getPieces(),possibleMoves);
			
			System.out.println();
			System.out.println("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
		ChessPiece capturedPiece = chessmatch	.performChessMove(source, target);
		}
		catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		
		}
		

}
}