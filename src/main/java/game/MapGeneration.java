package game;
import java.util.Random;

public class MapGeneration {
    Random random;
    Data data;

    public MapGeneration(Data newData) {
        random = new Random();
        data = newData;
    }


    public void createMap() {
        initializeMap();
        generateWall();
        generateEnemies();
        generationPlayer();
        generationGoal();
    }
    public void initializeMap(){
        for (int x = 0; x < Data.size; ++x) {
            for (int y = 0; y < Data.size; ++y) {
                data.map[x][y] = Data.EMPTY_CHAR;
            }
        }
    }

    public void generateWall() {
        for (int i = 0; i < Data.wallsCount; ++i) {
            int x = random.nextInt(30);
            int y = random.nextInt(30);
            data.map[x][y] = Data.WALL_CHAR;
        }
    }

    public void generateEnemies() {
        int j = 0;
        for (int i = 0; i < Data.enemiesCount; ++i) {
            int x, y;
            do {
                x = random.nextInt(30);
                y = random.nextInt(30);
            } while(data.map[x][y] != Data.EMPTY_CHAR);
            data.map[x][y] = Data.ENEMY_CHAR;
            Enemy enemy = new Enemy(x, y);
            data.enemies[j] = enemy;
            j++;
        }
    }

    public void generationPlayer() {
        int x;
        int y;
        do {
            x = random.nextInt(30);
            y = random.nextInt(30);
        } while(data.map[x][y] != Data.EMPTY_CHAR);
        data.map[x][y] = Data.PLAYER_CHAR;
        data.player.setX(x);
        data.player.setY(y);
    }


    public void generationGoal() {
        int x;
        int y;
        do {
            x = random.nextInt(30);
            y = random.nextInt(30);
        } while(data.map[x][y] != Data.EMPTY_CHAR);
        data.map[x][y] = Data.GOAL_CHAR;
    }
}
