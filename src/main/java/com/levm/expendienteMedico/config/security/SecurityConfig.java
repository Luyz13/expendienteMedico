package com.levm.expendienteMedico.config.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/*
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Value("${spring.security.debug:false}")
    boolean securityDebug;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/medico")
                .permitAll()
                .requestMatchers(HttpMethod.GET,"/medico/**")
                .permitAll()
                .requestMatchers(HttpMethod.GET,"/medicamento")
                .permitAll()
                .requestMatchers(HttpMethod.GET,"/medicamento/**")
                .permitAll()
                /*Se agrego para probarlos desde Angular*/
                .requestMatchers(HttpMethod.GET,"/paciente/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST,"/medico")
                .permitAll()
                .requestMatchers(HttpMethod.DELETE)
                .permitAll()
                .requestMatchers(HttpMethod.POST)
                .permitAll()
                //.hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT)
                .permitAll()
                //.hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH)
                .permitAll()
                //.hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET)
                .permitAll()
                //.hasAnyRole("USER","ADMIN")
                .requestMatchers("/login/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.debug(securityDebug)
                .ignoring()
                .requestMatchers("/css/**","/img/**");
    }

}
*/
   /* @Bean
    CorsConfigurationSource corseConfigurationSource  () {
    	CorsConfiguration configuration = new CorsConfiguration();
    	configuration.setAllowedOrigins(Arrays.asList("http://localhost:4201"));
    	configuration.setAllowedMethods(Arrays.asList("PUT", "DELETE","GET","POST","PATCH"));
    	configuration.setAllowedHeaders(List.of("Authorization"));
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", configuration);
		return source;
    	
    }*/
}

