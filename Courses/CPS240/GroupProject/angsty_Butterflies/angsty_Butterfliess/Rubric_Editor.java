package angsty_Butterfliess;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * By Kyle Head
 */

/**
 * @author head1km
 * 
 */
public class Rubric_Editor {

	private JFrame frmRubricEditor;
	private JTextField txtCourseName;
	private JTextField txtCourseTerm;
	private String newName = null;
	Course curCourse = new Course();
	private String newTerm = null;
	private String newCrn = null;
	private String newAssign = null;
	RubricMetadata rubData = new RubricMetadata();
	private String newDesc = null;
	private String date = null;
	private String month = "00";
	private String day = "00";
	private String year = "0000";
	private String ddate = null;
	private String dmonth = "00";
	private String dday = "00";
	private String dyear = "0000";
	Date curDate, dueDate;
	SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rubric_Editor window = new Rubric_Editor();
					window.getFrmRubricEditor().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rubric_Editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmRubricEditor(new JFrame());
		getFrmRubricEditor().setTitle("Rubric Editor");
		getFrmRubricEditor().setBounds(100, 100, 455, 524);
		getFrmRubricEditor().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblCourseName = new JLabel("Course Name:");

		JLabel lblNewLabel = new JLabel("Course Term:");

		JLabel lblCourseCrn = new JLabel("Course CRN:");

		JLabel lblAssignmentNumber = new JLabel("Assignment Number:");

		JLabel lblDateIssued = new JLabel("Date Issued:");

		JLabel lblDateDue = new JLabel("Date Due:");

		JLabel lblAssignmentDescription = new JLabel("Assignment Description:");

		JLabel lblQuestions = new JLabel("Questions:");

