package tictactoe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

            if (action.equals("exit"))
                running = false;
            else if (action.equals("start")) {
                startGame(getGameMode(command));
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

    private List<Player> getGameMode(String input) {
        String[] action = input.split(" ");

        if (action.length != 3) {
            return Collections.emptyList();
        }

        Player player1 = createFirstPlayerFromInput(action[1]);
        Player player2 = createSecondPlayerFromInput(action[2]);

        if(player1 == null || player2 == null) {
            return Collections.emptyList();
        }

        return Arrays.asList(player1, player2);
    }

    private Player createFirstPlayerFromInput(String input)
    {
        return createPlayerFromInput(input, true);
    }

    private Player createSecondPlayerFromInput(String input)
    {
        return createPlayerFromInput(input, false);
    }

    private Player createPlayerFromInput(String input, boolean playLikeX)
    {
        switch(PlayerType.fromValue(input)) {
            case USER: return new Human();
            case COMPUTER_EASY: return new EasyComputer();
            case COMPUTER_MEDIUM: return new MediumComputer(playLikeX);
            default: return null;
        }
    }

    private void startGame(List<Player>players) {
        if(players.isEmpty()) {
            System.out.println("Bad parameters!");
            return;
        }

        board.clear();
        boolean firstPlayerMove = true;
        String winner = "N";

        while (winner.equals("N")) {
            System.out.println(board.drawBoard());

            if(firstPlayerMove) {
                board.makeMove(players.get(0).getNextMove(board), "X");
            } else {
                board.makeMove(players.get(1).getNextMove(board), "O");
            }

            firstPlayerMove = !firstPlayerMove;

            winner = board.determinateBoardState();
        }

        System.out.println(board.drawBoard());
        System.out.println(Objects.equals(winner, "D") ? "Draw" : winner + " wins");
    }
}

//TODO: let player to choose size of board
