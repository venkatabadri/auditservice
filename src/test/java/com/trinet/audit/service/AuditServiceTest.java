package com.trinet.audit.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trinet.audit.TrinetAuditApplication;
import com.trinet.audit.entity.AuditData;
import com.trinet.audit.entity.AuditEvent;
import com.trinet.audit.response.AuditResponse;

/**
 * Test case to test the  audit service
 * @author laxmi_pabbaraju
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TrinetAuditApplication.class)
@WebAppConfiguration
public class AuditServiceTest {

    @Autowired
    private AuditService auditService;
    List<AuditEvent> auditEventList = null;
    AuditEvent auditEvent = null;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        createAuditEventObject();
    }

    @Test
    public void insertAuditDocumentTest() {

        AuditResponse auditResponse = auditService.insertAuditDocument(auditEventList);
        assertTrue(auditResponse.getStatusCode().equals("200"));
        assertNull(auditResponse.getAuditException());

    }

    private void createAuditEventObject() {

        auditEvent = new AuditEvent();

        List<AuditData> auditDataList = new ArrayList<AuditData>();
        AuditData auditData1 = new AuditData();
        AuditData auditData2 = new AuditData();

        auditData1.setColumnName("SALARY");
        auditData1.setOldValue("10000");
        auditData1.setNewValue("20000");

        auditData2.setColumnName("MANAGER");
        auditData2.setOldValue("Ramu");
        auditData2.setNewValue("Somu");

        auditDataList.add(auditData1);
        auditDataList.add(auditData2);

        auditEvent.setUserId("1001");
        auditEvent.setCompanyId("16301");
        auditEvent.setRemoteClientIp("127.0.0.1");
        auditEvent.setEnttryName("PERSISTENT_HYD");
        auditEvent.setRecordIdentfierName("EMP_ID");
        auditEvent.setRecordIdentfierValue("7970");
        auditEvent.setCriticalFieldName("EMP_NAME");
        auditEvent.setCriticalFieldValue("Laxmi");
        auditEvent.setTimeStamp(new Date().getTime());
        auditEvent.setServerId("Tech_support_copmuter");
        auditEvent.setAction("Update");
        auditEvent.setBlob(false);
        auditEvent.setApplicationName("Trinet_Employee");
        auditEvent.setMethodName("employeeDetails");
        auditEvent.setUiPage("user_frist_page");
        auditEvent.setBrowserInfo("ChromBrowser");
        auditEvent.setOsInfo("Windows7Enterprise");
        auditEvent.setMobileInfo("Samsung");
        auditEvent.setAuditData(auditDataList);

        List<AuditEvent> auditEventList = new ArrayList<AuditEvent>();
        auditEventList.add(auditEvent);
    }

}
