/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.serviceImpl;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Slf4j
public class GenericReportingService {

    @Autowired
    private JdbcTemplate jdbc;

    public byte[] exportPdfFile (Map<String, Object> params, URL path) throws SQLException, JRException, IOException {
	Connection conn = conect();
	JasperReport jasper = (JasperReport) JRLoader.loadObject(path);
	JasperPrint print = JasperFillManager.fillReport(jasper, params, conn);
	conn.close();
	try {
             System.out.println("SELIO BIEN" +print.toString());
	    return JasperExportManager.exportReportToPdf(print);
           
	} catch (JRException e) {
             System.out.println("SELIO MAL :(");
	    log.error(e.getMessage());
	    throw new RuntimeException(e);
	}
    }

    private Connection conect () throws SQLException {
	return jdbc.getDataSource().getConnection();
    }

}