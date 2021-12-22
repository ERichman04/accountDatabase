package accountDatabase;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import java.awt.*;
import javax.swing.SpringLayout;
public class database {
	
	public database() throws IOException {
		String username;
		String password;
		File f = new File("Database.txt");
		FileWriter fw = new FileWriter(f, true);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		PrintWriter pw = new PrintWriter(fw);
		encryption en = new encryption();
		//create the GUI
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,4));
		frame.setSize(800,600);
		//Create login text
		JLabel loginUsername = new JLabel("Enter username: ");
		JLabel loginPassword = new JLabel("Enter password: ");
		JLabel platformNameLabel = new JLabel("Enter Platform: ");
		//Create text fields
		JTextField loginUser = new JTextField("");
		JTextField loginPass = new JTextField("");
		JTextField platformText = new JTextField("");
		JTextArea accountShow = new JTextArea(50,50);
		JScrollPane scroll = new JScrollPane(accountShow);
		//Create Buttons
		JButton submit = new JButton("Submit");
		JButton openDoc = new JButton("Open file");
		//Create ActionListeners
		/*
		 * This ActionListener takes the username,password, and platform text parameters and encrypts them to the text file. Then it will append the given parameters to the text box for the user.
		 */
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (f.canRead()) {
					try {
//						pw.println(platformText.getText());
						pw.println(en.encrypt(loginUser.getText()));
						pw.println(en.encrypt(loginPass.getText()));
						pw.println(en.encrypt(platformText.getText()) + "\n");
						fw.flush();
						accountShow.append("Platform: " + platformText.getText()+"\n");
						accountShow.append("Username: " + loginUser.getText()+"\n");
						accountShow.append("Password: " + loginPass.getText()+"\n\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					loginUser.setText("");
					loginPass.setText("");
					platformText.setText("");
				}
			}
		});
		//write contents of file to textArea
		String line;
		while ((line = br.readLine()) != null) {
			accountShow.append(en.decrypt(line)+"\n");
		}
		//adding to panel
		panel.add(loginUsername);
		panel.add(loginUser);
		panel.add(loginPassword);
		panel.add(loginPass);
		panel.add(platformNameLabel);
		panel.add(platformText);
		panel.add(openDoc);
		panel.add(submit);
		panel.add(scroll);
		//GUI Finisher
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
	}
	
}
