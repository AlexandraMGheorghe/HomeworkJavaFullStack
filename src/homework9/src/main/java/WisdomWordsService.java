import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class WisdomWordsService {

    private String message = "Hard work pays off";
@Autowired
    public WisdomWordsService(String message) {
        this.message = message;
    }
}
