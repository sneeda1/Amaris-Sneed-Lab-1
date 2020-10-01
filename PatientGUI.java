import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class PatientGUI extends JFrame {

	ArrayList<Patient> plist;

	public PatientGUI(ArrayList<Patient> list) {

		plist = list;

		createPatientUI();

	}

	private void createPatientUI() {
		{
			JFrame jframe = new JFrame("Patient GUI");

			jframe.setLayout(null);

			JLabel pld = new JLabel("Patient's ID");

			pld.setBounds(10, 50, 150, 20);

			JTextField pldtxt = new JTextField(" ");

			pldtxt.setBounds(200, 50, 150, 20);

			JLabel pName = new JLabel("Name ");

			pName.setBounds(10, 80, 150, 20);

			JTextField pNametxt = new JTextField(" ");

			pNametxt.setBounds(200, 80, 150, 20);

			;

			JButton printToFileButton = new JButton("PrintToFile");

			printToFileButton.setBounds(10, 220, 70, 20);

			JButton populateButton = new JButton("Populate Patient's Details");

			populateButton.setBounds(100, 220, 150, 20);

			printToFileButton.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					// Get selected name from combox as shown below

					int id = Integer.parseInt(pldtxt.getText());

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

					int id = Integer.parseInt(pldtxt.getText());
					for (Patient p : plist) {

						if (id == p.id) {

							pNametxt.setText(p.name);

						}

					}

					// and populate the GUI with proper details

				}

			});

			jframe.add(pld);

			jframe.add(pldtxt);

			jframe.add(pName);

			jframe.add(pNametxt);

			jframe.add(populateButton);

			jframe.add(printToFileButton);

			jframe.setSize(400, 300);

			jframe.setVisible(true);

			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}
}
