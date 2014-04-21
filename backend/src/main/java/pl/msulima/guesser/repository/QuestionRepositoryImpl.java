package pl.msulima.guesser.repository;

import org.springframework.stereotype.Component;
import pl.msulima.guesser.model.Question;

@Component
public class QuestionRepositoryImpl implements QuestionsRepository {

    @Override
    public void setCurrentQuestion(Question question) {

    }

    @Override
    public Question getCurrentQuestion() {
        return null;
    }
}