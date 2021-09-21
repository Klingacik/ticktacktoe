package tictactoe;

import java.util.Random;

public abstract class Computer implements Player {
    protected Board board;
    protected boolean playingAsX;

    protected Computer(boolean playingAsX) {
        this.playingAsX = playingAsX;
    }

    @Override
    public abstract int[] getNextMove(Board board);

    protected int[] getNextRandomMove() {
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
