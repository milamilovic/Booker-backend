//package booker.BookingApp.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//public class WebConfiguration  {
//
//
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/console/**").permitAll();
//
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//    }
//
//}