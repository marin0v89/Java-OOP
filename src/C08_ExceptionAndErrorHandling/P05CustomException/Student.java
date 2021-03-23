package C08_ExceptionAndErrorHandling.P05CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public void setName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char symbol = name.charAt(i);
            if (!Character.isAlphabetic(symbol)){
                try {
                    throw new InvalidPersonNameException("Name should contains only alphabetic letters");
                } catch (InvalidPersonNameException e) {
                    e.printStackTrace();
                }
            }
        }
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
