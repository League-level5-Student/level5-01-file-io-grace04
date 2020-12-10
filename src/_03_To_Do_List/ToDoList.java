package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
		JFrame frame = new JFrame();
		JButton at = new JButton("add task"), vt = new JButton("view task"), rt = new JButton("remove task"),
			sl = new JButton("save list"), ll = new JButton("load list");
		frame.add(at);
		frame.add(vt);
		frame.add(rt);
		frame.add(sl);
		frame.add(ll);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		String s = reader.readLine();
		while(!s.isEmpty()) {
			list.add(s);
			s = reader.readLine();
		}
		reader.close();
		
		at.addActionListener(e -> {
			String ans = JOptionPane.showInputDialog("task to add");
			list.add(ans);
		});
		vt.addActionListener(e -> {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		});
		rt.addActionListener(e -> {
			String ans = JOptionPane.showInputDialog("task to remove");
			list.remove(ans);
		});
		sl.addActionListener(e -> {
			PrintWriter out;
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("list.txt")));
				for(int i=0;i<list.size();i++) {
					out.write(list.get(i)+"\n");
				}
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		ll.addActionListener(e -> {
			String ans = JOptionPane.showInputDialog("file to read");
			try {
				BufferedReader read = new BufferedReader(new FileReader(ans));
				String str = reader.readLine();
				while(!str.isEmpty()) {
					list.add(str);
					str = read.readLine();
				}
				read.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
}
