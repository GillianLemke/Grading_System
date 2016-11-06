import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Grades {
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("./finalreport.txt");
		Scanner keyboard = new Scanner(System.in);
		String readFrom = "";
		String writeTo = "";
		String anotherStudent = "";
		String name = "";
		
		System.out.println("Enter the write-to directory for the student.");
		writeTo = keyboard.nextLine();

		
		do {
			
			System.out.println("Enter student's name.");
			name = keyboard.nextLine();
			System.out.println("Enter the read-from file for the student.");
			readFrom = keyboard.nextLine();

			Student student = new Student(name, readFrom);
			
			if (writeTo.endsWith("/"))
				student.writeValues(writeTo + "/" + name + ".txt", fw);
			else
				student.writeValues(writeTo + "/" + name + ".txt", fw);

			System.out.println("Would you like to calculate grades for another student? [y/n]");
			anotherStudent = keyboard.nextLine();
			
			// student.debug();
			
		}
		while(anotherStudent.equalsIgnoreCase("y"));
		
		fw.close();
	}
}