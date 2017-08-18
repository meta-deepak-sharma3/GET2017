package com.metacube.employee;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * Facade Class which will
 * handle all data from and to client
 */
@Path("/employees")
public class EmployeeFacade {
	
	/*
	*Method to get employee detail by their id
	*GET Method
	*url- https://localhost/rest/employees/{id}
	*/
	@GET
	@Path("/{id}")
	@Produces("Application/json")
	public JSONObject getEmployeeDetail(@PathParam("id") int id) {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.getEmployeeDetails(id);
	}
	
	/*
	*Method to get employee details by their name
	*GET Method
	*url- https://localhost/rest/employees/{name}
	*/
	@GET
	@Path("/{name}")
	@Produces("Application/json")
	public JSONArray getEmployeeDetailByName(@PathParam("name") String name) {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.getAllEmployeesByName(name);
	}
	
	/*
	*Method to get all the employee details 
	* GET Method
	*url- https://localhost/rest/employees/	
	*/
	@GET
	@Produces("Application/json")
	public JSONArray getEmployees() {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.getAllEmployees();
	}
	
	/*
	*Method to create new employee
	*POST Method 
	*url-https://localhost/rest/employees/ 
	*/
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public JSONArray createEmployee(@Context HttpHeaders httpHeaders, JSONObject employee) throws Exception{
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		return employeeDao.addEmployee(employee);
	}
	
	/*
	*Method to delete employee by its id.
	* DELETE Method
	*url- https://localhost/rest/employees/{id} 
	*/
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray deleteUser(@PathParam("id") int id){
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.deleteEmployee(id);
	}
	
}
