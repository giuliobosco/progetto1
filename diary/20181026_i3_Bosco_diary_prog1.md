# PROGETTO1 | Diario di lavoro - 26.10.2018
##### Giulio Bosco
### Canobbio, 26.10.2018

## Lavori svolti

|Orario        |Lavoro svolto                 |
|--------------|------------------------------|
|13:15 - 13:30 |Implementazione: Classe Csv, Costruttore String path  |
|13:30 - 13:40 |Implementazione: Initialize Address |
|13:40 - 13:45 |Aggiunto i diagrammi delle classi Csv e CsvToJson |
|13:45 - 14:00 |Implementazione: Correzioni classi validator in JS |
|14:00 - 16:30 |Implementazione: Cercare di capire perché viene scatenato un errore nelle servlet |

##  Problemi riscontrati e soluzioni adottate
### Errore nel salvataggio Csv dalle servlet.
Quando si esegue da linea di comando il Csv.main() non da problemi, crea il file se non esiste e inserisce i dati.
Mentre eseguendo lo stesso processo dalle servlet o dai file .jsp viene scatenata l'eccezione NoCsvHeaderException e
sembra che non venga creato nessun file.  
Dopo svariati tentativi non sono ancora riuscito a capire il perché.

Per cercare di capire dove vi è il problema ho provado ad eseguire il debugging dell'intero codice, senza trovare l'errore.

Dopo scuola mi sono messo a provare ancora ed in poco tempo ho trovato qual'era il problema. Il file era gia eseistente
ma vuoto nella cartella di Tomcat, quando si eseguono i programmi i file che vengono generati vengono scritti
nella cartella su cui lavora Tomcat, cioè (/usr/local/tomcat/bin). In quella posizione vi era un file vuoto, quindi era
giusto che venisse scatenaa l'eccezione.

##  Punto della situazione rispetto alla pianificazione
Sono indietro rispetto alla pianificazione perché ho avuto problemi con le servlet di java.
