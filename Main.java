import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        try {
            hireDate = sdf.parse("2024-12-25");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        Employe emp = new Employe("amara", 19, 200, true, new String[] { "Java", "Python", "JavaScript" }, hireDate);
        emp.setHireDate(new Date());

        // emp.setName("Amara");
        // emp.setAge(19);
        // emp.setSalary(200);
        // emp.setActive(false);
        // emp.setSkills(new String[] { "Java", "Python", "JavaScript" });

        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: " + emp.getSalary() + " USD/day");
        System.out.println("Employee is " + (emp.isActive() ? "active" : "inactive"));
        System.out.println("Skills: " + String.join(", ", emp.getSkills()));
        System.out.println("Hire Date: " + emp.getHireDate());
    }
}
