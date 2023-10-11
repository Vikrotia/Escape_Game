package game;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class PrintingMap {
    char [][] createdMap;
    private final ColoredPrinter coloredPrinter;

    PrintingMap(int wC, int eC, int s) {
        MapGeneration map = new MapGeneration(wC, eC, s);
        createdMap = map.createMap();
        coloredPrinter = new ColoredPrinter.Builder(1, false).foreground(Ansi.FColor.BLACK).build();
        printMap();

    }

public void printMap() {
    for (int x = 0;x < createdMap.length; ++x){
        for (int y = 0; y < createdMap.length; ++y){
            if (createdMap[x][y] == Data.EMPTY_CHAR) {
                coloredPrinter.setBackgroundColor(Data.EMPTY_COLOR);
                coloredPrinter.print(Data.EMPTY_CHAR);
            } else if(createdMap[x][y] == Data.WALL_CHAR) {
                coloredPrinter.setBackgroundColor(Data.WALL_COLOR);
                coloredPrinter.print(Data.WALL_CHAR);
            } else if(createdMap[x][y] == Data.PLAYER_CHAR) {
                coloredPrinter.setBackgroundColor(Data.PLAYER_COLOR);
                coloredPrinter.print(Data.PLAYER_CHAR);
            } else if(createdMap[x][y] == Data.ENEMY_CHAR) {
                coloredPrinter.setBackgroundColor(Data.ENEMY_COLOR);
                coloredPrinter.print(Data.ENEMY_CHAR);
            } else if(createdMap[x][y] == Data.GOAL_CHAR) {
                coloredPrinter.setBackgroundColor(Data.GOAL_COLOR);
                coloredPrinter.print(Data.GOAL_CHAR);
            }
        }
        System.out.println();
    }
}

}
