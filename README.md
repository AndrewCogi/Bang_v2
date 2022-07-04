# Bang! the board game

Bang! the board game (server & client)

## 1. Introduction

### Motivation

 There are many activities to do for your hobby. Playing Board games with friends can be one of them. But, due to the extension of COVID 19, it is hard for us to gather a lot of people and enjoy these games. Furthermore, even if it is not for COVID 19, it was still difficult for us to gather people with knowledge and experience with this game. Through our term project of Software Engineering, we made a program for a Board game called ‘Bang!”, using Software Engineering Techniques.

### Scope of the system

 The game ‘Bang!’ is a game which has a background on the western era. The game can have up to 7 players, with different roles, such as sheriff, vice, renegade, outlaws. Each role has to fulfill different conditions to win the game. This can be done with the help of several cards, such as Bang! or Mancato!. The extension pack holds many scenarios that can turn the tables of the game. We made this program based on the Server and Client system along with many Protocols for effective communications and controls. We also use a neat User Interface for better use.

### Objectives and Success Criteria of the project

 The main objective of this project is making people enjoy and have fun with our project. To do this, we have to make sure that while connecting clients and server, there has to be no errors or issues with connection. Also, the interface has to be intuitive for people to understand and play. And we have to check if the server can contain more than 7 clients to start the game. For further improvement, we’ve set the limit of clients to 10000. This will determine the success of the project.

### Technical Skills

 There are several techniques used in this project. First, we made the server to allow many clients to communicate with the server. For better communication, we made a sub-server that will be connected to the clients one-on-one and let these sub-servers communicate with the main server. These sub-servers are managed by Thread-pool in the main server and this relieves the main server.
 
 Next, we made Managers to follow certain protocols which allows us to manage and control clients efficiently. The Managers are divided to manage each game, player and session. This will prevent bottle-necks occurring from sub-servers and receive data from each sub-servers. Each manager will do their work.
 
 Finally we made the architecture efficient to reduce throughput to the main server leading to the reduction of overload. The main server will only give certain messages to the clients and the clients will each do the given order such as dispensing cards and running the game.

## 2. Proposed System

### Overview

Our project is based on Client-Server architecture. Through this, we can show how clients and servers communicate with each other. The modeling of our project will show how the server reacts and works when new clients join the server. We also used timeout and other methods for effective communications and resource management.

### Requirement Analysis

#### There are two types of requirements, functional and non-functional requirements. The functional requirements are the following :
 
  #### 1. What kind of board game?
  
  The board game “Bang!” is popular among people and we wanted to make this game possible to play with other players online.
  
  #### 2. Game Rules and other requirements
  
  The game basically requires Character cards, Playing cards, Role cards and others and it also requires Scenario Cards in Extension packs for various game environments.
  
  #### 3. User Interface
  
  When people play our game, they need to have intuitive and also neat interfaces for better use.
  
  #### 4. Server
  
  A lot of people have to enjoy this game online, and these people need specific rooms to play privately. For this, we need a server to let clients communicate with each other and passwords for private rooms.
  
#### Next, there are some non-functional requirements, too. They are the following :

  #### 1. Timeout
  
  This requirement is needed for fluent communication with servers and clients. 	We’ve set a limit of 10 seconds for communication and if the response time exceeds our limit, the connection between them will automatically break.
  
  #### 2. Server Response Time
  
  We’ve tried to set the response time of the server below 1 second for each client for better connection.
  
  #### 3. Performance using Raspberry PI
  
  We’ve tried to make the server simple and light with Raspberry PI. Still, it needed not to be lagged behind, so we tried to simplify and relieve the work for the main server, such as only giving certain orders to sub-servers and clients during the game, which makes the server simple and well-performing.
  
### System modeling

#### We’ve used a behavioral model to illustrate the action servers take when new clients join. We’ve show this with activity diagram and the diagram follows :

