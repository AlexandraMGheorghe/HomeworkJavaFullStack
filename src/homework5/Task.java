package homework5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task {
   private String taskName;
   private Integer taskID;
   private int id = -1;
   private Integer executionTime;
   private static int numberOfTasks;
   private static Random random= new Random();
   public void run(){
      try{
         System.out.println("Sleep for: " + this.executionTime + " seconds");
         TimeUnit.SECONDS.sleep(this.executionTime);
      }catch (InterruptedException e){
         e.printStackTrace();
      }
   }

   public  Integer generateId(){
      return id++;
   }
//   public  Integer generateId(){
//      return new Random().nextInt(1000);
//   }

   public void performInitialization (){
      System.out.println("Start init method");
      numberOfTasks++;
      System.out.println("Current number of instance: " + Task.numberOfTasks);
      this.taskID=generateId();
      this.taskName = "Task" + taskID;
      this.executionTime = random.nextInt(20);

   }

   public void destroy(){
      System.out.println("Destroy task: "+ this.taskName);
      numberOfTasks --;
      System.out.println("Tasks in progress: " + numberOfTasks);
   }

   public String getTaskName() {
      return taskName;
   }

   public Integer getTaskID() {
      return taskID;
   }

   public static int getNumberOfTasks() {
      return numberOfTasks;
   }
}
