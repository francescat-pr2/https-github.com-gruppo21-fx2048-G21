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
All'avvio del gioco compare una finestra principale attraverso la quale il giocatore può decidere se avviare il gioco manualmente facendo la prima mossa o se giocare tramite l'ausilio di un giocatore automatico premendo il pulsante apposito.
Se si di effettua la prima mossa si inizia a giocare in modalità manuale e si prosegue il gioco effettuando una delle quattro mosse possibili con i tasti freccia direzionali.
Se si preme il pulsante "Giocatore Automatico" si avvia il gioco in modalità automatica o si prosegue il gioco con tale modalità se si è precedentemente iniziata la manche in modalità giocatore standard; 
il giocatore automatico eseguirà un intero turno di gioco, esegue una sequenza consecutiva di mosse fino alla fine della partita, ossia: <BR>
-raggiungimento del risultato vincente 2048; <BR>
-game over se non sono disponibili ulteriori mosse.



*Classi principali del gioco e modifiche effettuate*

*Game2048.java*

Implementa le funzioni e le variabili che si occupano di inizializzare e gestire l'interfaccia grafica,
da qui viene inizializzato anche un oggetto di tipo GameManager che si occupa di tutte le funzioni di gestione del gioco:<BR>
-meccanismi di somma e spostamento delle caselle;<BR>
-aggiornamento della griglia (a livello grafico);<BR> 
-aggiornamento dello score;<BR>
-conclusione del gioco in caso di game over o vittoria del gioco.

Modifiche effettuate:

—>  inserimento del button 'Giocatore Automatico':<BR> 
al click del bottone viene azionato il gioco automatico;

—>  creazione dell'oggetto Robot:<BR> 
tramite l'oggetto robot viene simulata la pressione del tasto SHIFT finchè non si ha il gameOver o il gameWon, il Robot continua a premere SHIFT e ogni volta l'ascoltatore intercetta l'evento permettendo l'esecuzione del gioco in autonomia;

—>  creazione Thread:<BR> 
creazione di un Thread che lavora parallelarmente al processo principale e si occupa di far funzionare il l'oggetto Robot e di sincronizzare il gioco;


*GameManager*

Tramite il metodo move, viene gestito il meccanismo di movimento di una casella, quindi della somma di due caselle con valori uguali, della posizione finale di una casella ottenuta dopo la somma, della posizione della casella figlia generata e della cancellazione delle precedenti;
un'altra funzione importante di Gamemanager e l'inizzializzazione di myGriglia e l'aggiornamento in modo simultaneo a GameGrid. 
Finchè non si ha il gameOver (e anche il gameWon) il Robot continua a simulare la pressione del tasto SHIFT e ogni volta l'ascoltatore intercetta l'evento permettendo l'esecuzione del gioco in autonomia. Quindi riassumendo GameManager si occupa delle seguenti funzioni: -meccanismi di somma e spostamento delle caselle, -aggiornamento della griglia (a livello grafico), -aggiornamento dello score, -conclusione del gioco in caso di gameOver e gameWon della partita. -aggiunta di 3 variabili boolean: gameOver e gameWon pubbliche e Griglia: myGriglia viene aggiornata in base alla situazione del gioco

*MyGiocatoreAutomatico*
Implementa l'interfaccia GiocatoreAutomatico.
Implimenta il metodo prossimaMossa dichiarato nell'interfaccia; tale metodo è utilizzato nel Game2048 su un oggetto GiocatoreAutomatico (memorizzato nella variabile myPlayer) e restituisce un int random da 0 a 3 con conseguente creazione di un valore Direction che viene passato al metodo move() del GameManager. 

*MyGriglia*
Implementa l'interfaccia 


LICENCE
=======

The project is licensed under GPL 3. See [LICENSE](https://raw.githubusercontent.com/brunoborges/fx2048/master/LICENSE)
file for the full license.




GameManager si occupa di gestire tutto il procedimento del movimento di una casella quindi della somma di due caselle di valori uguali, della posizione finale ottenuta dopo la somma e della casella figlia appena nata e della cancellazione delle precedenti;un altra funzione importante di Gamemanager e l'inizzializzazione di myGriglia e di aggiornarla in modo simultaneo a GameGrid. Finchè non si ha il gameOver (e anche il gameWon) il Robot continua a premere shift e ogni volta l'ascoltatore intercetta l evento permettendo l esecuzione del gioco in autonomia. Quindi riassumendo GameManager si occupa delle seguenti funzioni: -meccanismi di somma e spostamento delle caselle, -aggiornamento della griglia (a livello grafico), -aggiornamento dello score, -conclusione del gioco in caso di gameOver e gameWon della partita. -aggiunta di 3 variabili boolean: gameOver e gameWon pubbliche e Griglia: myGriglia viene aggiornata in base alla situazione del gioco

Modifiche effettuate: -aggiunta del package giocatoreAutomatico (e giocatoreAutomatico.player); -aggiunta delle classi implementate dalle interfacce.

-aggiunta di variabili, di un ascoltatore e di un Thread in Game2048 -> giocatoreAutomatico: viene creato un oggetto giocatoreAutomatico tramite il suo metodo; -aggiunta di button per attivare il giocatore automatico e della conseguente azione che crea un Thread permettendo di simulare la pressione del tasto shift tramite un oggetto di tipo Robot, evento che viene catturato da un ascoltatore apposito addBtnClicked che implementa l'azione da eseguire: -chiamata al metodo del giocatoreAutomatico prossimaMossa che restituisce un int random da 0 a 3, che verrà utilizzato dallo switch case per restituire la Direction ed essere successivamente passato al metodo move() del GameManager.

Il processo principale rimane comunque l'intefaccia grafica. L'oggetto giocatore automatico viene creato tramite il suo metodo button (per attivare il giocatore automatico), la pressione del tasto shift è creato tramite un oggetto di tipo robot, che va in un thread che viene mandato in esecuzione affianco all'interfaccia grafica. Il meccanismo di simulazione di premere il tasto shift viene fatto in un altro processo (thread) rispetto al processo principale perchè cosi può lavorare in maniera simultanea rispetto all'interfaccia grafica<, infatti questo permette il suo funzionamento. Non sarebbe stata corretto in sostituzione l'utilizzo di una for o una while perchè l'aggiornamento del processo secondario non sarebbe stato simultaneo a quello dell'interfaccia grafica e quindi il tutto non sarebbe stato corretto.

Il thread secondario serve per far gestire l'evento per premere il tasto shift riconoscerlo e richiamare alcuni metodi in un altro thread che è separato da quello principale. I due processi lavorano in maniera affiancata o meglio parallela; il secondo thread lavora in autonomia ma non blocca il processo principale come succede nelle chiamate dei metodi classici.Questo permette di gestire il giocatore automatico parallelo senza bloccare il giocatore automatico, abbiamo avuto il bisogno di gestire la chiamata al metodo move in modo automatico e parallelo al processo principale senza bloccarlo e da li è nata la nostra l'idea di un thread di un altro processo.la chiamata al metodo move avviene in questo metodo addBtnclick è l'ascoltatore che lavora nel processo principale perchè viene catturata l'evento del tasto premuto.

Messaggi - Contatti - Calendario - Opzioni - Logout
Copyright © 2014 - katamail.com - tutti i diritti riservati
