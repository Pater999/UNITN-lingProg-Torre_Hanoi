# UNITN-prog2-Torre_Hanoi
Università di Trento - Soluzione compito di Linguaggi di Programmazione, Modulo 1 – giugno 2018

Esempio di soluzione per l'esame di Ronchetti di giugno 2018.

#Di seguito il testo:

1) Si costruisca un’applicazione avente il seguente aspetto:

Vi sono tre PALI verticali (chiamati p1, p2 e p3) nei quali possono essere infilati
quattro DISCHI aventi diverse dimensioni. Inizialmente i dischi sono posti uno
sopra l’altro nel primo palo: ogni disco giace su un disco più grande.
Vi sono quattro bottoni (Clear, Move, Reset, Close) e due campi di testo,
inizialmente vuoti, a fianco di due etichette “from” e “to”. Il botton Close è
inizialmente disabilitato.
1b) Si documenti il codice prodotto con javadoc.
2) Se i campi di testo “from” e “to” sono vuoti, cliccando su un palo con il mouse,
il campo “from” si popola con il nome del palo, ed il sistema “ricorda” che il “palo
di partenza” è quello cliccato.

2b) Se però il palo cliccato come partenza è vuoto (ovvero non ha dischi),
il sistema stampa un avviso dicente “Il palo di partenza non può essere
vuoto” e null’altro accade.
3) Se il campo “from” non è vuoto ma il campo “to” lo è, cliccando su un palo il
campo “to” si popola con il nome del palo, ed il sistema “ricorda” che il “palo di
destinazione” è quello cliccato.
3b) Se però come destinazione si clicca sul palo già scelto come partenza,
il sistema stampa il messaggio “il palo di partenza e quello di destinazione
non possono coincidere” e null’altro accade.
4) Se entrambi il palo di partenza e quello di arrivo sono già definiti, cliccando su
un palo il sistema stampa il messaggio “il palo di partenza e quello di
destinazione sono già definiti” e null’altro accade.
4) Il tasto “Clear” cancella i due campi di testo, e fa dimenticare al sistema quali
sono i pali di partenza e di destinazione.
5) Il tasto “Move” preleva il disco posto più in alto dal palo di partenza, e lo
depone sul palo di arrivo, sotto due condizioni:
5a) Se i campi “from” e/o “to” sono vuoti, ovvero non sono definiti i pali di
partenza e di destinazione, il sistema stampa il messaggio “pali di
partenza e di arrivo non definiti” e null’altro accade.
5b) Se il palo di destinazione è già popolato con un disco di dimensione
minore di quello che deve essere trasferito, il sistema stampa il
messaggio “impossibile appoggiare un disco su uno più piccolo” e
null’altro accade.
6) Il tasto “Reset” ripristina lo stato iniziale.
7) I messaggi di sistema vanno mostrati in una finestra di pop up (in prima
battuta li si scriva semplicemente in console).
8) Quando compare la finestra di pop up, il bottone “Close” viene abilitato.
Premendolo, la finestra di pop up viene chiusa ed il bottone ritorna disabilitato.
9) Si produca e si consegni (su un foglio di protocollo sul quale devono essere
presenti nome, cognome, numero di matricola) un diagramma UML delle classi
sviluppate.
