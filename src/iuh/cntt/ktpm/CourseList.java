package iuh.cntt.ktpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/*
 * @description:
 * @author:   Hoang Ngoc Hai
 * @date:     29/08/2024
 * @version:     1.0
 */
public class CourseList {
    private static int count = 0;
    private Course[] courses;

    // Constructor
    public CourseList(int size) {
        courses = new Course[size];
    }

    public boolean addCourse(Course course) {
        if (course == null)
            return false;
        if (exists(course))
            return false;
        if (count == courses.length)
            return false;
        courses[count++] = course;
        return true;
    }

    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equals(course.getId()))
                return true;
        }
        return false;
    }

    public String DepartmentWithMostCourse() {
        HashMap<String, Integer> departmentCount = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }

        return departmentCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Course[] findMaxCreditCourse() {
        if (count == 0) return null;

        int maxCredits = courses[0].getCredit();
        ArrayList<Course> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > maxCredits) {
                maxCredits = courses[i].getCredit();
                result.clear();
                result.add(courses[i]);
            } else if (courses[i].getCredit() == maxCredits) {
                result.add(courses[i]);
            }
        }

        return result.toArray(new Course[0]);
    }

    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equals(id)) {
                courses[i] = courses[count - 1];
                courses[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public Course[] searchCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equals(id)) {
                return new Course[]{courses[i]};
            }
        }
        return null;
    }

    public Course[] searchCourseByDepartment(String department) {
        ArrayList<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getDepartment().equalsIgnoreCase(department)) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    public Course[] searchCourseByTitle(String title) {
        ArrayList<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    public Course[] sortCourses() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, (c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));
        return sortedCourses;
    }

    public Course[] getCourses() {
        return Arrays.copyOf(courses, count);
    }
}
