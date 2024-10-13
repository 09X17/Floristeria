package Floristeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .authorizeRequests()
                .requestMatchers("/login", "/css/**", "/js/**", "/", "/flores", "/pedidos", "/informes", "/entregas", "/facturas").permitAll() 
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/")
                .permitAll() 
            .and()
            .logout()
                .permitAll(); // Permitir logout

        return http.build();
    }
}
