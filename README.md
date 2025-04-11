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
- [Cas d'utilisation](/dashboard-docs/dashboard_usecase-diagram.png)
- [Architecture du système](/dashboard-docs/dashboard_architecture-diagram.png)
- [Séquence](/dashboard-docs/dashboard_sequence-diagram.png)
  
---

## Implémentations

### 1. Programmation fonctionnelle avec Streams
- **Processus** :
  - Création d’un modèle `DataPoint` pour représenter les données (date, valeur, catégorie).
  - Implémentation d’un service `DashboardService` utilisant `Stream.of` pour générer des données mockées.
  - Ajout d’un endpoint `/api/dashboard` dans `DashboardController` pour exposer les données.
- **Détails** :
  - **Pourquoi** : Simplifie la manipulation des collections avec un style déclaratif.
  - **Comment** : `Stream.of` crée un flux d’objets `DataPoint`, et `collect(Collectors.toList())` le transforme en liste.
  - **Résultat** : Une API REST retourne des données JSON prêtes à être consommées par le frontend.

### 2. Inversion de contrôle et injection de dépendance
- **Processus** :
  - Annotation de `DashboardService` avec `@Service` pour en faire un bean Spring.
  - Injection de `DashboardService` dans `DashboardController` via `@Autowired` dans le constructeur.
- **Détails** :
  - **Pourquoi** : Réduit le couplage et améliore la modularité.
  - **Comment** : Spring crée et gère l’instance de `DashboardService`, puis l’injecte automatiquement.
  - **Résultat** : Le controller utilise un service sans l’instancier manuellement, facilitant les tests et évolutions.

### 3. Configuration CORS
- **Processus** :
  - Création d’une classe `CorsConfig` implémentant `WebMvcConfigurer`.
  - Configuration pour autoriser les requêtes depuis `http://localhost:5173` sur les endpoints `/api/**`.
- **Détails** :
  - **Pourquoi** : Permet la communication entre le frontend et le backend sur des ports différents.
  - **Comment** : Définit les origines, méthodes, et en-têtes autorisés via Spring.
  - **Résultat** : Prépare l’API à être appelée sans erreur CORS par le frontend.

### 4. Graphique simple avec Chart.js
- **Processus** :
  - Création d’un projet React avec Vite.
  - Ajout de `chart.js` et `react-chartjs-2`.
  - Implémentation de `ChartComponent` pour afficher un graphique en barres.
  - Mise à jour de `App.jsx` pour récupérer et passer les données.
- **Détails** :
  - **Pourquoi** : Transforme les données brutes en visualisation intuitive.
  - **Comment** : Chart.js mappe les données sur un graphique configurable.
  - **Résultat** : Un tableau de bord visuel affichant les valeurs par date.

### 5. Hooks personnalisés
- **Processus** :
  - Création d’un hook `useDashboardData` dans `hooks/useDashboardData.js`.
  - Mise à jour de `App.jsx` pour utiliser ce hook.
- **Détails** :
  - **Pourquoi** : Sépare la logique de récupération des données.
  - **Comment** : Encapsule `useState` et `useEffect` dans une fonction réutilisable.
  - **Résultat** : Un composant `App` plus clair et extensible.

### 6. Caching avec Caffeine
- **Processus** :
  - Ajout de la dépendance Caffeine dans `pom.xml`.
  - Configuration d’un `LoadingCache` dans `DashboardService`.
- **Détails** :
  - **Pourquoi** : Optimise les performances en évitant des calculs répétés.
  - **Comment** : Stocke les données mockées en mémoire avec une expiration.
  - **Résultat** : Réponses API plus rapides après le premier appel.

### 7. Asynchronisme avec CompletableFuture
- **Processus** :
  - Modification de `loadMockedData` pour retourner un `CompletableFuture`.
  - Intégration avec le cache Caffeine.
- **Détails** :
  - **Pourquoi** : Permet des opérations non bloquantes.
  - **Comment** : Exécute la génération des données dans un thread séparé.
  - **Résultat** : Simule une récupération lente, optimisée par le cache.

### 8. Filtrage des données avec Streams
- **Processus** :
  - Ajout d’une méthode `getDataByCategory` dans `DashboardService`.
  - Mise à jour de `DashboardController` pour accepter un paramètre `category`.
- **Détails** :
  - **Pourquoi** : Permet une sélection dynamique des données.
  - **Comment** : Utilise `filter` pour ne garder que les éléments correspondants.
  - **Résultat** : L’API supporte le filtrage par catégorie.
