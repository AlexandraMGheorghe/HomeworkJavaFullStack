package Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Autocar implements Automobil {
    private Motor motor;
@Autowired
    public Autocar(Motor motor) {
        this.motor = motor;
    }

//    @Autowired (required = false)
//    @Qualifier("autocarMotor")
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String travel() {
        return "Calatoresti cu autocarul";
    }

    @Override
    public int maxDrivingSpeed() {
        return 150;
    }

    @Override
    public String showDetails(){
        return travel()+ " " + motor.toString() + " avand viteza maxima : " +maxDrivingSpeed() + "km/h";
    }
}
