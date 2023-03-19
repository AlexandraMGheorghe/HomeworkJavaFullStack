package Animal;

import org.springframework.beans.factory.annotation.Autowired;

public class Dog implements IAnimal{
    private AnimalName animalName;
    @Autowired
    public Dog(AnimalName animalName) {
        this.animalName = animalName;
    }

    @Autowired(required = false)
    public void setAnimalName(AnimalName animalName) {
        this.animalName = animalName;
    }

    @Override
    public String makeSound() {
        return "Woof";
    }

       @Override
    public void showDetails() {
        System.out.println("It is a dog " + " make Sound: " + makeSound());
    }
}
