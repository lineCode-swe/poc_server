![gruppo lineCode](https://imagizer.imageshack.com/img923/557/86bUrf.png)

# PoC Motore di Calcolo - PORTACS
Proof of Concept del motore di calcolo per il colloquio sulla Technology Baseline con il prof. Riccardo Cardin.

Realizzato in Java con Maven come build automation.

Nella fase di `package` di Maven raggiungibile con:
```shell
mvn package
```
viene creato un artefatto .jar standalone containerizzabile con il Dockerfile presente in questa repo.

Il motore di calcolo espone la sua API REST su: `http://localhost:8080/myapp`.
