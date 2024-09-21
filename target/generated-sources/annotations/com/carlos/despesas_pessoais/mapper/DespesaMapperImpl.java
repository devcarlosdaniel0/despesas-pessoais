package com.carlos.despesas_pessoais.mapper;

import com.carlos.despesas_pessoais.domain.Despesa;
import com.carlos.despesas_pessoais.request.DespesaPostRequestBody;
import com.carlos.despesas_pessoais.request.DespesaPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T13:13:52-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class DespesaMapperImpl implements DespesaMapper {

    @Override
    public Despesa toDespesa(DespesaPostRequestBody despesaPostRequestBody) {
        if ( despesaPostRequestBody == null ) {
            return null;
        }

        Despesa.DespesaBuilder despesa = Despesa.builder();

        despesa.descricao( despesaPostRequestBody.getDescricao() );
        despesa.valor( despesaPostRequestBody.getValor() );
        despesa.categoria( despesaPostRequestBody.getCategoria() );
        despesa.frequencia( despesaPostRequestBody.getFrequencia() );

        return despesa.build();
    }

    @Override
    public Despesa toDespesa(DespesaPutRequestBody despesaPutRequestBody) {
        if ( despesaPutRequestBody == null ) {
            return null;
        }

        Despesa.DespesaBuilder despesa = Despesa.builder();

        despesa.id( despesaPutRequestBody.getId() );
        despesa.descricao( despesaPutRequestBody.getDescricao() );
        despesa.valor( despesaPutRequestBody.getValor() );
        despesa.categoria( despesaPutRequestBody.getCategoria() );
        despesa.frequencia( despesaPutRequestBody.getFrequencia() );

        return despesa.build();
    }
}
