package Animal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        IAnimal theDog = context.getBean("myDog", IAnimal.class);
//        IAnimal theCat = context.getBean("myCat",IAnimal.class);
//        IAnimal theMouse = context.getBean("myMouse", IAnimal.class);
//
//        System.out.println("Dog sound: " + theDog.makeSound());
//        System.out.println("Cat sound: " + theCat.makeSound());
//        System.out.println("Mouse sound: " + theMouse.makeSound());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IAnimal pet1 = context.getBean("cat", IAnimal.class);

//        System.out.println(pet1.makeSound());
        pet1.showDetails();

        IAnimal pet2 = context.getBean("dog", IAnimal.class);

//        System.out.println(pet2.makeSound());
        pet2.showDetails();

        IAnimal pet3 = context.getBean("mouse", IAnimal.class);

//        System.out.println(pet3.makeSound());
        pet3.showDetails();


    }
}
