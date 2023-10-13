package game;

import java.util.Scanner;

public class Movement {
    Data data;
    PrintingMap printingMap;
    public char[][] movementMap;
    Player player;


    public Movement(int wC, int eC, int s, Data newData){
        printingMap = new PrintingMap(wC, eC, s);
        movementMap = printingMap.getCreatedMap();
        player = printingMap.getPlayer();
        data = newData;
    }

    public void Action() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the direction of travel (A - left, W - up, D - right, S - down): ");
        String userInput = scanner.nextLine().toLowerCase();
        while (!userInput.equals("9")) {
            movingAction(userInput);
            printingMap.setCreatedMap(movementMap);
            printingMap.printMap();
            userInput = scanner.nextLine().toLowerCase();
        }
        scanner.close();
//        printingMap.setCreatedMap(movementMap);
//        printingMap.printMap();
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
            object = movementMap[player.getX() + x][player.getY() +y];
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
        movementMap[player.getX()][player.getY()] = Data.EMPTY_CHAR;
        movementMap[player.getX() + x][player.getY() +y] = Data.PLAYER_CHAR;
        player.appendX(x);
        player.appendY(y);
    }

}
