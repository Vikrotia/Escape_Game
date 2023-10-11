package game;

import com.beust.jcommander.JCommander;

public class Program {
    public static void main (String[] args) throws IllegalParametersException {
        CommandLineArguments commandArg = new CommandLineArguments();
        JCommander.newBuilder()
                .addObject(commandArg)
                .build()
                .parse(args);
        try {
            commandArg.CheckParameters();
            Data data = new Data(commandArg.getProfile());
            PrintingMap map = new PrintingMap(commandArg.getWallsCount(), commandArg.getEnemiesCount(),
                    commandArg.getSize());
        } catch (IllegalParametersException ex){
            System.err.println("Illegal parameters.");
            System.exit(-1);
        }
    }
}
