package dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);

        Automobil motocicleta = context.getBean(Motocicleta.class);
//        System.out.println(motocicleta.travel());
//        System.out.println("Viteza maximă a motocicletei: " + motocicleta.maxDrivingSpeed());
        System.out.println(motocicleta.showDetails());

        Automobil masina = context.getBean(Masina.class);
//        System.out.println(masina.travel());
//        System.out.println("Viteza maximă a mașinii: " + masina.maxDrivingSpeed());
        System.out.println(masina.showDetails());

        Automobil autocar = context.getBean(Autocar.class);
//        System.out.println(autocar.travel());
//        System.out.println("Viteza maximă a autocarului: " + autocar.maxDrivingSpeed());
        System.out.println(autocar.showDetails());



    }
}
