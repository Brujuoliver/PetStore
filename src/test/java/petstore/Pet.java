// 1 - Pacote
package petstore;

// 2 - Biblioteca

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3 - Classe
public class Pet {
    // 3.1  -Atributos

    String uri = "https://petstore.swagger.io/v2/pet"; // Endereço entidade Pet

    //  3.2 - Métodos e funçoes
    public String lerJson (String caminhoJson) throws IOException {

       return new String (Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // incluir - Create - Post
    @Test // Identifica o metodo ou função como um teste para o TestNG
    public void incluirPet() throws IOException {
    String jsonBody = lerJson("DB/pet1.json");

    //Sintaxe Gherkin
    // Dado - Quando - Então
    // Given - When - Then


   given() //Dado
       .contentType("application/json") // comum em API REST
       .log().all()
       .body(jsonBody)

   .when()//quando
       .post(uri)
   .then() //Então
        .log().all()
        .statusCode(200);
    }


}


