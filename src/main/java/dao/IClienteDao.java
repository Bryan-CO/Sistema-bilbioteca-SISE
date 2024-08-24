package dao;
import java.util.List;

import models.Cliente;

public interface IClienteDao {
	public List<Cliente> getClientes();
	public void addCliente();
	public void editCliente();
	public Cliente getClienteByDni();
}
