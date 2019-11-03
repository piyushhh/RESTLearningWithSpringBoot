package com.RestWebservciesInSpringBoot.restfulwebServices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeresolver = new SessionLocaleResolver();
		localeresolver.setDefaultLocale(Locale.US);
	    return localeresolver;
	}
	public ResourceBundleMessageSource bundleMessageSource(){
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("message");
		return bundleMessageSource;
	}

}
