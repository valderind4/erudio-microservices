package br.com.erudio.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties("greeting-service")
@NoArgsConstructor
@RefreshScope
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;
}
