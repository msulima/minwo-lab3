package pl.msulima.guesser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private int id;
    private int answer;
    private int attemptsCount;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(int attemptsCount) {
        this.attemptsCount = attemptsCount;
    }
}
