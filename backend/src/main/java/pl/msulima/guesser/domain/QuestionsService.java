package pl.msulima.guesser.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.msulima.guesser.model.AnswerHint;
import pl.msulima.guesser.model.Question;
import pl.msulima.guesser.repository.QuestionsRepository;

import java.util.List;
import java.util.Random;

@Service
public class QuestionsService {

    private final Random random = new Random();

    @Autowired
    private QuestionsRepository questionsRepository;

    @Transactional
    public AnswerHint compareWithCurrentQuestion(int answer) {
        Question currentQuestion = findCurrentQuestion();

        currentQuestion.setAttemptsCount(currentQuestion.getAttemptsCount() + 1);

        int correctAnswer = currentQuestion.getAnswer();
        if (answer < correctAnswer) {
            return AnswerHint.LESSER;
        } else if (answer == correctAnswer) {
            generateNextQuestion();
            return AnswerHint.EQUAL;
        }
        return AnswerHint.GREATER;
    }

    private Question findCurrentQuestion() {
        Question currentQuestion = questionsRepository.getCurrentQuestion();
        if (currentQuestion == null) {
            currentQuestion = generateNextQuestion();
        }
        return currentQuestion;
    }

    private Question generateNextQuestion() {
        Question currentQuestion = new Question();
        currentQuestion.setAnswer(random.nextInt(100));
        questionsRepository.setCurrentQuestion(currentQuestion);

        return currentQuestion;
    }

    public List<Question> getPreviousQuestions() {
        return questionsRepository.getPreviousQuestions();
    }

    public void setQuestionsRepository(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
}