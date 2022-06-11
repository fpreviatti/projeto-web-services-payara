package br.resources;

import br.data.Cidade;
import br.data.Cliente;
import br.data.CrudCliente;
import br.ejb.EJBCliente;
import br.rs.RestClient;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }

    @GET
    @Path("/cidades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> getCidades() {
        RestClient rs = new RestClient();

        List<Cidade> cidades = new ArrayList<>();

        return rs.getCidades();

    }

    @POST
    @Path("/cliente")
    public void cadastrarCliente(@QueryParam("codcidade") int codCidade, @QueryParam("nome") String nome) {
        RestClient rs = new RestClient();

        ArrayList<Cidade> cidades = rs.getCidades();

        EJBCliente ejbCliente = new EJBCliente();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        for (int i = 0; i < cidades.size(); i++) {
            if (cidades.get(i).getCodigo() == codCidade) {
                cliente.setCidade(cidades.get(i));
                ejbCliente.cadastrarCliente(cliente);
            }
        }

    }

    @PUT
    @Path("/cliente/{codigo}")
    public void alterarCliente(@PathParam("codigo") int codigo, @QueryParam("codcidade") int codCidade, @QueryParam("nome") String nome) {
        RestClient rs = new RestClient();

        EJBCliente ejbCliente = new EJBCliente();

        List<Cidade> cidades = rs.getCidades();

        List<Cliente> clientes = ejbCliente.getClientes();
        Cliente cliente = new Cliente();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == codigo) {

                for (int j = 0; j < cidades.size(); j++) {
                    if (cidades.get(j).getCodigo() == codCidade) {
                        cliente.setCodigo(codigo);
                        cliente.setNome(nome);
                        cliente.setCidade(cidades.get(j));
                        ejbCliente.alterarCliente(cliente);
                        break;
                    }
                }
                break;
            }
        }
    }

    @GET
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() {
        RestClient rs = new RestClient();

        CrudCliente cr = new CrudCliente();

        return cr.getClientes();

    }

    @GET
    @Path("/clientes/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getClientePorCodigo(@PathParam("codigo") int codigo) {
        RestClient rs = new RestClient();

        CrudCliente cr = new CrudCliente();

        List<Cliente> clientes = cr.getClientes();

        clientes = cr.getClientes();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == codigo) {
                return clientes.get(i);
            }
        }
        return null;
    }

    @DELETE
    @Path("/clientes/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteClientePorCodigo(@PathParam("codigo") int codigo) {
        RestClient rs = new RestClient();

        CrudCliente cr = new CrudCliente();

        List<Cliente> clientes = cr.getClientes();

        clientes = cr.getClientes();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == codigo) {
                clientes.remove(i);
            }
        }
    }
}
