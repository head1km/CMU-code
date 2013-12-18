/**
 * Roxanne Harris, Alexander Brya, Kyle Head, Ben Lubitz
 * Kyle Head
 * CPS 240
 * Assignment 8
 */
package angsty_Butterfliess;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * GradeSheetEditor performs basic edits on the Gradesheet class. It implements
 * the Editor interface. 
 *
 */
public class GradeSheetEditor extends GradeSheet implements Editor {

	GradeSheet gradesheet;
	public Student stud = new Student(); 
	public Course course = new Course();

	//opens an instance of gradesheet.
	public void Open() {
		  XMLDecoder d;
		  
			try {
				d = new XMLDecoder(
				          new BufferedInputStream(
				              new FileInputStream("GradeSheetTest.xml")));
				Object result = d.readObject();
				d.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

	//edits the student metadata.
	public void editStudent() {
		String newGlobalid = null;
		String newStudName = null;
		
		stud.setGlobalid(newGlobalid);
		stud.setName(newStudName);
	}
	
	//edits the course metadata.
	public void editCourse(){
		String newName = null;
		String newCrn = null;
		String newTerm = null;
		
		course.setCrn(newCrn);
		course.setName(newName);
		course.setTerm(newTerm);
	}
	
	//edits the assignment metadata.
	public void editMetadata(){
		String newDescription = null;
		String newDue = null;
		
		gsMetadata.setDescription(newDescription);
		gsMetadata.setDue(newDue);
	}
	
	//edits question metadata if there are questions, if not it makes them.
	public void editQuestions(Question question){
		String qDescription = null;
		int possiblePts = 0;
		int stuScore = 0;
		String comment = null;
		
		if(question != null){
			question.setDescription(qDescription);
			question.setPtsPossible(possiblePts);
		}
		else {
			calculateScore(qDescription,possiblePts,stuScore,comment);
		}
	}

	@Override
	public void save() {
		  try {        
		        OutputStream fout= new FileOutputStream("GradeSheetBackup.xml");
		        OutputStream bout= new BufferedOutputStream(fout);
		        OutputStreamWriter out 
		         = new OutputStreamWriter(bout, "8859_1");
		      
		        out.write("<?xml version=\"1.0\" ");
		        out.write("encoding=\"ISO-8859-1\"?>\r\n");  
		        out.write("userinput\r\n");  
		        for (int i = 1; i <= 10; i++) {
		          
		          out.write(toString());
		          
		        }
		      
		        
		        out.flush(); 
		        out.close();
		      }
		      catch (UnsupportedEncodingException e) {
		        System.out.println(
		         "It done did broke."
		        );
		      }
		      catch (IOException e) {
		        System.out.println(e.getMessage());        
		      }
	}
	
	//Opens a new gradesheet.
	@Override
	public GradeSheet create() {
		gradesheet = new GradeSheet();
		return gradesheet;
		
	}

	public void delete() {
		gradesheet = null;
		
	}

	public GradeSheet copy() {
		// TODO Auto-generated method stub
		return null;
	}
}