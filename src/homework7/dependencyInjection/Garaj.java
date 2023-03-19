package dependencyInjection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Garaj {
    @Autowired
    @Qualifier("garajPersonal")

    private Automobil masina;
    private Automobil motocicleta;
    private Automobil autocar;

    @Autowired
    public Garaj(Automobil masina, Automobil motocicleta, Automobil autocar) {
        this.masina = masina;
        this.motocicleta = motocicleta;
        this.autocar = autocar;
    }

    @Autowired (required = false)
    public void setCar(Masina masinaNoua) {
        this.masina = masinaNoua;
    }

    @Autowired (required = false)
    public Motocicleta getmotorcycle(Motocicleta motocicleta) {
       return motocicleta;
    }

}
