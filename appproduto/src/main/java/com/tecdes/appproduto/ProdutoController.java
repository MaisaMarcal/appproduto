package com.tecdes.appproduto;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ProdutoController {
    
    @GetMapping("/")
    public String homeProduto() {
        return "index.html";
    }
    
    @GetMapping("/dado")
    @ResponseBody
    public String homeDado() {
        return "Eu sou um dado";
    }

    @GetMapping("/json")
    @ResponseBody
    public Map<String, Object> homeJson() {
        Map<String, Object> dado = new LinkedHashMap<>();
        dado.put("UserId", "101");
        dado.put("UserName", "João Silva");
        dado.put("UserAge", 25);

        return dado;
    }
    
    
}