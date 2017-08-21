package com.metacube.employee;


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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * Facade Class which will
 * handle all data from and to client
 */
@Path("/employees")
public class EmployeeService {
	
	/*
	*Method to get employee detail by their id
	*GET Method
	*url- https://localhost/RestWebservice/rest/employees/{id}
	*/
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEmployeeDetail(@PathParam("id") int id) {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		String output = employeeDao.getEmployeeDetails(id).toString();
		return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to get employee details by their name
	*GET Method
	*url- https://localhost/RestWebservice/rest/employees/{name}
	*/
	@GET
	@Path("/{name}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEmployeeDetailByName(@PathParam("name") String name) {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		String output = employeeDao.getAllEmployeesByName(name).toString();
		return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to get all the employee details 
	* GET Method
	*url- https://localhost/RestWebservice/rest/employees/	
	*/
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEmployees() {
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		String output = employeeDao.getAllEmployees().toString();
		return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to create new employee
	*POST Method 
	*url- https://localhost/RestWebservice/rest/employees/create 
	*/
	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response createEmployee(@Context HttpHeaders httpHeaders, JSONObject employee) throws Exception{
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		String output = employeeDao.addEmployee(employee).toString();
		return Response.status(200).entity(output).build();
	}
	
	/*
	*Method to delete employee by its id.
	* DELETE Method
	*url- https://localhost/RestWebservice/rest/employees/delete/{id} 
	*/
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id){
		EmployeeDao employeeDao = (EmployeeDao)EmployeeDao.getInstance();
		if(employeeDao.employeeArrayIsEmpty())
			return null;
		String output = employeeDao.deleteEmployee(id).toString();
		return Response.status(200).entity(output).build(); 
	}
	
}
