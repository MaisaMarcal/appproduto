package com.tecdes.appproduto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins ="*")
public class ProdutoRestController {
    @PostMapping("/salvar")
    public String salavr(@ModelAttribute ProdutoDTO produto) {
       String linha = produto.getCod() + ";" +
                       produto.getDescricao() + ";" +
                       produto.getQuantidade() + ";" +
                       produto.getPreco();
            
                
    try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("produtos.txt", true)); // true = adicionar no final
            writer.write(linha);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar produto";
        }
        
        
        return "Produto " + produto.getCod() + "recebido com sucesso" ;

    }
    @PostMapping("/json")
    public String dado(@RequestBody Map<String, Object> dado) {
        System.out.println("JSON recebido: " + dado);
    
        // Pegando valores do JSON
        Object nome = dado.get("User name");
        
        // Convertendo para String (evita NullPointerException)
        String linha = nome != null ? nome.toString() : "sem_nome";
    
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("dados.txt", true)); // true = append
            writer.write(linha);
            writer.newLine();
            writer.close();
    
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar dados";
        }
    
        return "dados recebidos com sucesso";
    }
    
    
}
