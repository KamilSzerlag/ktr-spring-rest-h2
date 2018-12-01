package kantor.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinTable(name = "wallets", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "wallet_id"))
    private Wallet wallet;

    public String getName() {
        return name;
    }

    public CustomerAccount setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CustomerAccount setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public CustomerAccount setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerAccount setEmail(String email) {
        this.email = email;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }


}