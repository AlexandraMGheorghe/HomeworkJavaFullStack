package Auto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
@Getter
@Setter
@ToString
public class Motor {

    private int putere;
    private String nume;
    private int numarCilindri;

}
