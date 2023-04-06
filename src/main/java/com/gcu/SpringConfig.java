package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.buisness.AnotherOrdersBusinessService;
import com.gcu.buisness.OrdersBusinessService;
import com.gcu.buisness.OrdersBusinessServiceInterface;

// Where the Spring Framework enables automatic dependency injection.
// 
@Configuration
public class SpringConfig 
{
	
}
