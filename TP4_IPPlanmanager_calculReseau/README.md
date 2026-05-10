TP4 : Calculs réseau automatiques dans IPPlan-Manager
🎯 Objectif
L’objectif de ce TP est l’introduction des calculs réseau automatisés dans l’application IPPlan-Manager. Il s’agit de passer d’une saisie manuelle sujette aux erreurs à un moteur de calcul capable de déterminer dynamiquement les propriétés d’un réseau à partir de son adresse et de son CIDR.  
📚 Notions étudiées
Logique algorithmique réseau : Automatisation du calcul des masques et de la capacité des sous-réseaux.  
Méthodes statiques : Utilisation du mot-clé static pour créer des classes utilitaires ne nécessitant pas d’instanciation.  
Calculs CIDR & Masques : Conversion de notations CIDR en masques décimaux et calcul du nombre d’hôtes utilisables (2^{(32-CIDR)} – 2).  
Analyse d’adresses IP : Extraction d’octets via la méthode split() et détermination des classes de réseaux (A, B, C).  
🧪 Tests réalisés
Calcul de capacité : Vérification du nombre d’hôtes pour différents CIDR (ex : /24 donne 254 hôtes).  
Détection de classe : Test de plusieurs adresses pour valider l’identification des classes A, B et C.  
Génération de masque : Validation de la correspondance entre le CIDR et le format décimal (ex : 25 -> 255.255.255.128).  
Filtrage Privé/Public : Test de la méthode supplémentaire estReseauPrive sur les plages 10.0.0.0, 172.16.0.0 et 192.168.0.0.  
❓ Réponses aux questions de compréhension
Pourquoi a-t-on créé une classe utilitaire ?
Elle permet de centraliser les traitements techniques qui ne sont pas des objets réels (comme un calcul mathématique) afin d’éviter les répétitions et de faciliter la maintenance du projet.  
Quel est le rôle du mot-clé static ?
Il permet d’appeler une méthode directement via le nom de la classe (ex : CalculateurReseau.calculer()) sans avoir besoin de créer un objet avec new.  
Pourquoi les calculs réseau sont-ils importants dans un outil IPAM ?
Ils permettent d’éviter les erreurs de saisie humaine, d’accélérer les déploiements et d’optimiser l’utilisation des ressources IP disponibles.  
Quelle est l’utilité du CIDR ?
Le CIDR simplifie la notation des masques et permet une gestion plus flexible (VLSM) que le système de classes traditionnel.  
Pourquoi le nombre d’hôtes dépend-il du masque réseau ?
Car le masque définit la frontière entre la partie « Réseau » et la partie « Hôte » de l’adresse IP ; plus le CIDR est petit, plus il reste de bits pour adresser des machines.  
Pourquoi certaines adresses IP sont-elles privées ?
Elles sont réservées pour une utilisation interne au sein des entreprises et ne sont pas routées sur Internet, ce qui permet de réutiliser les mêmes plages d’adresses dans différents réseaux locaux.  
Pourquoi la séparation entre logique métier et logique de calcul améliore-t-elle le projet ?
Cela rend le code plus propre et modulaire. On peut modifier l’algorithme de calcul sans toucher à la structure des objets ReseauIP ou SousReseau.  
Pourquoi les outils de planification réseau doivent-ils automatiser les calculs ?
Pour garantir l’intégrité des données du plan d’adressage et fournir des informations instantanées aux techniciens, même s’ils ne sont pas experts en calcul binaire.  
⚠️ Difficultés rencontrées
Manipulation de la méthode Math.pow() qui retourne un type double, nécessitant un transtypage (cast) en int.  
Utilisation de l’expression régulière \\. Pour découper l’adresse IP avec split, car le point est un caractère réservé en Java.  




