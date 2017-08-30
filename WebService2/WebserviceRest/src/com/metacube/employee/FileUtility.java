package com.metacube.employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tomcat.jni.File;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/*class for handling file operation.
 * for example: read and writing the file
 * closing of FileReader and BufferedReader Object
 */
public class FileUtility {
	private static String FILE_LOCATION = new String("C:/Users/Deepak/eclipse-workspace/WebserviceRest/Employees.json");
	private static FileUtility fileUtility = null;
	private FileUtility() {}
	
	public static FileUtility getInstance() {
		if(fileUtility == null) {
			fileUtility = new FileUtility();
		}
		return fileUtility;
	}
	
	public JSONArray readFile() {
		JSONArray employeeArray = null;
		JSONParser parser = new JSONParser();
		try {
			employeeArray = (JSONArray) parser.parse(new FileReader(FILE_LOCATION));
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		//System.out.println(employeeArray);
		return employeeArray;
	}
	
	public void writeFile(JSONArray employeeArray) {
		try {
			FileWriter file = new FileWriter(FILE_LOCATION);
			file.write(employeeArray.toJSONString());
			file.flush();
			System.out.println("Successfully Updated Employees Detail to File...");
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
