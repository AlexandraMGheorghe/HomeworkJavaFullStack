package Auto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {
    @Bean
    public Motor motor() {
        Motor motor = new Motor();
        motor.setPutere(200);
        motor.setNume("Motor V8");
        motor.setNumarCilindri(8);
        return motor;
    }

    @Bean
    public Automobil motocicleta() {
        return new Motocicleta(motor());
    }

    @Bean
    public Automobil masina() {
        Motor motor2 = new Motor();
        motor2.setPutere(200);
        motor2.setNume("Motor Benzina");
        motor2.setNumarCilindri(8);
         return new Masina(motor2);
    }

    @Bean
    public Automobil autocar() {
        Motor motor = new Motor();
        motor.setPutere(1000);
        motor.setNume("Motor Diesel");
        motor.setNumarCilindri(12);
        return new Autocar(motor);
    }
}

