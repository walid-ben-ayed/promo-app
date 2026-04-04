import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:injectable/injectable.dart';
import '../../domain/entities/promotion.dart';
import '../../domain/repositories/promotion_repository.dart';

part 'promotion_event.dart';
part 'promotion_state.dart';

@injectable
class PromotionBloc extends Bloc<PromotionEvent, PromotionState> {
  final PromotionRepository repository;

  PromotionBloc(this.repository) : super(PromotionInitial()) {
    on<LoadPromotions>(_onLoadPromotions);
    on<LoadActivePromotions>(_onLoadActivePromotions);
    on<LoadPromotionsByCategory>(_onLoadPromotionsByCategory);
  }

  Future<void> _onLoadPromotions(
    LoadPromotions event,
    Emitter<PromotionState> emit,
  ) async {
    emit(PromotionLoading());
    try {
      final promotions = await repository.getPromotions();
      emit(PromotionLoaded(promotions));
    } catch (e) {
      emit(PromotionError(e.toString()));
    }
  }

  Future<void> _onLoadActivePromotions(
    LoadActivePromotions event,
    Emitter<PromotionState> emit,
  ) async {
    emit(PromotionLoading());
    try {
      final promotions = await repository.getActivePromotions();
      emit(PromotionLoaded(promotions));
    } catch (e) {
      emit(PromotionError(e.toString()));
    }
  }

  Future<void> _onLoadPromotionsByCategory(
    LoadPromotionsByCategory event,
    Emitter<PromotionState> emit,
  ) async {
    emit(PromotionLoading());
    try {
      final promotions = await repository.getPromotionsByCategory(event.category);
      emit(PromotionLoaded(promotions));
    } catch (e) {
      emit(PromotionError(e.toString()));
    }
  }
}
