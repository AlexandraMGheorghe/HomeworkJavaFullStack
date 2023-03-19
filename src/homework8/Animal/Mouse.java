package Animal;

import org.springframework.beans.factory.annotation.Autowired;

public class Mouse implements IAnimal{
    private AnimalName animalName;

    public Mouse(AnimalName animalName) {
        this.animalName = animalName;
    }

    @Autowired(required = false)
    public void setAnimalName(AnimalName animalName) {
        this.animalName = animalName;
    }
    @Override
    public String makeSound() {
        return "Squeak";
    }


    @Override
    public void showDetails() {
        System.out.println("It is a mouse " +  " make Sound: " + makeSound());
    }
}
