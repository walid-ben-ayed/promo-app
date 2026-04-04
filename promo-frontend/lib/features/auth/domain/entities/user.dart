import 'package:equatable/equatable.dart';

class User extends Equatable {
  final String email;
  final String token;
  final String role;

  const User({
    required this.email,
    required this.token,
    required this.role,
  });

  @override
  List<Object> get props => [email, token, role];
}
