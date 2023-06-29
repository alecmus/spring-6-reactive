package com.github.alecmus.spring6reactive.controllers;

import com.github.alecmus.spring6reactive.model.CustomerDTO;
import com.github.alecmus.spring6reactive.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private static final String CUSTOMER_PATH = "/api/v2/customer";
    private static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    @GetMapping(CUSTOMER_PATH)
    Flux<CustomerDTO> getAllCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping(CUSTOMER_PATH_ID)
    Mono<CustomerDTO> getCustomerById(@PathVariable("customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping(CUSTOMER_PATH)
    Mono<ResponseEntity<Void>> saveNewCustomer(@Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.saveNewCustomer(customerDTO)
                .map(savedCustomer -> ResponseEntity.created(UriComponentsBuilder.fromHttpUrl(
                        "http://localhost:8080" + CUSTOMER_PATH
                                + "/" + savedCustomer.getId())
                        .build().toUri()
                ).build());
    }

    @PutMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> updateExistingCustomer(@PathVariable("customerId") Integer customerId,
                                                      @Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerId, customerDTO)
                .map(savedDto -> ResponseEntity.ok().build());
    }

    @PatchMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> patchExistingCustomer(@PathVariable("customerId") Integer customerId,
                                                      @Validated @RequestBody CustomerDTO customerDTO) {
        return customerService.patchCustomer(customerId, customerDTO)
                .map(savedDto -> ResponseEntity.ok().build());
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable("customerId") Integer customerId) {
        return customerService.deleteCustomerById(customerId)
                .map(response -> ResponseEntity.noContent().build());
    }
}
