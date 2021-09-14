package tictactoe;

public class Human extends Player{

    public int[] getNextMove(Board board) {
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
}
