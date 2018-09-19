# Requisites Table
##### Giulio Bosco - Progetto 1

|ID  |REQ-001                                       |
|----|------------------------------------------------|
|**Nome**    |Dati |
|**Priorità**|1                     |
|**Versione**|1.0                   |
|**Note**    |File CSV|
|            |**Sotto requisiti** |
|**001**     | Salvare i file in 2 CSV (Registrazioni_tutte.csv, Registrazione_yyyy_mm_dd.csv)  |
|**002**     | File salvati nella root del sito sotto "Registrazioni" |
|**003**     | separatore ";" |
|**004**     | permessi di scrittura |

#

|ID  |REQ-002                                    |
|----|------------------------------------------------|
|**Nome**    |Pagine |
|**Priorità**|2                     |
|**Versione**|1.0                   |
|**Note**    | ci devono essere 4 pagine.|
|            |**Sotto requisiti** |
|**001**     | ci deve essere una pagina con una descrizione del prodotto: introduzione  |
|**002**     | ci deve essere una pagina di inserimento dei dati. |
|**003**     | ci deve essere una pagina per controllare i dati precedentemente inseriti. |
|**004**     | ci deve essere una pagina per visualizzare i dati appena inseriti. |

#

|ID  |REQ-003                                        |
|----|------------------------------------------------|
|**Nome**    | Pagina _Introduzione_ |
|**Priorità**|2                     |
|**Versione**|1.0                   |
|**Note**    |pagina di benventuto|
|            |**Sotto requisiti** |
|**001**     | Ci deve essere un tasto che porta alla pagina di inserimento dei dati.  |

#

|ID  |REQ-004                                       |
|----|------------------------------------------------|
|**Nome**    |Pagina _Inserzione Dati_ |
|**Priorità**|1                     |
|**Versione**|1.0                   |
|**Note**    |Form dei dati|
|            |**Sotto requisiti** |
|**001**     | Validazione dei dati  |
|**002**     | Ci deve essere un tasto che annulli l'inserimento fatto, cancelli tutti i contenuti dei campi. |
|**003**     | Ci deve essere un tasto che porti alla pagina di controllo dei dati. |

#

|ID  |REQ-005                                        |
|----|------------------------------------------------|
|**Nome**    |Pagina _Controllo Dati_ |
|**Priorità**|1                     |
|**Versione**|1.0                   |
|**Note**    |Controllare i dati|
|            |**Sotto requisiti** |
|**001**     | Mostrare dati come nel form di registrazione |
|**002**     | Ci deve essere un tasto per correggere i dati inseriti, che riporti alla pagina: _Inserzione Dati_ |
|**003**     | Ci deve essere un tasto per la registrazione, che scriva i dati sul csv e che poi porti alla pagina di _Lettura dei dati dal CSV_ |

#

|ID  |REQ-006                                        |
|----|------------------------------------------------|
|**Nome**    |Pagina _ Lettura dati da CSV_ |
|**Priorità**|2                    |
|**Versione**|1.0                   |
|**Note**    |presentazione dati|
|            |**Sotto requisiti** |
|**001**     | la grafica di questa pagina deve essere uguale alla pagina di registrazione |
|**002**     | la posizione dei campi deve essere uguale alla pagina di registrazione. |
|**002**     | dati letti da "Registrazione_yyyy_mm_dd.csv" |
|**003**     | Teasto per ritornare alla pagina benvenuto |

#

|ID  |REQ-007|
|----|------------------------------------------------|
|**Nome**    | Grafica |
|**Priorità**|3|
|**Versione**|1.0|
|**Note**    |La grafica delle pagine è a discrezione del esecutore. |