package homework6;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Person {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int age;
}

// genereaza cod automat pentru metodele de acces (getteri și setteri), metodele equals(), hashCode() și toString() pentru o clasă.