--this is to create a new user
---------and to grant user permissions
CREATE USER pokemondb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO pokemondb;
GRANT DBA TO pokemondb WITH ADMIN OPTION;