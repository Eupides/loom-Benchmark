# Java Project Loom Benchmark Programm
 
## Allgemein
Dieses Programm dient zum Benchmarking vom Preview-Feature Project Loom.
Es wurde erstellt um das neue Feature ausreichend mit den bisherigen Threads zu vergleichen
 
## Ausführung
Um dieses Program auszuführen benötigt man immer mindestens 2 Parameter
1. Task-Typ: CPU, IO oder MEM
2. Thread-Typ: normal oder Loom

### Programmparameter
Je nach Task-Typ ist die Paramterwahl nach dem 2. unterschiedlich.
#### CPU
3. maximale Anzahl an erstellten Threads
4. Anzahl der Berechnungszyklen
5. Zeit in Sekunden, die ein Thread warten sollte nach einer Kalkulation
6. Der höchste Wert einer Kalkulation
#### IO
3. Anzahl der erstellten Dateien
4. Anzahl der Editorthreads die die erste Datei bearbeiten
#### MEM
3. Anzahl an Threads
4. Anzahl an Bloat-Objekten
5. Anzahl an Bloat-Subobjekten proj Bloat-Objekt
6. Zeit in Sekunden, die ein Thread wartet bevor er sich schließt
