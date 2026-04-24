import 'package:dio/dio.dart';
import 'package:injectable/injectable.dart';
import 'dart:io' show Platform;
import 'package:flutter/foundation.dart' show kIsWeb;

@module
abstract class NetworkModule {
  @lazySingleton
  Dio get dio {
    // Déterminer l'URL de base selon la plateforme
    String baseUrl;
    if (kIsWeb) {
      // Pour le web
      baseUrl = 'http://localhost:8080/api';
    } else if (Platform.isAndroid) {
      // Pour un appareil Android physique, utilisez l'IP de votre PC
      // Remplacez par l'IP de votre PC sur le réseau WiFi
      baseUrl = 'http://192.168.56.1:8080/api';
      
      // Si vous utilisez un émulateur Android, utilisez :
      // baseUrl = 'http://10.0.2.2:8080/api';
    } else {
      // Pour iOS, Windows, etc.
      baseUrl = 'http://localhost:8080/api';
    }

    final dio = Dio(
      BaseOptions(
        baseUrl: baseUrl,
        connectTimeout: const Duration(seconds: 30),
        receiveTimeout: const Duration(seconds: 30),
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
      ),
    );

    dio.interceptors.add(LogInterceptor(
      requestBody: true,
      responseBody: true,
    ));

    return dio;
  }
}
