package homework5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("homework5/applicationContext.xml");


        Task firstTask = context.getBean("myTask", Task.class);
        Task secondTask = context.getBean("myTask", Task.class);

        firstTask.run();
        secondTask.run();

        context.close();

    }
}


