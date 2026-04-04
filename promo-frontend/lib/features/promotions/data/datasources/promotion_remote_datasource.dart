import 'package:dio/dio.dart';
import 'package:injectable/injectable.dart';
import '../models/promotion_model.dart';

@injectable
class PromotionRemoteDataSource {
  final Dio _dio;

  PromotionRemoteDataSource(this._dio);

  Future<List<PromotionModel>> getPromotions() async {
    final response = await _dio.get('/promotions');
    return (response.data as List)
        .map((json) => PromotionModel.fromJson(json))
        .toList();
  }

  Future<List<PromotionModel>> getActivePromotions() async {
    final response = await _dio.get('/promotions/active');
    return (response.data as List)
        .map((json) => PromotionModel.fromJson(json))
        .toList();
  }

  Future<List<PromotionModel>> getPromotionsByCategory(String category) async {
    final response = await _dio.get('/promotions/category/$category');
    return (response.data as List)
        .map((json) => PromotionModel.fromJson(json))
        .toList();
  }

  Future<PromotionModel> getPromotionById(int id) async {
    final response = await _dio.get('/promotions/$id');
    return PromotionModel.fromJson(response.data);
  }
}
