package game;

import java.util.Scanner;

public class Movement {
    Data data;
    PrintingMap printingMap;


    public Movement(Data newData){
        printingMap = new PrintingMap(newData);
        data = newData;

    }

    public void Action() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the direction of travel (A - left, W - up, D - right, S - down): ");
        String userInput = scanner.nextLine().toLowerCase();
        while (!userInput.equals("9")) {
            movingAction(userInput);
            printingMap.printMap();
            userInput = scanner.nextLine().toLowerCase();
        }
        scanner.close();
    }


    public void movingAction(String userInput) {
            switch (userInput) {
                case "w" -> checkMoving(-1, 0);
                case "s" -> checkMoving(1, 0);
                case "a" -> checkMoving(0, -1);
                case "d" -> checkMoving(0, 1);
            }
    }

    public void checkMoving(int x, int y) {
        char object;
        try {
            object = data.map[data.player.getX() + x][data.player.getY() +y];
        } catch (Exception ex) {
            return;
        }
        if (object == Data.WALL_CHAR) {
            return;
        } else if (object == Data.ENEMY_CHAR) {
            System.out.println("End of the game! You lose. :(");
            System.exit(-1);
        } else if(object == Data.GOAL_CHAR) {
            System.out.println("End of the game! You win! :)");
            System.exit(0);
        }
        data.map[data.player.getX()][data.player.getY()] = Data.EMPTY_CHAR;
        data.map[data.player.getX() + x][data.player.getY() +y] = Data.PLAYER_CHAR;
        data.player.appendX(x);
        data.player.appendY(y);
    }

}
