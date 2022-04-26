package com.ndangducbn.hibernate.controller;

import com.ndangducbn.hibernate.dto.request.CreateCustomerRq;
import com.ndangducbn.hibernate.dto.response.CustomerRes;
import com.ndangducbn.hibernate.entity.Customer;
import com.ndangducbn.hibernate.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
@Tag(name = "user", description = "CUSTOMER API")
public class CustomerController {
    private final String PRE_FIX_LOG = "[CustomerController]_";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(description = "Xem danh sách Customer",
            responses = {
                    @ApiResponse(content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = Customer.class))), responseCode = "200")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Thành công"),
            @ApiResponse(responseCode = "401", description = "Chưa xác thực"),
            @ApiResponse(responseCode = "403", description = "Truy cập bị cấm"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy")
    })
    @GetMapping(value = "v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerList() {
        log.debug(PRE_FIX_LOG + "getCustomerList");
        List<Customer> listCustomer = this.customerService.getListCustomer();

        return ResponseEntity.status(HttpStatus.OK).body(listCustomer);
    }

    @Operation(description = "Xem danh sách Customer",
            responses = {
                    @ApiResponse(content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = Customer.class))), responseCode = "200")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Thành công"),
            @ApiResponse(responseCode = "401", description = "Chưa xác thực"),
            @ApiResponse(responseCode = "403", description = "Truy cập bị cấm"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy")
    })
    @PostMapping(value = "v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerRes> createCustomer(@RequestBody CreateCustomerRq request) {
        log.debug(PRE_FIX_LOG + "getCustomerList");
        this.customerService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.OK).body(this.customerService.createCustomer(request));
    }

}
