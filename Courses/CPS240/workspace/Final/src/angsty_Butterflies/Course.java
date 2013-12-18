/*
 * Roxanne Harris
 * Kyle Head
 * Ben Lubitz
 * Alex Byra
 * CPS 240
 * 11/7/11
 */
package angsty_Butterflies;

/*
 * Keeps track of the information for courses such as the name, term, and sourse reference value.
 * To be used in conjuction with the metadata classes.
 */
public class Course {

	  private String cName;

	  private String term;

	  private String crn;

	//sets values for course name.
	  public void setName(String newName) {
		  this.cName = newName;
	  }
	  
	//sets term value.
	  public void setTerm(String newTerm) {
		  this.term = newTerm;
	  }

	  //sets a new CRN value.
	  public void setCrn(String newCrn) {
		  this.crn = newCrn;
	  }

	  //gets the course name.
	  public String getName() {
	  return this.cName;
	  }

	  //gets a term.
	  public String getTerm() {
	  return this.term;
	  }

	  //gest a new a crn
	  public String getCrn() {
	  return this.crn;
	  }

	}