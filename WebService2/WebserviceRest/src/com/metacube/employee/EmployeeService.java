package com.metacube.employee;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jettison.json.JSONString;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

/*
 * Facade Class which will
 * handle all data from and to client
 */
@Path("/employees")
public class EmployeeService {
	
	/*
	*Method to get employee detail by their id
	*GET Method
	*url- https://localhost/WebserviceRest/rest/employees/{id}
	*/
	@GET
	@Path("/getById/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getEmployeeDetail(@PathParam("id") int id) {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.getEmployeeDetails(id).toString();
		//return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to get employee details by their name
	*GET Method
	*url- https://localhost/WebserviceRest/rest/employees/{name}
	*/
	@GET
	@Path("/getByName/{name}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getEmployeeDetailByName(@PathParam("name") String name) {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.getAllEmployeesByName(name).toString();
		//return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to get all the employee details 
	* GET Method
	*url- https://localhost/WebserviceRest/rest/employees/	
	*/
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getEmployees() {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.getAllEmployees().toString();
		//return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to create new employee
	*POST Method 
	*url- https://localhost/WebserviceRest/rest/employees/create 
	*/
	@POST
	@Path("/createEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createEmployee(@Context HttpHeaders httpHeaders, String employeeString) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject employee = (JSONObject) parser.parse(employeeString);
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		return employeeDao.addEmployee(employee).toString();
		//return employeeDao.addEmployee((JSONObject)employee).toString();
		//return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to delete employee by its id.
	* DELETE Method
	*url- https://localhost/WebserviceRest/rest/employees/delete/{id} 
	*/
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteUser(@PathParam("id") int id){
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		return employeeDao.deleteEmployee(id).toString();
		//return Response.status(200).entity(output).build(); 
	}
	
}
