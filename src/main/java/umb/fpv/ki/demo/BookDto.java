package umb.fpv.ki.demo;

public class BookDto {
    private String isbn;
    private String autfirstName;
    private String autlastName;
    private String title;
    private String count;
    private String id;

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
