package tictactoe;

public class MediumComputer extends Computer{
    public MediumComputer(boolean playingAsX) {
        super(playingAsX);
    }

    public int[] getNextMove(Board board) {
        super.board = board;
        int[] ret = new int[2];

        System.out.println("Making move level \"medium\"");

        if (hasNextGoodMove(ret, playingAsX ? "X" : "O")) {
            return ret;
        } else if (hasNextGoodMove(ret, !playingAsX ? "X" : "O")) {
            return ret;
        }

        ret = super.getNextRandomMove();
        return ret;
    }

    private boolean hasNextGoodMove(int[] position, String lookingFor) {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board.compareTwoPositions(lookingFor, i, j, i, j - 1) &&
                        board.isPositionEmpty(i, j + 1 > 2 ? 0 : j + 1)) {
                    position[0] = i;
                    position[1] = j == 2 ? 0 : j + 1;
                    return true;
                }

                if (board.compareTwoPositions(lookingFor, j, i, j - 1, i) &&
                        board.isPositionEmpty(j + 1 > 2 ? 0 : j + 1, i)) {
                    position[1] = i;
                    position[0] = j == 2 ? 0 : j + 1;
                    return true;
                }
            }
        }

        if (board.compareTwoPositions(lookingFor, 0, 0, 1, 1) && board.isPositionEmpty(2, 2)) {
            position[0] = 2;
            position[1] = 2;
            return true;
        }

        if (board.compareTwoPositions(lookingFor, 0, 0, 2, 2) && board.isPositionEmpty(1, 1)) {
            position[0] = 1;
            position[1] = 1;
            return true;
        }

        if (board.compareTwoPositions(lookingFor, 1, 1, 2, 2) && board.isPositionEmpty(0, 0)) {
            position[0] = 0;
            position[1] = 0;
            return true;
        }

        if (board.compareTwoPositions(lookingFor, 1, 1, 0, 2) && board.isPositionEmpty(2, 0)) {
            position[0] = 2;
            position[1] = 0;
            return true;
        }

        if (board.compareTwoPositions(lookingFor, 1, 1, 2, 0) && board.isPositionEmpty(0, 2)) {
            position[0] = 0;
            position[1] = 2;
            return true;
        }

        if (board.compareTwoPositions(lookingFor, 0, 2, 2, 0) && board.isPositionEmpty(1, 1)) {
            position[0] = 1;
            position[1] = 1;
            return true;
        }

        return false;
    }
}
