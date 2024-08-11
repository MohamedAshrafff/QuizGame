public class User {
    private String user_name;
    private Integer HighScore;


    public User(String user_name, Integer HighScore) {
        this.user_name = user_name;
        this.HighScore = HighScore;
    }

    public String getUser_name() {
        return user_name;
    }

    public Integer getHighScore() {
        return HighScore;
    }

    public void setHighScore(Integer HighScore) {
        this.HighScore = HighScore;
    }
}
