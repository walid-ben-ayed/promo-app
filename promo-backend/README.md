# Promo Backend - Spring Boot

## Architecture

Ce projet utilise une **architecture hexagonale** (ports & adapters) avec une séparation claire des responsabilités :

### Modules

- **promo-domain** : Modèles métier et ports (interfaces)
- **promo-application** : Services métier et cas d'usage
- **promo-infrastructure** : Implémentation des adapters (JPA, repositories)
- **promo-api** : Contrôleurs REST et configuration Spring Boot

## Technologies

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Spring Security + JWT
- MySQL 8.0+
- Lombok
- MapStruct
- Maven

## Prérequis

- JDK 17+
- Maven 3.8+
- MySQL 8.0+

## Configuration

La base de données sera créée automatiquement au démarrage.

Configuration actuelle :
- Host: localhost
- Port: 3306
- Database: promodb
- Username: root
- Password: walidA31+

Pour modifier, éditez `promo-api/src/main/resources/application.yml`

## Démarrage

```bash
cd promo-backend
mvn clean install
cd promo-api
mvn spring-boot:run
```

L'API sera disponible sur `http://localhost:8080`

## Endpoints

### Authentification
- POST `/api/auth/register` - Inscription
- POST `/api/auth/login` - Connexion

### Promotions
- GET `/api/promotions` - Liste toutes les promotions
- GET `/api/promotions/active` - Promotions actives
- GET `/api/promotions/{id}` - Détails d'une promotion
- GET `/api/promotions/category/{category}` - Par catégorie
- POST `/api/promotions` - Créer une promotion
- PUT `/api/promotions/{id}` - Modifier une promotion
- DELETE `/api/promotions/{id}` - Supprimer une promotion
