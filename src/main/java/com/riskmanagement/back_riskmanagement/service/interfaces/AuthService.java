package com.riskmanagement.back_riskmanagement.service.interfaces;

public interface AuthService {
void signUp(String username, String password);
void signIn(String username, String password);
void signOut();

}
