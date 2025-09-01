import java.util.Scanner;

class Student 
{
	private String studentName;
	private Integer[] marks; // Wrapper type for Autoboxing

	public Student(String studentName, int numberOfSubjects) 
	{
		this.studentName = studentName;
		this.marks = new Integer[numberOfSubjects];
	}
	public void enterMarks(Scanner sc) 
	{
		System.out.println("Enter marks for " + studentName + ":");
		for (int i=0; i<marks.length; i++) 
		{
			while (true) 
			{
				try 
				{
					System.out.print("Subject " + (i + 1) + " Marks: ");
					int mark = sc.nextInt(); // primitive int
					if (mark<0 || mark>100)
						throw new IllegalArgumentException("Marks must be between 0 and 100.");
					 
					marks[i] = mark; // Autoboxing int → Integer
					break;
				} 
				catch (Exception e) 
				{
					System.out.println("Invalid input! Please enter a valid number (0-100).");
					sc.nextLine(); // clear buffer
				}
			}
		}
	}
	public double calculateAverage() 
	{
		int sum = 0;
		for (Integer m : marks) 
			sum += m; // Unboxing Integer → int
		
		return (double) sum / marks.length;
	}
	
	public int getHighestMark() 
	{
		int highest = marks[0]; // Unboxing
		for(Integer m : marks) 
		{
			if (m > highest) 
				highest = m;
		}
		return highest;
	}
	
	public int getLowestMark() 
	{
		int lowest = marks[0]; // Unboxing
		for (Integer m : marks) 
		{
			if (m < lowest) 
				lowest = m;
		}
		return lowest;
	}
	
	public void displayReport() 
	{
		System.out.println("\n===== Report Card =====");
		System.out.println("Student: " + studentName);
		System.out.print("Marks: ");
		for (Integer m : marks)
			System.out.print(m + " ");
	 
		System.out.println("\nAverage: " + calculateAverage());
		System.out.println("Highest: " + getHighestMark());
		System.out.println("Lowest : " + getLowestMark());
	}
}

public class StudentMgmt_Autoboxing
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentCount = Integer.parseInt(sc.nextLine()); // ✅ read as line, then parse

        Student[] students = new Student[studentCount];
        for (int i=0; i<studentCount; i++) 
        {
            System.out.print("\nEnter name of Student " + (i + 1) + ": ");
            String name = sc.nextLine(); // ✅ will correctly read full name

            System.out.print("Enter number of subjects for " + name + ": ");
            int subjectCount = Integer.parseInt(sc.nextLine()); // ✅ read line, then parse

            students[i] = new Student(name, subjectCount);
            students[i].enterMarks(sc);
            sc.nextLine(); 
        }

        // Display all reports
        System.out.println("\n========= All Students Report=========");
        for (Student s : students)
            s.displayReport();

        sc.close();
    }
}
