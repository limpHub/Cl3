package com.bd.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bd.basico.modelo.*;
import com.bd.basico.servicio.IProductoServicio;

@Controller
@RequestMapping("/Vistas")
public class ProductoControlador {
	// inyeccion de dependencia...

	@Autowired
	private IProductoServicio iproductoservicio;
	// creamos el metodo listado..
	@GetMapping("ListadoProducto")
	public String ListadoAuto(Model modelo) {
		// recuperamos el listado de autos..
		List<TBL_PRODUCTOCL3> listado = iproductoservicio.ListadoProducto();
		for (TBL_PRODUCTOCL3 lis : listado) {
			System.out.println("codigo " + lis.getIDPRODUCTOCL3() + " " + " nombre " + lis.getNOMBRECL3());
		}
		// enviamos la data hacia la vista..
		modelo.addAttribute("listado", listado);
		// retornamos

		return "/Vistas/ListadoProducto";

	} // fin del metodo listado auto...
	// creamos los respectivos para metodos para registrar...
	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model modelo) {
		// realizamos la respectiva instancia...
		TBL_PRODUCTOCL3 producto = new TBL_PRODUCTOCL3();
		// enviamos a la vista...
		modelo.addAttribute("regproducto", producto);
		// retornamos
		return "/Vistas/FrmCrearProducto";
	} // fin del metodo registrar.
	// realizamos el mapeo con postmapping
	@PostMapping("/GuardarProducto")
	public String GuardarAuto(@ModelAttribute TBL_PRODUCTOCL3 producto, Model modelo) {
		iproductoservicio.RegistrarProducto(producto);
		System.out.println("dato registrado en la bd");
		// retornamos al listado...
		return "redirect:/Vistas/ListadoProducto";
	} // fin del metodo string...
	// *****************crearmos el metodo editar...
	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable("id") Integer IDPRODUCTOCL3, Model modelo) {
		TBL_PRODUCTOCL3 producto = iproductoservicio.BuscarporId(IDPRODUCTOCL3);
		// enviamos hacia la vista...
		modelo.addAttribute("regproducto", producto);
		// retornamos el frmcrearcliente...
		return "/Vistas/FrmCrearProducto";
	} // fin del metodo editar...
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer IDPRODUCTOCL3, Model modelo) {
		// aplicamos inyeccion de dependencia...
		iproductoservicio.Eliminar(IDPRODUCTOCL3);
		// actulizar el listado
		List<TBL_PRODUCTOCL3> listado = iproductoservicio.ListadoProducto();
		// enviamos a la vista
		modelo.addAttribute("listado", listado);
		// redireccionamos
		return "redirect:/Vistas/ListadoProducto";
	} // fin del metodo eliminar...
}
