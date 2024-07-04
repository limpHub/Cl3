package com.bd.basico.servicio;
import java.util.List;

import com.bd.basico.modelo.*;
public interface IProductoServicio {
	public List<TBL_PRODUCTOCL3>ListadoProducto();
	public void RegistrarProducto(TBL_PRODUCTOCL3 producto);
	public TBL_PRODUCTOCL3 BuscarporId(Integer id);
	public void Eliminar (Integer id);
}
