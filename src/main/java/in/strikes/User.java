package in.strikes;

/**
 * User — Stateful class, candidate for prototype scope.
 * 
 * Holds per-instance data (name, age). Sharing one instance across
 * the application would cause data corruption — each user needs
 * their own independent User object.
 * 
 * Use prototype scope for stateful beans: new instance per getBean() call.
 */
public class User {

    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
