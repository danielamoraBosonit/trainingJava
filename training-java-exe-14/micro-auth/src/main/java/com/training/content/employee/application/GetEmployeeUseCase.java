package com.training.content.employee.application;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface GetEmployeeUseCase {

    UserDetailsService userDetailsService();

}
