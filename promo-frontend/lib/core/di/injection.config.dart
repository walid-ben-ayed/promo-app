// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// InjectableConfigGenerator
// **************************************************************************

// ignore_for_file: type=lint
// coverage:ignore-file

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'package:dio/dio.dart' as _i361;
import 'package:get_it/get_it.dart' as _i174;
import 'package:injectable/injectable.dart' as _i526;
import 'package:promo_app/core/network/api_client.dart' as _i355;
import 'package:promo_app/features/auth/data/datasources/auth_remote_datasource.dart'
    as _i474;
import 'package:promo_app/features/auth/data/repositories/auth_repository_impl.dart'
    as _i122;
import 'package:promo_app/features/auth/domain/repositories/auth_repository.dart'
    as _i496;
import 'package:promo_app/features/auth/presentation/bloc/auth_bloc.dart'
    as _i523;
import 'package:promo_app/features/promotions/data/datasources/promotion_remote_datasource.dart'
    as _i586;
import 'package:promo_app/features/promotions/data/repositories/promotion_repository_impl.dart'
    as _i332;
import 'package:promo_app/features/promotions/domain/repositories/promotion_repository.dart'
    as _i251;
import 'package:promo_app/features/promotions/presentation/bloc/promotion_bloc.dart'
    as _i352;

extension GetItInjectableX on _i174.GetIt {
// initializes the registration of main-scope dependencies inside of GetIt
  _i174.GetIt init({
    String? environment,
    _i526.EnvironmentFilter? environmentFilter,
  }) {
    final gh = _i526.GetItHelper(
      this,
      environment,
      environmentFilter,
    );
    final networkModule = _$NetworkModule();
    gh.lazySingleton<_i361.Dio>(() => networkModule.dio);
    gh.factory<_i474.AuthRemoteDataSource>(
        () => _i474.AuthRemoteDataSource(gh<_i361.Dio>()));
    gh.factory<_i586.PromotionRemoteDataSource>(
        () => _i586.PromotionRemoteDataSource(gh<_i361.Dio>()));
    gh.lazySingleton<_i496.AuthRepository>(
        () => _i122.AuthRepositoryImpl(gh<_i474.AuthRemoteDataSource>()));
    gh.factory<_i523.AuthBloc>(
        () => _i523.AuthBloc(gh<_i496.AuthRepository>()));
    gh.lazySingleton<_i251.PromotionRepository>(() =>
        _i332.PromotionRepositoryImpl(gh<_i586.PromotionRemoteDataSource>()));
    gh.factory<_i352.PromotionBloc>(
        () => _i352.PromotionBloc(gh<_i251.PromotionRepository>()));
    return this;
  }
}

class _$NetworkModule extends _i355.NetworkModule {}
