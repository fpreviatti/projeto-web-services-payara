/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.data.Cidade;
import br.data.Cliente;
import br.resources.JakartaEE9Resource;
import br.rs.RestClient;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.faces.context.FacesContext;
import java.util.List;

/**
 *
 * @author sacarolhas
 */
@Named(value = "jsfCadastroClientes")
@RequestScoped
public class JsfCadastroClientes {
   JakartaEE9Resource jak = new JakartaEE9Resource();
   RestClient rs = new RestClient();
    public JsfCadastroClientes() {
           carregarListaCidades();
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
        return cidades;
    }

    public void cadastrarCliente(){
        jak.cadastrarCliente(Integer.parseInt(codigoCidade), nome);
        nome=null;
    }
    
    public void excluirCliente(){
        jak.deleteClientePorCodigo(Integer.parseInt(codigoCliente));
        codigoCliente=null;
    }
    
    public void alterarCliente(){
        
        List<Cliente> clientes = getClientes();
        Boolean clienteEstaCadastrado=false;
        try{
        for(int i=0; i<clientes.size();i++){
            if(clientes.get(i).getCodigo()==Integer.parseInt(codigoCliente)){
                clienteEstaCadastrado = true;
            }
        }
        if(clienteEstaCadastrado){
            
            if(!nome.equals("")){
                jak.alterarCliente(Integer.parseInt(codigoCliente), Integer.parseInt(codigoCidade), nome);
                codigoCidade=null;
                nome=null;
                codigoCliente=null;
            }
            else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nome não pode ser vazio" , "Message body");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario não encontrado para o ID informado" , "Message body");
                FacesContext.getCurrentInstance().addMessage(null, message);
        }
        }
        catch(NumberFormatException e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ID é composto por um campo inteiro" , "Message body");
                FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void carregarListaCidades(){
        cidades = rs.getCidades();
    }

}
