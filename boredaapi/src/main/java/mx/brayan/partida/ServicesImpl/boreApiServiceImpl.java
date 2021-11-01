package mx.brayan.partida.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.brayan.partida.boreapiServices.boreApiService;
import mx.brayan.partida.entities.boredapi;
import mx.brayan.partida.repository.boreApiRepository;
import mx.brayan.partida.token.Token;

@Service
public class boreApiServiceImpl implements boreApiService {

	@Autowired
	boreApiRepository borerepo;

	@Override
	public Token Getserviceapi() {
		Token token = new Token();
		List<boredapi> listaBore = borerepo.findAll();

		if (listaBore.isEmpty() == true) {
			token.setMensaje("se encuentra vacia la base de datos");
			token.setOk(false);
			return token;
		} else {
			token.setObjeto(listaBore);
			token.setMensaje("estos son los mensajes que se encontraron");
			return token;
		}

	}

	@Override
	public Token PostServiceApi(boredapi bore) {
		Token token = new Token();
		borerepo.save(bore);

		token.setMensaje("se guardo con exito");
		token.setOk(true);
		return token;

	}

}
