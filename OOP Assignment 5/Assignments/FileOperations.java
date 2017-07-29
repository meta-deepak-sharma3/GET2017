package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

	private File file;

	private FileInputStream fileInputStream;

	private BufferedReader bufferedReader;


	public void createNewFile(String fileName){

		try{

			file = new File(fileName);

			file.createNewFile();

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}
	}

	public List<Entity> readDataFromFile(String fileName){
		
		List<Entity> entityList = null;

		try{
			
			entityList = new ArrayList<Entity>();

			fileInputStream = new FileInputStream(fileName);

			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

			String strLine;

			while( (strLine = bufferedReader.readLine() ) != null){
				
				Entity entity;
				
				String[] entityDataArray = strLine.split(",");
				
				if(entityDataArray[0].equals("o")){
					
					entity = new Organisation(); 
				}
				
				else{
					
					entity = new Person();
				}
				
				entity.setName(entityDataArray[1]);
				
				entity.setContactNumber(entityDataArray[2]);
				
				entity.setEmailID(entityDataArray[3]);
				
				entityList.add(entity);

			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{

				fileInputStream.close();

				bufferedReader.close();

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}
		
		return entityList;
	}
	
	public List<String> readConnectionsFromFile(String fileName){
		
		List<String> connectionsList = null;

		try{
			
			connectionsList = new ArrayList<String>();

			fileInputStream = new FileInputStream(fileName);

			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

			String strLine;

			while( (strLine = bufferedReader.readLine() ) != null){
				
				connectionsList.add(strLine);

			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{

				fileInputStream.close();

				bufferedReader.close();

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}
		
		return connectionsList;
		
	}
	

	public String searchInFile(String name , String fileName){

		String resultString = null;

		try{

			fileInputStream = new FileInputStream(fileName);

			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

			String strLine ;

			while( (strLine = bufferedReader.readLine() ) != null){

				if(strLine.contains(name)){

					resultString = strLine;

					break;
				}

			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{

				fileInputStream.close();

				bufferedReader.close();

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}

		return resultString;

	}
}