package booker.BookingApp.config;


import booker.BookingApp.enums.Role;
import booker.BookingApp.security.RestAuthenticationEntryPoint;
import booker.BookingApp.security.TokenAuthenticationFilter;
import booker.BookingApp.service.implementation.CustomUserDetailsService;
import booker.BookingApp.util.TokenUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;
import static org.springframework.security.core.context.SecurityContextHolder.setStrategyName;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;



@Log4j2
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        jsr250Enabled = true
)
public class WebSecurityConfig {

    public WebSecurityConfig() {
        // Inherit security context in async function calls
        setStrategyName(MODE_INHERITABLETHREADLOCAL);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(jwtUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Autowired
    private TokenUtils tokenUtils;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http)
            throws Exception {

        http
                // Enable CORS
                .cors(withDefaults())
                //Disable CSRF
                .csrf(AbstractHttpConfigurer::disable)
                // Set session management to stateless
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(STATELESS))
                // Set unauthorized requests exception handler
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(restAuthenticationEntryPoint))
                //.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authorizeHttpRequests(auth ->{
                            auth.requestMatchers(antMatcher("/api/users/login")).permitAll();
                            auth.requestMatchers(antMatcher("/api/users/signup")).permitAll();
                            auth.requestMatchers(antMatcher("/api/users/activate_profile/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/accommodations/search/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/accommodations/*")).permitAll();
                            auth.requestMatchers(antMatcher("/api/accommodations/priceType/*")).permitAll();
                            auth.requestMatchers(antMatcher("/api/owners/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/guests/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/admin/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/guests/{guestId}")).permitAll();
                            auth.requestMatchers(antMatcher("/api/guests/delete/{guestId}")).permitAll();
                            auth.requestMatchers(antMatcher("/api/owners/{ownerId}")).permitAll();
                            auth.requestMatchers(antMatcher("/api/owners/delete/{ownerId}")).permitAll();
                            auth.requestMatchers(antMatcher("/api/admin/{adminId}")).permitAll();
                            auth.requestMatchers(antMatcher("/api/amenities/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/availability/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/accommodations/create_accommodation")).hasAuthority("OWNER");
                            auth.requestMatchers(antMatcher("/api/accommodations/update_availability/**")).hasAuthority("OWNER");
                            auth.requestMatchers(antMatcher("/api/accommodations/search/**")).permitAll();
                            auth.requestMatchers(antMatcher("/api/accommodation_ratings/all/*/ratings")).permitAll();
                            auth.requestMatchers(antMatcher("/api/images/upload-multiple")).hasAuthority("OWNER");
                            auth.requestMatchers(antMatcher("/h2-console/**")).permitAll();


                            auth.anyRequest().authenticated();
                        }
                )
                .headers(headers ->
                        headers.frameOptions(FrameOptionsConfig::sameOrigin).disable())



                // Add JWT token filter
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils,  userDetailsService()), BasicAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers
                (antMatcher(HttpMethod.POST, "/api/users/signup"),
                        antMatcher(HttpMethod.POST, "/api/users/login"),
                        antMatcher(HttpMethod.POST, "/api/accommodations/create_accommodation"),
                        antMatcher(HttpMethod.PUT, "/api/users/activate_profile/**"),
                        antMatcher(HttpMethod.PUT, "/api/accommodations/update_availability/**"),
                        antMatcher(HttpMethod.GET, "api/accommodations/search/**"),
                        antMatcher(HttpMethod.POST, "api/images/upload-multiple"),
                        antMatcher("/h2-console/**"));
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }





}
