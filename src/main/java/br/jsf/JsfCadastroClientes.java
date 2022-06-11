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
import jakarta.faces.component.html.HtmlDataTable;
import java.util.List;

/**
 *
 * @author sacarolhas
 */
@Named(value = "jsfCadastroClientes")
@RequestScoped
public class JsfCadastroClientes {
   JakartaEE9Resource jak = new JakartaEE9Resource();
    public JsfCadastroClientes() {
           
    }
   
    private String nome;
    private String codigoCidade;
    private String codigoCliente;
    private Cidade cidade;
    private List<Cidade> cidades;
    private String nomeCidade;
    private List<Cliente> clientes;
    private HtmlDataTable dataTable;

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public List<Cliente> getClientes() {
        clientes = jak.getClientes();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(String codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public void cadastrarCliente(){
        jak.cadastrarCliente(Integer.parseInt(codigoCidade), nome);
    }
    
    public void excluirCliente(){
        jak.deleteClientePorCodigo(Integer.parseInt(codigoCliente));
    }
    
    public void alterarCliente(){
        jak.alterarCliente(0, 0, nome);
    }

}
