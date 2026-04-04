import 'package:injectable/injectable.dart';
import '../../domain/entities/promotion.dart';
import '../../domain/repositories/promotion_repository.dart';
import '../datasources/promotion_remote_datasource.dart';

@LazySingleton(as: PromotionRepository)
class PromotionRepositoryImpl implements PromotionRepository {
  final PromotionRemoteDataSource remoteDataSource;

  PromotionRepositoryImpl(this.remoteDataSource);

  @override
  Future<List<Promotion>> getPromotions() async {
    final models = await remoteDataSource.getPromotions();
    return models.map((model) => model.toEntity()).toList();
  }

  @override
  Future<List<Promotion>> getActivePromotions() async {
    final models = await remoteDataSource.getActivePromotions();
    return models.map((model) => model.toEntity()).toList();
  }

  @override
  Future<List<Promotion>> getPromotionsByCategory(String category) async {
    final models = await remoteDataSource.getPromotionsByCategory(category);
    return models.map((model) => model.toEntity()).toList();
  }

  @override
  Future<Promotion> getPromotionById(int id) async {
    final model = await remoteDataSource.getPromotionById(id);
    return model.toEntity();
  }
}
