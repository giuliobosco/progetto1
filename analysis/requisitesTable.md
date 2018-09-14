# Requisites Table
##### Giulio Bosco - Progetto 1

|ID  |REQ-001                                        |
|----|------------------------------------------------|
|**Nome**    |Tipo Software |
|**Priorità**|1                     |
|**Versione**|1.0                   |
|**Note**    |Web-app|
|            |**Sotto requisiti** |
|**001**     | registrazione utenti  |
|**002**     | pagina con campi obbligatori e con validazione                |
  
|ID  |REQ-002                                       |
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

|ID  |REQ-003                                    |
|----|------------------------------------------------|
|**Nome**    |Pagine |
|**Priorità**|2                     |
|**Versione**|1.0                   |
|**Note**    |4 pagine|
|            |**Sotto requisiti** |
|**001**     | introduzione  |
|**002**     | inserzione dati |
|**003**     | controllo dati |
|**004**     | lettura dati da CSV |

|ID  |REQ-004                                        |
|----|------------------------------------------------|
|**Nome**    | Pagina _Introduzione_ |
|**Priorità**|2                     |
|**Versione**|1.0                   |
|**Note**    |pagina di benventuto|
|            |**Sotto requisiti** |
|**001**     | tasto -> pagina registrazione  |
|**002**     | pagina con campi obbligatori e con validazione                |

|ID  |REQ-005                                       |
|----|------------------------------------------------|
|**Nome**    |Pagina _Inserzione Dati_ |
|**Priorità**|1                     |
|**Versione**|1.0                   |
|**Note**    |Form dei dati|
|            |**Sotto requisiti** |
|**001**     | Validazione dei dati  |
|**002**     | Tasto -> Annullamento Inserimento |
|**003**     | Tasto -> Controllo Dati |

|ID  |REQ-006                                        |
|----|------------------------------------------------|
|**Nome**    |Pagina _Controllo Dati_ |
|**Priorità**|1                     |
|**Versione**|1.0                   |
|**Note**    |Controllare i dati|
|            |**Sotto requisiti** |
|**001**     | Mostrare dati come nel form di registrazione |
|**002**     | tasto -> correzione |
|**003**     | tasto -> iscrizione, salvare i dati e andare alla pagina lettura dati |

|ID  |REQ-007                                        |
|----|------------------------------------------------|
|**Nome**    |Pagina _ Lettura dati da CSV_ |
|**Priorità**|2                    |
|**Versione**|1.0                   |
|**Note**    |presentazione dati|
|            |**Sotto requisiti** |
|**001**     | design pagina registrazione  |
|**002**     | dati letti da "Registrazione_yyyy_mm_dd.csv" |
|**003**     | ritorno a pagina benvenuto |

|ID  |REQ-008                                        |
|----|------------------------------------------------|
|**Nome**    | Grafica |
|**Priorità**|3                     |
|**Versione**|1.0                   |