package game;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class CommandLineArguments {
    @Parameter(names = "--enemiesCount", required = true)
    private Integer enemiesCount;
    @Parameter(names = "--wallsCount", required = true)
    private Integer wallsCount;
    @Parameter(names = "--size", required = true)
    private Integer size;
    @Parameter(names = "--profile", required = true)
    private String profile;

    public void printAr() {
        System.out.println(enemiesCount);
        System.out.println(wallsCount);
        System.out.println(size);
        System.out.println(profile);
    }

    public int getEnemiesCount() {
        return enemiesCount;
    }
    public int getWallsCount() {
        return wallsCount;
    }
    public int getSize() {
        return size;
    }
    public String getProfile() {
        return profile;
    }

    public void CheckParameters() throws IllegalParametersException {
        if ((Math.pow((size - 2), 2) < wallsCount) || size < 6 || (Math.pow((size - 2), 2) - wallsCount < enemiesCount)) {
            throw new IllegalParametersException("IllegalParametersException");
        }
    }


}
