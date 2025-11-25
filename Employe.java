import java.util.Arrays;
import java.util.Date;

public class Employe {
    private String name;
    private int age;
    private double salary;
    private boolean active;
    private String[] skills;
    private Date hireDate;

    public Employe(String name, int age, double salary, boolean active, String[] skills, Date hireDate) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
        this.setActive(active);
        this.setSkills(skills);
        this.setHireDate(hireDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be positive");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String[] getSkills() {
        return Arrays.copyOf(skills, skills.length);
    }

    public void setSkills(String[] skills) {
        this.skills = Arrays.copyOf(skills, skills.length);
    }

    public Date getHireDate() {
        return hireDate == null ? null : new Date(hireDate.getTime());
    }

    public void setHireDate(Date hireDate) {
        if (hireDate == null) {
            this.hireDate = null;
        } else {
            Date today = new Date();
            // ✅ Validasi: hireDate tidak boleh melebihi tanggal sekarang
            if (hireDate.after(today)) {
                throw new IllegalArgumentException("Hire date cannot be in the future");
            }
            this.hireDate = new Date(hireDate.getTime());
        }
    }

}
