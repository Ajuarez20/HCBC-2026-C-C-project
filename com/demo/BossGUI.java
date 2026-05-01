package com.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BossGUI extends Application {

    private Stage stage;

    // ================= DATA =================
    private HashMap<String, String> users = new HashMap<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private TaskManager taskManager = new TaskManager();

    private double budget = 20000;

    // ================= GLOBAL UI =================
    private Label budgetLabel = new Label();
    private Label costLabel = new Label();
    private Label statusLabel = new Label();

    private ListView<Employee> employeeListView = new ListView<>();

    // ================= SCENES =================
    private Scene loginScene;
    private Scene dashboardScene;
    private Scene employeeScene;
    private Scene taskScene;
    private Scene reportScene;

    // ================= START =================
    @Override
    public void start(Stage stage) {
        this.stage = stage;

        users.put("admin", "123");

        employees.add(new Custodian("John"));
        employees.add(new BusinessEmployee("Sarah"));

        createLoginScene();
        createDashboardScene();
        createEmployeeScene();
        createTaskScene();
        createReportScene();

        stage.setScene(loginScene);
        stage.setTitle("Payroll Management System");
        stage.setWidth(900);
        stage.setHeight(650);
        stage.show();
    }

    // ======================================================
    // LOGIN SCENE (UNCHANGED STYLE — YOUR DESIGN)
    // ======================================================
    private void createLoginScene() {

        Label title = new Label("Payroll System Login");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        ImageView imgView = new ImageView(new Image("file:user.png"));
        imgView.setFitWidth(100);
        imgView.setFitHeight(90);
        imgView.setPreserveRatio(true);

        TextField username = new TextField();
        username.setPromptText("👤 Username");
        username.setMaxWidth(200);

        PasswordField password = new PasswordField();
        password.setPromptText("🔒 Password");
        password.setMaxWidth(200);

        Label msg = new Label();

        Button loginBtn = new Button("Login");
        loginBtn.setMaxWidth(200);

        loginBtn.setOnAction(e -> {
            if (users.containsKey(username.getText())
                    && users.get(username.getText()).equals(password.getText())) {
                stage.setScene(dashboardScene);
                refreshDashboard();
            } else {
                msg.setText("Invalid credentials");
            }
        });

        VBox layout = new VBox(15,
                imgView, title, username, password, loginBtn, msg
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));
        layout.setMaxWidth(300);

        layout.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #ccc;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );

        
    

        loginScene = new Scene(layout, 350, 400);
    }

    // ======================================================
    // DASHBOARD (CARD STYLE)
    // ======================================================
    private void createDashboardScene() {

        // ===== TITLE =====
        Label title = new Label("Monthly Statistics");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold;");

        Label monthly = new Label("");
        monthly.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ===== IMAGE =====
        VBox imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);

        // ===== BUTTONS =====
        Button employeesBtn = new Button("Employee Management");
        Button tasksBtn = new Button("Task Management");
        Button reportsBtn = new Button("Reports");
        Button logoutBtn = new Button("Logout");

        employeesBtn.setPrefWidth(180);
        tasksBtn.setPrefWidth(180);
        reportsBtn.setPrefWidth(180);
        logoutBtn.setPrefWidth(180);

        employeesBtn.setOnAction(e -> stage.setScene(employeeScene));
        tasksBtn.setOnAction(e -> stage.setScene(taskScene));
        reportsBtn.setOnAction(e -> stage.setScene(reportScene));
        logoutBtn.setOnAction(e -> stage.setScene(loginScene));

        // ===== BUTTON ROWS =====
        HBox row1 = new HBox(15);
        row1.setAlignment(Pos.CENTER);
        row1.getChildren().addAll(employeesBtn, tasksBtn);

        HBox row2 = new HBox(15);
        row2.setAlignment(Pos.CENTER);
        row2.getChildren().addAll(reportsBtn, logoutBtn);

        // ===== STATS SECTION =====
        VBox statsBox = new VBox(40,
                imageBox,
               
                budgetLabel,
                costLabel,
                statusLabel
        );
        statsBox.setAlignment(Pos.CENTER);

        // ===== MAIN ROOT (ALL IN ONE VBOX) =====
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                title,
                statsBox,
                row1,
                row2
        );

        // ===== CARD STYLE =====
        root.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #ddd;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );

        dashboardScene = new Scene(root, 550, 500);

        refreshDashboard();
    }
    // ======================================================
    // EMPLOYEE MANAGEMENT (REAL SYSTEM)
    // ======================================================
    private void createEmployeeScene() {

        Label title = new Label("Employee Management");

        // ===== INPUT =====
        TextField name = new TextField();
        name.setPromptText("Name");
        name.setMaxWidth(200);

        ComboBox<String> type = new ComboBox<>();
        type.getItems().addAll("Custodian", "Business Employee");
        type.setPromptText("Select Role");
        type.setMaxWidth(200);

        Button add = new Button("Hire");
        Button remove = new Button("Fire Selected");
        Button back = new Button("Back");

        add.setMaxWidth(200);
        remove.setMaxWidth(200);
        back.setMaxWidth(200);

        // ===== HIRE LOGIC =====
        add.setOnAction(e -> {

            String n = name.getText();
            String t = type.getValue();

            if (n == null || n.isEmpty() || t == null) return;

            Employee emp;

            if (t.equals("Custodian")) {
                emp = new Custodian(n);
            } else {
                emp = new BusinessEmployee(n);
            }

            employees.add(emp);
            initializeScores();
            refreshEmployees();
            refreshDashboard();

            // optional cleanup
            name.clear();
            type.setValue(null);
        });

        // ===== REMOVE =====
        remove.setOnAction(e -> {
            Employee selected = employeeListView.getSelectionModel().getSelectedItem();
            employeeListView.setPrefWidth(300);
            employeeListView.setPrefHeight(200);

            if (selected != null) {
                employees.remove(selected);
                refreshEmployees();
                refreshDashboard();
            }
        });

        // ===== BACK =====
        back.setOnAction(e -> stage.setScene(dashboardScene));

        // ===== FORM =====
        VBox form = new VBox(10,
                name,
                type,
                add,
                remove,
                back
        );
        form.setAlignment(Pos.CENTER);
        VBox.setVgrow(employeeListView, Priority.ALWAYS);

        // ===== MAIN LAYOUT =====
        VBox card = new VBox(30,
                title,
                employeeListView,
                form
        );

        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(25));
        card.setMaxWidth(500);

        VBox root = new VBox(card);
        root.setAlignment(Pos.CENTER);

        employeeScene = new Scene(root, 400, 500);

        
        refreshEmployees();
    }

    // ======================================================
    // TASK SCENE
    // ======================================================
    private void createTaskScene() {

        Label title = new Label("Task Management");

        // ===== SELECT EMPLOYEE =====
        ComboBox<Employee> employeeBox = new ComboBox<>();
        employeeBox.setPromptText("Select Employee");
        employeeBox.setMaxWidth(200);

        // ===== TASK INPUT =====
        TextField taskField = new TextField();
        taskField.setPromptText("Enter Task");
        taskField.setMaxWidth(200);

        Button assignBtn = new Button("Assign Task");
        Button back = new Button("Back");

        assignBtn.setMaxWidth(200);
        back.setMaxWidth(200);

        // ===== ASSIGN LOGIC =====
        assignBtn.setOnAction(e -> {

            Employee selected = employeeBox.getValue();
            if (selected == null) return;

            String taskName = taskField.getText();

            // CASE 1: user typed a task
            if (taskName != null && !taskName.isEmpty()) {
                selected.addTask(new Task(taskName));
            }

            // CASE 2: also add random tasks (your simulation logic)
            List<Task> tasks = taskManager.assignTasks();

            for (Task t : tasks) {
                selected.addTask(t);
            }

            taskField.clear();

            refreshEmployees();
            refreshDashboard();
        });

        // ===== BACK =====
        back.setOnAction(e -> stage.setScene(dashboardScene));

        // ===== LAYOUT =====
        VBox card = new VBox(12,
                title,
                employeeBox,
                taskField,
                assignBtn,
                back
        );

        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(25));
        card.setMaxWidth(320);

        VBox root = new VBox(card);
        root.setAlignment(Pos.CENTER);

        taskScene = new Scene(root, 350, 400);

        // 🔥 FIX: always refresh dropdown when scene opens
        employeeBox.getItems().setAll(employees);
    }
    // ======================================================
    // REPORT SCENE
    // ======================================================
    private void createReportScene() {

        TextArea report = new TextArea();
        report.setText(generateReport());
        report.setPrefHeight(150);
        report.setMaxWidth(300);

        Button back = new Button("Back");
        back.setMaxWidth(200);

        back.setOnAction(e -> stage.setScene(dashboardScene));

        VBox card = new VBox(12,
                new Label("Reports"),
                report,
                back
        );

        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(25));
        card.setMaxWidth(320);

        VBox root = new VBox(card);
        root.setAlignment(Pos.CENTER);

        reportScene = new Scene(root, 350, 400);
    }

    // ======================================================
    // LOGIC
    // ======================================================
    private void refreshEmployees() {

    	    // recalculate scores BEFORE showing UI
    	    for (Employee e : employees) {

    	        e.performanceScore = 0;

    	        if (e.getTasks().isEmpty()) {
    	            e.addTask(new Task("Basic Work"));
    	            e.addTask(new Task("Assessment Task"));
    	        }

    	        e.evaluateTasks(taskManager);
    	    }

    	    employeeListView.setItems(FXCollections.observableArrayList(employees));
    	}
    

    private void refreshDashboard() {
        double cost = calculatePayroll();

        budgetLabel.setText("Budget: $" + budget);
        costLabel.setText("Payroll: $" + cost);

        statusLabel.setText(cost <= budget ? "Status: UNDER BUDGET" : "Status: OVER BUDGET");
    }
    
    private void initializeScores() {

        for (Employee e : employees) {

            // If employee has no tasks yet, give a simple starter workload
            if (e.getTasks().isEmpty()) {

                e.addTask(new Task("Basic Work"));
                e.addTask(new Task("Assessment Task"));
            }

            // Reset score so it doesn't stack every time you open scene
            // (important or scores will inflate)
            e.performanceScore = 0;

            // Evaluate once to generate a meaningful baseline score
            e.evaluateTasks(taskManager);
        }
    }

    private double calculatePayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.salary;
        }
        return total;
    }

    private String generateReport() {
        return "Employees: " + employees.size()
                + "\nPayroll: $" + calculatePayroll()
                + "\nBudget: $" + budget;
    }

    public static void main(String[] args) {
        launch();
    }
}