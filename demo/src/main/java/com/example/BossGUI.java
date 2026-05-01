package com.example;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BossGUI extends Application {

    private Stage stage;

    // ================= DATA =================
    private HashMap<String, String> users = new HashMap<>();
    private ArrayList<Employee> employees = UserInterface.getEmployeeList();

    private double budget = 20000;

    // ================= UI =================
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
        UserInterface.HireEmployee("John", "Custodian", 25000);
        UserInterface.HireEmployee("Sarah", "Business Emp", 3500);
        UserInterface.HireEmployee("Mike", "It worker", 3500);
        UserInterface.HireEmployee("Issac", "Engineer", 3500);

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

        refreshEmployees();
        
   
    }

    // ======================================================
    // LOGIN (UNCHANGED)
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
    // DASHBOARD
    // ======================================================
    private void createDashboardScene() {

        Label title = new Label("Monthly Statistics");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold;");

        Button empBtn = new Button("Employees");
        Button taskBtn = new Button("Tasks");
        Button repBtn = new Button("Reports");
        Button logoutBtn = new Button("Logout");
        
        empBtn.setMaxWidth(200);
        taskBtn.setMaxWidth(200);
        repBtn.setMaxWidth(200);
        logoutBtn.setMaxWidth(200);
        
        

        empBtn.setOnAction(e -> stage.setScene(employeeScene));
        taskBtn.setOnAction(e -> stage.setScene(taskScene));
        repBtn.setOnAction(e -> stage.setScene(reportScene));
        logoutBtn.setOnAction(e -> stage.setScene(loginScene));

     

        VBox root = new VBox(20,
                title,
                budgetLabel,
                costLabel,
                statusLabel,empBtn,taskBtn,repBtn,logoutBtn
                
        );

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        dashboardScene = new Scene(root, 550, 500);

        refreshDashboard();
    }

    // ======================================================
    // EMPLOYEES
    // ======================================================
    private void createEmployeeScene() {

        Label title = new Label("Employee Management");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // ================= INPUT =================
        TextField name = new TextField();
        name.setPromptText("Name");
        name.setMaxWidth(200);

        TextField occupation = new TextField();
        occupation.setPromptText("Occupation");
        occupation.setMaxWidth(200);

        TextField salary = new TextField();
        salary.setPromptText("Salary (year)");
        salary.setMaxWidth(200);


        // ================= LIST =================
        employeeListView.setPrefHeight(250);
        employeeListView.setPrefWidth(350);

        // ================= BUTTONS =================
        Button hire = new Button("Hire Employee");
        Button fire = new Button("Fire Selected");
        Button back = new Button("Back");

        hire.setMaxWidth(200);
        fire.setMaxWidth(200);
        back.setMaxWidth(200);

        // ================= HIRE LOGIC =================
        hire.setOnAction(e -> { 
        String n = name.getText();
        String t = occupation.getText(); if (n == null || n.isEmpty() || t == null) return;
        double s = Double.parseDouble((salary.getText()));
        UserInterface.HireEmployee(n, t, s);
        refreshEmployees(); refreshDashboard();
        name.clear(); occupation.clear(); salary.clear(); });
        // ================= BACK =================
        back.setOnAction(e -> stage.setScene(dashboardScene));

        // ================= LAYOUT =================
        VBox layout = new VBox(15,
            title, employeeListView, name, occupation,
            salary,
            hire, fire, back
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        employeeScene = new Scene(layout, 450, 550);

        refreshEmployees();
    }

    // ======================================================
    // TASKS
    // ======================================================
    private void createTaskScene() {

        Label title = new Label("Task Management");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ================= INPUTS =================
        ComboBox<Employee> employeeBox = new ComboBox<>();
        employeeBox.getItems().setAll(UserInterface.getEmployeeList());

        TextField taskTitle = new TextField();
        taskTitle.setPromptText("Task Title");

        TextField taskDesc = new TextField();
        taskDesc.setPromptText("Task Description");


        Label msg = new Label();

        Button assignBtn = new Button("Assign Task");
        Button backBtn = new Button("Back");

        // ================= GRID =================
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // Row 0
        grid.add(title, 0, 0, 2, 1);

        // Row 2
        grid.add(new Label("Title:"), 0, 2);
        grid.add(taskTitle, 1, 2);

        // Row 3
        grid.add(new Label("Description:"), 0, 3);
        grid.add(taskDesc, 1, 3);

       ;

        // Row 5
        grid.add(assignBtn, 0, 5);
        grid.add(backBtn, 1, 5);

        // Row 6
        grid.add(msg, 0, 6, 2, 1);

        // ================= ASSIGN LOGIC =================
        assignBtn.setOnAction(e -> {


            String t = taskTitle.getText();
            String d = taskDesc.getText();

            if (t == null || t.isEmpty()) {
                msg.setText("Enter task title");
                return;
            }

            if (d == null) d = "";

            String response = UserInterface.CreateTask(taskTitle.getText(), taskDesc.getText());
            refreshEmployees();
            refreshDashboard();

            // allow manual override of completion
           


            taskTitle.clear();
            taskDesc.clear();
            

            msg.setText(response);

            refreshEmployees();
            refreshDashboard();
        });

        // ================= BACK =================
        backBtn.setOnAction(e -> stage.setScene(dashboardScene));

        // ================= SCENE =================
        taskScene = new Scene(grid, 450, 400);
    }

    // ======================================================
    // REPORT
    // ======================================================
    private void createReportScene() {

        TextArea report = new TextArea();
        report.setText(PayrollReport.generateReport());

        Button back = new Button("Back");
        back.setOnAction(e -> stage.setScene(dashboardScene));

        VBox layout = new VBox(10,
                new Label("Report"),
                report,
                back
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        reportScene = new Scene(layout, 350, 400);
    }

    // ======================================================
    // LOGIC
    // ======================================================
    private void refreshEmployees() {
        employeeListView.setItems(FXCollections.observableArrayList(UserInterface.getEmployeeList()));
    }

    private void refreshDashboard() {
        double cost = calculatePayroll();

        budgetLabel.setText("Budget: $" + budget);
        costLabel.setText("Payroll: $" + cost);

        statusLabel.setText(cost <= budget ? "UNDER BUDGET" : "OVER BUDGET");
    }

    private double calculatePayroll() {
        double total = 0;
        for (Employee e : UserInterface.getEmployeeList()) {
            total += e.salary;
        }
        return total;
    }

    private String generateReport() {
        return "Employees: " + UserInterface.getEmployeeList().size()
                + "\nPayroll: $" + calculatePayroll()
                + "\nBudget: $" + budget;
    }

    public static void main(String[] args) {
        launch();
    }
}