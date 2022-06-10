package br.resources;

import br.data.Cidade;
import br.data.Cliente;
import br.data.CrudCliente;
import br.rs.RestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE9Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    
    
    
    @GET
    @Path("/cidades")
    public List<Cidade> getCidades(){
        RestClient rs = new RestClient();
        
        List<Cidade> cidades = new ArrayList<>();
        
        return rs.getCidades();
        
        
    }
    
    @POST
    @Path("/cliente")
    public void cadastrarCliente(){
        RestClient rs = new RestClient();
        
        CrudCliente cr = new CrudCliente();
        
        cr.cadastrarCliente();
 
    }
    
    @GET
    @Path("/clientes")
    public List<Cliente> getClientes(){
        RestClient rs = new RestClient();
        
        CrudCliente cr = new CrudCliente();
        
        return cr.getClientes();
 
    }

    
    @GET
    @Path("/clientes/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getClientePorCodigo(@PathParam ("codigo") int codigo){
        RestClient rs = new RestClient();
        
        CrudCliente cr = new CrudCliente();
        
        List<Cliente> clientes = cr.getClientes();
        
        clientes = cr.getClientes();
        
        for(int i=0; i<clientes.size();i++){
            if(clientes.get(i).getCodigo()==codigo){
                return clientes.get(i);
            }
        }
        return null;
    }

}
