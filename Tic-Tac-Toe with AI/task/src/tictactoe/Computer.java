package tictactoe;

import java.util.Random;

public abstract class Computer extends Player {
    protected boolean playingAsX;

    protected Computer(boolean playingAsX, PlayerType playerType) {
        super(playerType);
        this.playingAsX = playingAsX;
    }

    public int[] getNextMove(Board board) {
        System.out.println("Making move level \"" + playerType.toString() + "\"");
        int[] nextMove = getNextPosition(board);

        return nextMove.length == 0 ? getNextRandomMove(board) : nextMove;
    }

    public abstract int[] getNextPosition(Board board);

    protected int[] getNextRandomMove(Board board) {
        int[] position = new int[2];
        String[] availablePosition = new String[9];
        Random random = new Random();
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isPositionEmpty(i, j)) {
                    availablePosition[counter] = i + " " + j;
                    counter++;
                }
            }
        }

        int randomPosition = random.nextInt(counter);

        String[] randomPositionSplit = availablePosition[randomPosition].split(" ");

        position[0] = Integer.parseInt(randomPositionSplit[0]);
        position[1] = Integer.parseInt(randomPositionSplit[1]);

        return position;
    }
}
