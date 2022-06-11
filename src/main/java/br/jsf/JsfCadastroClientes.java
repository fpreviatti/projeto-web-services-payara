/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.Cidade;
import br.data.Cliente;
import br.ejb.EJBCliente;
import br.resources.JakartaEE9Resource;
import br.rs.RestClient;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;

/**
 *
 * @author sacarolhas
 */
@Named(value = "jsfCadastroClientes")
@RequestScoped
public class JsfCadastroClientes {
   
    public JsfCadastroClientes() {
           
    }
   
    private String nome;
    private String codigo;
    private Cidade cidade;
    private List<Cidade> cidades;
    private String nomeCidade;

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        RestClient rs = new RestClient();
        cidades = rs.getCidades();
        
        rs.close();
        return cidades;
    }

    public EJBCliente getEjbCliente() {
        return ejbCliente;
    }

    public void setEjbCliente(EJBCliente ejbCliente) {
        this.ejbCliente = ejbCliente;
    }

@EJB
    EJBCliente ejbCliente;

    public void cadastrarCliente(){
        
        JakartaEE9Resource jak = new JakartaEE9Resource();
        jak.cadastrarCliente(Integer.parseInt(codigo), nome);
        
//        System.out.println("Cidade:" +codigo);
//        System.out.println("Nome: " +nome);
//        Cliente cliente = new Cliente();
//        Cidade cidade = new Cidade();
//        cidade.setNome("Aleluia");
//        cidade.setCodigo(Integer.parseInt(codigo));
//        cliente.setNome(nome);
//        cliente.setCidade(cidade);
//        ejbCliente.cadastrarCliente(cliente);  
    }

}
