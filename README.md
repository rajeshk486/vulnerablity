# sahaj
Tamola is a game palyed by 2 or more players.
* Every round will have players and game type(BottomLine,TopLine,MiddleLine, EarlyFive, HouseFull)
* Depends on the gametype the validation and claims are made.
* if the validation fails claim is rejected else accepted


In general Game will have game engine or rule engine to compute the logics and emits the ouput(win/loss)
keeping the above as idea, the given project is designed
to play the game the follwing are needed and that wa made as class
1. Player
2. Board(containing numbers)->it can be of any order top, bottom,middle
   **GameEngine**
4. Game: its a interface
5. GameImpl: its a abstract class haivng minimal implementaion of the logics
6. BottomLine,TopLine,MiddleLine, EarlyFive, HouseFull are gametype classes extends the above abstract class to have additional logic implentation of the game.
class diagram given below
   
<img width="1062" alt="image" src="https://github.com/user-attachments/assets/6ae62e49-155e-420c-8385-caaf9c6ef416">

Main:
main program does the following
1. adding players
2. adding boards
3. adding game(BottomLine,TopLine,MiddleLine, EarlyFive, HouseFull)
   Above are minimal requirement to start the game
4. announced numers is a list passed along with game type as input to the enginge which is validator class, it decieds wheather the announced number present or not and finds the winner/loser.
5. the game can be done in round robin as syn or aync with threads.
  example input:
  <img width="720" alt="image" src="https://github.com/user-attachments/assets/0beb6145-70aa-4cd0-a151-b0e1f4d558eb">
  <img width="1119" alt="image" src="https://github.com/user-attachments/assets/22fff7a6-9969-4001-9e90-8a3ec05eef66">

   example output
   <img width="468" alt="image" src="https://github.com/user-attachments/assets/f14eab81-9d22-4f9d-ba7f-49e566be396b">

