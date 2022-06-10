package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

    public class Logger {
        boolean onScreen;
        private static Logger log;
        private static final String pathLog = "log.txt";


        public Logger(boolean onScreen) throws IOException {
            this.onScreen = onScreen;
            if (!onScreen) {
                new FileWriter(pathLog, false);
            }
        }

        public static synchronized Logger getLogger(boolean onScreen) throws IOException {
            if (log == null) {
                log = new Logger(onScreen);
            }
            return log;
        }

        public void log(String str) throws IOException {
            Date date = new Date();
            if (this.onScreen) {
                System.out.println(date + " " + str);
            }
            else {
                Files.writeString(Paths.get(pathLog),date + " " + str + "\n", StandardOpenOption.APPEND);
            }
        }
    }

