package com.maycon.produtosapi.dto.request;

import com.maycon.produtosapi.dto.PurchaseProductDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PurchaseRequestDTO {

    List<PurchaseProductDTO> products;
}
