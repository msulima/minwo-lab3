package pl.msulima.guesser.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.msulima.guesser.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class QuestionsRepositoryImpl implements QuestionsRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void setCurrentQuestion(Question question) {
        em.persist(question);
        em.flush();
    }

    @Override
    public Question getCurrentQuestion() {
        List<Question> allQuestions = getAllQuestions();

        if (allQuestions.isEmpty()) {
            return null;
        }
        return allQuestions.get(allQuestions.size() - 1);
    }

    @Override
    public List<Question> getPreviousQuestions() {
        List<Question> allQuestions = getAllQuestions();

        if (allQuestions.isEmpty()) {
            return allQuestions;
        }
        return allQuestions.subList(0, allQuestions.size() - 1);
    }

    @SuppressWarnings("unchecked")
    private List<Question> getAllQuestions() {
        return em.createQuery("FROM Question").getResultList();
    }
}