import java.util.*;
import java.io.*;

public class SurveyForm{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = 1;
		try{
			numberOfStudents = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Enter the valid input for number of students");
		}
		Participant[] participants = new Participant[numberOfStudents];
		for(int i=0;i<numberOfStudents;i++){
			participants[i] = new Participant();
			participants[i].askQuestion();
		}
		Report rp = new Report();
		rp.reportOne(participants);
		rp.reportTwo(participants);		

	}
}
class Participant{
	Map<Object, String[]> questionWithResponse = new HashMap<Object, String[]>();

	public Participant(){
		this.questionWithResponse = Collections.<Object, String[]>emptyMap();
	}	

	public void askQuestion(){
		Survey survey = new Survey();
		Question[] questions = survey.getAllQuestionsOfSurvey();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the response of Survey Questions one by one");
		for(int i=0;i<questions.length;i++){
			System.out.println(questions[i].quest);
			if(questions[i].type == "Text"){
				System.out.println("Enter your text repsonse");
				String textResponse = sc.nextLine();
				questionWithResponse.put(questions[i], new String[]{textResponse});
			}else if(questions[i].type=="Single Select"){
				System.out.print("Available Options: ");
				for(int j=0;j<questions[i].getAvailableOptions().length;i++){
					System.out.println(questions[i].getAvailableOptions()[j]);
				}
				String singleResponse;
				do{
					System.out.println("Enter your single select repsonse");
					singleResponse = sc.nextLine().trim();
				}while(!Arrays.asList(questions[i].getAvailableOptions()).contains(singleResponse));
				questionWithResponse.put(questions[i], new String[]{singleResponse});
			}else{
				String multipleResponseList[];
				System.out.print("Available Options: ");
				for(int j=0;j<questions[i].getAvailableOptions().length;i++){
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
					for(int j=0;i<multipleResponseList.length;j++){
						if(!Arrays.asList(questions[i].getAvailableOptions()).contains(multipleResponseList[j]))
							isPresent = false;
					}
				}while(!isPresent);
				questionWithResponse.put(questions[i], multipleResponseList);
			}

		}

	}	
}

class Survey{
	int numOfQuestions;
	Question[] questions;
	
	public Survey(){
		try {
			File file = new File("Input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			int count = 0;
			while ((line = bufferedReader.readLine()) != null && line!="") {
				Question question = new Question();
				question.questionNumber = count+1;
				String questionTypeOption = line.split(".")[1].trim();
				question.quest = questionTypeOption.split(",")[0].trim();
				question.type =  questionTypeOption.split(",")[1].trim();
				if (question.type == "Single Select" || question.type == "Multiple Select"){
					String availableOptionsWithBracket = questionTypeOption.split(",")[2].trim();  // for choice type of 																question
					question.availableOptions = availableOptionsWithBracket.substring(1,availableOptionsWithBracket.length()-1).split("/");
				}else{
					question.availableOptions = new String[]{""};       // for text type of question
				}
	
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
		return this.questions;
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

class Report{
	//used to view report1 and report two
	public void reportOne(Participant[] participants){
		Survey survey = new Survey();
		Question[] questions = survey.getAllQuestionsOfSurvey();
		
		for(Question question: questions){
			if(question.getType() == "Single Select"){
				System.out.println(question.getQuestion());
				Map<String, Integer> numberOfStudentsWithAnswer = new HashMap<String, Integer>();
				for (int i=0;i<question.availableOptions.length;i++){
					numberOfStudentsWithAnswer.put(question.availableOptions[i], 0);
				}
				for (Participant participant: participants){
					numberOfStudentsWithAnswer.put(participant.questionWithResponse.get(question)[0], numberOfStudentsWithAnswer.get(participant.questionWithResponse.get(question)[0])+1);
				}
				for (int j=0;j<question.availableOptions.length;j++){
					System.out.println(question.availableOptions[j]+" : "+numberOfStudentsWithAnswer.get(question.availableOptions[j]));
				}
			}
		}
	}
	
	public void reportTwo(Participant[] participants){
		Survey survey = new Survey();
		Question[] questions = survey.getAllQuestionsOfSurvey();
		for(Question question: questions){
			if(question.getType() == "Multiple Select"){
				Map<String, String> responseResultWithParticipantNumber = new HashMap<String, String>();
				String participantNumber = "Participant";	
				for(int i=0;i<participants.length;i++){
					for(int j=0;j<question.getAvailableOptions().length;j++){
						String[] responseList = participants[i].questionWithResponse.get(question);
						if(Arrays.asList(responseList).contains(question.getAvailableOptions()[j])){
							participantNumber = participantNumber + " "+String.valueOf(participants[i])+",";
							responseResultWithParticipantNumber.put(question.getAvailableOptions()[j], participantNumber);
							
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




















