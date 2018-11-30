package kantor.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Acount")
public class CustomerAcount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String email;
    private Wallet wallet;

    public String getName() {
        return name;
    }

    public CustomerAcount setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CustomerAcount setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public CustomerAcount setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerAcount setEmail(String email) {
        this.email = email;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }


}