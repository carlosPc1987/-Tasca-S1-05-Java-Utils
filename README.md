# Tasca S1.05 - Java Utils

TASCA S1.05 – Java Utils (Nivell 5)

//=============================\\  
||   Crafted with 💛 by Carlos  ||  
||     and approved by 🦆       ||  
\\=============================//

AUTOR
------
Carlos de Cozar 
GitHub: https://github.com/carlosPc1987/-Tasca-S1-05-Java-Utils.git

REQUISITS DE COMPLECIÓ
-----------------------
- Utilitzar Eclipse o IntelliJ per desenvolupar.
- Projectes Java senzills, Maven o Gradle són vàlids.
- Programa íntegrament en anglès.
- Evita rutes absolutes. Utilitza **rutes relatives**.
- Fes servir `File.separator` per compatibilitat entre sistemes.
- Segueix el document de bones pràctiques de l’Sprint 0.
- **Executa els exercicis des de la línia de comandes**, no només des de l’IDE.

COMPILAR MANUALMENT
---------------------
Des del directori arrel del projecte:

> javac -d out src/main/java/org/example/nivell1/exercici5/**/*.java

EXECUTAR MANUALMENT
---------------------
> java -cp out org.example.nivell1.exercici5.application.Main

FUNCIONALITAT
--------------

L’exercici 5 ofereix 3 accions diferents, seleccionables des de consola:

| ACCIÓ           | DESCRIPCIÓ                                                                 |
|------------------|-----------------------------------------------------------------------------|
| listar           | Mostra per pantalla la informació estructurada d’un directori              |
| serialitzar      | Desa la informació d’un directori en un fitxer `.ser` com a objecte Java   |
| desserialitzar   | Llegeix el fitxer `.ser` i mostra el contingut deserialitzat per consola   |


 Uso de utilidades (utils)
El projecte incorpora classes utils que encapsulan comportamientos genèrics reutilitzables, millorant l’organització i la netedat del codi. Aquests components ajuden a:
- Simplificar l’accés a operacions comunes (com lectura/escriptura de fitxers, formatació de dades, etc.).
- Evitar duplicació de codi entre nivells o exercicis.
- Separar la lògica auxiliar de la lògica principal (separation of concerns).
- Fer les classes més testejables i mantenibles.
 Exemples d’ús
- FileUtils: pot contenir mètodes per llegir, escriure o validar rutes i fitxers.
- DateUtils: pot oferir formatació de dates o càlculs de temps de modificació.
- SerializationUtils: encapsula la lògica de serialització i desserialització d’objectes Java.
- ConsoleUtils: ajuda a demanar i validar entrada per consola de forma reutilitzable

   //=============================\\  
  ||   Crafted with 💛 by Carlos  ||  
  ||     and approved by 🦆       ||  
   \\=============================//


   [github.com/carlosPc1987](https://github.com/carlosPc1987)
--------------------
