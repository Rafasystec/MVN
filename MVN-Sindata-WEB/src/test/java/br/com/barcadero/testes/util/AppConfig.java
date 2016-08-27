package br.com.barcadero.testes.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.barcadero.dao","br.com.barcadero.rule"})
public class AppConfig {

}
