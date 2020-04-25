package br.com.java.pagseguro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.uol.pagseguro.api.PagSeguro;


@Configuration
@EnableWebMvc
public class WebConfig  extends WebMvcConfigurerAdapter{
	
	  @Bean public PagSeguro getPagSeguro() { 	  
		  return PagSeguro .instance();
	  }

	  @Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
		}
}
