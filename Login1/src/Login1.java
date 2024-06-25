import javax.swing.JOptionPane; 

  

public class Login1 { 

    private String username; 

    private String password; 

    private String firstName; 

    private String lastName; 

    public static int totalHours = 0; 

  

    // Constructor to initialize the Login1 object with username, password, first name, and last name 

    public Login1(String username, String password, String firstName, String lastName) { 

        this.username = username; 

        this.password = password; 

        this.firstName = firstName; 

        this.lastName = lastName; 

    } 

  

    // Method to check if the username is correctly formatted 

    public boolean checkUsername() { 

        return username.contains("_") && username.length() <= 5; 

    } 

  

    // Method to check password complexity using a regular expression 

    public boolean checkPasswordComplexity() { 

        return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}"); 

    } 

  

    // Method to register a user based on username and password complexity 

    public String registerUser() { 

        if (!checkUsername()) { 

            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length."; 

        } 

        if (!checkPasswordComplexity()) { 

            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character."; 

        } 

        return "Welcome " + firstName + ", " + lastName + " it is great to see you again."; 

    } 

  

    // Method to check if the provided username and password match the stored ones 

    public boolean longUser(String username, String password) { 

        return this.username.equals(username) && this.password.equals(password); 

    } 

  

    // Method to return login status message based on loginStatus boolean 

    public String returnLoginStatus(boolean loginStatus) { 

        if (loginStatus) { 

            return "Welcome " + firstName + ", " + lastName + " it is great to see you again."; 

        } else { 

            return "Username or password incorrect, please try again"; 

        } 

    } 

  

