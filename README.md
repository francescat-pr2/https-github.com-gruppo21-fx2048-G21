fx2048
======
*Pr2 Project 2014*
==================
*Gruppo21 :*<BR>
*Francesca Trudu matricola 44884*<BR>
*Fulgheri Nadia Jolanda matricola 39310*


The game 2048 built using JavaFX and Java 8. 
This is a fork based on the Javascript version: https://github.com/atzori/fx2048.git




Scopo del progetto
==================
Modifica dell'implementazione del gioco 2048 in modo da permettere, opzionalmente, di giocare autonomamente con un giocatore automatico. 



Strumenti utilizzati
====================
NetBeans - <BR>
GitHub - <BR>


Modalità di gioco:
=================
All'avvio del gioco compare una finestra principale attraverso la quale il giocatore può decidere se avviare il gioco manualmente facendo la prima mossa o se giocare con l'ausilio di un giocatore automatico premendo il pulsante apposito.
Se si di effettua la prima mossa si inizia a giocare in modalità manuale e si prosegue il gioco effettuando una delle quattro mosse possibili con i tasti freccia direzionali.
Se si preme il pulsante "Giocatore Automatico" si avvia il gioco in modalità automatica o si prosegue il gioco con tale modalità se si è precedentemente iniziata la manche in modalità giocatore standard; 
il giocatore automatico eseguirà un intero turno di gioco con una sequenza consecutiva di mosse fino alla fine della partita, ossia: <BR>
-raggiungimento del risultato vincente 2048; <BR>
-game over se non sono disponibili ulteriori mosse.



*Classi principali del gioco*

*Game2048.java*

Implementa le funzioni e le variabili che si occupano di inizializzare e gestire l'interfaccia grafica,
da qui viene inizializzato anche un oggetto di tipo GameManager che si occupa di tutte le funzioni di gestione del gioco:<BR>
-meccanismi di somma e spostamento delle caselle; <BR>
-aggiornamento della griglia (a livello grafico); <BR> 
-aggiornamento dello score; <BR>
-conclusione del gioco in caso di game over o vittoria del gioco.

Modifiche effettuate:

—>  inserimento del button 'Giocatore Automatico': <BR> 
al click del bottone viene azionato il gioco automatico;

—>  creazione dell'oggetto Robot:<BR> 
tramite l'oggetto robot viene simulata la pressione del tasto SHIFT finchè non si ha il gameOver o il gameWon, il Robot continua a premere SHIFT e ogni volta l'ascoltatore intercetta l'evento permettendo l'esecuzione del gioco in autonomia;

—>  creazione Thread: <BR> 
creazione di un Thread che lavora parallelarmente al processo principale e si occupa di far funzionare il l'oggetto Robot e di sincronizzare il gioco;


*GameManager*

GameManager si occupa, tramite il metodo "move()", di gestire tutto il meccanismo di somma e spostamento delle caselle quindi: <BR>
-la somma di due caselle con valori uguali; <BR> 
-la posizione finale della casella figlia generata; <BR> 
-la cancellazione delle caselle sommate. <BR>

Tramite la classe Gamemanager si ha inoltre l'implementazione delle funzionalità aggiuntive del gioco come il calcolo del punteggio, l'inizzializzazione di myGriglia e l'aggiornamento in modo simultaneo a GameGrid.
La conclusione della partita si ha in caso di gameOver e gameWon cioè quando una delle due variabili booleane assume il valore "true".
Finchè non si ha il gameOver o il gameWon, il Robot continua a simulare la pressione del tasto SHIFT e ogni volta l'ascoltatore intercetta l'evento permettendo l'esecuzione del gioco in autonomia.



*Dettagli Tecnici Implementativi*

Per permettere il funzionamento corretto del gioco e quindi il meccanismo di simulazione di pressione del tasto SHIFT è stato necessario affiancare un thread "secondario" rispetto al processo principale che si occupa di gestire l'interfaccia grafica. 
In tal modo si è potuto far in modo che i processi lavorassero in maniera parallela.

Con la pressione del button "Giocatore Automatico" si ha la conseguente azione di creazione del thread secondario che permette di simulare la pressione del tasto SHIFT tramite un oggetto di tipo Robot, evento che viene catturato da un ascoltatore apposito addBtnClicked che implementa l'azione da eseguire ossia la chiamata al metodo del giocatoreAutomatico prossimaMossa che restituisce un int random da 0 a 3, che verrà utilizzato dallo switch case per restituire la Direction ed essere successivamente passato al metodo move() del GameManager.

addBtnClicked() è il metodo che viene richiamato alla pressione del tasto shift da parte del robot nel thread, l'ascoltatore nell'addKeyHandler cattura l evento e se il tasto premuto è shift viene chiamato il metodo addBtnClicked che si preoccupa di richiamare il metodo prossimaMossa() ottenendo un valore int , sempre in addBtnClicked attraverso uno switch creiamo un valore di tipo direction in base all'int restituito dal prossimaMossa() che rappresenta la possima mossa da effettuare che viene effettivamente svolta passando la varibile direction al metodo move().




LICENCE
=======

The project is licensed under GPL 3. See [LICENSE](https://raw.githubusercontent.com/brunoborges/fx2048/master/LICENSE)
file for the full license.

