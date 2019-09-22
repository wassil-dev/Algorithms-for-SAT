# Algorithmes pour probleme SAT en JAVA

* Ce projet contient les algorithmes suivant :

  * **Algorithmes Aveugles** : Largeur D'abord , Profondeur D'abord , A etoile ( A* ).
  * **MetaHeuristiques** : Algorithme Genetique et PSO .

## Structure des fichiers :
  - Classe SAT : Elle représente le probleme SAT avec sa matrice qu'elle construit a part du fichier cnf exemple : ( uf75-01.cnf ).
  - Classe noeud qui réprésente un noeud qui est un etat de la solution .
  - Classe NoeudParcours : Un noeud pour l'utiliser dans les algorithmes aveugles.
  - Classe NoeudG : un noeud pour Algorithme genetique.
  - Classe NoeudPSO : un noeud pour l'algorithme PSO.
  - Classe Particule : Algorithme de PSO.
  - Classe Genetique : Algorithme de genetique.
  - Classe Parcours : Algorithmes A* + Largeur d'abord + profondeur d'abord.
  - Classe Main : Pour executer et appeler les classes.
  - Les ficheirs CNF testés sur les algos.
