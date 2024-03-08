package com.rushabh.book_author.config;//package com.rushabh.book_author.config;//package com.rushabh.book_author.config;
////
////
////import jakarta.servlet.http.HttpServletRequest;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////
////
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.web.cors.CorsConfiguration;
////import org.springframework.web.cors.CorsConfigurationSource;
////
////import javax.sql.DataSource;
////import java.util.Collections;
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
////
////
////        http.securityContext((context) -> context
////                        .requireExplicitSave(false))
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
////                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
////                    // the CORS is to communication between two Origins for example the client(APPS) and Server
////                    @Override
////                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
////                        CorsConfiguration config = new CorsConfiguration();
////                        config.setAllowedOrigins(Collections.singletonList("*"));
////                        config.setAllowedMethods(Collections.singletonList("*"));
////                        config.setAllowCredentials(true);
////                        config.setAllowedHeaders(Collections.singletonList("*"));
////                        config.setMaxAge(3600L);
////                        return config;
////                    }
////                }))
////                .csrf(AbstractHttpConfigurer::disable)
////                .formLogin(Customizer.withDefaults())
////                .httpBasic(Customizer.withDefaults());
////        return http.build();
////    }
////
////
////
////
////}
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig implements  {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Allow requests from any origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .allowCredentials(true)
                .maxAge(3600);
    }
}