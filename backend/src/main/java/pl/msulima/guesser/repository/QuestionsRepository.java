package pl.msulima.guesser.repository;

import pl.msulima.guesser.model.Question;

public interface QuestionsRepository {

    void setCurrentQuestion(Question question);

    Question getCurrentQuestion();
}