		txtCourseName = new JTextField();
		txtCourseName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField field = (JTextField) arg0.getSource();
				if(!field.isFocusOwner()) {
					newName = txtCourseName.getText();
					curCourse.setName(newName);
					rubData.setCourse(curCourse);
				}
			}
		});
		txtCourseName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == 10) {
					newName = txtCourseName.getText();
					curCourse.setName(newName);
					rubData.setCourse(curCourse);
				}
			}
		});
		lblCourseName.setLabelFor(txtCourseName);
		txtCourseName.setText("Course Name");
		txtCourseName.setColumns(10);

		final JFormattedTextField frmtdtxtfldCrn = new JFormattedTextField();
		frmtdtxtfldCrn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JFormattedTextField field = (JFormattedTextField) e.getSource();
				if(!field.isFocusOwner()) {
					newCrn = frmtdtxtfldCrn.getText();
					curCourse.setCrn(newCrn);
					rubData.setCourse(curCourse);
				}
			}
		});
		frmtdtxtfldCrn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == 10) {
					newCrn = frmtdtxtfldCrn.getText();
					curCourse.setCrn(newCrn);
					rubData.setCourse(curCourse);
				}
			}
		});
		lblCourseCrn.setLabelFor(frmtdtxtfldCrn);
		frmtdtxtfldCrn.setText("CRN");

		txtCourseTerm = new JTextField();
		txtCourseTerm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField field = (JTextField) arg0.getSource();
				if(!field.isFocusOwner()) {
					newTerm = txtCourseTerm.getText();
					curCourse.setTerm(newTerm);
					rubData.setCourse(curCourse);
				}
			}
		});
		txtCourseTerm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == 10) {
					newTerm = txtCourseTerm.getText();
					curCourse.setTerm(newTerm);
					rubData.setCourse(curCourse);
				}
			}
		});
		lblNewLabel.setLabelFor(txtCourseTerm);
		txtCourseTerm.setText("Course Term");
		txtCourseTerm.setColumns(10);

		final JFormattedTextField frmtdtxtfldAssignment = new JFormattedTextField();
		frmtdtxtfldAssignment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JFormattedTextField field = (JFormattedTextField) e.getSource();
				if(!field.isFocusOwner()) {
					newAssign = frmtdtxtfldAssignment.getText();
					rubData.setAssignNumber(newAssign);
				}
			}
		});
		frmtdtxtfldAssignment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				System.out.print(key);
				if (key == 10) {
					newAssign = frmtdtxtfldAssignment.getText();
					rubData.setAssignNumber(newAssign);
				}
			}
		});
		lblAssignmentNumber.setLabelFor(frmtdtxtfldAssignment);
		frmtdtxtfldAssignment.setText("Assignment #");

		JComboBox issuedMonth = new JComboBox();
		issuedMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox box = (JComboBox) arg0.getSource();
				month = (String) box.getSelectedItem();
				date = month + "/" + day + "/" + year;
				try {
					curDate = format.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rubData.setIsuued(curDate);
			}
		});
		issuedMonth.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

		JComboBox issuedDay = new JComboBox();
		issuedDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox box = (JComboBox) arg0.getSource();
				day = (String) box.getSelectedItem();
				date = month + "/" + day + "/" + year;
				try {
					curDate = format.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rubData.setIsuued(curDate);
			}
		});
		issuedDay.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		JComboBox issuedYear = new JComboBox();
		issuedYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				year = (String) box.getSelectedItem();
				date = month + "/" + day + "/" + year;
				try {
					curDate = format.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rubData.setIsuued(curDate);
				System.out.println(rubData.getIssued());
			}
		});
		issuedYear.setModel(new DefaultComboBoxModel(new String[] { "2011",
				"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
				"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027",
				"2028", "2029", "2030" }));

		JComboBox dueMonth = new JComboBox();
		dueMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				dmonth = (String) box.getSelectedItem();
				ddate = dmonth + "/" + dday + "/" + dyear;
				try {
					dueDate = format.parse(ddate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rubData.setDue(dueDate);
			}
		});
		dueMonth.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

		JComboBox dueDay = new JComboBox();
		dueDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				dday = (String) box.getSelectedItem();
				ddate = month + "/" + day + "/" + year;
				try {
					dueDate = format.parse(ddate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rubData.setDue(dueDate);
			}
		});
		dueDay.setModel(new DefaultComboBoxModel(new String[] { "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		JComboBox dueYear = new JComboBox();
		dueYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				dyear = (String) box.getSelectedItem();
				ddate = month + "/" + day + "/" + year;
				try {
					dueDate = format.parse(ddate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rubData.setDue(dueDate);
			}
		});
		dueYear.setModel(new DefaultComboBoxModel(new String[] { "2011",
				"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
				"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027",
				"2028", "2029", "2030" }));

		final JTextPane txtpnEnterDescription = new JTextPane();
		txtpnEnterDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JTextPane pane = (JTextPane) e.getSource();
				if(!pane.isFocusOwner()) {
					newDesc = txtpnEnterDescription.getText();
					rubData.setDescription(newDesc);
				}
			}
		});
		txtpnEnterDescription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == 10) {
					newDesc = txtpnEnterDescription.getText();
					rubData.setDescription(newDesc);
				}
			}
		});
		lblAssignmentDescription.setLabelFor(txtpnEnterDescription);
		txtpnEnterDescription.setText("Enter Description");

		JButton btnAddAQuestion = new JButton("Add A Question");
		btnAddAQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0 != null) {
					TestQuestion.main(null);
					getFrmRubricEditor().setVisible(false);
				}
			}
		});
		lblQuestions.setLabelFor(btnAddAQuestion);
		
		JLabel lblMonth = new JLabel("Month:");
		
		JLabel lblDay = new JLabel("Day:");
		
		JLabel lblYear = new JLabel("Year:");
		
		JLabel lblPressEnterAfter = new JLabel("Press enter after each selection below");
		GroupLayout groupLayout = new GroupLayout(getFrmRubricEditor()
				.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnEnterDescription, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQuestions)
							.addGap(18)
							.addComponent(btnAddAQuestion)
							.addGap(193))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDateDue)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(dueMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblAssignmentDescription))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(dueDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(dueYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDateIssued)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(issuedMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(issuedDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDay))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblYear)
										.addComponent(issuedYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(82))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(txtCourseTerm, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAssignmentNumber)
										.addComponent(lblMonth))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(frmtdtxtfldAssignment, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCourseCrn)
									.addGap(18)
									.addComponent(frmtdtxtfldCrn, 293, 293, 293))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblCourseName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPressEnterAfter)
										.addComponent(txtCourseName, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))))
							.addGap(32))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPressEnterAfter)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourseName)
						.addComponent(txtCourseName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtCourseTerm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(frmtdtxtfldCrn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourseCrn))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAssignmentNumber)
						.addComponent(frmtdtxtfldAssignment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonth)
						.addComponent(lblDay)
						.addComponent(lblYear))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(issuedYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(issuedDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(issuedMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateIssued))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateDue)
						.addComponent(dueMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dueDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dueYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAssignmentDescription)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnEnterDescription, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuestions)
						.addComponent(btnAddAQuestion))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		getFrmRubricEditor().getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmRubricEditor() {
		return frmRubricEditor;
	}

	public void setFrmRubricEditor(JFrame frmRubricEditor) {
		this.frmRubricEditor = frmRubricEditor;
	}
}