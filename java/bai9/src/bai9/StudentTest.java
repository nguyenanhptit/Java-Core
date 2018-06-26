package bai9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
	public static java.util.List<Student> filter(java.util.List<Student> students, bai9.Filter<Student> pred) {
		List<Student> list = new ArrayList<Student>();
		for (Student student : students) {
			if (pred.valid(student))
				list.add(student);

		}
		return (java.util.List<Student>) list;

	}

	public static void main(String[] args) {
		java.util.List<Student> students = new ArrayList<Student>();
		students.add(new Student("Tran Van A", 23));
		students.add(new Student("Nguyen Thi B", 34));
		students.add(new Student("Ta Van C", 15));
		students.add(new Student("Nguyen Thi D", 46));

		// Stream<Student> stream= students.stream().filter(student->
		// student.getAge()>=30);
		// stream.forEach(student->System.out.println(student));

		// bai9.Filter<Student> older = student ->student.getAge()>=30;
		// java.util.List<Student> filtered = filter(students, older);
		// for(Student student:filtered) {
		// System.out.println(student);
		// }

		// Collections.sort(students, (Student student1,Student student2)->
		// student1.getAge()-student2.getAge());
		// students.forEach(student->System.out.println(student));

		
		Comparator<Student> comparator=(student1, student2)->student1.getAge()- student2.getAge();
		Stream<Student> stream = students.stream().sorted(comparator);
		stream.forEach(student->System.out.println(student));
				System.out.println("/n Max is " +students.stream().max(comparator));
				int sum= students.stream().mapToInt(Student::getAge).sum();
				System.out.println("Average of age is " + sum/students.size());
				Thread thread= new Thread();
				
				students.parallelStream().forEach((it)-> System.out.println(thread.getName() + "hello" + it.getName()));
	
	}
}
