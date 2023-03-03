package course3;

public class Dog implements IAnimal{
    private String animalName;
    // este necesar modificarea fisierului xml prin adaugarea  <constructor-arg ref="AnimalName" />

    public Dog() {
    }

    public Dog(String animalName) {
        this.animalName = animalName;
    }
    @Override
    public String makeSound() {
        return "Woof";
    }


}
