package com.metacube.employee;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmployeeDao implements UserDao{
	public JSONArray employeeArray;
	private static EmployeeDao employeeDao = null;
	private EmployeeDao() {}
	
	public static EmployeeDao getInstance() {
		if(employeeDao == null) {
			employeeDao = new EmployeeDao();
		}
		employeeDao.employeeArray = FileUtility.getInstance().readFile();
		return employeeDao;
	}
	
	public boolean employeeArrayIsEmpty() {
		if(employeeArray == null) {
			return true;
		}
		if(employeeArray.size() == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public JSONArray deleteEmployee(int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject) employeeArray.get(i);
			if (Integer.parseInt(obj.get("id").toString()) == id) {
				employeeArray.remove(i);
			}
		}
		FileUtility.getInstance().writeFile(employeeArray);
		return employeeArray;
	}

	@Override
	public JSONObject getEmployeeDetails(int id) {
		// TODO Auto-generated method stub
		JSONObject resultObj = new JSONObject();;
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject)employeeArray.get(i);
			if (Integer.parseInt(obj.get("id").toString()) == id) {
				resultObj = obj;
				break;
			}
		}
		return resultObj;
	}

	@Override
	public JSONArray addEmployee(JSONObject employee) {
		// TODO Auto-generated method stub
		int id = 0;
		if(employeeArray == null)
			id = 1;
		else
			id = employeeArray.size()+1;
		
		employee.putIfAbsent("id", id);
		if(employeeArray == null) {
			employeeArray = new JSONArray();
		}
		employeeArray.add(employee);
		FileUtility.getInstance().writeFile(employeeArray);
		return employeeArray;
	}

	@Override
	public JSONObject updateEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeArray;
	}
	
	@Override
	public JSONArray getAllEmployeesByName(String name) {
		JSONArray employeesWithName = new JSONArray();
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject)employeeArray.get(i);
			if((obj.get("name").toString()).equals(name)) {
				employeesWithName.add(obj);
			}
		}
		return employeesWithName;
	}

}
