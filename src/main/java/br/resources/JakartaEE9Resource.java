package br.resources;

import br.data.Cidade;
import br.rs.RestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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
    
    
}
