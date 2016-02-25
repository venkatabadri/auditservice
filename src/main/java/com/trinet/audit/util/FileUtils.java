/**
 * 
 */
package com.trinet.audit.util;

import java.io.File;
import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laxmi_pabbaraju
 * 
 */
public class FileUtils {

    /* Instance of Logger Factory */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
        super();
    }

    /**
     * Writing audit data to the specified location If location not exists it
     * will create directory
     * 
     * @param location
     * @param auditdata
     */
    public static void writeToFile(String location, String auditdata) {

        File directory = new File(location);
        if (!directory.exists()) {
            directory.mkdir();
        }
        try {
            File auditFile = new File(directory, "auditlog.txt");
            FileWriter fw = new FileWriter(auditFile, true);
            fw.write(auditdata + "\n");
            fw.close();
        } catch (Exception ex) {

            LOGGER.info(ex.getMessage(), ex);
        }
    }
}
