package tictactoe;

public class Board {
    private final Field[][] board;
    private final int size;

    public Board(int size) {
        board = new Field[size][size];
        this.size = size;
        clear();
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Field();
            }
        }
    }

    public String determinateBoardState() {
        String winner = "D";

        //Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].isEmpty()) {
                winner = board[i][0].getValue();
            }
        }

        //Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].isEmpty()) {
                winner = board[0][i].getValue();
            }
        }

        //Check diagonals
        if (((board[0][0].equals(board[1][1]) && board[2][2].equals(board[0][0])) ||
                (board[0][2].equals(board[1][1]) && board[2][0].equals(board[1][1]))) && !board[1][1].isEmpty()) {
            winner = board[1][1].getValue();
        }

        //Check for draw
        if (winner.equals("D")) {
            for (Field[] row : board) {
                for (Field field : row) {
                    if (field.isEmpty()) {
                        winner = "N";
                        break;
                    }
                }
            }
        }

        return winner;
    }

    public String drawBoard() {
        StringBuilder ret = new StringBuilder();

        ret.append("---------" + "\n");

        for (Field[] row : board) {
            ret.append("| ");
            for (Field field : row) {
                if (field.isEmpty()) {
                    ret.append("  ");
                } else {
                    ret.append(field.getValue()).append(" ");
                }
            }
            ret.append("|" + "\n");
        }

        ret.append("---------" + "\n");

        return ret.toString();
    }

    public boolean isPositionEmpty(int... position) {
        return board[position[0]][position[1]].isEmpty();
    }

    public void makeMove(int[] position, String move) {
        board[position[0]][position[1]].setValue(move);
    }

    public boolean compareTwoPositions(String value, int... positions) {
        return board[positions[0]][positions[1]].getValue().equals(value) && board[positions[2]][positions[3]].getValue().equals(value);
    }
}
