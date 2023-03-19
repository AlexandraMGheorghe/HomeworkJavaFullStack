package dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Masina implements Automobil {
    private Motor motor;

    @Autowired
    public Masina(Motor motor) {
        this.motor = motor;
    }

    @Autowired (required = false)
    @Qualifier("masinaMotor")
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String travel() {
        return "Calatoresti cu masina";
    }

    @Override
    public int maxDrivingSpeed() {
        return 230;
    }

    @Override
    public String showDetails(){
        return travel() + " " + motor.toString() + " avand viteza maxima : " +maxDrivingSpeed() + "km/h";
    }
}
