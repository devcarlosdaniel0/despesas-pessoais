package com.carlos.despesas_pessoais.controller;

import com.carlos.despesas_pessoais.domain.Despesa;
import com.carlos.despesas_pessoais.request.DespesaPostRequestBody;
import com.carlos.despesas_pessoais.request.DespesaPutRequestBody;
import com.carlos.despesas_pessoais.service.DespesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("despesas")
public class DespesaController {
    private final DespesaService despesaService;

    @GetMapping
    public ResponseEntity<List<Despesa>> findAll() {
        return ResponseEntity.ok(despesaService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Despesa> findById(@PathVariable long id) {
        return ResponseEntity.ok(despesaService.findByIdOrThrowsException(id));
    }

    @PostMapping
    public ResponseEntity<Despesa> save(@RequestBody @Valid DespesaPostRequestBody despesaPostRequestBody) {
        return new ResponseEntity<>(despesaService.save(despesaPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        despesaService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody DespesaPutRequestBody despesaPutRequestBody) {
        despesaService.update(despesaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
