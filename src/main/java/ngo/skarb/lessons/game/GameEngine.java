package ngo.skarb.lessons.game;

public class GameEngine {

	private Player playerOne;

	private Player playerTwo;

	private Result lastResult;

	public GameEngine(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public Result decideWinner() {
		return lastResult;
	}

	public void playRound() {
		Move moveOne = playerOne.makeMove();
		Move moveTwo = playerTwo.makeMove();

		if(moveOne == null){
			throw new GameException("Player move cannot be null");
		}

		if (moveOne.equals(moveTwo)) {
			lastResult = Result.DRAW;
		} else {

			lastResult = Result.PLAYER_ONE_WINS;
		}
	}
}
