package C03_Inheritance.E06_Animals;

public class Kittens extends Cat {
    public Kittens(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
