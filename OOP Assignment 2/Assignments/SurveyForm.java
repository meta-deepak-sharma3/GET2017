package Assignments;

import java.util.*;
import java.io.*;

public class SurveyForm{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = 1;
		System.out.println("Enter the number of students");
		try{
			numberOfStudents = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Enter the valid input for number of students");
		}
		Participant[] participants = new Participant[numberOfStudents];
		for(int i=0;i<numberOfStudents;i++){
			participants[i] = new Participant();
			participants[i].id = i+1;
			participants[i].askQuestion();
		}
		Report rp = new Report();
		rp.reportOne(participants);
		rp.reportTwo(participants);		

	}
}
class Participant{
	int id;
	Map<Integer, String[]> questionWithResponse = new HashMap<Integer, String[]>();

	public Participant(){
		id = 0;
		//this.questionWithResponse = Collections.<Object, String[]>emptyMap();
	}	

	public void askQuestion(){
		Survey survey = new Survey();
		//Question[] questions = new Question[survey.numOfQuestions];
		Question[] questions = survey.getAllQuestionsOfSurvey();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the response of Survey Questions one by one");
		for(int i=0;i<questions.length;i++){
			System.out.println(questions[i].quest);
			if(questions[i].type.equals("Text")){
				System.out.println("Enter your text repsonse");
				String textResponse = sc.nextLine();
				questionWithResponse.put(questions[i].questionNumber, new String[]{textResponse});
			}else if(questions[i].type.equals("Single Select")){
				System.out.print("Available Options: ");
				for(int j=0;j<questions[i].getAvailableOptions().length;j++){
					System.out.println(questions[i].getAvailableOptions()[j]);
				}
				String singleResponse;
				do{
					System.out.println("Enter your single select repsonse");
					singleResponse = sc.nextLine().trim();
				}while(!Arrays.asList(questions[i].getAvailableOptions()).contains(singleResponse));
				questionWithResponse.put(questions[i].questionNumber, new String[]{singleResponse});
			}else{
				String multipleResponseList[];
				System.out.print("Available Options: ");
				for(int j=0;j<questions[i].getAvailableOptions().length;j++){
					questions[i].getAvailableOptions()[j].trim();
					System.out.println(questions[i].getAvailableOptions()[j]);
				}
				boolean isPresent = true;
				do{
					System.out.println("Enter your Multiple select repsonse: format: Option1/Option2/Option3");
					String multipleResponse = sc.nextLine();
					multipleResponseList = multipleResponse.split("/");
					for(int j=0;j<multipleResponseList.length;j++){
						multipleResponseList[j].trim();
					}
					for(int k=0;k<multipleResponseList.length;k++){
						if(!Arrays.asList(questions[i].getAvailableOptions()).contains(multipleResponseList[k]))
							isPresent = false;
					}
				}while(!isPresent);
				questionWithResponse.put(questions[i].questionNumber, multipleResponseList);
			}

		}

	}	
}

class Survey extends Question{
	int numOfQuestions;
	Question[] questions;
	
	public Survey(){
		questions = new Question[100];
		try {
			File file = new File("D:/GET2017Assignments/OOPs Assignment 2/src/Assignments/Input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			int count = 0;
			while ((line = bufferedReader.readLine()) != null && line!="") {
				Question question = new Question();
				question.questionNumber = count+1;
				String questionTypeOption = line.split("\\.")[1].trim();
				question.quest = questionTypeOption.split(",")[0].trim();
				question.type =  questionTypeOption.split(",")[1].trim();
				if (question.type.equals("Single Select") || question.type.equals("Multi Select")){
					String availableOptionsWithBracket = questionTypeOption.split(",")[2].trim();  // for choice type of question
					question.availableOptions = availableOptionsWithBracket.substring(1,availableOptionsWithBracket.length()-1).split("/");
				}else{
					question.availableOptions = new String[]{""};       // for text type of question
				}
				System.out.println(question.quest);
				questions[count] = question;
				count++;
			}
			numOfQuestions = count;
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Question[] getAllQuestionsOfSurvey(){
		return Arrays.copyOfRange(this.questions, 0, numOfQuestions);
	}
	
}

class Question{
	int questionNumber;  //should be unique.
	String quest;
	String type;
	String[] availableOptions;
	
	public Question(){
	questionNumber = 0;
	quest = "";
	type = "";
	availableOptions = new String[]{};
	}
	public String getType(){
		return this.type;
	}

	public String getQuestion(){
		return this.quest;
	}

	public String[] getAvailableOptions(){
		return this.availableOptions;
	}
}

// Report Class extends Survey as they both have same Questions field.
class Report extends Survey{
	//used to view report1 and report two
	public void reportOne(Participant[] participants){
		Question[] questions = super.getAllQuestionsOfSurvey();
		for(Question question: questions){
			if(question.getType().equals("Single Select")){
				System.out.println(question.getQuestion());
				Map<String, Integer> numberOfStudentsWithAnswer = new HashMap<String, Integer>();
				for (int i=0;i<question.availableOptions.length;i++){
					numberOfStudentsWithAnswer.put(question.availableOptions[i], 0);
				}
				for (Participant participant: participants){
					numberOfStudentsWithAnswer.put(participant.questionWithResponse.get(question.questionNumber)[0], new Integer((numberOfStudentsWithAnswer.get(participant.questionWithResponse.get(question.questionNumber)[0])+1)/participants.length)*100);
				}
				for (int j=0;j<question.availableOptions.length;j++){
					System.out.println(question.availableOptions[j]+" : "+numberOfStudentsWithAnswer.get(question.availableOptions[j])/participants.length);
				}
			}
		}
	}
	
	public void reportTwo(Participant[] participants){
		Survey survey = new Survey();
		Question[] questions = survey.getAllQuestionsOfSurvey();
		for(Question question: questions){
			if(question.getType().equals("Multi Select")){
				Map<String, String> responseResultWithParticipantNumber = new HashMap<String, String>();
				String participantNumber = "Participant";	
				for(int i=0;i<participants.length;i++){
					for(int j=0;j<question.getAvailableOptions().length;j++){
						String[] responseList = participants[i].questionWithResponse.get(question.questionNumber);
						if(Arrays.asList(responseList).contains(question.getAvailableOptions()[j])){
							participantNumber = participantNumber + " "+String.valueOf(participants[i].id)+",";
							responseResultWithParticipantNumber.put(question.getAvailableOptions()[j], new String(participantNumber));
							
						}
					}
				}
				String result = question.getQuestion()+"\n";
				for(int j=0;j<question.getAvailableOptions().length;j++){
					result = result + responseResultWithParticipantNumber.get(question.getAvailableOptions()[j])+" --> "+ question.getAvailableOptions()[j]+"\n";
				}
				BufferedWriter writer = null;
				try{
					writer = new BufferedWriter(new FileWriter("Report2.txt"));
					writer.write(result);
				}catch(IOException e){
					e.printStackTrace();
				}
				finally{
					try{
						if(writer !=null)
							writer.close();
					}catch(IOException e){
						
					}
				}	
			}
		}
	}

}