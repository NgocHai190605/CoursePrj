/*
 *@ (#) TestCourse.java        1.0     29/08/2024
 *
 *Copyright (c) 2024 IUH. All right reserved.
 */
package iuh.cntt.ktpm;

/*
 * @description:
 * @author:   Hoang Ngoc Hai
 * @date:     29/08/2024
 * @version:     1.0
 */
import java.util.Scanner;
public class TestCourse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 -> {

                }
                default ->
                        System.out.println("Invalid choice!");
            }
        } while (choice != 0);

    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
        Course course5 = new Course("FIT105", "Software Engineering", 3, "FIT");
        Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "FIT");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "FIT");
//        Course course9 = new Course("FIT109", "Computer Vision", 3, "FIT");
//        Course course10 = new Course("FIT110", "Natural Language Processing", 3, "FIT");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }
}