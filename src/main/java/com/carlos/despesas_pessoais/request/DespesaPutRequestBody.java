package com.carlos.despesas_pessoais.request;

import com.carlos.despesas_pessoais.domain.Categoria;
import com.carlos.despesas_pessoais.domain.Frequencia;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DespesaPutRequestBody {
    @NotNull(message = "O ID da despesa é obrigatório")
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que 0")
    private Double valor;

    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;

    @NotNull(message = "A frequência é obrigatória")
    private Frequencia frequencia;
}
