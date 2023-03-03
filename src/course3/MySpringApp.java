package course3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAnimal theDog = context.getBean("myDog", IAnimal.class);
        IAnimal theCat = context.getBean("myCat",IAnimal.class);
        IAnimal theMouse = context.getBean("myMouse", IAnimal.class);

        System.out.println("Dog sound: " + theDog.makeSound());
        System.out.println("Cat sound: " + theCat.makeSound());
        System.out.println("Mouse sound: " + theMouse.makeSound());
    }
}
