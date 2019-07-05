import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.logging.LogManager;

public class Recipe9_11 {
    public static void main (String [] args) {
        Recipe9_11 recipe = new Recipe9_11();
        recipe.start();
    }

    static Logger rootLogger = LoggerFactory.getLogger("");
    private void start() {
        loadLoggingConfiguration();
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
            rootLogger.error("Error in thread "+t+" caused by ",e);
        });

        int c = 20/0;
    }

    private void loadLoggingConfiguration() {
        FileInputStream ins = null;
        try {
            ins = new FileInputStream(new File("logging.properties"));
            LogManager.getLogManager().readConfiguration(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
