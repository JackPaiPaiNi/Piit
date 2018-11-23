package com.ey.piit.core.report.service;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.ConnectionPoolDataSource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.exception.ServiceException;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ReportExportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;

@Service
public class ReportService {
	
	@Autowired
	private ConnectionPoolDataSource dataSource;

	/**
	 * 导出excel
	 */
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, String jasper, String fileName,
			Map<String, Object> parameters) {
		exportExcel(request, response, jasper, fileName, parameters, null);
	}

	/**
	 * 导出excel
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, String jasper, String fileName,
			Map<String, Object> parameters, ReportExportConfiguration reportConfiguration) {
		ServletOutputStream ouputStream = null;

		try {
			ouputStream = response.getOutputStream();

			/*
			 * 设置头信息
			 */
			String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment;filename=" + codedFileName);

			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/report/" + jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource.getPooledConnection().getConnection());

			Exporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(ouputStream));
			exporter.setConfiguration(reportConfiguration);
			exporter.exportReport();
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(ouputStream);
		}
	}

	/**
	 * 导出html
	 */
	public void exportHtml(HttpServletRequest request, HttpServletResponse response, String jasper,
			Map<String, Object> parameters) {
		exportHtml(request, response, jasper, parameters, null);
	}

	/**
	 * 导出html
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportHtml(HttpServletRequest request, HttpServletResponse response, String jasper,
			Map<String, Object> parameters, ReportExportConfiguration reportConfiguration) {
		ServletOutputStream ouputStream = null;

		try {
			ouputStream = response.getOutputStream();

			/*
			 * 设置头信息
			 */
			response.setContentType("text/html;charset=UTF-8");
			
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/report/" + jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource.getPooledConnection().getConnection());
			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

			Exporter exporter = new HtmlExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			SimpleHtmlExporterOutput exporterOutput = new SimpleHtmlExporterOutput(ouputStream);
			String imageURI = request.getContextPath() + "/servlets/image?image={0}";
			HtmlResourceHandler imageHandler = new WebHtmlResourceHandler(imageURI);
			exporterOutput.setImageHandler(imageHandler);
			exporter.setExporterOutput(exporterOutput);
			exporter.setConfiguration(reportConfiguration);
			exporter.exportReport();
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(ouputStream);
		}
	}

	/**
	 * 导出pdf
	 */
	public void exportPdf(HttpServletRequest request, HttpServletResponse response, String jasper, String fileName,
			Map<String, Object> parameters) {
		exportPdf(request, response, jasper, fileName, parameters, null);
	}

	/**
	 * 导出pdf
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportPdf(HttpServletRequest request, HttpServletResponse response, String jasper, String fileName,
			Map<String, Object> parameters, ReportExportConfiguration reportConfiguration) {
		ServletOutputStream ouputStream = null;

		try {
			ouputStream = response.getOutputStream();

			/*
			 * 设置头信息
			 */
			String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			response.setContentType("application/pdf;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment;filename=" + codedFileName);

			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/report/" + jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource.getPooledConnection().getConnection());

			Exporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(ouputStream));
			exporter.setConfiguration(reportConfiguration);
			exporter.exportReport();
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(ouputStream);
		}
	}

	/**
	 * 导出word
	 */
	public void exportWord(HttpServletRequest request, HttpServletResponse response, String jasper, String fileName,
			Map<String, Object> parameters) {
		exportWord(request, response, jasper, fileName, parameters, null);
	}

	/**
	 * 导出word
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportWord(HttpServletRequest request, HttpServletResponse response, String jasper, String fileName,
			Map<String, Object> parameters, ReportExportConfiguration reportConfiguration) {
		ServletOutputStream ouputStream = null;

		try {
			ouputStream = response.getOutputStream();
			
			/*
			 * 设置头信息
			 */
			String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			response.setContentType("application/msword;charset=utf-8");
			response.setHeader("Content-disposition", "attachment;filename=" + codedFileName);

			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/report/" + jasper);
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource.getPooledConnection().getConnection());

			Exporter exporter = new JRDocxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(ouputStream));
			exporter.setConfiguration(reportConfiguration);
			exporter.exportReport();
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(ouputStream);
		}
	}

}
