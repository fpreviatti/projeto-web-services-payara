/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data;


/**
 *
 * @author sacarolhas
 */
public class CrudCliente {
    
    public void cadastrarCliente(){
       
        Cidade cidade = new Cidade();
        cidade.setCodigo(1);
        cidade.setNome("Curitiba");
        
        Cliente cliente = new Cliente();
        cliente.setCidade(cidade);
        cliente.setCodigo(1);
        cliente.setNome("Jose");
        
    }
    
}