![Fig 1.) Activity diagram of our system](https://user-images.githubusercontent.com/69946205/173247500-df9d9109-734d-4bbc-ac48-e92543801348.png)

 The diagram shows how the server behaves when new clients join the server. First, when the server is activated, it gets assigned a new port number by port forwarding and initializes the thread pool. After that, it waits for new clients to join and check status for clients joined. When new clients try to enter the server, the server checks availability if the client can join the server. If it can’t, the server tells the client why they can’t join the server. (Ex. redundant ID, Wrong Password) If the client is accessible to the server, the server creates a capitalizer, which is a sub-server for the client. It also creates Player Manager, Game Manager, Session Manager. When this work is done, the sub-server joins the pool which was initialized at server activation. When the command for server termination is accepted, the server sends all connected clients connection break messages and terminates all sub-servers in the Thread pool. After checking total termination of sub-servers, the main server closes.

### Architectural Design

#### We’ve used Client-Server Architecture design to show our system to show how servers and clients interact with each other. The architecture follows :

![Fig 2.) Client-Server Architecture design of our system](https://user-images.githubusercontent.com/69946205/173995765-dc2bbac3-df60-4a70-b228-4fe86b7a6450.png)

 The architecture design shows that when clients access the server, it gets assigned a sub-server and this sub-server interacts with the server through the internet. Also, you can see that Player Manager, Session Manager, Game Manager do their work assigned.

## 3. Validation

#### First, we have to check if the system meets the requirements. First we had to check functional requirements.

 - Board game implementation (Bang!)
 - We’ve made the program to accept 7 players to play the game, through online.

![Fig 3.1.) Before Start Bang (Below 7 players, Waiting State)](https://user-images.githubusercontent.com/69946205/173996029-80c75885-5f81-4082-a6ae-0b83f266a423.png)

![Fig 3.2.) Activate the Start Button when all 7 people come in](https://user-images.githubusercontent.com/69946205/173996112-2ec38315-a5b7-4a95-9270-c5cfb05c8bc0.png)

 - Game rules and other requirements implementation
 - The players have to get a certain position for the game randomly and they have to choose a role, scenario and their character to play. 

![Fig 4.1.) Players getting their position at the beginning of the game](https://user-images.githubusercontent.com/69946205/173996285-f47428da-34ed-4cce-ac89-a42ba87c9591.png)

![Fig 4.2.) Player Role Selection](https://user-images.githubusercontent.com/69946205/173996323-5b09da15-4282-4f39-ada2-49d1ca1bdad2.png)

![Fig 4.3.) Game Scenario Selection](https://user-images.githubusercontent.com/69946205/173996356-089a90fd-b03a-4561-a202-3ff4b91fc2b1.png)

![Fig 4.4.) Character Selection](https://user-images.githubusercontent.com/69946205/173996403-24d64034-b2c0-4d5f-b410-4729046f9ad3.png)

 - Neat and intuitive User Interface
 - The users can be immersed into the game with a neat and intuitive user interface. They can check who to target, what to do and which card to use, what kind of equipped card they have.

![Fig 5.) Game Progress Screen - User Interface](https://user-images.githubusercontent.com/69946205/173996495-3c5a8966-7015-4244-bb87-6efc923a3c64.png)

 - The server has to be secured with a random password and has a limitation of 7 people. 

![Fig 6.1. ) Log-in Session](https://user-images.githubusercontent.com/69946205/173996925-06d457e7-7aeb-4108-a2ac-d807e9b043d2.png)

![Fig 6.2. ) Password input](https://user-images.githubusercontent.com/69946205/173997025-a3b6d549-5a85-454e-86cd-e8ec535940cf.png)

![Fig 6.3. ) Member exceed](https://user-images.githubusercontent.com/69946205/173997070-1aad6cf4-312a-4d48-9308-a1fe9c76b992.png)

#### Now, we had to check non-functional requirements.

 - Connection Timeout between server and client (10 Seconds)
 - We implemented this part with the following code, and the result is below the code : 

![Fig 7.1. ) Out-of-connection exceeded 10 seconds](https://user-images.githubusercontent.com/69946205/173997584-b073d3d3-c151-4dc8-a122-5498f133466e.png)

![Fig 7.2. ) Alert Message for time out](https://user-images.githubusercontent.com/69946205/173997627-c71501d4-0445-4757-a690-9de8f3c3157e.png)

- Server : We’ve made the server respond to each client below 1 seconds. This can be unavailable according to the environment condition of each client.

![Fig 8. ) Server Response rate](https://user-images.githubusercontent.com/69946205/173997907-356040dd-8640-4e37-934b-17987ced1a09.png)

 - Performance using Raspberry PI
 - As you can see, the figure below shows that we’ve used Raspberry PI for server performance.

![Fig 9.1. ) Server Hardware Specs](https://user-images.githubusercontent.com/69946205/173997988-c4939274-9880-401f-a72b-68b7b8cb49a1.png)

![Fig 9.2. ) Server Memory Specs](https://user-images.githubusercontent.com/69946205/173998110-01cb23ab-6947-4263-b45a-a161b4bd600b.png)

 Furthermore, we’ve had a test on the system to check if the server can tolerate 10000 clients. We’ve first used JMeter for the test. We’ve set 9999 clients for the initial test set, but the computer went out of memory when about 4000 clients accessed the server. The result follows : 

![Fig 10.1. ) Defining the the maximum number of Thread](https://user-images.githubusercontent.com/69946205/173998363-e6c445c6-0155-4b58-80d0-a22cab141c08.png)

![Fig 10.2. ) Check the maximum number of client the server can tolerate (Using JMeter)](https://user-images.githubusercontent.com/69946205/173998416-6b9f1b8f-e248-41e3-b023-519021f80e5d.png)

We’ve found that there were no issues or problems with 4000 clients on the server.

![Fig 10.3. ) Checking Server : 4000 Clients (2 ln per 1 Client)](https://user-images.githubusercontent.com/69946205/173998486-9cd5a809-0d84-4e23-89d5-e9dfc0199688.png)

 Next, we’ve used the Socket_V3 tool for testing. The test was focused on communication with server and client. Under the condition that 4000 clients are on the server, we’ve checked if the server can respond well to the client. The result follows : 
 
 ![Fig 10.4. ) Checking Server Tolerance (Using Socket_V3)](https://user-images.githubusercontent.com/69946205/173998519-1d7be2bc-cccf-4888-b6df-0322feb4b722.png)

 We’ve found that there were no problems or issues with communicating with the server no matter how many clients were on the server.
 
## 4. Glossary
 
Sheriff : The king of the game. Target of Outlaw and renegade

Vice : The role of helping Sheriff. Same target as Sheriff.

Outlaw : The opposite team of Sheriffs. The goal is to kill the Sheriff.

Renegade : No one is a team. The goal is to survive alone.

<Bang!> card : 1 damage to one player within range.

<Mancato!> card : Disable the effect of the <Bang!> card.

ThreadPool : A kind of pool that collects and manages Threads.

SessionManager : Check the connection status with the server in real time and check for abnormal disconnection.

PlayerManager : Manage access and exit of other players.

GameManager : Engage in game progress and UI placement related to the game. (ex. card usage, HP damage, etc.)

Capitializer : A sub-server created in one-to-one correspondence with each client when a client connects.

JMeter : Java program designed to test the performance of client-server structured software

Socket_V3 : A program that lets you access the server and send messages and receive responses.

## 5. Review

Our project isn’t over yet. We will update card functions and new cards necessary for the game. Also, even though we’ve set the limit of accessible clients to 10000, only 7 clients can enjoy the game now, so we will make more private rooms for many players to enjoy the game. Last but not least, we are going to upgrade the user interface to make people more immersed in the game.

 Through following the steps of Software Engineering, it was efficient and easy to understand the whole system. This led us to make the system to show better performance. Furthermore, testing in the validation step made us check the actual performance of the system, and made us realize the importance of Software Engineering. Still, it wasn’t easy to build and follow the Engineering Step, because it was difficult. But the result was satisfying, so we would be glad to follow this step whenever we launch a new project.
 
 ---
 
The copyright for board games is in daVinci Editrice S.r.l.

Please be aware that unauthorized copying or use may be subject to legal punishment.

Copyright - (ⓒ daVinci Editrice S.r.l. Via S. Penna, 24 I-06132 Perugia, Italy)
