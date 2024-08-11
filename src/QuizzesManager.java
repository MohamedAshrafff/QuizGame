import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class QuizzesManager {
    private List<Question> questions_list;

    public QuizzesManager(){
        questions_list = new ArrayList<Question>();
    }

    public void LoadQuestionsFromTextFile(String file_name){

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\New folder\\JavaQuizGame\\src\\" + file_name))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String questionText = parts[0];
                List<String> options = List.of(parts[1], parts[2], parts[3], parts[4]);
                String correctAnswer = parts[5];
                questions_list.add( new Question(questionText, options, correctAnswer));
            }
        } catch (IOException e) {
            System.out.println("Try Again Later , Error occurred while loading questions from file: " + file_name);
        }
    }

    public List<Question> GetRandomQuestions(){
        Collections.shuffle(questions_list);
        Random rand = new Random();
        int start_index = rand.nextInt(questions_list.size()-10);
        return questions_list.subList(start_index , start_index+10);
    }
}
