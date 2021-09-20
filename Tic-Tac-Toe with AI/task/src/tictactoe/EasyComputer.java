package tictactoe;

import java.util.Random;

public class EasyComputer implements Player{

    public int[] getNextMove(Board board) {
        System.out.println("Making move level \"easy\"");
        int[] position = new int[2];
        String[] availablePosition = new String[9];
        Random random = new Random();
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isPositionEmpty(new int[] {i, j})) {
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
