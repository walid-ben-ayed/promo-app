# Application Promo

Application mobile de gestion des promotions avec backend Spring Boot et frontend Flutter.

## Structure du Projet

```
promo/
├── promo-backend/          # Backend Spring Boot
│   ├── promo-domain/       # Modèles métier
│   ├── promo-application/  # Services métier
│   ├── promo-infrastructure/ # Adapters (JPA, etc.)
│   └── promo-api/          # API REST
└── promo-frontend/         # Frontend Flutter
    └── lib/
        ├── core/           # Fonctionnalités partagées
        └── features/       # Fonctionnalités par domaine
```

## Architecture

### Backend - Architecture Hexagonale
- **Domain** : Modèles métier purs, sans dépendances
- **Application** : Services et cas d'usage
- **Infrastructure** : Implémentation des ports (JPA, repositories)
- **API** : Contrôleurs REST et configuration

### Frontend - Clean Architecture + BLoC
- **Data** : Sources de données et repositories
- **Domain** : Entités et interfaces
- **Presentation** : UI et gestion d'état (BLoC)

## Technologies

### Backend
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Spring Security + JWT
- PostgreSQL
- Maven

### Frontend
- Flutter 3.x
- BLoC (state management)
- Dio + Retrofit (networking)
- GetIt + Injectable (DI)

## Démarrage Rapide

### Backend
```bash
cd promo-backend
mvn clean install
cd promo-api
mvn spring-boot:run
```

### Frontend
```bash
cd promo-frontend
flutter pub get
flutter pub run build_runner build --delete-conflicting-outputs
flutter run
```

## Documentation

- [Backend README](promo-backend/README.md)
- [Frontend README](promo-frontend/README.md)

## Fonctionnalités

- Authentification JWT
- Gestion des promotions
- Filtrage par catégorie
- Promotions actives
- Interface mobile moderne
