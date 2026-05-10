TP3 : Collections et composition
Introduction
Ce TP porte sur l’évolution de l’application IPPlan-Manager pour gérer des ensembles d’objets structurés (réseaux, équipements, interfaces) en utilisant les concepts de composition et de collections en Java.  
Notions étudiées
Composition : Relation entre objets où un objet est constitué d’autres objets.  
ArrayList : Utilisation d’une liste dynamique pour stocker des objets.  
Collections : Gestion de groupes d’objets (équipements, sous-réseaux).  
Parcours de listes : Utilisation de la boucle for-each pour traiter les éléments d’une collection.  
Tests réalisés
Création d’une infrastructure complète nommée « Infrastructure IUT ».  
Ajout de plusieurs sous-réseaux (ADMIN, TECH et WIFI).  
Ajout d’un routeur (R1 EDGE) avec deux interfaces (eth0, eth1).  
Ajout d’un serveur (SRV-DATA) et d’un switch (SW-CORE).  
Test de la méthode rechercherEquipement pour localiser un serveur par son nom.  
Difficultés rencontrées
Manipulation des majuscules/minuscules dans la syntaxe Java (public, boolean, if).
Compréhension de la structure de la boucle for-each pour parcourir les ArrayList.
Organisation des dossiers pour respecter la structure du dépôt Git demandée par l’enseignant.  
Réponses aux questions 
(Étape 16)
La composition : C’est une relation « possède un » où un objet parent contient un ou plusieurs objets enfants comme attributs.  
Utilisation d’ArrayList : Elle permet d’ajouter dynamiquement des objets sans connaître la taille finale de la liste à l’avance.  
Variable simple vs Collection : Une variable simple contient une seule donnée, alors qu’une collection permet de regrouper et manipuler plusieurs objets ensemble.  
Interfaces multiples : Un équipement réseau réel, comme un routeur, a besoin de plusieurs interfaces pour se connecter à différents réseaux.  
Sous-réseaux multiples : Découper une infrastructure en sous-réseaux permet de segmenter le trafic et d’améliorer la sécurité.  
Boucle for-each : Son rôle est de parcourir chaque élément d’une collection de manière simplifiée sans utiliser d’index.  
Importance d’InfrastructureReseau : Elle centralise toute l’organisation du projet en devenant le conteneur principal de tous les objets réseau.  
Collections professionnelles : Elles sont indispensables car les réseaux réels contiennent des centaines d’équipements qu’on ne peut pas gérer individuellement

