package pl.msulima.guesser.domain

import org.scalatest.{FunSpec, ShouldMatchers}
import pl.msulima.guesser.model.{Question, AnswerHint}
import pl.msulima.guesser.repository.QuestionsRepository
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class QuestionsServiceTest extends FunSpec with ShouldMatchers {

  var answer: Int = _

  var question: Question = _

  val questionRepositoryStub = new QuestionsRepository {
    override def getCurrentQuestion =
      question

    override def setCurrentQuestion(q: Question) = {
      question = q
      answer = q.getAnswer
    }

    override def getPreviousQuestions = ???
  }

  val questionService = new QuestionsService
  questionService.setQuestionsRepository(questionRepositoryStub)

  describe("QuestionService") {
    it("should create Question if it doesn't exist yet") {
      questionService.compareWithCurrentQuestion(0)
      question should not be null
    }

    it("should increate Question's attempts count") {
      val attemptsCount = question.getAttemptsCount
      questionService.compareWithCurrentQuestion(0)
      question.getAttemptsCount should be(attemptsCount + 1)
    }

    it("should return LESSER hint, if passed number is lesser than correct answer") {
      questionService.compareWithCurrentQuestion(answer - 1) should be(AnswerHint.LESSER)
    }

    it("should return GREATER hint, if passed number is greater than correct answer") {
      questionService.compareWithCurrentQuestion(answer + 1) should be(AnswerHint.GREATER)
    }

    it("should return EQUAL hint, if passed number is equal to correct answer") {
      questionService.compareWithCurrentQuestion(answer) should be(AnswerHint.EQUAL)
    }
  }
}