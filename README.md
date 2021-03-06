![gruppo lineCode](https://imagizer.imageshack.com/img923/557/86bUrf.png)

# PoC Motore di Calcolo - PORTACS
Proof of Concept del motore di calcolo per il colloquio sulla Technology Baseline con il prof. Riccardo Cardin.

## Overview
L'applicativo funge da PoC e simula il comportamento di un server con mappa e motore di calcolo nel sistema real-time progettato e sviluppato come attività progettuale per il corso di SWE dell'Università degli Studi di Padova sotto il nominativo di Progetto _PORTACS_.

## Installazione, dipendenze ed esecuzione
Dipendenze:
 - JDK 13
 - Maven

Nella fase di `package` di Maven raggiungibile con:
```shell
mvn package
```
viene creato un artefatto .jar standalone containerizzabile con il Dockerfile presente in questa repo.

Il motore di calcolo espone la sua API REST su: `http://localhost:8080/myapp`.
