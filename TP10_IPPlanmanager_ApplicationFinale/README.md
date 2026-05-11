TP10: APPLICATION FINALE
 

Objectif: Assembler toutes les fonctionnalités développées dans les TPs précédents 
afin de produire une application console complète de planification d'adressage IP.

 Fonctionnalités réalisées

- Saisie interactive des besoins réseaux.
- Calcul de plan d'adressage VLSM sans chevauchement.
- Création automatique de VLANs (ID et noms).
- Validation de la cohérence des plages IP.
- Moteur de recommandations techniques (sécurité et broadcast).
- Sauvegarde des résultats en formats CSV et rapport TXT.

 Difficultés rencontrées

La principale difficulté a été la gestion précise du décalage des adresses IP dans la boucle VLSM pour éviter tout chevauchement, 
ainsi que la synchronisation entre la création des VLANs et les résultats du plan IP.


Scénarios testés

Scénario  : Campus IRT

Besoin   	Hôtels	Adresse	        CIDR	Margarine

ÉTUDIANTS	500	10.10.0.0	/23	10
WIFI_INVITES    200	10.10.2.0	/24	54
ENSEIGNANTS	120	10.10.3.0	/25	6
LABORATOIRES	60	10.10.3.128	/26	2
SERVEURS	30	10.10.3.192	/27	0



18. Réponses aux questions de compréhension

1-Pourquoi le TP10 représente-t-il une application plus complète ?

Contrairement aux TPs précédents qui se concentraient sur des fonctionnalités isolées 
(le calcul VLSM, la gestion des exceptions ou l'écriture de fichiers), 
le TP10 assemble toutes ces briques pour créer un produit fini, cohérent et prêt à l'emploi.

2-Quel est le rôle de la classe ApplicationIPPlanManager ?

C'est l'orchestrateur de l'application.
 Elle coordonne les interactions entre l'utilisateur (via la console), 
les moteurs de calcul (logic) et la sauvegarde des données (repository).

3-Pourquoi la classe Main doit-elle rester courte ?

Pour respecter les principes de la POO. 
Son rôle unique est de servir de point d'entrée pour instancier et démarrer l'application principale,
laissant la logique métier aux classes spécialisées.

4-Importance de la séparation des packages ?

Cela permet une meilleure maintenabilité et une modularité du code. 
Par exemple, on peut modifier l'interface utilisateur (package console) sans impacter les calculs mathématiques (package service).

5-Pourquoi la saisie utilisateur est-elle dans ConsoleService ?

Cela isole les entrées/sorties du reste du code. 
Si l'on souhaite passer d'une application console à une application graphique (GUI) plus tard, 
il suffira de remplacer ce service.

6-Pourquoi valider l'adresse réseau avant le VLSM ?

Pour garantir l'intégrité des calculs. 
Si l'adresse de départ est invalide (ex: 192.168.1.256), 
tous les sous-réseaux calculés par la suite seraient mathématiquement faux.

7-Pourquoi les recommandations sont-elles après les VLANs ?

Parce que l'analyse du moteur de recommandations se base sur les caractéristiques finales des VLANs (nom, taille, type de service) pour fournir des conseils pertinents.

8-Pourquoi la sauvegarde rend-elle l'application exploitable ?

Un plan d'adressage n'est utile que s'il peut être partagé et conservé. 
Les fichiers CSV et TXT permettent à un administrateur réseau d'utiliser ces données pour configurer réellement ses équipements.

9-Importance du rapport technique en contexte professionnel ?

Il sert de document de référence pour l'audit, la traçabilité et l'aide au dépannage.
Il justifie les choix techniques auprès de la direction ou des clients.

10-Améliorations futures ?

-L'ajout d'une interface graphique, 
-la prise en charge de l'IPv6, 
-l'export direct de scripts de configuration pour routeurs (Cisco, Juniper).
