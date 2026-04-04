import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import '../bloc/promotion_bloc.dart';
import '../widgets/promotion_card.dart';

class PromotionsPage extends StatelessWidget {
  const PromotionsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Promotions'),
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: () {
              context.read<PromotionBloc>().add(LoadActivePromotions());
            },
          ),
        ],
      ),
      body: BlocBuilder<PromotionBloc, PromotionState>(
        builder: (context, state) {
          if (state is PromotionLoading) {
            return const Center(child: CircularProgressIndicator());
          }

          if (state is PromotionError) {
            return Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text('Erreur: ${state.message}'),
                  ElevatedButton(
                    onPressed: () {
                      context.read<PromotionBloc>().add(LoadPromotions());
                    },
                    child: const Text('Réessayer'),
                  ),
                ],
              ),
            );
          }

          if (state is PromotionLoaded) {
            if (state.promotions.isEmpty) {
              return const Center(
                child: Text('Aucune promotion disponible'),
              );
            }

            return ListView.builder(
              padding: const EdgeInsets.all(16),
              itemCount: state.promotions.length,
              itemBuilder: (context, index) {
                return PromotionCard(promotion: state.promotions[index]);
              },
            );
          }

          return const SizedBox();
        },
      ),
    );
  }
}
