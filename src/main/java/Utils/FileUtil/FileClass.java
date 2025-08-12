package Utils.FileUtil;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileClass {


    public static File getLastFile(String file) {
        File file1 = new File(file);
        if (!file1.exists()) {
            LogClass.error("File does not exist");
        }
        File[] files = file1.listFiles();
        assert files != null;
        if (files.length == 0) {
            LogClass.error("File does not exist");
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];
    }


    public static void cleanDirectory(File path) {
        try {

            FileUtils.deleteQuietly(path);
        } catch (Exception e) {
            LogClass.error("Fail to clean directory", e.getMessage());
        }

    }


}
