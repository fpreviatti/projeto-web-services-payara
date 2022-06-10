/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author sacarolhas
 */
public class CrudCliente {
    
    static List<Cliente> clientes = new ArrayList<>();
    
    static int codCliente=1;
    
    public void cadastrarCliente(Cliente cliente){  
        cliente.setCodigo(codCliente);
        clientes.add(cliente);
        codCliente = codCliente+1;
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
}
