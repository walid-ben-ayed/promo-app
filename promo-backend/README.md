# Promo Backend - Architecture Simple

## 📁 Structure du Projet

```
promo-backend-simple/
├── src/main/java/com/promo/
│   ├── PromoApplication.java       # Point d'entrée
│   ├── entity/                     # Entités JPA
│   │   ├── User.java
│   │   ├── Promotion.java
│   │   └── UserRole.java
│   ├── repository/                 # Repositories Spring Data
│   │   ├── UserRepository.java
│   │   └── PromotionRepository.java
│   ├── service/                    # Logique métier
│   │   ├── AuthService.java
│   │   └── PromotionService.java
│   ├── controller/                 # API REST
│   │   ├── AuthController.java
│   │   └── PromotionController.java
│   ├── dto/                        # Data Transfer Objects
│   │   ├── LoginRequest.java
│   │   ├── RegisterRequest.java
│   │   ├── AuthResponse.java
│   │   ├── PromotionRequest.java
│   │   └── PromotionResponse.java
│   ├── config/                     # Configuration
│   │   └── SecurityConfig.java
│   └── security/                   # Sécurité JWT
│       └── JwtService.java
└── src/main/resources/
    └── application.properties      # Configuration

## 🚀 Démarrage

### 1. Compiler le projet
```bash
cd promo-backend-simple
mvn clean install
```

### 2. Lancer l'application
```bash
mvn spring-boot:run
```

Ou dans IntelliJ : Run `PromoApplication.java`

## 📝 Configuration

Modifiez `application.properties` pour vos paramètres :
- Base de données MySQL
- Port du serveur
- JWT secret et expiration

## 🔗 Endpoints API

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

## 🎯 Avantages de cette architecture

1. **Simple** - Un seul module, facile à comprendre
2. **Clair** - Chaque package a un rôle précis
3. **Maintenable** - Facile à modifier et déboguer
4. **Professionnel** - Suit les bonnes pratiques Spring Boot
5. **Évolutif** - Facile d'ajouter de nouvelles fonctionnalités
6. **Compatible** - Fonctionne avec toutes les versions de Spring Boot
