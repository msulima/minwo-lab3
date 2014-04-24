package pl.msulima.guesser.controllers;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import pl.msulima.guesser.domain.QuestionsService;
import pl.msulima.guesser.model.Question;

import java.util.ArrayList;
import java.util.List;

public class IndexControllerTest {

    IndexController indexController = new IndexController();

    ArrayList<Question> questions = Lists.newArrayList();

    QuestionsService questionsService = new QuestionsService() {

        @Override
        public List<Question> getPreviousQuestions() {
            return questions;
        }
    };

    @Test
    public void addsPreviousQuestionsToModel() {
        indexController.setQuestionsService(questionsService);
        ModelAndView modelAndView = indexController.index();

        Assert.assertEquals(questions, modelAndView.getModel().get("previousQuestions"));
    }
}
