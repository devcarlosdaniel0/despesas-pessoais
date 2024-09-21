package com.carlos.despesas_pessoais.service;

import com.carlos.despesas_pessoais.domain.Despesa;
import com.carlos.despesas_pessoais.exception.BadRequestException;
import com.carlos.despesas_pessoais.mapper.DespesaMapper;
import com.carlos.despesas_pessoais.repository.DespesaRepository;
import com.carlos.despesas_pessoais.request.DespesaPostRequestBody;
import com.carlos.despesas_pessoais.request.DespesaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {
    private final DespesaRepository despesaRepository;
    private final DespesaMapper despesaMapper;

    @Override
    @Transactional
    public Despesa save(DespesaPostRequestBody despesaPostRequestBody) {
        Despesa despesa = DespesaMapper.INSTANCE.toDespesa(despesaPostRequestBody);
        return despesaRepository.save(despesa);
    }

    @Override
    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    @Override
    public Despesa findByIdOrThrowsBadRequestException(Long id) {
        return despesaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Despesa not found"));
    }

    @Override
    @Transactional
    public Despesa update(DespesaPutRequestBody despesaPutRequestBody) {
        Despesa despesaDB = findByIdOrThrowsBadRequestException(despesaPutRequestBody.getId());
        Despesa despesa = DespesaMapper.INSTANCE.toDespesa(despesaPutRequestBody);
        despesa.setId(despesaDB.getId());
        return despesaRepository.save(despesa);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        despesaRepository.delete(findByIdOrThrowsBadRequestException(id));
    }
}
