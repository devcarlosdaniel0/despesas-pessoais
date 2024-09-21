package com.carlos.despesas_pessoais.mapper;

import com.carlos.despesas_pessoais.domain.Despesa;
import com.carlos.despesas_pessoais.request.DespesaPostRequestBody;
import com.carlos.despesas_pessoais.request.DespesaPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DespesaMapper {
        DespesaMapper INSTANCE = Mappers.getMapper(DespesaMapper.class);

        Despesa toDespesa(DespesaPostRequestBody despesaPostRequestBody);
        Despesa toDespesa(DespesaPutRequestBody despesaPutRequestBody);
}
