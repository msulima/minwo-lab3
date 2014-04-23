package pl.msulima.guesser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.msulima.guesser.dao.Answer;
import pl.msulima.guesser.domain.QuestionsService;

@Controller
public class IndexController {

    @Autowired
    private QuestionsService questionsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "answer", new Answer());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView index(@ModelAttribute("answer") Answer answer) {
        return new ModelAndView("index", "answer", answer);
    }
}