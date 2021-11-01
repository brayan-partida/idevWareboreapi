package mx.brayan.partida.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mx.brayan.partida.ServicesImpl.boreApiServiceImpl;
import mx.brayan.partida.entities.boredapi;
import mx.brayan.partida.token.Token;

@RestController
@RequestMapping("/")
public class boreControllers {

	@Autowired
	boreApiServiceImpl servicess;

	@PostMapping("postboreapp/")
	Token potMappin(@RequestBody boredapi bore) {
		Token token = new Token();
		servicess.PostServiceApi(bore);
		return token;

	}

	@GetMapping("getboreapp/")
	Token getBore() {
		Token token = new Token();
		token = servicess.Getserviceapi();
		return token;

	}

	@GetMapping("getboreservice/")
	String getBoreservice() {

		String uri = "https://www.boredapi.com/api/activity";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

}
