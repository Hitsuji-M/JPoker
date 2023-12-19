

import models.Deck;
import models.Player;
import utils.GameState;

public class GameEngine {
	private GameState state = GameState.PENDING;
	private Deck deck;
	private Player player1, player2;

	public GameEngine() {
		this.player1 = new Player("Erwann");
		this.player2 = new Player("Abdel");
		this.deck = new Deck();
		this.deck.shuffle();
	}

	public void startApplication() {
		while (this.state == GameState.PENDING) {
			this.state = GameState.DRAW;
		}
	}
}
