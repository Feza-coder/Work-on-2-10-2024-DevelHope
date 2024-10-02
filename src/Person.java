public class Person{
    private String name;
    private int age;
    private String username;
    private String password;

    // Constructor
    public Person(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return username.equals(person.username) && password.equals(person.password);
    }
    @Override
    public int hashCode() {
        return username.hashCode() + password.hashCode();
    }
}
