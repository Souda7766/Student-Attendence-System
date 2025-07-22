package studentsystem.models;

public class Student {
    private int id;
    private String name;
    private String roll;
    private String className;

    public Student() { }

    public Student(int id, String name, String roll, String className) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.className = className;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRoll() { return roll; }
    public void setRoll(String roll) { this.roll = roll; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
}
