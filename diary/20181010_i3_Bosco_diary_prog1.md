

# PROGETTO | Diario di lavoro - 10.10.2018
##### Giulio Bosco
### Canobbio, 10.10.2018

## Lavori svolti


|Orario        |Lavoro svolto                 |
|--------------|------------------------------|
|13:15 - 13:30 |Preparato ambiente di sviluppo |
|13:30 - 13:45 |Implementato classe DateValidator (JavaClass) |
|13:45 - 14:15 |Implementato classe Record (JavaClass) |
|14:15 - 14:30 |Ripassare il funzionamento delle operazioni sui file in Java |
|14:30 - 14:45 |Inizio implementazione classe Csv |

##  Problemi riscontrati e soluzioni adottate
### Ambiente di sviluppo
Come ambiente di sviluppo ho deciso di utilizzare
[JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/?fromMenu),
un tool professionale per lo sviluppo in Java.
Siccome la licenza "Education" è gratuita ho deciso di utilizzare questo software, che porta molte facilitazione durante lo sviluppo.

### Scrittura in un file
Durante l'implementazione della class "Csv" ho avuto problemi con la scrittura nel file.
#### Soluzione:
Soluzione trovata su StackOverflow alla domanda How do I create a file and write to it in Java?`
[Link](https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java),
Consultazione: 10.10.2018
````
Files.write(filePath, lines, Charset.forName("UTF-8"));
````

##  Punto della situazione rispetto alla pianificazione
Rispetto alla pianificazione sono avanti, siccome ho impiegato solamente 15 minuti per configurare l'ambiente di sviluppo, quindi ho gi&agrave; iniziato a implementare.


## Programma di massima per la prossima giornata di lavoro
Finire tutta la gestione dei Csv ed inizio dell'implementazione della grafica.
