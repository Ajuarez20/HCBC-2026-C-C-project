package demo.src.main.java.com.example;

public class Task implements java.io.Serializable {
    final private  String title;
    final private String description;
    public boolean Completeion = false;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "| Task title: " + this.title + "| task Discription: " + this.description + "| task Completed:" + this.Completeion;
    }
}