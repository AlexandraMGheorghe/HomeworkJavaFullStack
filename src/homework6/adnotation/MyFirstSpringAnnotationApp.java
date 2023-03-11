package homework6.adnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFirstSpringAnnotationApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ITeacher firstTeacher = context.getBean("webDevTeacher", WebDevTeacher.class);
        ITeacher secondTeacher = context.getBean("javaTeacher", ITeacher.class);

        System.out.println(firstTeacher.getHomeWork());
        System.out.println(secondTeacher.getHomeWork());

        context.close();
    }
}