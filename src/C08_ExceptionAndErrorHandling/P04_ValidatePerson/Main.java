package C08_ExceptionAndErrorHandling.P04_ValidatePerson;

public class Main {
    public static void main(String[] args) {
        //Create several objects of type Person – one with valid data, one with an empty first name,
        // one with null as last name, one with negative age and one with age > 120.
        Person person = new Person("Stoqn", "Kolev", 32);
        try {
            Person blankName = new Person(" ", "kolev", 31);
            Person nullLast = new Person("Kolev", null, 33);
            Person unBorn = new Person("Stoyan", "Kolev", -2);
            Person oldOne = new Person("Stoyan", "Kolev", 140);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
