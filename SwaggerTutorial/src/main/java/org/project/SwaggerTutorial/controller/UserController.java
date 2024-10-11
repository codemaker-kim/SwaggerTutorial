package org.project.SwaggerTutorial.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

// Swagger 학습용 간단한 컨트롤러
@RestController
@RequestMapping("/api/users")
public class UserController {

    /*
    * Swagger 사용을 위하여 사용된 어노테이션들 정리
    * @Operation : 특정 API에 대한 설명을 제공할 수 있음.
    * @ApiResponses : API가 반환할 수 있는 모든 응답을 문서화.
    * @ApiResponse : @ApiResponses 내에서 응답 코드와 간단한 설명을 포함해 응답을 설명함.
    * */

    @Operation(summary = "Get all users")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Successfully get list"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @GetMapping
    public List<String> getAllUsers(){
        return Arrays.asList("수민", "케인", "엄준식");
    }

    @Operation(summary = "Get a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get user"),
            @ApiResponse(responseCode = "400", description = "User not found")
    })
    @GetMapping("{id}")
    public String getUserById(@PathVariable int id){
        List<String> users = Arrays.asList("수민", "케인", "엄준식");
        if(id < 0 || id >= users.size())
            return "User not found";
        return users.get(id);
    }

    @Operation(summary = "Add new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created Successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public String addUser(@RequestBody String name) {
        return "User " + name + " added successfully";
    }
}
