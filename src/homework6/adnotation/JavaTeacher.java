package homework6.adnotation;;

import org.springframework.stereotype.Component;

@Antet(nameOfTeacher = "Alexandra",school = "School")
@Component()
public class JavaTeacher implements ITeacher {

    @Override
    public String getHomeWork() {
        return "do Java homework";
    }
}