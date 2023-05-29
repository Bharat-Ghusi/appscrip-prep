package appscripprep.javaprep.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import appscripprep.javaprep.queue.Student;
import appscripprep.javaprep.queue.StudentNameComparator;

public class Exercise1805 {
//1.	Write a Java program to create an array list, add some colors (strings) and print out the collection.
	public static void solve1() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		System.out.println(list);
	}

//	2. Write a Java program to iterate through all elements in an array list.
	public static void solve2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
//1.	list.forEach(e -> System.out.println(e));
//2.	list.forEach(e->  {
//		if(e.equals("Red"))System.out.println(e);
//		});
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}

	}

//	3. Write a Java program to insert an element into the array list at the first position.
	public static void solve3() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		System.out.println(list);
		list.add(0, "White");
		System.out.println(list);

	}

	// [--------------Streams API demonstration-------------]
	public static void solve4() {
		// Demonstration of map method
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> square = nums.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(square);
		// Demonstration of filter
		List<Integer> evenNums = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Filter method: " + evenNums);

		// Demonstration of sorted method
		List<Student> student = List.of(new Student(1, "Rahul"), new Student(2, "Avilash"), new Student(3, "Bharat"));
		List<Student> sorted = student.stream().sorted(new StudentNameComparator()).collect(Collectors.toList());
		System.out.println("Sorted(): " + sorted);

		// Demonstration of forEach
		System.out.println("Demonstration of forEach");
		student.stream().sorted(new StudentNameComparator()).forEach(stud -> System.out.println(stud));

		// demonstration of reduce()
//		Here ans variable is assigned 0 as the initial value and i is added to it .
		Integer reduce = nums.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println(reduce);

	}

	// Stream.of(arr[]) vs Arrays.stream(arr[])
	public static void solve5() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// Demonstration of Arrays.stream()
		IntStream intStream = Arrays.stream(arr);
		intStream.forEach(x -> System.out.println(x));
		// Demonstration of Stream.of()
		Stream<int[]> stream = Stream.of(arr);
		IntStream flatMapToInt = stream.flatMapToInt(Arrays::stream);
		flatMapToInt.forEach(x -> System.out.println(x));

	}

//	Flatten a Stream of Arrays in Java using forEach loop
//	Input: arr[][] = {{ 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 }}
//	Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
	public static void solve6() {
		int arr[][] = { { 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 } };
		IntStream flatMapToInt = Arrays.stream(arr).flatMapToInt(Arrays::stream);
		flatMapToInt.forEach(e -> System.out.println(e));

		Arrays.stream(arr).forEach(e -> System.out.println(e));
	}

	class Employee {
		private String name;
		private String jobTitle;
		private long salary;

		public Employee(String name, String jobTitle, long salary) {
			super();
			this.name = name;
			this.jobTitle = jobTitle;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", jobTitle=" + jobTitle + ", salary=" + salary + "]";
		}

		public String getJobTitle() {
			return jobTitle;
		}

	}

	/*
	 * the task is to group an array of employee records into a data map organized
	 * by job title. Here is a traditional way to loop through the list and
	 * construct a data map.
	 */
	public static void solve7(List<Employee> empList) {
		HashMap<String, List<Employee>> map = new HashMap<>();
		for (Employee emp : empList) {
			List<Employee> orDefault = map.getOrDefault(emp.jobTitle, new ArrayList<>());
			orDefault.add(emp);
			map.put(emp.jobTitle, orDefault);
		}
		// Iterate
		Set<Entry<String, List<Employee>>> entrySet = map.entrySet();
		entrySet.forEach(s -> System.out.println(s));

	}

	// Do the above problem through Stream API
	public static void solve8(List<Employee> empList) {
//		Map<String, List<Employee>> map = empList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
		Map<String, List<Employee>> map = empList.stream().collect(Collectors.groupingBy(emp -> emp.jobTitle));
		// Iterate
		Set<Entry<String, List<Employee>>> entrySet = map.entrySet();
		entrySet.forEach(s -> System.out.println(s));

	}

	// Qn-calculate average salary of all employee in the list
	public static void solve9(List<Employee> empList) {
		Long asDouble = (long) empList.stream().mapToDouble(emp -> emp.salary).average().getAsDouble();
		System.out.println(asDouble);
	}

	// 9. Write a Java program to copy one array list into another.
	public static void solve10(List<Integer> list) {
		List<Integer> copyOf = List.copyOf(list);
		List<Integer> collect = list.stream().collect(Collectors.toList());
		System.out.println(copyOf);
		System.out.println(collect);

	}

//	11. Write a Java program to reverse elements in an array list.
	public static void solve11(List<Integer> list) {
		Collections.reverse(list);
		System.out.println(list);
	}

//	12. Write a Java program to extract a portion of an array list.
	public static void solve12(List<Integer> list) {
		List<Integer> subList = list.subList(0, 3);
		System.out.println(subList);
	}

//	13. Write a Java program to compare two array lists.
	public static void solve13(List<Integer> list1, List<Integer> list2) {

		System.out.println(list1.equals(list2));
	}

//	15. Write a Java program to join two array lists.
	public static void solve14(List<Integer> list1, List<Integer> list2) {
		list1.addAll(list2);
		
	}

	public static void main(String[] args) {
		Exercise1805 ex = new Exercise1805();
		List<Employee> list = new ArrayList<>();
		list.add(ex.new Employee("Avilash", "Android", 50000));
		list.add(ex.new Employee("Bharat", "iOS", 25000));
		list.add(ex.new Employee("Kunal", "Flutter", 30000));
		list.add(ex.new Employee("Shree", "WebApp", 40000));
		list.add(ex.new Employee("Jhon", "Gamer", 45000));
		list.add(ex.new Employee("Zgod", "Gamer", 80000));
		list.add(ex.new Employee("Shadow", "Gamer", 400000));

		solve12(List.of(1, 2, 3, 4, 5, 6, 7));
	}

}
