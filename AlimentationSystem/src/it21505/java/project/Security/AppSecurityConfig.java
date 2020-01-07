
package it21505.java.project.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Order(1)
	public static class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter{
		
	
		@Autowired
		DataSource dataSource;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
					.usersByUsernameQuery("select username,password, enabled from user where username=?")
					.authoritiesByUsernameQuery("select username, authority from authorities where username=?");

		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/admin/**")
			.authorizeRequests()
			.antMatchers("/admin/**").hasAuthority("Admin")
			.and()
			.formLogin().loginPage("/admin/login").permitAll()
            .loginProcessingUrl("/admin/authAdmin")
            .defaultSuccessUrl("/admin/home")
            .failureUrl("/admin/login?error")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
            .logoutSuccessUrl("/admin/login")
            .deleteCookies("JSESSIONID")
            .and()
            .exceptionHandling()
            .accessDeniedPage("/403");

		}
		
		@Override
        public void configure(WebSecurity web) throws Exception {
                 web.ignoring()
                .antMatchers("/resources/**");
        }

		@Bean
		public PasswordEncoder passwordEncoder() {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}

	}
	
	@Order(2)
	public static class UserSecurityConfiguration extends WebSecurityConfigurerAdapter{
		
		@Autowired
		DataSource dataSource;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
					.usersByUsernameQuery("select username,password, enabled from user where username=?")
					.authoritiesByUsernameQuery("select username, authority from authorities where username=?");

		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/user/**")
			.authorizeRequests()
			.antMatchers("/user/update-limit").hasAuthority("Supervisor")
			.antMatchers("/user/**").hasAnyAuthority("Employee","Supervisor")			
			.and()
			.formLogin().loginPage("/user/login").permitAll()
	        .loginProcessingUrl("/user/authUser")
	        .defaultSuccessUrl("/user/home")
	        .failureUrl("/user/login?error")
	        .and()
	        .logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	        .logoutSuccessUrl("/user/login")
	        .deleteCookies("JSESSIONID")
	        .and()
	        .exceptionHandling()
	        .accessDeniedPage("/403");

		}
		
		@Override
        public void configure(WebSecurity web) throws Exception {
                 web.ignoring()
                .antMatchers("/resources/**");
        }
		

		@Bean
		public PasswordEncoder passwordEncoder() {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}
		
	}
	
	
}
	

	
	


