package com.MyPage.MyPage.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsers")
    private int idUsers;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "Users_has_Squads",
                joinColumns = @JoinColumn(name = "Users_idUsers"),
                inverseJoinColumns = @JoinColumn(name = "Squads_idSquads"))
    private Set<Squad> squads;

    @OneToMany(mappedBy = "user2")
    private Set<BalanceConfirmation> balanceConfirmations;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(int idUsers, String login, String password, String email, Set<Squad> squads) {
        this.idUsers = idUsers;
        this.login = login;
        this.password = password;
        this.email = email;
        this.squads = squads;
    }

    public User(int idUsers, String login, String password, String email, Set<Squad> squads, Set<BalanceConfirmation> balanceConfirmations) {
        this.idUsers = idUsers;
        this.login = login;
        this.password = password;
        this.email = email;
        this.squads = squads;
        this.balanceConfirmations = balanceConfirmations;
    }

    public Set<BalanceConfirmation> getBalanceConfirmations() {
        return balanceConfirmations;
    }

    public void setBalanceConfirmations(Set<BalanceConfirmation> balanceConfirmations) {
        this.balanceConfirmations = balanceConfirmations;
    }

    public User(){

    }

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        this.squads = squads;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUsers=" + idUsers +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
