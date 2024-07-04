package com.bd.basico.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NuevaClase {
	@GetMapping("/mensaje")
	public String mensaje() {
		return "mensaje";
	}//fin metodo
}//fin clase
