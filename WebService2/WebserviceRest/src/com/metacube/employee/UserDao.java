package com.metacube.employee;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//Base Class for Employee
public interface UserDao {
	JSONArray deleteEmployee(int id);
	JSONObject getEmployeeDetails(int id);
	JSONArray addEmployee(JSONObject employee);
	JSONObject updateEmployee(int id);
	JSONArray getAllEmployees();
	JSONArray getAllEmployeesByName(String name);
	
}
