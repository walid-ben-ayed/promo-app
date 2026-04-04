import 'package:json_annotation/json_annotation.dart';
import '../../domain/entities/promotion.dart';

part 'promotion_model.g.dart';

@JsonSerializable()
class PromotionModel {
  final int id;
  final String title;
  final String description;
  final String? imageUrl;
  final double originalPrice;
  final double discountedPrice;
  final int discountPercentage;
  final String category;
  final DateTime startDate;
  final DateTime endDate;
  final bool active;
  final String merchantName;

  PromotionModel({
    required this.id,
    required this.title,
    required this.description,
    this.imageUrl,
    required this.originalPrice,
    required this.discountedPrice,
    required this.discountPercentage,
    required this.category,
    required this.startDate,
    required this.endDate,
    required this.active,
    required this.merchantName,
  });

  factory PromotionModel.fromJson(Map<String, dynamic> json) =>
      _$PromotionModelFromJson(json);

  Map<String, dynamic> toJson() => _$PromotionModelToJson(this);

  Promotion toEntity() => Promotion(
        id: id,
        title: title,
        description: description,
        imageUrl: imageUrl,
        originalPrice: originalPrice,
        discountedPrice: discountedPrice,
        discountPercentage: discountPercentage,
        category: category,
        startDate: startDate,
        endDate: endDate,
        active: active,
        merchantName: merchantName,
      );
}
