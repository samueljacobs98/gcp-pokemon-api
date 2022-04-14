package com.example.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@CrossOrigin
@RestController
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemon() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
    }

    @GetMapping("/pokemon/players")
    public ResponseEntity<List<Player>> getPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(playerRepository.findAll());
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable String id) {
        for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getId() == parseInt(id)) {
                return ResponseEntity.status(HttpStatus.OK).body(pokemon);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/pokemon/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        for (Player player : playerRepository.findAll()) {
            if (player.getId() == parseInt(id)) {
                return ResponseEntity.status(HttpStatus.OK).body(player);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/pokemon/players/{id}/pokemon")
    public ResponseEntity<String[]> getPlayerPokemon(@PathVariable String id) {
        for (Player player : playerRepository.findAll()) {
            if (player.getId() == parseInt(id)) {
                return ResponseEntity.status(HttpStatus.OK).body(player.getPokemons().split(" "));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/pokemon")
    public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon added");
    }

    @PostMapping("/pokemon/player")
    public ResponseEntity<String> createPokemon(@RequestBody Player player) {
        String[] playerPokemon = player.getPokemons().split("\\s+");
        if (playerPokemon.length > 6)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A player cannot have more than 6 pokemon");
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body("Player added");
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable String id) {
        try {
            pokemonRepository.deleteById(parseInt(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pokemon with id of: " + id + " was deleted");
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon with the id of: " + id + " doesn't exist, can't delete!");
        }
    }

    @DeleteMapping("/pokemon/players/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable String id) {
        try {
            playerRepository.deleteById(parseInt(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Player with id of: " + id + " was deleted");
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player with the id of: " + id + " doesn't exist, can't delete!");
        }
    }
}
