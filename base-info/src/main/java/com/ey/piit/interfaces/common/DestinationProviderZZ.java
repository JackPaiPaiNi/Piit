package com.ey.piit.interfaces.common;

import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

public class DestinationProviderZZ
{    
    private static Properties setProperties()
    {    
        // logon parameters and other properties
        Properties connProps = new Properties();         
        connProps.setProperty(DestinationDataProvider.JCO_ASHOST, "172.20.1.61");//测试机：172.20.1.62，正式机：172.20.1.61
        connProps.setProperty(DestinationDataProvider.JCO_SYSNR, "00");// sap系统编号
        connProps.setProperty(DestinationDataProvider.JCO_USER, "SDO01");
        connProps.setProperty(DestinationDataProvider.JCO_PASSWD, "654321");
        connProps.setProperty(DestinationDataProvider.JCO_CLIENT, "600");
        connProps.setProperty(DestinationDataProvider.JCO_LANG, "zh");// 登录语言

        return connProps;        
    }

    public static JCoDestination getDestination() throws JCoException
    {
        String destName = "SAP_ZZ";

        Properties props = setProperties();        
        DestinationDataProviderImp destDataProvider = new DestinationDataProviderImp();
        destDataProvider.addDestinationProperties(destName, props);
        Environment.registerDestinationDataProvider(destDataProvider);

        JCoDestination dest = JCoDestinationManager.getDestination(destName);
        return dest;        
    }
}