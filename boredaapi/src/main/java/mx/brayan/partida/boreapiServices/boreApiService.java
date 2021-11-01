package mx.brayan.partida.boreapiServices;

import org.springframework.stereotype.Service;

import mx.brayan.partida.entities.boredapi;
import mx.brayan.partida.token.Token;

@Service
public interface boreApiService {

	Token Getserviceapi();

	/**
	 * save bore
	 * 
	 * @param bore
	 * @return
	 */
	Token PostServiceApi(boredapi bore);

}
