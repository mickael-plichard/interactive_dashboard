# Tableau de bord interactif

## Objectif
L'objectif de cette étude est de concevoir et développer une application web de tableau de bord interactif permettant de visualiser des données dynamiques, telles que des statistiques de ventes ou d’utilisateurs, à travers une interface graphique intuitive.
Ce projet vise à explorer l’intégration d’un backend robuste avec un frontend réactif, en expérimentant des concepts modernes de développement comme la programmation fonctionnelle, la gestion asynchrone, et la réactivité des interfaces utilisateur.

## Contexte
Ce projet s’inscrit dans une démarche d’apprentissage personnel, motivée par l’envie d’approfondir mes connaissances en développement full-stack. 
Il me permet d’explorer des concepts intéressants comme le traitement efficace des données, l’optimisation des performances via le caching, et la gestion d’état dans une application web.

## Portée
L’application comprend un backend Java avec Spring Boot qui expose une API REST pour fournir des données mockées, et un frontend React qui affiche ces données sous forme de graphiques interactifs. 
Les fonctionnalités incluent la récupération de données, leur affichage graphique, et la possibilité de filtrer dynamiquement par catégorie.
Pour cette phase initiale, le projet reste en local, sans base de données externe ou déploiement.

## Analyse des besoins
- **Fonctionnalités principales** :
  - Récupérer et traiter des données via une API REST.
  - Afficher les données dans des graphiques (ex. : barres).
  - Permettre des filtres dynamiques par catégorie.
  - Assurer une mise à jour fluide des données.
- **Exigences non fonctionnelles** :
  - Performance : Réponse rapide grâce à une gestion optimisée.
  - Modularité : Code structuré et réutilisable.
  - Fiabilité : Validation via des tests.

## Concepts mis en place
- **Backend (Java/Spring Boot)** :
  - **Programmation fonctionnelle (Streams)** : Permet de manipuler les collections de données de manière déclarative (ex. : filtrage par catégorie). Justification : Simplifie le code et le rend plus lisible.
  - **Concurrence (CompletableFuture)** : Exécute des tâches asynchrones (ex. : simulation d’appels API) sans bloquer le thread principal. Justification : Améliore la réactivité du serveur.
  - **Caching (Caffeine)** : Stocke les données en mémoire pour éviter des calculs répétés. Justification : Optimise les performances pour les requêtes fréquentes.
  - **Inversion de contrôle (IoC) et Injection de dépendances (DI)** : Spring gère les objets et leurs dépendances automatiquement. Justification : Facilite la modularité et la maintenance.
- **Frontend (React)** :
  - **React Query** : Gère les appels API avec caching et états (chargement, erreur). Justification : Simplifie la gestion des données dynamiques.
  - **Context API** : Centralise l’état des filtres pour une gestion globale. Justification : Évite le prop drilling et rend le code plus propre.
  - **Hooks personnalisés** : Encapsule la logique réutilisable. Justification : Améliore la modularité.

## Architecture du système choisi
- **Architecture** : Architecture 3-Tier :
  - **Présentation** : React pour l’interface utilisateur et les graphiques.
  - **Logique métier** : Spring Boot pour traiter les données et exposer l’API REST.
  - **Données** : Données mockées en mémoire (évolutif vers une base de données).
- **Justification** :
- Séparation claire des responsabilités entre affichage et logique.
- API REST comme standard simple et efficace pour la communication.
- Suffisamment légère pour une étude locale, mais extensible pour des ajouts futurs (ex. : base de données).

## Technologies et outils utilisés
- **Backend** :
- Java 17
- Spring Boot 3.4.4
- Maven pour la gestion des dépendances
- Caffeine pour le caching
- **Frontend** :
- React 19.1.0 avec Vite 6.2.6
- Chart.js 4.4.8 et react-chartjs-2 5.3.0 pour les graphiques
- React Query (@tanstack/react-query) pour les appels API
- **Outils** :
- IntelliJ Idea Community Edition pour le développement backend
- Web Storm pour le développement frontend
- Git et GitHub pour le versionnement

## Diagrammes
- [Cas d'utilisation](/dashboard-docs/dashboard-usecase-diagram.png)
- [Architecture du système](/dashboard-docs/dashboard_architecture-diagram.png)
- [Séquence](/dashboard-docs/dashboard_sequence-diagram.png)
  
---
