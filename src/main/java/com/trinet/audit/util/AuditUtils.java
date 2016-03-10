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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trinet.audit.entity.Audit;

/**
 * Audit service Util
 * 
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
        SimpleDateFormat dateformater = new SimpleDateFormat(ServiceConstants.DATE_FORMAT_US);
        String auditLogfileName = ServiceConstants.AUDIT_LOG_FILENAME + dateformater.format(new Date());
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
        DateFormat dateFormat = new SimpleDateFormat(ServiceConstants.DATE_FORMAT_ISO_STD, Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(new Date());
    }

    /**
     * checking the string value
     * @param strValue
     * @return
     */
    public static boolean isStringEmpty(String strValue) {
        if (strValue != null && strValue.length() == 0) {
            return true;
        }
        return false;
    }

     /**
     * loading properties file using vm argument
     * 
     * @return
     * @throws IOException 
     * @throws FileNotFoundException
     */
    public static Properties loadPropertiesFileFromEnv()  {

        Properties props = null;
        String sConfigFilePath = ConfigConstants.CONFIG_AUDIT_PROERTY_FILE;
        //String value = System.getenv(ConfigConstants.CONFIG_AUDIT_PROERTY_ENV);
        String value = System.getProperty(ConfigConstants.AUDIT_CONFIG_FILE_LOC);
        LOGGER.info("Properties files from vm argument path :: {}", value);
        InputStream fis = null;
        props = new Properties();
        if (value != null) {
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