public static void main(String[] args) { 

    // Display welcome message 

    JOptionPane.showMessageDialog(null, "Welcome to EasyKanban"); 

  

    // Input user data using JOptionPane dialogs 

    String username = JOptionPane.showInputDialog("Enter your username: "); 

    String password = JOptionPane.showInputDialog("Enter your password: "); 

    String firstName = JOptionPane.showInputDialog("Enter your first name: "); 

    String lastName = JOptionPane.showInputDialog("Enter your last name: "); 

  

    // Create a Login1 object with the provided user data 

    Login1 user = new Login1(username, password, firstName, lastName); 

  

    // Display registration message using JOptionPane dialog 

    JOptionPane.showMessageDialog(null, user.registerUser()); 

  

    boolean loginStatus = false; 

    while (!loginStatus) { 

        // Prompt the user for login credentials using JOptionPane dialogs 

        username = JOptionPane.showInputDialog("Enter your username to login: "); 

        password = JOptionPane.showInputDialog("Enter your password to login: "); 

  

        // Check login status using longUser method 

        loginStatus = user.longUser(username, password); 

  

        // Display login status message using JOptionPane dialog 

        JOptionPane.showMessageDialog(null, user.returnLoginStatus(loginStatus)); 

    } 

  

    // Perform tasks if login is successful 

    if (loginStatus) { 

        String[] developers = new String[100]; 

        String[] taskNames = new String[100]; 

        String[] taskIDs = new String[100]; 

        int[] taskDurations = new int[100]; 

        String[] taskStatuses = new String[100]; 

        int taskCount = 0; 

  

        int choice = 0; 

        while (choice != 3) { 

            String menu = "Choose an option:\n" + 

                    "1) Add tasks\n" + 

                    "2) Show report\n" + 

                    "3) Quit\n"; 

            choice = Integer.parseInt(JOptionPane.showInputDialog(menu)); 

  

            switch (choice) { 

                case 1: 

                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: ")); 

  

                    // Create an array of Task objects 

                    Task[] tasks = new Task[numTasks]; 

  

                    // Input task details and display task information using JOptionPane dialogs 

                    for (int i = 0; i < numTasks; i++) { 

                        String taskName = JOptionPane.showInputDialog("Enter task name: "); 

                        String taskDescription = JOptionPane.showInputDialog("Enter task description: "); 

                        String developerDetails = JOptionPane.showInputDialog("Enter developer details: "); 

                        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours): ")); 

  

                        // Task status selection 

                        String[] statusOptions = {"To Do", "Doing", "Done"}; 

                        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", 

                                "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]); 

  

                        // Create a Task object and display task details 

                        Task task1 = new Task(taskName, taskDescription, developerDetails, taskDuration); 

                        task1.setTaskStatus(taskStatus); // Set the task status 

                        tasks[i] = task1; 

  

                        // Populate arrays 

                        developers[taskCount] = developerDetails; 

                        taskNames[taskCount] = taskName; 

                        taskIDs[taskCount] = task1.createTaskID(); 

                        taskDurations[taskCount] = taskDuration; 

                        taskStatuses[taskCount] = taskStatus; 

                        taskCount++; 

  

                        JOptionPane.showMessageDialog(null, task1.printTaskDetails()); 

                    } 

  

                    // Calculate and display total hours using JOptionPane dialog 

                    totalHours = 0; // Initialize totalHours correctly 

                    for (Task task : tasks) { 

                        totalHours += task.returnTotalHours(); 

                    } 

  

                    JOptionPane.showMessageDialog(null, "Total hours: " + totalHours); 

                    break; 

                case 2: 

                    int reportChoice = 0; 

                    while (reportChoice != 7) { 

                        String reportMenu = "Choose a report option:\n" + 

                                "1) Display tasks with status 'Done'\n" + 

                                "2) Display task with longest duration\n" + 

                                "3) Search for task by name\n" + 

                                "4) Search for tasks by developer\n" + 

                                "5) Delete a task by name\n" + 

                                "6) Display full report\n" + 

                                "7) Back to main menu\n"; 

                        reportChoice = Integer.parseInt(JOptionPane.showInputDialog(reportMenu)); 

  

                        switch (reportChoice) { 

                            case 1: 

                                StringBuilder doneTasks = new StringBuilder(); 

                                for (int i = 0; i < taskCount; i++) { 

                                    if ("Done".equals(taskStatuses[i])) { 

                                        doneTasks.append("Developer: ").append(developers[i]) 

                                                .append(", Task Name: ").append(taskNames[i]) 

                                                .append(", Task Duration: ").append(taskDurations[i]) 

                                                .append("\n"); 

                                    } 

                                } 

                                JOptionPane.showMessageDialog(null, doneTasks.toString()); 

                                break; 

                            case 2: 

                                int maxDurationIndex = 0; 

                                for (int i = 1; i < taskCount; i++) { 

                                    if (taskDurations[i] > taskDurations[maxDurationIndex]) { 

                                        maxDurationIndex = i; 

                                    } 

                                } 

                                JOptionPane.showMessageDialog(null, "Developer: " + developers[maxDurationIndex] 

                                        + ", Task Duration: " + taskDurations[maxDurationIndex]); 

                                break; 

                            case 3: 

                                String searchTaskName = JOptionPane.showInputDialog("Enter task name to search: "); 

                                StringBuilder taskInfo = new StringBuilder(); 

                                for (int i = 0; i < taskCount; i++) { 

                                    if (searchTaskName.equals(taskNames[i])) { 

                                        taskInfo.append("Task Name: ").append(taskNames[i]) 

                                                .append(", Developer: ").append(developers[i]) 

                                                .append(", Task Status: ").append(taskStatuses[i]) 

                                                .append("\n"); 

                                        break; 

                                    } 

                                } 

                                JOptionPane.showMessageDialog(null, taskInfo.toString()); 

                                break; 

                            case 4: 

                                String searchDeveloper = JOptionPane.showInputDialog("Enter developer name to search: "); 

                                StringBuilder developerTasks = new StringBuilder(); 

                                for (int i = 0; i < taskCount; i++) { 

                                    if (searchDeveloper.equals(developers[i])) { 

                                        developerTasks.append("Task Name: ").append(taskNames[i]) 

                                                .append(", Task Status: ").append(taskStatuses[i]) 

                                                .append("\n"); 

                                    } 

                                } 

                             case 5: 

                              // Display all tasks and prompt the user to pick a task to delete 

                                StringBuilder allTasksToDelete = new StringBuilder(); 

                                for (int i = 0; i < taskCount; i++) { 

                                allTasksToDelete.append(i + 1).append(") Task Name: ").append(taskNames[i]) 

                                                  .append(", Developer: ").append(developers[i]) 

                                                  .append(", Task Status: ").append(taskStatuses[i]) 

                                                  .append(", Task Duration: ").append(taskDurations[i]) 

                                                  .append("\n"); 

                                      } 

                              int taskNumberToDelete = Integer.parseInt(JOptionPane.showInputDialog("Select a task to delete by number:\n" + allTasksToDelete.toString())) - 1; 

  

                              if (taskNumberToDelete >= 0 && taskNumberToDelete < taskCount) { 

                              // Shift elements to the left to delete the task 

                              for (int i = taskNumberToDelete; i < taskCount - 1; i++) { 

                              developers[i] = developers[i + 1]; 

                              taskNames[i] = taskNames[i + 1]; 

                              taskIDs[i] = taskIDs[i + 1]; 

                              taskDurations[i] = taskDurations[i + 1]; 

                              taskStatuses[i] = taskStatuses[i + 1]; 

                               } 

                              taskCount--; 

                              JOptionPane.showMessageDialog(null, "Task deleted successfully."); 

                            } else { 

                              JOptionPane.showMessageDialog(null, "Invalid task number."); 

                            } 

                              break; 

  

                            case 6: 

                           // Display all tasks with their information 

                              StringBuilder allTasks = new StringBuilder(); 

                              for (int i = 0; i < taskCount; i++) { 

                              allTasks.append("Task Name: ").append(taskNames[i]) 

                              .append(", Developer: ").append(developers[i]) 

                              .append(", Task Status: ").append(taskStatuses[i]) 

                              .append(", Task Duration: ").append(taskDurations[i]) 

                              .append(", Task ID: ").append(taskIDs[i]) 

                              .append("\n"); 

                            } 

                            JOptionPane.showMessageDialog(null, allTasks.toString()); 

                              break; 

  

  

                        } 

                    } 

                } 

            } 

        } 

    } 

} 
    

        
    





