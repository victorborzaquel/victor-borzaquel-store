package com.ada.victorborzaquelstore.api.v1;

import com.ada.victorborzaquelstore.modules.product.services.ProductService;
import com.ada.victorborzaquelstore.modules.product.dto.CreateProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.ResponseProductDTO;
import com.ada.victorborzaquelstore.modules.product.dto.UpdateProductDTO;
import com.ada.victorborzaquelstore.shared.providers.mail.models.MailProvider;
import com.ada.victorborzaquelstore.shared.providers.mail.dto.MailProviderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

  private final ProductService productService;

  private final MailProvider mailProvider;

  @PostMapping
  public ResponseProductDTO create(@RequestBody CreateProductDTO dto) {
    var mail = new MailProviderDTO("name", "email", "subject");
    this.mailProvider.sendMail(mail);
    return this.productService.create(dto);
  }

  @PutMapping("{id}")
  public ResponseProductDTO update(@PathVariable UUID id, @RequestBody UpdateProductDTO dto) {
    return this.productService.update(id, dto);
  }
}
