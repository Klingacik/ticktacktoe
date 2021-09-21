package tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        board = new Board(3);

        start();
    }

    private void start() {
        boolean running = true;

        while (running) {
            System.out.print("Input command: ");
            String command = scanner.nextLine();
            String action = getMenuAction(command);

            if (!action.equals("Error!")) {
                if (action.equals("exit")) {
                    running = false;
                } else {
                    int gameMode = getGameMode(command);

                    switch (gameMode) {
                        case 11:
                            startGame(new Human(), new Human());
                            break;

                        case 12:
                            startGame(new Human(), new EasyComputer(false));
                            break;

                        case 13:
                            startGame(new Human(), new MediumComputer(false));

                        case 21:
                            startGame(new EasyComputer(true), new Human());
                            break;

                        case 22:
                            startGame(new EasyComputer(true), new EasyComputer(false));
                            break;

                        case 23:
                            startGame(new EasyComputer(true), new MediumComputer(false));
                            break;

                        case 31:
                            startGame(new MediumComputer(true), new Human());
                            break;

                        case 32:
                            startGame(new MediumComputer(true), new EasyComputer(false));
                            break;

                        case 33:
                            startGame(new MediumComputer(true), new MediumComputer(false));
                            break;

                        case -1:
                        default:
                            System.out.println("Bad parameters!");
                            break;
                    }
                }
            }
        }
    }

    private String getMenuAction(String input) {
        //Get first word from users input
        String action = input.split(" ")[0];

        if (action.equals("start") || action.equals("exit")) {
            return action;
        }

        return "Error!";
    }

    private int getGameMode(String input) {
        String[] action = input.split(" ");
        int ret;

        if (action.length != 3) {
            return -1;
        }

        switch (action[1]) {
            case "user":
                ret = 10;
                break;

            case "easy":
                ret = 20;
                break;

            case "medium":
                ret = 30;
                break;

            default:
                return -1;
        }

        switch (action[2]) {
            case "user":
                ret += 1;
                break;

            case "easy":
                ret += 2;
                break;

            case "medium":
                ret += 3;
                break;

            default:
                return -1;
        }

        return ret;
    }

    private void startGame(Player playerOne, Player playerTwo) {
        board.clear();
        boolean firstPlayerMove = true;
        String winner = "N";

        while (winner.equals("N")) {
            System.out.println(board.drawBoard());

            if(firstPlayerMove) {
                board.makeMove(playerOne.getNextMove(board), "X");
            } else {
                board.makeMove(playerTwo.getNextMove(board), "O");
            }

            firstPlayerMove = !firstPlayerMove;

            winner = board.determinateBoardState();
        }

        System.out.println(board.drawBoard());
        System.out.println(Objects.equals(winner, "D") ? "Draw" : winner + " wins");
    }
}

//TODO: let player to choose size of board
