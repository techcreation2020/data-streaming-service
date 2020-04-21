
package com.wissen.streamingservice.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(IBrokerChannel.class)
public class BrokerIntegrationConfig {

}
