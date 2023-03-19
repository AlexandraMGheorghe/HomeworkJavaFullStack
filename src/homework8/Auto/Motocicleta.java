package Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Motocicleta implements Automobil {


    private Motor motor;
    @Autowired
    public Motocicleta(Motor motor) {
        this.motor = motor;
    }

    @Autowired(required = false)
    @Qualifier("motocicletaMotor")
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String travel() {
        return "Calatoresti cu motocicleta";
    }

    @Override
    public int maxDrivingSpeed() {
        return 180;
    }
    @Override
    public String showDetails(){
        return travel()+ " " + motor.toString() + " avand viteza maxima : " + maxDrivingSpeed() + "km/h";
    }
}
