package angsty_Butterflies;
//sdf
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * By Kyle Head
 * 
 * @author head1km
 * 
 */
public class TestWindow {

	private JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
					window.getFrmWelcome().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmWelcome(new JFrame());
		getFrmWelcome().setTitle("Welcome!");
		getFrmWelcome().setBounds(100, 100, 450, 300);
		getFrmWelcome().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(getFrmWelcome().getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE));

		JPanel Rubric = new JPanel();
		tabbedPane.addTab("Rubric Editor\r", null, Rubric, null);

		final JButton btnCreateRubric = new JButton("Create Rubric");
		btnCreateRubric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				if (source.equals(btnCreateRubric)) {
					TestGradesheet.main(null);
					getFrmWelcome().setVisible(false);
				}
			}
		});

		JButton btnEditRubric = new JButton("Edit Rubric");
		GroupLayout gl_Rubric = new GroupLayout(Rubric);
		gl_Rubric.setHorizontalGroup(gl_Rubric.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_Rubric.createSequentialGroup()
						.addContainerGap(101, Short.MAX_VALUE)
						.addComponent(btnCreateRubric).addGap(18)
						.addComponent(btnEditRubric).addGap(70)));
		gl_Rubric.setVerticalGroup(gl_Rubric.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_Rubric
								.createSequentialGroup()
								.addGap(81)
								.addGroup(
										gl_Rubric
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnEditRubric)
												.addComponent(btnCreateRubric))
								.addContainerGap(122, Short.MAX_VALUE)));
		Rubric.setLayout(gl_Rubric);

		JPanel Gradesheet = new JPanel();
		tabbedPane.addTab("Gradesheet Editor\r", null, Gradesheet, null);

		final JButton btnCreateGradesheet = new JButton("Create Gradesheet");
		btnCreateGradesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton source = (JButton) arg0.getSource();
				if (source.equals(btnCreateGradesheet)) {
					TestGradesheet.main(null);
					getFrmWelcome().setVisible(false);
				}
			}
		});

		final JButton btnEditGradesheet = new JButton("Edit Gradesheet");
		GroupLayout gl_Gradesheet = new GroupLayout(Gradesheet);
		gl_Gradesheet.setHorizontalGroup(gl_Gradesheet.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_Gradesheet.createSequentialGroup()
						.addContainerGap(59, Short.MAX_VALUE)
						.addComponent(btnCreateGradesheet).addGap(18)
						.addComponent(btnEditGradesheet).addGap(52)));
		gl_Gradesheet
				.setVerticalGroup(gl_Gradesheet
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_Gradesheet
										.createSequentialGroup()
										.addGap(65)
										.addGroup(
												gl_Gradesheet
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnEditGradesheet)
														.addComponent(
																btnCreateGradesheet))
										.addContainerGap(138, Short.MAX_VALUE)));
		Gradesheet.setLayout(gl_Gradesheet);
		getFrmWelcome().getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmWelcome() {
		return frmWelcome;
	}

	public void setFrmWelcome(JFrame frmWelcome) {
		this.frmWelcome = frmWelcome;
	}
}