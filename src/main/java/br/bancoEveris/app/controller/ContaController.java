package br.bancoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bancoEveris.app.model.BaseResponse;
import br.bancoEveris.app.service.ContaService;
import br.bancoEveris.app.spec.ContaSpec;

@RequestMapping
@RestController("/contas")
public class ContaController extends BaseController {

	private final ContaService _service;
	//criar propriedade saldo 
	@Autowired
	public ContaController(ContaService service) {
		_service = service;

	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody ContaSpec contaSpec) {

		try {

			BaseResponse response = _service.inserir(contaSpec);
			return ResponseEntity.status(response.statusCode).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}

}
