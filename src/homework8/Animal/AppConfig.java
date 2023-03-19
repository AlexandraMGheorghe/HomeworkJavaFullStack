package Animal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan()
public class AppConfig {
    @Bean
    public Dog dog() {
        AnimalName name= new AnimalName();
        name.setName("Ozzy");
        return new Dog(animalName());
    }

    @Bean
    public Cat cat() {
        AnimalName name2= new AnimalName();
        name2.setName("Tom");
        return new Cat(animalName());
    }

    @Bean
    public Mouse mouse() {
        AnimalName name3= new AnimalName();
        name3.setName("Jerry");
        return new Mouse(animalName());
    }

    @Bean
    public AnimalName animalName() {
        return new AnimalName();
    }


}
