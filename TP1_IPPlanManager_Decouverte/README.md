TP1 : Projet IPPlan-Manager

## 1. Présentation du projet
Ce projet est une application Java développée dans le cadre du cours de Programmation Orientée Objet (POO). L’objectif est de créer un outil d’aide à la gestion des plans d’adressage IP pour les administrateurs réseaux. Ce premier TP pose les bases structurelles du projet.

## 2. Architecture du code (Classes créées)
* AdresseIP : Gère le stockage des adresses IPv4.
* ReseauIP : Représente un sous-réseau (Adresse, Masque CIDR, Description).
* InterfaceReseau: Simule une interface physique (Nom, IP associée, État activé/désactivé).
*Equipement: Représente un matériel réseau (Routeur, Switch, PC) contenant une interface.
* Main : Point d’entrée du programme servant à tester les interactions entre objets.
 ## 3. Travail réalisé 

 A. Implémentation des classes
J’ai créé et structuré les 4 classes fondamentales dans le package `ipplanmanager` :
* AdresseIP : Stockage des chaînes IPv4.
* ReseauIP : Définition des réseaux avec masque CIDR.
* InterfaceReseau : Gestion de l’état (actif/inactif) et lien avec une IP.
* Equipement: Modélisation du matériel réseau.

B. Instanciation des objets (Minimum 5 requis)
Dans la classe `Main`, j’ai créé les objets suivants pour démontrer le fonctionnement :
1. Routeur: Un équipement avec une interface active et une IP fixe.
2. Serveur : Un équipement simulant un serveur de fichiers.
3. Switch : Test d’un équipement avec une interface sans adresse IP(conformément à l’étape 13.2).
4. Point d’accès WiFi: Un équipement avec interface active sur un réseau de management.
5. Poste Client: Test d’un équipement avec une interface inactive (conformément à l’étape 13.5).

 C. Validation du fonctionnement
Le programme s’exécute correctement dans la console NetBeans, affichant les détails de chaque réseau et la configuration complète de chaque équipement (Nom, Type, Interface, IP et État).

 D. Gestion des sources
Le projet est organisé selon la structure demandée :
* Code source dans src/.
* Fichier `README.md` complété.
* Historique des versions géré avec Git.

 4. Réponses aux questions de compréhension (Étape 14)

1.Pourquoi créer une classe AdresseIP au lieu d’utiliser un simple String ?
   Cela permet de préparer l’ajout de méthodes de validation (vérifier que les octets sont entre 0 et 255) et de calcul sans avoir à modifier le reste du code plus tard.

2.Quelle est la différence entre une classe et un objet ?
   La classe est le modèle théorique (le moule), tandis que l’objet est une instance concrète créée en mémoire à partir de ce modèle.

3.Quel est le rôle du constructeur ?
   Il sert à initialiser les attributs d’un objet au moment de sa création avec le mot-clé `new`.

4.Pourquoi la classe InterfaceReseau contient-elle un objet de type AdresseIP ?
   Parce que dans la réalité, une interface réseau possède une adresse IP. C’est une relation de composition.

5.Pourquoi la classe Equipement contient-elle un objet de type InterfaceReseau ?

   Un équipement réseau a besoin d’au moins une interface pour pouvoir communiquer sur un réseau.

6.Quelle est la limite actuelle de la classe Equipement ?
   Elle ne possède qu’une seule interface, alors que les équipements réels (comme les switchs ou routeurs) en possèdent généralement plusieurs.

7.Pourquoi cette version du programme est-elle insuffisante pour gérer un plan d’adressage ?
   Elle ne fait que stocker et afficher des informations ; elle ne calcule pas encore les plages d’adresses ou les masques de sous-réseau.

