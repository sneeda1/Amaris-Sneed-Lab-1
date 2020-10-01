import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class Patient extends JFrame {
    String name;
	int id;

	public Patient(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name=name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	ArrayList<Patient> plist;
	String[] Patient = { "aaa","bbb","ccc","ddd","eee"};
	
	
	

	public Patient(ArrayList<Patient> list) {

		plist = list;

		createPatient();

	}

	private void createPatient () {
		{
			JFrame jframe = new JFrame("Patient");

			jframe.setLayout(null);

			JLabel pld = new JLabel("Patient's ID");

			pld.setBounds(10, 50, 150, 20);

			final JComboBox comboBox = new JComboBox(); 
			comboBox.addItem("Select");
			comboBox.addItem("Patient 1");
			comboBox.addItem("Patient 2");
			comboBox.addItem("Patient 3");
			comboBox.addItem("Patient 4");
			comboBox.addItem("Patient 5");

			comboBox.setBounds(200, 50, 150, 20);

			JLabel pName = new JLabel("Name ");

			pName.setBounds(10, 80, 150, 20);

			JTextField pNametxt = new JTextField(" ");

			pNametxt.setBounds(200, 80, 150, 20);

			;

			JButton printToFileButton = new JButton("PrintToFile");

			printToFileButton.setBounds(10, 220, 70, 20);

			JButton populateButton = new JButton("Populate Patient's Details");

			populateButton.setBounds(100, 220, 150, 20);
			JButton exitButton = new JButton("Exit");
			exitButton.setBounds(270, 220 , 85, 20);

			printToFileButton.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					// Get selected name from combox as shown below

					int id = Integer.parseInt(pld.getText());

					// go through the Player array list,

					// print the details of the selected Player to a file.
					for (Patient p : plist) {

						if (id == p.id) {

							try {
								PrintWriter fw = new PrintWriter("patient.txt");
								fw.write(p.toString());

								fw.close();
							} catch (Exception ec) {

								System.out.println(" " + ec);

							}

						}

					}
				}

			}

			);

			populateButton.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					// Get selected name from combox, go through the Player array list,

					int id = Integer.parseInt(pld.getText());
					for (Patient p : plist) {

						if (id == p.id) {

							pNametxt.setText(p.name);

						}

					}

					// and populate the GUI with proper details

				}
				
				

			});

			jframe.add(pld);
			
			

			

			jframe.add(pName);

			jframe.add(pNametxt);

			jframe.add(populateButton);

			jframe.add(printToFileButton);
			jframe.add(exitButton);
			jframe.add(comboBox);

			jframe.setSize(400, 300);

			jframe.setVisible(true);
			
			
			


                        exitButton.addActionListener(e -> System.exit(0));

		}
	}
}