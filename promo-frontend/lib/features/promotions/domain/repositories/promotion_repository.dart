import '../entities/promotion.dart';

abstract class PromotionRepository {
  Future<List<Promotion>> getPromotions();
  Future<List<Promotion>> getActivePromotions();
  Future<List<Promotion>> getPromotionsByCategory(String category);
  Future<Promotion> getPromotionById(int id);
}
