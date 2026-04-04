part of 'promotion_bloc.dart';

abstract class PromotionEvent extends Equatable {
  const PromotionEvent();

  @override
  List<Object> get props => [];
}

class LoadPromotions extends PromotionEvent {}

class LoadActivePromotions extends PromotionEvent {}

class LoadPromotionsByCategory extends PromotionEvent {
  final String category;

  const LoadPromotionsByCategory(this.category);

  @override
  List<Object> get props => [category];
}
