

import java.util.Scanner;

import models.Deck;
import models.Player;
import utils.GameState;
import models.Card;

public class GameEngine {
	private GameState state = GameState.PENDING;
	private Deck deck;
	private Player player1, player2;
	private Scanner scanner;

	public GameEngine() {
		this.scanner = new Scanner(System.in);
		this.player1 = new Player("Erwann");
		this.player2 = new Player("Abdel");
		this.deck = new Deck();
		this.deck.shuffle();
	}
	
	private void fillPlayerCards() {
		for (int i = 0; i < 5; i++) {
			this.player1.addCardToHand(this.deck.drawCard());
			this.player2.addCardToHand(this.deck.drawCard());
		}
	}
	
	private int[] cardDrawingIndexes(final Player currentPlayer) {
		System.out.print(
				"- " +
				currentPlayer +
				", please enter the card indexes (starting at 1) of the cards you want to draw : "
		);
		String input = this.scanner.next();
		System.out.println("\n");

		input = input.replaceAll("[^0-9]", " ");
		input = input.replaceAll(" +", " ");
		String[] numbers = !(input.equals("") || input.equals(" "))  ? input.split(" ") : null;
		
		if (numbers == null) {
			return new int[] {};
		}
		else if (numbers.length > 5) {
			return null;
		}

		int[] indexes = new int[numbers.length];	
		for (int i = 0; i < indexes.length; i++) {
			try {
				int tmp = Integer.parseInt(numbers[i]) - 1;
				if (tmp < 0 || tmp > 4) {
					return null;
				}
				
				indexes[i] = tmp; 
			} catch (final Exception e) {
				return null;
			}
		}

		return indexes;
	}
	
	private void drawAndRefill(final int[] indexP1, final int[] indexP2) {
		this.deck.addCards(this.player1.removeCardsFromHand(indexP1));
		this.deck.addCards(this.player2.removeCardsFromHand(indexP2));
		
		for (int i = 0; i < indexP1.length; i++) {
			this.player1.addCardToHand(this.deck.drawCard());
		}
		for (int i = 0; i < indexP2.length; i++) {
			this.player2.addCardToHand(this.deck.drawCard());
		}
	}

	public void startApplication() {
		String input1, input2;
		int nb1, nb2;
		
		this.fillPlayerCards();

		while (this.state == GameState.PENDING) {
			System.out.println("-----> " + this.player1 + " :\n" + this.player1.getHandString() + "\n");
			System.out.println("-----> " + this.player2 + " :\n" + this.player2.getHandString() + "\n");
			
			int[] draw1 = this.cardDrawingIndexes(this.player1);
			if (draw1 == null) {
				System.out.println("Wrong input. Make sure to separate all the indexes and no more than 5.\n They must be between 1 and 5 included !\n\n");
				continue;
			}

			int[] draw2 = this.cardDrawingIndexes(this.player2);
			if (draw2 == null) {
				System.out.println("Wrong input. Make sure to separate all the indexes and no more than 5.\n They must be between 1 and 5 included !\n\n");
				continue;
			}

			this.drawAndRefill(draw1, draw2);
			this.state = GameState.DRAW;
		}

		this.scanner.close();
	}
}
