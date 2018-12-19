package task;// Please, do not use internet or any other sources of information during the test

// tast shouldn’t take more than 30 minutes
// There are 3 classes: Student, Subject and Mark
// - Fill the data according to the following conditions (use lists)
// 1. It is known that there are such students in the group: Valery Popov, Semyon Korzhev, Peter Ivanov, Maria Semenova and Kolya Nesterenko
// 2. Mathematics, Physics, Astronomy, History and Ethics are learned by this group and all subjects are mandatory excluding Ethics. It is optional.
// 3. Fill the data about marks if it is known that students have mark 3 for mandatory subjects and Maria has mark 5 for History and Ethics.
// 4. Please print results in a such way:
//   Popova Valeria Mathematics-1 Physics-2 Astronomy-0 History-1 Ethics-3 (do not display the subject info if there is no data about it)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        // inititalizing students and creating list of students
    	Student valery = new Student("Valery", "Popov");
    	Student semyon = new Student("Semyon", "Korzhev");
    	Student peter = new Student("Peter", "Ivanov");
    	Student maria = new Student("Maria", "Semenova");
    	Student kolya = new Student("Kolya", "Nesterenko");
    	List<Student> students = Arrays.asList(valery, semyon, peter, maria, kolya);
    	// inititalizing subjects and create list of subjects
    	Subject math = new Subject("Mathematics", true);
    	Subject physics = new Subject("Physics", true);
    	Subject astronomy = new Subject("Astronomy", true);
    	Subject history = new Subject("History", true);
    	Subject ethics = new Subject("Ethics", false);
    	List<Subject> subjects = Arrays.asList(math, physics, astronomy, history, ethics);
        // filling in the list of Marks
    	List<Mark> marks = new ArrayList<Mark>();
    	for (Student student: students) {
    		for(Subject subject: subjects) {
    			Mark mark = null;
    			if(student.getFirstName().equals("Maria") && (subject.getName().equals("History") || subject.getName().equals("Ethics"))){
    				 mark = new Mark(student, subject, 5);
    				 marks.add(mark);
    			} else if(subject.isMandatory()) {
    				 mark = new Mark(student, subject, 3);
    				 marks.add(mark);
    			} 
    		}
    	}
        // groupping map by students
    	 Map<Student, List<Mark>> groupByStudent = 
  				marks.stream().collect(Collectors.groupingBy(Mark::getStudent));
    	// displaying the result
    	 for (Map.Entry<Student, List<Mark>> entry : groupByStudent.entrySet()){
    	     System.out.println(entry.getKey() + ": " + entry.getValue());
    	 }
    }
}
