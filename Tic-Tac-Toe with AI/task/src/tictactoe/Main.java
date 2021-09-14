package tictactoe;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static char[][] board = new char[3][3];
    static Scanner scanner;

    public static void startGame(int playerOne, int playerTwo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        if (playerOne == 0 && playerTwo == 1) {
            startPlayerVsComputerGame(false);
        } else if (playerOne == 1 && playerTwo == 0) {
            startPlayerVsComputerGame(true);
        } else if (playerOne == 0 && playerTwo == 0) {
            startPlayerVsPlayerGame();
        } else {
            startComputerVsComputerGame();
        }
    }

    public static void startPlayerVsPlayerGame() {
        String winner = "_";
        boolean playersMove = false;

        while (winner.equals("_")) {
            drawBoard();

            if (playersMove) {
                int[] computer1Move = getNextPlayerMove();
                board[computer1Move[0] - 1][computer1Move[1] - 1] = 'X';
            } else {
                int[] computer2Move = getNextPlayerMove();
                board[computer2Move[0] - 1][computer2Move[1] - 1] = 'O';
            }

            winner = determinateBoardState();

            playersMove = !playersMove;
        }
        drawBoard();
        System.out.println(Objects.equals(winner, "F") ? "Draw" : winner + " wins");
    }

    public static void startComputerVsComputerGame() {
        String winner = "_";
        boolean playersMove = true;

        while (winner.equals("_")) {
            drawBoard();

            if (playersMove) {
                int[] computer1Move = getNextComputerMove();
                board[computer1Move[0]][computer1Move[1]] = 'X';
            } else {
                int[] computer2Move = getNextComputerMove();
                board[computer2Move[0]][computer2Move[1]] = 'O';
            }

            winner = determinateBoardState();

            playersMove = !playersMove;
        }
        drawBoard();
        System.out.println(Objects.equals(winner, "F") ? "Draw" : winner + " wins");
    }

    public static void startPlayerVsComputerGame(boolean isComputerFirst) {
        String winner = "_";
        boolean playersMove = !isComputerFirst;

        while (winner.equals("_")) {
            drawBoard();

            if (playersMove) {
                int[] playerMove = getNextPlayerMove();
                board[playerMove[0] - 1][playerMove[1] - 1] = isComputerFirst ? 'O' : 'X';
            } else {
                int[] computerMove = getNextComputerMove();
                board[computerMove[0]][computerMove[1]] = isComputerFirst ? 'X' : 'O';
            }

            winner = determinateBoardState();

            playersMove = !playersMove;
        }
        drawBoard();
        System.out.println(Objects.equals(winner, "F") ? "Draw" : winner + " wins");
    }

    public static char boardState() {
        char ret = 'F';

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '_') {
                ret = board[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '_') {
                ret = board[0][i];
            }
        }

        if ((board[0][0] == board[1][1] && board[2][2] == board[0][0] ||
                board[0][2] == board[1][1] && board[2][0] == board[1][1]) && board[1][1] != '_') {
            ret = board[1][1];
        }

        if (ret == 'F') {
            for (char[] row : board) {
                for (char position : row) {
                    if (position == '_') {
                        ret = 'N';
                        break;
                    }
                }
            }
        }

        return ret;
    }

    public static String determinateBoardState() {
        String winner = "_";

        switch (boardState()) {
            case 'X':
                winner = "X";
                break;

            case 'O':
                winner = "O";
                break;

            case 'N':
                winner = "_";
                break;

            case 'F':
                winner = "F";
                break;

            default:
                System.out.println("Error! Unknown board state.");
                break;
        }

        return winner;
    }

    public static void drawBoard() {
        System.out.println("---------");

        for (char[] row : board) {
            System.out.print("| ");
            for (char position : row) {
                if (position != '_') {
                    System.out.print(position + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    public static int[] getNextPlayerMove() {
        boolean hasGoodInput = false;
        int[] position = new int[2];
        String input;

        while (!hasGoodInput) {
            System.out.print("Enter the coordinates: ");
            input = scanner.nextLine();

            try {
                String[] splitedInpt = input.split(" ", 2);
                position[0] = Integer.parseInt(splitedInpt[0]);
                position[1] = Integer.parseInt(splitedInpt[1]);
            } catch (Exception e) {
                System.out.println("\nYou should enter numbers!");
                continue;
            }

            if (position[0] > 3 || position[0] < 1 || position[1] > 3 || position[1] < 1) {
                System.out.println("\nCoordinates should be from 1 to 3!");
                continue;
            }

            if (board[position[0] - 1][position[1] - 1] != '_') {
                System.out.println("\nThis cell is occupied! Choose another one!");
                continue;
            }

            hasGoodInput = true;
        }

        return position;
    }

    public static int[] getNextComputerMove() {
        System.out.println("Making move level \"easy\"");
        int[] position = new int[2];
        String[] availablePosition = new String[9];
        Random random = new Random();
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
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

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String command = "";

        while (!command.equals("exit")) {
            System.out.print("Input command: ");
            command = scanner.nextLine();
            String[] splitCommand = command.split(" ");

            if (splitCommand.length < 3) {
                if (splitCommand[0].equals("exit")) {
                    command = "exit";
                    break;
                } else if (splitCommand[0].equals("start")) {
                    System.out.println("Bad parameters!");
                }
            } else {
                if (splitCommand[0].equals("start")) {
                    int playerOne = -1;
                    int playerTwo = -1;

                    if (splitCommand[1].equals("user")) {
                        playerOne = 0;
                    } else if(splitCommand[1].equals("easy")) {
                        playerOne = 1;
                    }

                    if (splitCommand[2].equals("user")) {
                        playerTwo = 0;
                    } else if(splitCommand[2].equals("easy")) {
                        playerTwo = 1;
                    }

                    startGame(playerOne, playerTwo);
                } else {
                    System.out.println("Bad parameters!");
                }
            }
        }
    }
}
