package com.acsk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acsk.dao.EmployeeDaoImpl;
import com.acsk.model.EmployeeBean;

@Controller
public class EmployeeController {

@Autowired
EmployeeDaoImpl employeeDaoRef;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		employeeDaoRef.addEmployee(employeeBean);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		employeeDaoRef.deleteEmployee(employeeBean);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", employeeDaoRef.getEmployee(employeeBean.getId()));
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("addEmployee", model);
	}
}
