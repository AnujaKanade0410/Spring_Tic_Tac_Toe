# Spring_Tic_Tac_Toe
Tic tac toe game using Spring boot

Database details:

Table: game
game_id  integer   pk
first_player_id  integer  fk
second_player_id   integer  nullable fk
created   timestamp
game_status  varchar(255)
game_type  varchar(255)
first_player_piece_code     char(1)


Table: player
player_id   integer pk
user_name   varchar(64)
password_hash   varchar(64)
email   varchar(255)

Table: move
id   integer  pk
player_id  integer  fk
game_id integer fk
board_row  integer 
board_column  integer 
created     timestamp


Create player using following REST API:
http://localhost:8081/player/create

method: POST

Request body:
{"userName":"","passwordHash":"","email":""}

Login to the game:
http://localhost:8081

1. Login using the username and password for the player created in above step.
2. Select Game type and Play as from drop down
3. My Games shows the all the games list which are IN_PROGRESS
4. Join Existing game shows the games created by different player.
5. Once created new game, you can start the game by clicking on any grid. History of moves can be seen on the right side.



