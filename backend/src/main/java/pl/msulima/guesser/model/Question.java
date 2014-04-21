package pl.msulima.guesser.model;

import javax.persistence.Entity;

@Entity
public class Question {

    private int answer;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
