package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.testRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/testGetMapping")
    public String testController(){
        return "Hello World";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello World! ID: "+id;
    }

    @GetMapping("/testRequestParam")
    public String restControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! ID: "+id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody testRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID:" + testRequestBodyDTO.getId() + "Message:" + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm hiJ");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();

        list.add("I'm ResponseEntity and you got 400");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.badRequest().body(response);
    }
}
