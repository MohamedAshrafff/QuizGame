import java.util.List;

public class Question {
    private String question;
    private List<String> answer_options_list;
    private String answer;

    public Question(String question, List<String> answer_options, String answer) {
        this.question = question;
        this.answer_options_list = answer_options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswer_options_list() {
        return answer_options_list;
    }

    public String getAnswer() {
        return answer;
    }

}
