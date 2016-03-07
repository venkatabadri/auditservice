/**
 * 
 */
package com.trinet.audit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trinet.audit.entity.Audit;

/**
 * @author laxmi_pabbaraju
 * 
 */
public class AuditUtils {
    
    /* Instance of Logger Factory */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditUtils.class);

    private AuditUtils() {
        super();
    }

    /**
     * Writing audit data to the specified location If location not exists it
     * will create directory
     * 
     * @param location
     * @param auditdata
     */
    public static void writeToFile(String location, Audit auditdata) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String auditData = mapper.writeValueAsString(auditdata);
        File directory = new File(location);
        SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-MM-dd");
        String auditLogfileName = "audit-log-" + dateformater.format(new Date());
        File auditFile = new File(directory, auditLogfileName + ".txt");
        FileWriter fw = new FileWriter(auditFile, true);
        fw.write(auditData + "\n");
        fw.close();
    }

    /**
     * verifying audit data wither company id and employee id's are empty or
     * null
     * 
     * @param audit
     * @return
     */
    public static boolean verifyAudit(Audit audit) {
        if (audit != null) {
            return AuditUtils.isStringEmpty(audit.getCompanyId()) || AuditUtils.isStringEmpty(audit.getEmployeeId());
        }
        return false;
    }

    /**
     * Getting Time stamp in ISO8601 format
     */
    public static String getISO8601StringForDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(new Date());
    }

    public static boolean isStringEmpty(String strValue) {
        if (strValue != null && strValue.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isStringEmptyByEquals(String strValue) {
        return "".equals(strValue);
    }

    /**
     * Loading property file
     * @return
     * @throws FileNotFoundException
     */
    public static Properties loadPropertiesFile() throws FileNotFoundException {

        String sConfigFile = "application-audit.properties";
        Properties props = null;
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream(sConfigFile);
            if (in != null) {
                props = new java.util.Properties();
                props.load(in);
            }
        } catch (IOException ex) {
            LOGGER.info(ex.toString(), ex);
        }
        return props;
    }

    /**
     * loading properties file  using Environment variable
     * @return
     * @throws FileNotFoundException
     */
    public static Properties loadPropertiesFileFromEnv() throws FileNotFoundException {

        Properties props = null;
        String sConfigFilePath = "application-audit.properties";
        String value = System.getenv("AUDIT_CONFIG");
        LOGGER.info("Properties files from environment variable path :: " + value);
        InputStream fis = null;
        if (value != null) {
            props = new Properties();
            sConfigFilePath = value + "\\" + sConfigFilePath;
           
            try {

                fis = new FileInputStream(new File(sConfigFilePath));
            } catch (FileNotFoundException e) {
              
                LOGGER.info(e.toString(), e);
            }
        }
        if (fis == null) {
            fis = ClassLoader.getSystemResourceAsStream(sConfigFilePath);
        }
        try {
            props.load(fis);
        } catch (IOException ex) {
            LOGGER.info(ex.toString(), ex);
           
        }

        return props;

    }

}
