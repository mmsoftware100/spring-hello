package mm.com.software100.springhello.hello.entities;


public class User {
    // basic user information
    // fields
    private long id;
    private String name;
    private String email;
    private String password;

    // constructors
    // for hibernate, we need a no-argument constructor to instantiate entities
    public User() {
    }

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getters and setters
    // id
    public long getId() {
        return id;
    }
    // name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // toString
    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', email='%s', password='%s']",
                id, name, email, password);
    }


}
