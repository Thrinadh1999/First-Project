package com.pranavaeet.controllers;

import java.util.List;

//import java.util.List;
//import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.common.Invoices;

@Controller
public class InvoiceController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	ObjectDAO objectDAO;
	
	//Invoice Page
	@GetMapping(value="/Invoice")
	public ModelAndView invoicePage(HttpServletRequest request, HttpSession session) {
		List<Invoices> invoiceList = (List<Invoices>) objectDAO.multipleResultSelect(SQL_QUERIES.getInvoices, null, Invoices.class);
		ModelAndView page = new ModelAndView();
		
		page.addObject("invoTableLst", invoiceList);
		page.setViewName("Invoice");
		page.addObject("newInvoice", new Invoices());
		
	return page;
	}
	
	@PostMapping(value = "/addinvoice")
	public ModelAndView addNewInvoice(@ModelAttribute Invoices newInvoice, HttpServletRequest request,HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addInvoices, new String [] {newInvoice.getInvoiceNo(), newInvoice.getClient(), newInvoice.getClientAdress(), newInvoice.getToName(), newInvoice.getIssueDate(), newInvoice.getInvoiceBy(), newInvoice.getCreatedTime()});
		
		return new ModelAndView("redirect:/Invoice");
	}
}
		
		
		
		
		
	
		
		