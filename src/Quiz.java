import java.util.ArrayList;
import java.util.List;


public class Quiz {
    private List<Question> questions_list;
    private QuizzesManager manager;

    public Quiz(QuizzesManager manager){
        this.manager = manager;
        questions_list = new ArrayList<Question>();
    }

    public List<Question> getQuestions(){
        return questions_list;
    }

    public void getQuizQuestions(){
            questions_list = manager.GetRandomQuestions();
    }

}
