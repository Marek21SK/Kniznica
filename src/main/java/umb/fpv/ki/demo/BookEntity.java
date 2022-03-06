package umb.fpv.ki.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue
    private String isbn;
    private String autfirstName;
    private String autlastName;
    private String title;
    private String count;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutfirstName() {
        return autfirstName;
    }

    public void setAutfirstName(String isbn) {
        this.autfirstName = autfirstName;
    }

    public String getAutlastName() {
        return autlastName;
    }

    public void setAutlastName(String autlastName) {
        this.autlastName = autlastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

