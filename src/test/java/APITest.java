/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import br.data.Cliente;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author sacarolhas
 */
public class APITest {
    
	/*
    @Test
    public void testCriaNovoCliente() throws JSONException {
        
        JSONObject request = new JSONObject();
        
        String nome = "fabio";
        String codcidade="1";
        
        request.put("nome", nome);
	request.put("codcidade", codcidade);
        
        Cliente cliente = new Cliente();
        

        given().queryParam("nome", nome).
		queryParam("codcidade", codcidade).
		when().
		post("/projeto-web-services/resources/rest/cliente").
		then().statusCode(204);

    }
    
    @Test
    public void testGetClienteEspecifico() {
        
        given().get("/projeto-web-services/resources/rest/clientes/1").then().statusCode(200).body("codigo", equalTo(1));
        given().get("/projeto-web-services/resources/rest/clientes/1").then().statusCode(200).body("nome", equalTo("fabio"));

    }
    
    @Test
    public void testValidaQuantidadeDeClientes() {
        
        given().get("/projeto-web-services/resources/rest/clientes").then().statusCode(200).assertThat().body("size()", equalTo(1));

    }
    
    @Test
    public void testDeleteCliente() throws JSONException{
        
		given().
		delete("/projeto-web-services/resources/rest/clientes/1").
		then().statusCode(204).
		log().all();
    }
    */
    
}
