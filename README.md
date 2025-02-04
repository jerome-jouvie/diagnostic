# auto-diagnostic

Coding test basé sur le document [coding_test_v3.pdf](coding_test_v3.pdf)

## Structure du projet
Le projet est basé sur l'architecture hexagonale.

### core
Contient :
- le domain (entité métier)
- la logique métier (service et use cases)
- les ports vers l'extérieur (interfaces)

### infrastructure
Contient les adapteurs des ports pour communiquer avec le capteur
et l'écran de la cabine automatisée d'auto-diagnostic.

### application
Contient l'injection des dépendances et le runner de l'application

### code-coverage-report
Projet d'aggragation de couverture de code

## Commandes gradle

### Pré-requis

Disposer de Java 21 accessible par defaut ou via la variable d'environnement JAVA_HOME

Il est également possible d'ajouter aux commandes gradlew l'argument: `-Dorg.gradle.java.home=<path_to_java_21>`

### Generation du rapport de couverture de code

    ./gradlew check

puis ouvrir le rapport : [code coverage report](code-coverage-report/build/reports/jacoco/testCodeCoverageReport/html/index.html)

### Execution de l'application

    ./gradlew application:bootRun
