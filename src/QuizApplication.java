import java.util.Scanner;

public class QuizApplication {
    private User new_user;
    private QuizzesManager manager ;
    private Quiz quiz ;

    public QuizApplication() {
        manager = new QuizzesManager();
        quiz = new Quiz(manager);
    }

    public void welcomeMessage(){
        System.out.println("HELLO AND WELCOME TO OUR QUIZ GAME");
        System.out.println("Please Enter your username");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        new_user = new User(username ,0);
        System.out.println("Welcome " + new_user.getUser_name());
    }


    public void createQuiz(String file_name){
        manager.LoadQuestionsFromTextFile(file_name);
    }

    public void startQuiz(){
        quiz.getQuizQuestions();
        System.out.println("Let's play ");
        String numbering = "abcd"; int question_idx=1 , option_idx = 0 , correctAnswers = 0;

        for(Question question : quiz.getQuestions()){
            option_idx=0;
            System.out.println(question_idx + ") " +question.getQuestion());
            for(String option : question.getAnswer_options_list()){
                System.out.println(numbering.charAt(option_idx) + ") "+ option);
                option_idx++;
            }

            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if(answer.toLowerCase().equals(question.getAnswer())){
                correctAnswers++;
                System.out.println("Answer : " + answer + "  CORRECT :)" + "     Score = " + correctAnswers + "/10");
            }
            else System.out.println("Answer : " + answer + "  WRONG :(  Correct Answer is "+ question.getAnswer() + "     Score = " + correctAnswers + "/10");
            question_idx++;
        }
        if(correctAnswers > new_user.getHighScore()){
            new_user.setHighScore(correctAnswers);
            System.out.println("Great work you got a new HighScore "+  new_user.getHighScore() + " !!! " );
        }
        afterQuiz();
    }

    public void afterQuiz(){
        System.out.println("Play Again ? (Y/y)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.toLowerCase().equals("y")) startQuiz();
        else System.out.println("Thank you for playing :)");

    }

}
