package com.metacube.employee;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmployeeDao implements UserDao{
	private static int id = 0;
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
			if ((int)obj.get(id) == id) {
				employeeArray.remove(i);
			}
		}
		return employeeArray;
	}

	@Override
	public JSONObject getEmployeeDetails(int id) {
		// TODO Auto-generated method stub
		JSONObject resultObj = new JSONObject();;
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject) employeeArray.get(i);
			if ((int)obj.get(id) == id) {
				resultObj = obj;
				break;
			}
		}
		return resultObj;
	}

	@Override
	public JSONArray addEmployee(JSONObject employee) {
		// TODO Auto-generated method stub
		employeeArray.add(employee);
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
		List<JSONObject> employeesWithName = new ArrayList<JSONObject>();
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject)employeeArray.get(i);
			if(obj.get((String)"name") == name) {
				employeesWithName.add(obj);
			}
		}
		return (JSONArray) employeesWithName;
	}

}
