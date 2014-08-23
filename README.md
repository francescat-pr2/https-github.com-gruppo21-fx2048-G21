fx2048
======


*Pr2 Project 2014*

*Francesca Trudu* -
*Fulgheri Nadia Jolanda*

Modifica dell'implementazione del gioco 2048 in modo da permettere, opzionalmente, di giocare autonomamente con un giocatore automatico. 



Strumenti utilizzati:

git - distributed version control system


*Game2048.java*
classe contenente il main e il metodo start.
Implementa le funzioni e le variabili che si occupano di inizializzare e gestire l interfaccia grafica,
da qui viene inizializzato anche un oggetto di tipo GameManager che si occupa di tutte le funzioni di gestione del gioco: 
-i meccanismi di somma e spostamento delle caselle, 
-aggiornamento della griglia (a livello grafico), 
-aggiornamento dello score, 
-conclusione del gioco in caso di game over e vittoria del gioco.

Game2048 inoltre gestisce gli ascoltatori che implementano l'azione da svolgere in base al tasto premuto.












