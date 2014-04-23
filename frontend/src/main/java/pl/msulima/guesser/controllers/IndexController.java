package pl.msulima.guesser.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.msulima.guesser.dao.Answer;
import pl.msulima.guesser.domain.QuestionsService;
import pl.msulima.guesser.model.AnswerHint;
import pl.msulima.guesser.model.Question;

import java.util.HashMap;

@Controller
public class IndexController {

    @Autowired
    private QuestionsService questionsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("answer", new Answer());
        model.put("previousQuestions", questionsService.getPreviousQuestions());
        return new ModelAndView("index", model);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView index(@ModelAttribute("answer") Answer answer) {
        HashMap<String, Object> model = new HashMap<String, Object>();

        model.put("answer", answer);
        model.put("answerHint", questionsService.compareWithCurrentQuestion(answer.getAnswer()));
        model.put("previousQuestions", questionsService.getPreviousQuestions());

        return new ModelAndView("index", model);
    }
}