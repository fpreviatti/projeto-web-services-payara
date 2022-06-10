/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.Cliente;
import br.data.CrudCliente;
import jakarta.ejb.Stateless;

/**
 *
 * @author sacarolhas
 */
@Stateless
public class EJBCliente {
    
    public void cadastrarCliente(Cliente cliente){
        CrudCliente crud = new CrudCliente();
        crud.cadastrarCliente(cliente);
    }

}
