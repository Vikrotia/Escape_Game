package game;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class PrintingMap {
    private final ColoredPrinter coloredPrinter;
    Data data;

    PrintingMap(Data newData) {
        data = newData;
        MapGeneration map = new MapGeneration(data);
        map.createMap();
        coloredPrinter = new ColoredPrinter.Builder(1, false).foreground(Ansi.FColor.BLACK).build();
        printMap();
    }

    public void printMap() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int x = 0; x < data.map.length; ++x) {
            for (int y = 0; y < data.map.length; ++y) {
                if (data.map[x][y] == Data.EMPTY_CHAR) {
                    coloredPrinter.setBackgroundColor(Data.EMPTY_COLOR);
                    coloredPrinter.print(Data.EMPTY_CHAR);
                } else if(data.map[x][y] == Data.WALL_CHAR) {
                    coloredPrinter.setBackgroundColor(Data.WALL_COLOR);
                    coloredPrinter.print(Data.WALL_CHAR);
                } else if(data.map[x][y] == Data.PLAYER_CHAR) {
                    coloredPrinter.setBackgroundColor(Data.PLAYER_COLOR);
                    coloredPrinter.print(Data.PLAYER_CHAR);
                } else if(data.map[x][y] == Data.ENEMY_CHAR) {
                    coloredPrinter.setBackgroundColor(Data.ENEMY_COLOR);
                    coloredPrinter.print(Data.ENEMY_CHAR);
                } else if(data.map[x][y] == Data.GOAL_CHAR) {
                    coloredPrinter.setBackgroundColor(Data.GOAL_COLOR);
                    coloredPrinter.print(Data.GOAL_CHAR);
                }
            }
            System.out.println();
        }
    }

}
