# Google Cloud Platform hosted Pokemon API (gcp-pokemon-api)

## Project Overview

Created an API using Spring Boot and Java with a MySQL database. The functionality of the API was verified in localhost with Postman. The API and it's database was then launched into the cloud using Google Cloud Platform.

# Documentation

## Root End Point
Access the API using this end point.
```
https://lundy-project.nw.r.appspot.com
```

## GET Requests
<!-- 1. -->
Return **all** Pokemon in the database.
```
https://lundy-project.nw.r.appspot.com/pokemon
```
<!-- 2. -->
Return **all** Players in the database.
```
https://lundy-project.nw.r.appspot.com/pokemon/players
```
<!-- 3. -->
Return Pokemon by id.
```
https://lundy-project.nw.r.appspot.com/pokemon/{id}
```
_Example_:
```
https://lundy-project.nw.r.appspot.com/pokemon/2
```
<!-- 4. -->
Return Player by id.
```
https://lundy-project.nw.r.appspot.com/pokemon/player/{id}
```
_Example_:
```
https://lundy-project.nw.r.appspot.com/pokemon/player/3
```
<!-- 5. -->
Return a Player's Pokemon in an array.
```
https://lundy-project.nw.r.appspot.com/pokemon/players/{id}/pokemon
```
_Example_:
```
https://lundy-project.nw.r.appspot.com/pokemon/players/3/pokemon
```

## POST Requests
Add a Pokemon to the database.

A Pokemon must be an object contained in the body of the request, including a name (string) key-value pair. An Id and dateCreated will automatically designated to each Pokemon.
```
https://lundy-project.nw.r.appspot.com/pokemon
```
Add a Player to the repository.

A Player must be an object contained in the body of the request including a username (string) key-value pair and a pokemons (string - each Pokemon name separated by a space - maximum 6 Pokemon) key-value pair.
```
https://lundy-project.nw.r.appspot.com/pokemon/player
```

## DELETE Requests
Delete a Pokemon from the database by id.
```
https://lundy-project.nw.r.appspot.com/pokemon/{id}
```
_Example_:
```
https://lundy-project.nw.r.appspot.com/pokemon/2
```

Delete a player from the database by id.
```
https://lundy-project.nw.r.appspot.com/pokemon/player/{id}
```
_Example_:
```
https://lundy-project.nw.r.appspot.com/pokemon/player/2
```
