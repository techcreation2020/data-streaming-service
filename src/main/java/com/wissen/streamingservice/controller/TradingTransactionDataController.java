
package com.wissen.streamingservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.streamingservice.model.User;
import com.wissen.streamingservice.service.TradeDataStreamingService;

@RestController
public class TradingTransactionDataController {

	private final TradeDataStreamingService tradeDataStreamingService;

	public TradingTransactionDataController(TradeDataStreamingService tradeDataStreamingService) {
		this.tradeDataStreamingService = tradeDataStreamingService;
	}

	@RequestMapping(value = "/create", method = { RequestMethod.PUT }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public void createEmployee(@RequestBody User user) {
		System.out.println("----------------->>> ---->>> User received " + user);
		tradeDataStreamingService.sendDataToKafkaTopic(user);
	}
}
