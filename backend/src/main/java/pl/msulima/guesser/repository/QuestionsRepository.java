package pl.msulima.guesser.repository;

import pl.msulima.guesser.model.Question;

import java.util.List;

public interface QuestionsRepository {

    void setCurrentQuestion(Question question);

    Question getCurrentQuestion();

    List<Question> getPreviousQuestions();
}