# Rapport de TP 2 : Encapsulation et Robustesse du Code

1. Objectifs du Projet
* Sécurisation des données: Mise en place de l’accès restreint (private) pour protéger l’état interne des objets réseau.
* Intégrité du système: Utilisation des méthodes Getters et Setters pour filtrer les données entrantes.
* Automatisation des contrôles: Application systématique des règles de validation dès l’instanciation des objets via les constructeurs.

2. Concepts de Programmation Orientée Objet Appliqués
* Encapsulation: Masquage des attributs pour empêcher les modifications directes non autorisées.
* Validation de données : Implémentation de conditions logiques (if/else) pour rejeter les valeurs incohérentes (IP nulles, masques hors limites).
* Référencement d’instance (this): Distinction précise entre les variables de classe et les paramètres de méthodes pour assurer la clarté du code.

3. Questionnaire de compréhension
1. Pourquoi utilise-t-on le modificateur private ?** Pour interdire l’accès direct aux attributs depuis l’extérieur de la classe, garantissant ainsi que les données ne soient pas modifiées de manière anarchique.
2. Différence entre un attribut public et un attribut privé ?** Un attribut public est accessible par n’importe quelle autre classe du projet, tandis qu’un attribut privé n’est visible et manipulable qu’à l’intérieur de sa propre classe.
3. Quel est l’intérêt des méthodes getters et setters ?** Ils servent d’interface de contrôle. Le getter permet de lire la donnée en toute sécurité, et le setter permet de la modifier tout en appliquant des règles de validation.
4. Pourquoi est-il important de valider les données ?** Dans un contexte réseau, des données erronées (comme un masque CIDR de 50) rendraient les calculs de sous-réseaux impossibles et pourraient faire planter l’application.
5. À quoi sert le mot-clé « this » ?Il permet de lever l’ambiguïté en désignant explicitement l’attribut de l’objet actuel lorsque le paramètre d’une méthode porte le même nom.
6. Pourquoi appeler les setters dans le constructeur ?** Pour s’assurer que les règles de validation sont appliquées dès la création de l’objet, évitant ainsi la naissance d’objets avec des données invalides.
 4. Difficultés et Problèmes Rencontrés

Défis Techniques de Syntaxe
* Gestion de la casse (Case Sensitivity) : Résolution d’erreurs de compilation liées à la distinction stricte entre les noms de classes (ex : `AdresseIP`) et les instances (ex : `ip1`).
* Erreurs de structure de blocs: L’imbrication des instructions de contrôle à l’intérieur des méthodes a nécessité une correction rigoureuse de la portée des accolades `{}`.
* Incompatibilité de caractères: Le copier-coller depuis des documents externes a introduit des guillemets typographiques (« ») invalides, imposant une correction manuelle des chaînes de caractères.

Défis Logiques et d’Architecture
*Utilisation des méthodes de classe String: L’implémentation de `startsWith()` a nécessité une vérification préalable de la nullité de l’objet pour éviter les exceptions de type « NullPointerException ».
* Transition vers l’accès privé: Le passage des attributs en `private` a nécessité une refactorisation complète de la classe `Main` pour remplacer les accès directs par des appels aux méthodes `get()` et `set()`.
 5. Tests et Validations Réalisés
* Test de robustesse IP: Remplacement automatique des entrées nulles par « 0.0.0.0 ».
* Test de filtrage Masque: Correction des masques hors intervalle [0-32] vers la valeur 24.
* Validation locale : Succès de l’identification des réseaux privés via la méthode `estAdresseLocale()`.



