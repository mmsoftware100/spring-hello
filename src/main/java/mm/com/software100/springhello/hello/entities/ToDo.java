package mm.com.software100.springhello.hello.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String status;


    /*
     * Hibernate requires a no-argument constructor to instantiate entities. 
     * If you don't have one, add it to your entity class.
     */
    // Default no-argument constructor
    public ToDo() {
    }


    public ToDo(long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    
    public ToDo(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', status='%s']",
                id, name, status);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
