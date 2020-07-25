package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPiece>captured = new ArrayList<>();
		
		while(true) {
		try {
			UI.clearScreen();
			UI.printMatch(chessmatch,captured);
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessmatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessmatch.getPieces(),possibleMoves);
			
			System.out.println();
			System.out.println("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessmatch	.performChessMove(source, target);
		
			if(capturedPiece!=null) {
				captured.add(capturedPiece);
			}
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