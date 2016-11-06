import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Student {
	private String path;
	private int numOfLabs = 11;
	private double[] labs = new double[numOfLabs];
	private int numOfProjects = 3;
	private double[] projects = new double[numOfProjects];
	private int numOfExams = 6;
	private double[] exams = new double[numOfExams];
	private int numOfExtra = 7;
	private double[] extraCredits = new double[numOfExtra];
	private double labGrade;
	private double projectGrade;
	private double examGrade;
	private double extraCredit;
	private double labWeight = .20;
	private double projectWeight = .20;
	private double examWeight = .60;
	private double finalGrade;
	private String name;
	
	
	
	
	public Student(String name, String path) throws FileNotFoundException {
		this.name = name;
		this.path = path;
		this.readValues();
	}
	
	public double lab() {
		int labSum = 0;
		
		for (int i = 0; i < numOfLabs; i++) {
			labSum += labs[i];
		}
		double labGrade = (double)labSum / 200;
		return labGrade;
	}
	
	public double project() {
		int projectSum = 0;
		
		for (int i = 0; i < numOfProjects; i++) {
			projectSum += projects[i]; 
		}
		double projectGrade = (double)projectSum / 300;
		return projectGrade;
	}
	
	public double exam() {
		int examSum = 0;
		
		for (int i = 0; i < numOfExams; i++) {
			examSum += exams[i];
		}
		double examGrade = (double)examSum / 300;
		return examGrade;
	}
	
	public double extraCredit() {
		int exCrSum = 0;
		
		for (int i = 0; i < numOfExtra; i++) {
			exCrSum += extraCredits[i];
		}
		double extraCredit = (double)exCrSum / 500;
		return extraCredit;
	}
	
	public double finalGrade() {
		double finalGrade = ((labGrade * labWeight) + (projectGrade * projectWeight) + 
				(examGrade * examWeight)) + extraCredit;
		return finalGrade;
	}
	
	public void readValues() throws FileNotFoundException {
		Scanner filein = new Scanner(new File(path));
		
		for (int i = 0; i < numOfLabs; i++)
			labs[i] = filein.nextDouble();
		for (int i = 0; i < numOfProjects; i++)
			projects[i] = filein.nextDouble();
		for (int i = 0; i < numOfExams; i++)
			exams[i] = filein.nextDouble();
		for (int i = 0; i < numOfExtra; i++) 
			extraCredits[i] = filein.nextDouble();
		
		this.labGrade = lab();
		this.projectGrade = project();
		this.examGrade = exam();
		this.extraCredit = extraCredit();
		this.finalGrade = finalGrade();
	}
	
	public void debug() {
		System.out.println(labGrade);
		System.out.println(projectGrade);
		System.out.println(examGrade);
		System.out.println(extraCredit);
		System.out.println(finalGrade);
	}
	
	public void writeValues(String path, FileWriter report) throws IOException {
		FileWriter fw = new FileWriter(path);
		fw.write("" + (finalGrade * 100));
		report.write(name + " " + (finalGrade * 100) + "\n");
		fw.flush();
		fw.close();
	}
	
}
