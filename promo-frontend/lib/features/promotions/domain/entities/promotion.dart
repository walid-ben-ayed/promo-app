import 'package:equatable/equatable.dart';

class Promotion extends Equatable {
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

  const Promotion({
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

  @override
  List<Object?> get props => [
        id,
        title,
        description,
        imageUrl,
        originalPrice,
        discountedPrice,
        discountPercentage,
        category,
        startDate,
        endDate,
        active,
        merchantName,
      ];
}
