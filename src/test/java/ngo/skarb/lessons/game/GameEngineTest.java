package ngo.skarb.lessons.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameEngineTest {

	@Mock
	private Player playerOne;

	@Mock
	private Player playerTwo;

	private GameEngine gameEngine;

	@BeforeEach
	void setUp() {
		gameEngine = new GameEngine(playerOne, playerTwo);
	}

	@Test
	void shouldSimulatePlayerMoves() {
		when(playerOne.makeMove()).thenReturn(Move.ROCK);
		when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);

		gameEngine.playRound();

		assertEquals(Result.PLAYER_ONE_WINS, gameEngine.decideWinner(),
			"GameEngine should correctly simulate a round and decide the winner"
		);
	}

	@Test
	void shouldHandleDrowWhenSameMove() {
		when(playerOne.makeMove()).thenReturn(Move.SCISSORS);
		when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);

		gameEngine.playRound();

		assertEquals(
			Result.DRAW,
			gameEngine.decideWinner(),
			"GameEngine should correctly simulate draw a round and decide the winner"
		);
	}

	@Test
	void shouldHandleExceptionWhenPlayerMoveIsNull() {
		when(playerOne.makeMove()).thenReturn(null);
		Exception exception = assertThrows(GameException.class, () ->
				gameEngine.playRound(),
			"Game engine should throw exception when player move is null"
		);
		assertEquals("Player move cannot be null", exception.getMessage());
	}
}
