# Projet Bookstore - Chapitre 8 : Gestion d'une Bibliothèque avec JUnit 5 & AssertJ

Ce projet est une application Java de gestion de bibliothèque développée en suivant une approche de développement piloté par les tests (**TDD**).

## Fonctionnalités Implémentées

1. **Gestion de l'étagère de livres (`BookShelf`)** : Vérification de la vacuité, de la capacité et de l'immutabilité de la collection retournée au client.
2. **Tri des livres** :
    - Tri lexicographique par titre de livre.
    - Tri personnalisé selon les critères fournis par l'utilisateur.
    - **Exercice 1 (Noté)** : Implémentation et validation du tri chronologique par date de publication (ordre croissant).
3. **Regroupement des livres (Troisième fonctionnalité)** :
    - Regroupement initial par année de publication grâce à l'intégration de la bibliothèque **AssertJ**.
    - Refactorisation vers une méthode générique permettant le regroupement selon n'importe quel critère utilisateur (ex: par auteur).

## Technologies Utilisées
- **Java 21**
- **JUnit Jupiter (JUnit 5)**
- **AssertJ Core 3.27.7**