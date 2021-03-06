package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager.
	 * Use any key you want (1 - 25) to shift each letter in the users input and save the final result to a file.
	 */
	
	public static void main(String[] args) throws IOException {
		String ans = JOptionPane.showInputDialog("message");
		FileWriter out = new FileWriter("file.txt");
		out.write(encrypt(ans));
		out.close();
	}
	
	static String encrypt(String s) {
		String encry = "";
		for(int i=0;i<s.length();i++) {
			char c = (char) (s.charAt(i)+4);
			encry += c;
		}	
		return encry;
	}
}
