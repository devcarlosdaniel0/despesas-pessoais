package com.carlos.despesas_pessoais.service;

import com.carlos.despesas_pessoais.domain.Despesa;
import com.carlos.despesas_pessoais.request.DespesaPostRequestBody;
import com.carlos.despesas_pessoais.request.DespesaPutRequestBody;

import java.util.List;

public interface DespesaService {
    Despesa save(DespesaPostRequestBody despesaPostRequestBody);
    List<Despesa> findAll();
    Despesa findByIdOrThrowsException(Long id);
    Despesa update(DespesaPutRequestBody despesaPutRequestBody);
    void remove(Long id);
}
