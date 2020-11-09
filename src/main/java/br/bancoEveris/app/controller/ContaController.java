package br.bancoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.bancoEveris.app.model.BaseResponse;
import br.bancoEveris.app.model.Conta;
import br.bancoEveris.app.service.ContaService;
import br.bancoEveris.app.spec.ContaList;
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

		try
		{
			BaseResponse base = _service.inserir(contaSpec);
			return ResponseEntity.status(base.statusCode).body(base);
		} catch (Exception e)
		{
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}
	
	@GetMapping
	public ResponseEntity obter() {
		try
		{
			ContaList contas = _service.obter();			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(contas);
		}
		catch (Exception e)
		{
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
		
	}
	
	@GetMapping(path="/listar/{hash}")
	public ResponseEntity listar(@PathVariable String hash) {
		try
		{
			Conta conta = _service.obterByHash(hash);
			return ResponseEntity.status(conta.statusCode).body(conta);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@PutMapping(path="/editar/{hash}")
	public ResponseEntity editar(@RequestBody ContaSpec contaSpec, @PathVariable String hash) {
		try
		{
			Conta conta = _service.editar(hash, contaSpec);
			return ResponseEntity.status(conta.statusCode).body(conta);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@DeleteMapping(path="/deletar/{hash}")
	public ResponseEntity deletar(@PathVariable String hash) {
		try
		{
			BaseResponse conta = _service.deletar(hash);
			return ResponseEntity.status(conta.statusCode).body(conta);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@GetMapping(path="/saldo/{hash}")
	public ResponseEntity Saldo(@PathVariable String hash) {
		try
		{
			BaseResponse response = _service.saldo(hash);
			return ResponseEntity.status(response.statusCode).body(response);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
}

