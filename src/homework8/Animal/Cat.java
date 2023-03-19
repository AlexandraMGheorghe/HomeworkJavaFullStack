package Animal;

import org.springframework.beans.factory.annotation.Autowired;

public class Cat implements IAnimal{
    @Autowired
    private AnimalName animalName;

    public String animalName() {
        return animalName.getName();
    }

    public Cat(AnimalName animalName) {
        this.animalName = animalName;
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }


    @Override
    public void showDetails() {
        System.out.println("It is a cat " +  " make Sound: " + makeSound());
    }

}
