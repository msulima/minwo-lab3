package pl.msulima.guesser.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.msulima.guesser.model.AnswerHint;
import pl.msulima.guesser.model.Question;
import pl.msulima.guesser.repository.QuestionsRepository;

import java.util.Random;

@Service
public class QuestionsService {

    private final Random random = new Random();

    private QuestionsRepository questionsRepository;

    public AnswerHint compareWithCurrentQuestion(int answer) {
        Question currentQuestion = findCurrentQuestion();

        int correctAnswer = currentQuestion.getAnswer();
        if (answer < correctAnswer) {
            return AnswerHint.LESSER;
        } else if (answer == correctAnswer) {
            return AnswerHint.EQUAL;
        }
        return AnswerHint.GREATER;
    }

    private Question findCurrentQuestion() {
        Question currentQuestion = questionsRepository.getCurrentQuestion();
        if (currentQuestion == null) {
            currentQuestion = new Question();
            currentQuestion.setAnswer(random.nextInt(100));
            questionsRepository.setCurrentQuestion(currentQuestion);
        }
        return currentQuestion;
    }

    @Autowired
    public void setQuestionsRepository(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
}