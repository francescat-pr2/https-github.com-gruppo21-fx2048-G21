fx2048
======

The game 2048 built using JavaFX and Java 8. This is a fork based on the
Javascript version: https://github.com/gabrielecirulli/2048

Building fx2048
====================

You will need [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
and [ANT](http://ant.apache.org/) installed to build the project. Just
execute ant in the project root.

```bash
ant
```

Running fx2048
===================

After you've built the project you can run this with a simple java command.

```bash
java -jar dist/Game2048.jar
```

License
===================

The project is licensed under GPL 3. See [LICENSE](https://raw.githubusercontent.com/brunoborges/fx2048/master/LICENSE)
file for the full license.


**********************************************************************************

*Pr2 Project 2014*

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












