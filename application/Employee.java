package application;

public abstract class Employee implements java.io.Serializable {

    protected String name;
    protected double skill;
    protected double salary;
    protected double performanceScore = 0;

    public Employee(String name) {
        this.name = name;

        // 🔥 RANDOM SKILL (0.6 → 1.0)
        this.skill = 0.6 + Math.random() * 0.4;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " | " + name +
                " | Skill: " + String.format("%.2f", skill) +
                " | $" + salary +
                " | Score: " + performanceScore;
    }

    public abstract void evaluateTasks(TaskManager tm);
}