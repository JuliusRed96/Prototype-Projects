Guida al funzionamento e progettazione backend di Torino Teatri (PROTOTIPO).

Il progetto è stato creato nella parte backend su Java Spring [boot] [devtools], un database MySQL Workbench contenente 5 tabelle (Biglietti, Clienti, Repliche, Spettacoli, Teatri) e l'uso API esterna Postman.

Il progetto nella parte backend Java Spring [boot] [devtools] è composto da:

1) Le classi (Biglietto, clienti, repliche, spettacoli, teatri);

2) Le classi controller hanno la funzione di mandare la request tramite l'API esterna Postman, al servcer dove sta database torino_teatro:

* Il "SAVE", che serve per salvare i dati nella tabella scelta, che si trova nel database;

* "L'UPDATE", che serve per aggiornare o modificare i dati tramite che si trovano nella colonna scelta (tramite "ID") della tabella del database ad esempio (l'ora o la data dello spettacolo\replica ecc.);

* Il "DELETE", che serve per eliminare\rimuovere i dati che si trovano nella colonna scelta (tramite "ID") della tabella;

* "FINDALL", che serve per ricevere sotto forma di lista "JSON" i dati che si trovano dentro la tabella.

Il progetto è compreso anche di 5 tabelle nel server database MySQL Workbench che sono (Biglietto, clienti, repliche, spettacoli, teatri).

Per fare partire il progetto (PROTOTIPO) bisogna:

* Importare il database che si trova nell'aposita cartella "EXPORT DATABASE" su MySQL Workbench;

* Importare la cartella "Torino_Teatri" del progetto su Eclipse è farlo partire con Java Spring [boot] [devtools];

* Importare il file "java" nell'API esterna Postaman, che si trova nell'aposita cartella "Da importare su Postman" 



 
