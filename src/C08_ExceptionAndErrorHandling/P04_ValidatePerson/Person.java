package C08_ExceptionAndErrorHandling.P04_ValidatePerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void setFirstName(String firstName) {
        checkIfStringIsEmpty(firstName, "first");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        checkIfStringIsEmpty(lastName, "last");
        this.lastName = lastName;
    }

    private void checkIfStringIsEmpty(String name, String nameType) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException
                    (String.format("The %s name cannot be null or empty", nameType));
        }
    }

    private void setAge(int age) {
        if (age<0 || age >120){
            throw new IllegalArgumentException("Age should be in the range[0 ... 120] ");
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
