package _01_File_Recorder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) throws IOException{
		String ans = JOptionPane.showInputDialog("Give me a message");
		FileWriter out = new FileWriter("textfile.txt");
		out.write(ans);
		out.close();
		
		BufferedReader br = new BufferedReader(new FileReader("textfile.txt"));
		System.out.println(br.readLine());
		br.close();
	}
}
