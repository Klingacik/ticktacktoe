package tictactoe;

import java.util.Random;

public class MediumComputer implements Player{
    private Board board;
    private final boolean playingAsX;

    public MediumComputer(boolean playingAsX) {
        this.playingAsX = playingAsX;
    }

    public int[] getNextMove(Board board) {
        this.board = board;
        int[] ret = new int[2];

        System.out.println("Making move level \"medium\"");

        if (hasNextWinningMove(ret)) {
            return ret;
        } else if (hasNextBlockingMove(ret)) {
            return ret;
        }

        ret = getNextRandomMove();
        return ret;
    }

    private int[] getNextRandomMove() {
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

    private boolean hasNextWinningMove(int[] position) {
        String lookingFor = playingAsX ? "X" : "O";

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board.isPosition(lookingFor, new int[] {i, j}) &&
                        board.isPosition(lookingFor, new int[] {i, j - 1}) && board.isPositionEmpty(new int[] {i , j + 1 > 2 ? 0 : j + 1})) {
                    position[0] = i;
                    position[1] = j == 2 ? 0 : j + 1;
                    return true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board.isPosition(lookingFor, new int[] {j, i}) &&
                        board.isPosition(lookingFor, new int[] {j - 1, i}) && board.isPositionEmpty(new int[] {j + 1 > 2 ? 0 : j + 1, i})) {
                    position[1] = i;
                    position[0] = j == 2 ? 0 : j + 1;
                    return true;
                }
            }
        }

        if (board.isPosition(lookingFor, new int[] {0, 0}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {2, 2})) {
            position[0] = 2;
            position[1] = 2;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {0, 0}) && board.isPosition(lookingFor, new int[] {2, 2}) && board.isPositionEmpty(new int[] {1, 1})) {
            position[0] = 1;
            position[1] = 1;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {2, 2}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {0, 0})) {
            position[0] = 0;
            position[1] = 0;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {0, 2}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {2, 0})) {
            position[0] = 2;
            position[1] = 0;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {2, 0}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {0, 2})) {
            position[0] = 0;
            position[1] = 2;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {0, 2}) && board.isPosition(lookingFor, new int[] {2, 0}) && board.isPositionEmpty(new int[] {1, 1})) {
            position[0] = 1;
            position[1] = 1;
            return true;
        }

        return false;
    }

    private boolean hasNextBlockingMove(int[] position) {
        String lookingFor = !playingAsX ? "X" : "O";

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board.isPosition(lookingFor, new int[] {i, j}) &&
                        board.isPosition(lookingFor, new int[] {i, j - 1})  && board.isPositionEmpty(new int[] {i , j + 1 > 2 ? 0 : j + 1})) {
                    position[0] = i;
                    position[1] = j == 2 ? 0 : j + 1;
                    return true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board.isPosition(lookingFor, new int[] {j, i}) &&
                        board.isPosition(lookingFor, new int[] {j - 1, i}) && board.isPositionEmpty(new int[] {j + 1 > 2 ? 0 : j + 1, i})) {
                    position[1] = i;
                    position[0] = j == 2 ? 0 : j + 1;
                    return true;
                }
            }
        }

        if (board.isPosition(lookingFor, new int[] {0, 0}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {2, 2})) {
            position[0] = 2;
            position[1] = 2;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {0, 0}) && board.isPosition(lookingFor, new int[] {2, 2}) && board.isPositionEmpty(new int[] {1, 1})) {
            position[0] = 1;
            position[1] = 1;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {2, 2}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {0, 0})) {
            position[0] = 0;
            position[1] = 0;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {0, 2}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {2, 0})) {
            position[0] = 2;
            position[1] = 0;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {2, 0}) && board.isPosition(lookingFor, new int[] {1, 1}) && board.isPositionEmpty(new int[] {0, 2})) {
            position[0] = 0;
            position[1] = 2;
            return true;
        }

        if (board.isPosition(lookingFor, new int[] {0, 2}) && board.isPosition(lookingFor, new int[] {2, 0}) && board.isPositionEmpty(new int[] {1, 1})) {
            position[0] = 1;
            position[1] = 1;
            return true;
        }

        return false;
    }
}
