import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class JavaTeacher implements ITeacher{

    private WisdomWordsService wisdomService;

    private int age;
    private String workPlace;

    @Autowired
    public JavaTeacher(WisdomWordsService wisdomService, int age, String workPlace) {
        this.wisdomService = wisdomService;
        this.age = age;
        this.workPlace = workPlace;
    }

    public JavaTeacher(WisdomWordsService wisdomService) {
        this.wisdomService = wisdomService;

    }

    @Override
    public String getWisdom() {
        return wisdomService.getMessage();
    }

    @Override
    public String getHomework() {
        return "Create 100 classes";
    }


}