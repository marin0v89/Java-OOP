package C02_Encapsulation.Lab.P03_ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 3) {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 3) {
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva.");
        }
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double percent) {

        defineAge(this.getAge(), percent);
    }

    private void defineAge(int age, double percent) {
        if (age < 30) {
            this.setSalary(getSalary() + (getSalary() * percent / 200));
        } else {
            this.setSalary(getSalary() + (getSalary() * percent / 100));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
