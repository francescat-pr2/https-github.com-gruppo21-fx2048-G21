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

L'oggetto giocatore automatico viene creato tramite il suo metodo button (per attivare il giocatore automatico), la pressione del tasto shift è creato tramite un oggetto di tipo robot, che va in un thread che viene mandato in esecuzione affianco all'interfaccia grafica. Il meccanismo di simulazione di premere il tasto shift viene fatto in un altro processo (thread) rispetto al processo principale perchè cosi può lavorare in maniera simultanea rispetto all'interfaccia grafica<, infatti questo permette il suo funzionamento. Non sarebbe stata corretto in sostituzione l'utilizzo di una for o una while perchè l'aggiornamento del processo secondario non sarebbe stato simultaneo a quello dell'interfaccia grafica e quindi il tutto non sarebbe stato corretto.

Il thread secondario serve per far gestire l'evento per premere il tasto shift riconoscerlo e richiamare alcuni metodi in un altro thread che è separato da quello principale. I due processi lavorano in maniera affiancata o meglio parallela; il secondo thread lavora in autonomia ma non blocca il processo principale come succede nelle chiamate dei metodi classici.Questo permette di gestire il giocatore automatico parallelo senza bloccare il giocatore automatico, abbiamo avuto il bisogno di gestire la chiamata al metodo move in modo automatico e parallelo al processo principale senza bloccarlo e da li è nata la nostra l'idea di un thread di un altro processo.la chiamata al metodo move avviene in questo metodo addBtnclick è l'ascoltatore che lavora nel processo principale perchè viene catturata l'evento del tasto premuto.



LICENCE
=======

The project is licensed under GPL 3. See [LICENSE](https://raw.githubusercontent.com/brunoborges/fx2048/master/LICENSE)
file for the full license.

