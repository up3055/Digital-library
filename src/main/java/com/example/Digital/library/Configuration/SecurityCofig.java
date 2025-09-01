package com.example.Digital.library.Configuration;

import com.example.Digital.library.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityCofig {


    private final UserService userService;

    public SecurityCofig(UserService userService){
        this.userService= userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/user/addUser").permitAll()
                        .requestMatchers("/user/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder( new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(this.userService);

        return provider;
    }

//    @Bean
//    public BearerTokenResolver bearerTokenResolver() {
//        DefaultBearerTokenResolver resolver = new DefaultBearerTokenResolver();
//        resolver.setAllowFormEncodedBodyParameter(true); // Optional customization
//        resolver.setAllowUriQueryParameter(true);        // Optional customization
//        return resolver;
//    }

//    public UserDetailsService userDetailsService(){
//        return new InMemoryUserDetailsManager();
//    }

}
