/*
 * Roxanne Harris, Alex Brya, Ben lubitz, Kyle Head
 * Kyle Head
 * CPS 240
 * Assignment 8
 * 11/7/11
 */
package angsty_Butterfliess;

public class Rubric {

  private RubricMetadata metadata;
  public static Question[] questions = new Question[50];
  static QuestionFactory qFactory;
  private int questionsMade = 0;
  private static int totalPtsPossible;
  
  Rubric(){
	  super();
  }
  Rubric(Course currcourse) {
	  metadata.setCourse(currcourse);
  }
  // method that will find and create the questions for The Rubric to follow
  public void createQuestion(String qDescription, int possiblePts) {
	  questions[questionsMade] = qFactory.getQuestion(qDescription, possiblePts);
	  totalPtsPossible += possiblePts;
	  questionsMade++;
  }
  // finds total number of point possible on the assignment
  public int getTotalPtsPossible() {
	  return totalPtsPossible;
  }
  
}