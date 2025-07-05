import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class StartProject {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/main/resources/users.json"));

        JSONObject obj = (JSONObject) jsonArray.get(0);
        String adminName = obj.get("username").toString();
        String adminPassword = obj.get("password").toString();
        String adminRole = obj.get("role").toString();
        obj = (JSONObject) jsonArray.get(1);
        String userName = obj.get("username").toString();
        String userPassword = obj.get("password").toString();
        String userRole = obj.get("role").toString();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Username");
        String realName = scanner.nextLine();
        System.out.println("Enter Your Password");
        String realPassword = scanner.nextLine();
        System.out.println("Enter Your Role");
        String realRole = scanner.nextLine();

        if (realName.equals(adminName) && realPassword.equals(adminPassword) && realRole.equals(adminRole)){
            System.out.println("Welcome admin! Please create new questions in the question bank.");
            char ch = 'q';
                do {
                    jsonParser = new JSONParser();
                    Object obj2 = jsonParser.parse(new FileReader("./src/main/resources/quiz.json"));
                    jsonArray = (JSONArray) obj2;
                    JSONObject jsonObject = new JSONObject();
                    System.out.println("Please input your question");
                    jsonObject.put("Question" , scanner.nextLine());
                    System.out.println("Input Options");
                    System.out.println("Option a: ");
                    jsonObject.put("Option a " , scanner.nextLine());
                    System.out.println("Option b: ");
                    jsonObject.put("Option b " , scanner.nextLine());
                    System.out.println("Option c: ");
                    jsonObject.put("Option c " , scanner.nextLine());
                    System.out.println("Option d: ");
                    jsonObject.put("Option d " , scanner.nextLine());
                    System.out.println("Please input the correct answer");
                    jsonObject.put("answer" , scanner.nextLine());
                    jsonArray.add(jsonObject);

                    FileWriter fileWriter = new FileWriter("./src/main/resources/quiz.json");
                    fileWriter.write(jsonArray.toJSONString());
                    fileWriter.flush();
                    System.out.println("Saved successfully! Do you want to add more questions?(press s for start and q for quit)");
                    ch = scanner.nextLine().charAt(0);

                } while (ch == 's');
        }
        else if(realName.equals(userName) && realPassword.equals(userPassword) && realRole.equals(userRole)){
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Welcome salman to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
                char ch = scanner1.next().charAt(0);
                char ch1;
                do{
                    if(ch == 's' || ch == 'S'){
                        int count = 0;
                        jsonParser = new JSONParser();
                        Object objquiz = jsonParser.parse(new FileReader("./src/main/resources/quiz.json"));
                        jsonArray = (JSONArray) objquiz;
                        //           System.out.println(jsonArray.size());
                        for (int i = 1; i<=10; i++){
                            Random r = new Random();
                            int res = r.nextInt(jsonArray.size());
                            JSONObject jsonObject = (JSONObject) jsonArray.get(res);
                            String ques = (String) jsonObject.get("Question");
                            System.out.println(i+". "+ques);
                            String option1 = (String) jsonObject.get("Option a ");
                            System.out.println("a. "+option1);
                            String option2 = (String) jsonObject.get("Option b ");
                            System.out.println("b. "+option2);
                            String option3 = (String) jsonObject.get("Option c ");
                            System.out.println("c. "+option3);
                            String option4 = (String) jsonObject.get("Option d ");
                            System.out.println("d. "+option4);
                            System.out.println("Answer");
                            String useranswer = scanner.nextLine();
                            String jsonanswer = (String) jsonObject.get("answer");
                            if (useranswer.equals(jsonanswer)){
                                // System.out.println("Correct!");
                                count++;
                            }
//                    else {
//                        System.out.println("Not Correct!");
//                    }
                        }
                        if (count>=8){
                            System.out.println("Excellent! You have got "+count+ " out of 10");
                        } else if (count>=5) {
                            System.out.println("Good! You have got "+count+ " out of 10");
                        }
                        else if(count>=2){
                            System.out.println("Very poor! You have got "+count+ " out of 10");
                        }
                        else {
                            System.out.println("Very sorry you are failed! You have got "+count+ " out of 10");
                        }
                    } else {
                        System.out.println("You didn't press 's'. Existing the quiz");
                        break;
                    }
                    System.out.println("Would you like to start again? press s for start or q for quit");
                    ch1 = scanner1.next().charAt(0);
                } while(ch1 == 's');

        }
        else {
            System.out.println("Who are you?");
        }
    }
}
