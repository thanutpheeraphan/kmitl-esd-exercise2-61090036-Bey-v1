import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO class for a customer
 */
@Setter
@Getter
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private Long age;


    /**
     * constructor
     */
    public CustomerDTO() {
    }

    /**
     * constuctor
     *
     * @param id
     * @param name
     * @return void
     */
    public CustomerDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     * constructor
     *
     * @param id
     * @param name
     * @param age  return void
     */
    public CustomerDTO(long id, String name, long age) {
        this(id, name);
        this.age = age;
    }

    /**
     * print details
     *
     * @return string customer details
     */
    @Override
    public String toString() {
        return Long.toString(id) + " , " + name + " , " + age;
    }

    /**
     * get id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * set id
     *
     * @param id
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


}



