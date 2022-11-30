package lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Competitive_Exam {

	public static void main(String[] args) {
		List<course> listOfCourse = new ArrayList<>();
		List<course> courseList = Arrays.asList(new course(1, "JEE", "Ram", 6, 150000),
				new course(2, "JEE", "Seetha", 5, 130000), new course(3, "CAT", "Hanuman", 4, 120000),
				new course(4, "NEET", "Mike", 3, 150000), new course(6, "JEE", "Miya", 4, 100000),
				new course(7, "JEE", "Mike", 3, 90000), new course(8, "NEET", "Miya", 7, 160000),
				new course(9, "CAT", "Hanuman", 8, 170000), new course(10, "JEE", "Ram", 7, 150000),
				new course(11, "NEET", "Ram", 4, 110000), new course(12, "CAT", "Seetha", 6, 140000),
				new course(13, "CAT", "Ram", 3, 80000), new course(14, "NEET", "Seetha", 8, 150000),
				new course(15, "JEE", "Ram", 8, 130000), new course(16, "NEET", "Ram", 5, 110000),
				new course(17, "JEE", "Mike", 3, 70000));

		Collections.sort(courseList, (courseA, courseB) -> courseA.getTotal_fees() < courseB.getTotal_fees() ? 1
				: courseA.getTotal_fees() > courseB.getTotal_fees() ? -1 : 0);
		courseList.forEach(course -> System.out.println(course));
		
		Map<Double, List<course>> courseMap = courseList.stream()
				.collect(Collectors.groupingBy(course::getTotal_fees, TreeMap::new, Collectors.toList()));

		courseMap.values().forEach(list -> list.sort(Comparator.comparing(course::getDuration)));

		List<course> courseLists = courseMap.values().stream().collect(Collectors.toList()).stream()
				.flatMap(List::stream).collect(Collectors.toList());

		System.out.println("=========================");

		courseLists.forEach(course -> System.out.println(course));

	}
}
