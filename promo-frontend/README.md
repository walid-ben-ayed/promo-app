# Promo Frontend - Flutter

## Architecture

Ce projet utilise une **architecture Clean** avec BLoC pour la gestion d'état :

### Structure
```
lib/
├── core/                    # Fonctionnalités partagées
│   ├── di/                 # Injection de dépendances
│   └── network/            # Configuration réseau
├── features/               # Fonctionnalités par domaine
│   ├── auth/
│   │   ├── data/          # Sources de données et repositories
│   │   ├── domain/        # Entités et interfaces
│   │   └── presentation/  # UI et BLoC
│   └── promotions/
│       ├── data/
│       ├── domain/
│       └── presentation/
└── main.dart
```

## Technologies

- Flutter 3.x
- BLoC pour la gestion d'état
- Dio + Retrofit pour les appels API
- GetIt + Injectable pour l'injection de dépendances
- Cached Network Image pour les images
- Equatable pour la comparaison d'objets

## Installation

1. Installer Flutter : https://flutter.dev/docs/get-started/install

2. Installer les dépendances :
```bash
cd promo-frontend
flutter pub get
```

3. Générer le code :
```bash
flutter pub run build_runner build --delete-conflicting-outputs
```

## Configuration

Modifier l'URL de l'API dans `lib/core/network/api_client.dart` :
```dart
baseUrl: 'http://votre-ip:8080/api'
```

## Lancement

```bash
flutter run
```

## Build

### Android
```bash
flutter build apk --release
```

### iOS
```bash
flutter build ios --release
```
