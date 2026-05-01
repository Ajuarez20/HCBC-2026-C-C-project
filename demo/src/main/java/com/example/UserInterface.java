package com.example;
import java.util.ArrayList;
import java.util.Arrays;

public class UserInterface{
    @SuppressWarnings("FieldMayBeFinal")
    private static ArrayList<Employee> Employeelist = new ArrayList<>();

    public static void main(String[] args) {
        Employee e1 = new Employee("ahmed", "begger", 12.5);
        Employeelist.add(e1);
        Employee e2 = new Employee("malasi","slave", 0);
        Employeelist.add(e2);

        //CreateTask("build rocket", "build a space craft");
        PayrollReport.generateReport();

        //FireEmployees();
    }

    public static ArrayList<Employee> getEmployeeList(){
        return Employeelist;
    }

    public static StringBuilder employeeINFO(){

        StringBuilder info = new StringBuilder("");

        for (Employee e : Employeelist) {
            
            info.append(e.SelfAsses());

        }
        return info;
    }

    public static void HireEmployee(String Name, String Occupation){

        //pronmpt user via Gui to enter employee specs
        //name
        //enter occupation
        
       

    }

    public static void FireEmployees(){

        // add a gui Option that protects certin employees from being fired

        ArrayList<String> ProtectedEmployeeNames = new ArrayList<>();    

        String info = employeeINFO().toString() + """
                    \n\nI must layoff an employee/s which employee/s should I layoff \n
                    Evaluate the least critical Employee based on their performance 
                    score and whether there is one or more other Employee/s with the 
                    same/smiliar occupation Respond with only the Employee/s name/s 
                    (if more than one employee separate thier name by commas) exactly 
                    as it was written \nProtected Employies (employees u dont fire) 
                    are :""" + ProtectedEmployeeNames.toString();
        
        System.out.println(info);

        String response = model.chatbot.chat(info);
        System.out.println(response);

        String[] names = response.split("[,\\s]+");
        ArrayList<String> toBeFired = new ArrayList<>(Arrays.asList(names));

        Employeelist.removeIf(e -> {
            if (toBeFired.contains(e.name)) {
                System.out.println(e.name + " has been fired.");

                // TODO: update GUI here

                return true;
            }
            return false;
        });

    }

    public static void GiveRaises(){

        String info = employeeINFO().toString() + """
        \n\nwhich Employee/s deserve a raise based on there performance, task/s 
        completion status and skill, Deserver a raise pick one or more employee\n
        Respond with only the Employee/s name/s (if more than one employee separate 
        thier name by commas) exactly as it was written
        """;

        String response = model.chatbot.chat(info);
        System.out.println(response);

        String[] names = response.split("[,\\s]+");
        ArrayList<String> toReciveRaise = new ArrayList<>(Arrays.asList(names));

        for (Employee e : Employeelist ) {

            for (String name : toReciveRaise) {
                if (e.name.equals(name)){

                }    
            }
        }
    }

    public static void CreateTask(String taskName, String taskDiscription){

        // gui will prompt user for name of the task and description then Ai will select the emplyee most fit for the job or prompt user to hire someone from a field that corisponds

        Task task = new Task(taskName,taskDiscription);    
        String info = employeeINFO().toString() + "\n\nThe new taks is: " + task.toString() +  
                    """
                    which employee has the occipation most fit for this task? \nEmployees can only have up to 4 tasks Respond with only the exact name Employee's name.\n\n
                    if no employee fits the job type "Hire a,[suggested occupation]" (make sure the coma is there)
                    """;
        
        System.out.println(info);


        String response = model.chatbot.chat(info);
        System.out.println(response);

        String[] names = response.split("[,\\s]+");
        ArrayList<String> segments = new ArrayList<>(Arrays.asList(names));

        if (segments.get(0).equals("Hire a")){
            //prompt user to hire the occupation it suggests
        }else{
            for (Employee e : Employeelist) {
                if (e.name.equals(response)){
                    e.TakeOnTask(task);
                }
            }
        }    
        // update Gui
        System.out.println(employeeINFO().toString());
    }
}