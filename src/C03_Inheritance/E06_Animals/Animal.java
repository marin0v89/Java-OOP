package C03_Inheritance.E06_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String produceSound() {
        return null;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                getClass().getSimpleName(), getName(), getAge(), getGender(), produceSound());
    }

}
