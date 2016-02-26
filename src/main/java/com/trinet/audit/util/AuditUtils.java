/**
 * 
 */
package com.trinet.audit.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import com.trinet.audit.entity.Audit;

/**
 * @author laxmi_pabbaraju
 * 
 */
public class AuditUtils {

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
            return StringUtils.isEmpty(audit.getCompanyId()) || StringUtils.isEmpty(audit.getEmployeeId());
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
}
