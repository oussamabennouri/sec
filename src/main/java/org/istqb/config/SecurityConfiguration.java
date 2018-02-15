package org.istqb.config;

import org.istqb.repository.UsersRepository;
import org.istqb.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;





@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


  @Autowired
  //  private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //auth.userDetailsService(userDetailsService)
       // .passwordEncoder(getPasswordEncoder());
  
	  auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","MANAGER");
	  auth.inMemoryAuthentication().withUser("user").password("user").roles("ING");
	  auth.inMemoryAuthentication().withUser("stage").password("stage").roles("STAGIAIRE");
	  auth.inMemoryAuthentication().withUser("manager").password("manager").roles("MANAGER");
	  }
  


    @Override
    protected void configure(HttpSecurity http) throws Exception {

       // http.csrf().disable();
        http.authorizeRequests()
               // .antMatchers("**/secured/**")
        .anyRequest()        
        .authenticated()
                //.anyRequest().permitAll()
                .and()
                .formLogin()
                //.loginPage(html file)
                .permitAll();
                 //.failureUrl("/error.html");
               // .defaultSuccessUrl("/.html");
        
        
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }
}
