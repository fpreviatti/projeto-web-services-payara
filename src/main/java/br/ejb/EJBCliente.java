/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.Cliente;
import br.data.CrudCliente;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author sacarolhas
 */
@Stateless
public class EJBCliente {
    CrudCliente crud = new CrudCliente();
    public void cadastrarCliente(Cliente cliente){
        crud.cadastrarCliente(cliente);
    }
    
    public void alterarCliente(Cliente cliente){
        crud.alterarCliente(cliente);
    }
    
    public List<Cliente> getClientes(){
        
        return crud.getClientes();
    }

}
