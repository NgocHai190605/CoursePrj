/*
 *@ (#) Course.java        1.0     29/08/2024
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
public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;
    public Course(){

    }
    public Course(String id, String department,int credit, String title){
        this.id = id;
        this.department = department;
        this.credit = credit;
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if(credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.length() < 3)
            throw new IllegalArgumentException("Id must be at least 3 characters");
        for(int i = 0;i<id.length();i++){
            if(!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("Id must contain only letters or digits");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }
    @Override
    public String toString(){
        return String.format("%-10s %-30s %2s %-10s", id, title, credit, department);
    }
}
