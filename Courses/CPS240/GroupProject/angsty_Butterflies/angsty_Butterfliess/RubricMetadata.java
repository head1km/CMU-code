/*
 * Roxanne Harris Alex Brya, Ben lubitz, Kyle Head
 * Kyle Head
 * CPS 240
 * Assignment 8
 * 11/7/11
 */
package angsty_Butterfliess;

import java.util.Date;

public class RubricMetadata {

  private Course course;

  private Date issued;

  private String description;

  private Date due;
  
  private String assignNumber;

//  private String assignment;

  
  /**
 * @return the assignNumber
 */
public String getAssignNumber() {
	return assignNumber;
}

/**
 * @param assignNumber the assignNumber to set
 */
public void setAssignNumber(String assignNumber) {
	this.assignNumber = assignNumber;
}

//finds the course data
  public Course getCourse() {
	  return course;
  }
  
  	//Sets the course data to the metadata
  public void setCourse(Course currcourse) {
	  course = currcourse;
  }
  	// finds the date project was issued
  public Date getIssued() {
	  return issued;
  }
  	//sets the date the project was issued to metadata
  public void setIsuued(Date dateIssued) {
	  issued = dateIssued;
  }
  	//Finds projects Description
  public String getDescription() {
	  return description;
  }
  	//sets projects description to metadata
  public void setDescription(String aDescription) {
	  description = aDescription;
  }
  	// gets the due data
  public Date getDue() {
	  return due;
  }
  	//sets the due data to the metadata
  public void setDue(Date dateDue) {
	  due = dateDue;
	  
  }

}