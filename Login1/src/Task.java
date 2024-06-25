public class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;

    // Constructor to initialize the Task object
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = "To Do"; // Default status
    }

    // Getters for the fields
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    // Method to set the task status
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Method to create a task ID (implementation can vary)
    public String createTaskID() {
        return taskName.substring(0, 2) + developerDetails.substring(0, 2) + taskDuration;
    }

    // Method to return the total hours of the task
    public int returnTotalHours() {
        return taskDuration;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Duration: " + taskDuration + " hours\n" +
               "Task Status: " + taskStatus + "\n" +
               "Task ID: " + createTaskID();
    }
}

