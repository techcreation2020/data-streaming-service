
package com.wissen.streamingservice.configuration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface IBrokerChannel {

	@Input("inbound")
	SubscribableChannel inbound();

	@Output("output")
	MessageChannel outbound();
}
