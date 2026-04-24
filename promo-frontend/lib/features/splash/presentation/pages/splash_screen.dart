import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:math';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> with TickerProviderStateMixin {
  late AnimationController _textController;
  late AnimationController _splashController;
  late Animation<double> _fadeAnimation;
  
  String _displayedText = '';
  final String _fullText = 'PROMO';
  int _currentIndex = 0;
  Timer? _textTimer;

  @override
  void initState() {
    super.initState();
    
    // Animation pour les taches blanches
    _splashController = AnimationController(
      duration: const Duration(milliseconds: 1500),
      vsync: this,
    )..repeat();
    
    // Animation pour le fade du logo
    _textController = AnimationController(
      duration: const Duration(milliseconds: 800),
      vsync: this,
    );
    
    _fadeAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(
      CurvedAnimation(parent: _textController, curve: Curves.easeIn),
    );
    
    _startAnimations();
  }

  void _startAnimations() async {
    // Attendre un peu avant de commencer
    await Future.delayed(const Duration(milliseconds: 500));
    
    // Fade in du logo
    _textController.forward();
    
    // Attendre que le logo apparaisse
    await Future.delayed(const Duration(milliseconds: 800));
    
    // Commencer l'animation du texte lettre par lettre
    _textTimer = Timer.periodic(const Duration(milliseconds: 200), (timer) {
      if (_currentIndex < _fullText.length) {
        setState(() {
          _displayedText += _fullText[_currentIndex];
          _currentIndex++;
        });
      } else {
        timer.cancel();
        // Attendre 1 seconde puis naviguer vers la page de login
        Future.delayed(const Duration(milliseconds: 1000), () {
          if (mounted) {
            Navigator.of(context).pushReplacementNamed('/login');
          }
        });
      }
    });
  }

  @override
  void dispose() {
    _textTimer?.cancel();
    _textController.dispose();
    _splashController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFFFC00), // Jaune
      body: Stack(
        children: [
          // Taches blanches animées
          ..._buildWhiteSplashes(),
          
          // Contenu principal
          Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                // Logo avec animation fade
                FadeTransition(
                  opacity: _fadeAnimation,
                  child: Image.asset(
                    'assets/icon/app_icon.png',
                    width: 150,
                    height: 150,
                  ),
                ),
                
                const SizedBox(height: 30),
                
                // Texte PROMO animé lettre par lettre
                SizedBox(
                  height: 60,
                  child: Text(
                    _displayedText,
                    style: const TextStyle(
                      fontSize: 48,
                      fontWeight: FontWeight.bold,
                      color: Colors.black,
                      letterSpacing: 4,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  List<Widget> _buildWhiteSplashes() {
    final random = Random(42); // Seed fixe pour des positions cohérentes
    return List.generate(8, (index) {
      final size = 30.0 + random.nextDouble() * 50;
      final left = random.nextDouble() * 100;
      final top = random.nextDouble() * 100;
      
      return AnimatedBuilder(
        animation: _splashController,
        builder: (context, child) {
          final animValue = (_splashController.value + (index * 0.1)) % 1.0;
          final opacity = (sin(animValue * pi * 2) + 1) / 4; // 0 à 0.5
          
          return Positioned(
            left: MediaQuery.of(context).size.width * (left / 100),
            top: MediaQuery.of(context).size.height * (top / 100),
            child: Opacity(
              opacity: opacity,
              child: Container(
                width: size,
                height: size,
                decoration: BoxDecoration(
                  color: Colors.white,
                  shape: BoxShape.circle,
                ),
              ),
            ),
          );
        },
      );
    });
  }
}
