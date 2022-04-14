package com.example.pokemon;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(schema = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String pokemons;
    private Timestamp dateCreated;

    public Player(){
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Player(int id, String username, String pokemons){
        this.id = id;
        this.username = username;
        this.pokemons = pokemons;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPokemons() {
        return pokemons;
    }

    public void setPokemons(String pokemons) {
        this.pokemons = pokemons;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
}