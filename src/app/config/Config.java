package app.config;

import java.nio.file.FileSystems;

public class Config {
    public static final String CSV_DELIMITER = ",";

    public static final String ABS_USER_FILE_PATH = getDbFilePath();
    private static final String FOLDER_NAME = "db";
    private static final String FILE_NAME = "users.csv";

    public static final Integer SALT_LENGTH = 10;


    private static String getDbFilePath() {
        String userDir = System.getProperty("user.dir");
        String systemSeparator = FileSystems.getDefault().getSeparator();
        return userDir + systemSeparator + FOLDER_NAME + systemSeparator + FILE_NAME;
    }
}
