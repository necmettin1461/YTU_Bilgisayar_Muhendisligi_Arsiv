package nyp10c;
import java.util.*;

/* Example of using a primitive key that is automatically transformed 
 * to its Wrapper (auto-boxing in Java terminology).
 * */
public class Course { 
	private String code; private String name; private int capacity;
	private HashMap<Integer,Student> students;

	public Course(String code, String name, int capacity) {
		this.code = code; this.name = name; this.capacity = capacity;
		students = new HashMap<Integer,Student>();
	}
	public String getCode() { return code; }
	public String getName() { return name; }
	public int getCapacity() { return capacity; }
	public int getStudentCount() { 
		return students.size(); 
	}
	public boolean addStudent( Student aStudent ) {
		if( getStudentCount() == capacity || 
				findStudent(aStudent.getNumber()) != null ) 
			return false;
		students.put(aStudent.getNumber(), aStudent);
		return true;
	}
	public Student findStudent( int number ) { //autoboxing: Automatic Wrapping
		return students.get(number);
	}
	public void increaseCapacity( int newCapacity ) {
		if( newCapacity <= capacity )
			return;
		capacity = newCapacity;
	}
	public void showClassList( ) {
		System.out.println("Class List of "+code+" "+name);
		System.out.println("Student#  Name, Surname");
		System.out.println("--------  -----------------------------");
		for( Student aStudent : students.values() )
			System.out.println(aStudent.getNumber()+
			" " + aStudent.getName());
	}
}
