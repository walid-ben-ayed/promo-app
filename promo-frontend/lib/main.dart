import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'core/di/injection.dart';
import 'features/auth/presentation/bloc/auth_bloc.dart';
import 'features/promotions/presentation/bloc/promotion_bloc.dart';
import 'features/auth/presentation/pages/login_page.dart';
import 'features/promotions/presentation/pages/promotions_page.dart';
import 'features/splash/presentation/pages/splash_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await configureDependencies();
  runApp(const PromoApp());
}

class PromoApp extends StatelessWidget {
  const PromoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      providers: [
        BlocProvider(create: (_) => getIt<AuthBloc>()),
        BlocProvider(create: (_) => getIt<PromotionBloc>()..add(LoadPromotions())),
      ],
      child: MaterialApp(
        title: 'Promo',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
          useMaterial3: true,
        ),
        initialRoute: '/',
        routes: {
          '/': (context) => const SplashScreen(),
          '/login': (context) => const LoginPage(),
          '/promotions': (context) => const PromotionsPage(),
        },
      ),
    );
  }
}
