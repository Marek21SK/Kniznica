package umb.fpv.ki.demo;

public class UserDto {
    private Long id;
    private String meno;
    private String priezvisko;
    private String kontakt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {return meno;}

    public void setFirstName(String meno) {
        this.meno = meno;
    }

    public String getLastName() {
        return priezvisko;
    }

    public void setLastName(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getEmail() {
        return kontakt;
    }

    public void setEmail(String kontakt) {
        this.kontakt = kontakt;
    }
}