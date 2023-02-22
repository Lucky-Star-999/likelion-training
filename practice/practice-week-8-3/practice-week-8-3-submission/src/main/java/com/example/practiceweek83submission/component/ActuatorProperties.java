package com.example.practiceweek83submission.component;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ConfigurationProperties(prefix="management.server")
public class ActuatorProperties {
    private String port;
}
