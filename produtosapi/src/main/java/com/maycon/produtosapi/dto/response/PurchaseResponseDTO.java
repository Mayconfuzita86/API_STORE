package com.maycon.produtosapi.dto.response;

import com.maycon.produtosapi.dto.PurchaseProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseResponseDTO {

    List<PurchaseProductDTO> products;
}
