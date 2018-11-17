package com.teamdev.app.controllers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamdev.app.datas.DataDemo;
import com.teamdev.app.models.Department;

import net.sf.jxls.transformer.XLSTransformer;

@Controller
public class PagesControllers {

	@Autowired
	private ServletContext context;

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String export(HttpServletRequest request, HttpServletResponse response) {
		try {
			// set output header
			ServletOutputStream os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"myexcel.xls\"");

			String reportLocation = context.getRealPath("excel");

			Map beans = new HashMap();
			beans.put("name", "Edwin");
			beans.put("address", "Jakarta, Indonesia");
			XLSTransformer transformer = new XLSTransformer();

			Workbook workbook = transformer.transformXLS(new FileInputStream(reportLocation + "/myexcel.xls"), beans);
			workbook.write(os);
			os.flush();
			os.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/depart1", method = RequestMethod.GET)
	public String exportMultiSheetDemo1(HttpServletRequest request, HttpServletResponse response) {
		try {
			final List<Department> departments = DataDemo.createDepartments();
			
			String reportLocation = context.getRealPath("excel")+"/multisheet_markup_demo.xls";
			final FileInputStream is = new FileInputStream(reportLocation);
			
			// set output header
			ServletOutputStream os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"depart1.xls\"");

			Context context = new Context();
			context.putVar("departments", departments);
            context.putVar("sheetNames", Arrays.asList(
                    departments.get(0).getName(),
                    departments.get(1).getName(),
                    departments.get(2).getName()));
			
			Workbook workbook = WorkbookFactory.create(is);
			PoiTransformer poiTransformer =  PoiTransformer.createTransformer(workbook);
			AreaBuilder areaBuilder = new XlsCommentAreaBuilder(poiTransformer);
			
			List<Area> aList = areaBuilder.build();
			Area area = aList.get(0);
			area.applyAt(new CellRef("Template!A1"), context);
			area.processFormulas();
			
			workbook.write(os);
			workbook.removeName(0);
			os.flush();
			os.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/depart2", method = RequestMethod.GET)
	public String exportMultiSheetDemo2(HttpServletRequest request, HttpServletResponse response) {
		try {
			final List<Department> departments = DataDemo.createDepartments();
			final InputStream is = PagesControllers.class.getResourceAsStream("excels/multisheet_markup_demo-2.xlsx");
			
			String reportLocation = context.getRealPath("excel")+"/multisheet_markup_demo-2.xlsx";
			final FileInputStream iss = new FileInputStream(reportLocation);
			// set output header
			ServletOutputStream os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"depart2.xlsx\"");

			Context context = new Context();
			context.putVar("departments", departments);
            context.putVar("sheetNames", Arrays.asList(
                    departments.get(0).getName(),
                    departments.get(1).getName(),
                    departments.get(2).getName()));
			
			Workbook workbook = WorkbookFactory.create(iss);
			PoiTransformer poiTransformer =  PoiTransformer.createTransformer(workbook);
			AreaBuilder areaBuilder = new XlsCommentAreaBuilder(poiTransformer);
			
			List<Area> aList = areaBuilder.build();
			Area area = aList.get(0);
			area.applyAt(new CellRef("Template!A1"), context);
			area.processFormulas();
			
			workbook.write(os);
			workbook.removeName(0);
			os.flush();
            os.close();
            
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/depart3", method = RequestMethod.GET)
	public String exportMultiSheetDemo3(HttpServletRequest request, HttpServletResponse response) {
		try {
			final List<Department> departments = DataDemo.createDepartments();
			final InputStream is = PagesControllers.class.getResourceAsStream("excels/multisheet_markup_demo-2.xlsx");
			// set output header
			ServletOutputStream os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"depart2.xlsx\"");

			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
