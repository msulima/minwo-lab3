package pl.msulima.guesser.repository;

import org.springframework.stereotype.Component;
import pl.msulima.guesser.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class QuestionsRepositoryImpl implements QuestionsRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void setCurrentQuestion(Question question) {

    }

    @Override
    public Question getCurrentQuestion() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Question> getPreviousQuestions() {
        return em.createQuery("FROM Question").getResultList();
    }
}