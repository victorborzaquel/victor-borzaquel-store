package com.ada.victorborzaquelstore.modules.product;

import com.ada.victorborzaquelstore.modules.order.OrderItemEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "discount_percentage")
  private Double discountPercentage;

  @Column(name = "rating")
  private Double rating;

  @Column(name = "stock")
  private Integer stock;

  @Column(name = "brand")
  private String brand;

  @Column(name = "category")
  private String category;

  @Column(name = "thumbnail")
  private String thumbnail;

  @Column(name = "images")
  @ElementCollection
  private List<String> images;

  @OneToMany(mappedBy = "product")
  private List<OrderItemEntity> orderItems;

  public ProductEntity(UUID id) {
    this.id = id;
  }

  public BigDecimal getDiscountPrice() {
    if (doesNotHaveDiscount()) {
      return BigDecimal.ZERO;
    }

    return price.multiply(BigDecimal.valueOf(discountPercentage));
  }

  public BigDecimal getTotalPrice() {
    if (doesNotHaveDiscount()) {
      return price;
    }

    return price.subtract(getDiscountPrice());
  }

  private boolean doesNotHaveDiscount() {
    return discountPercentage == null;
  }

  public void decreaseStock(Integer quantity) {
    this.stock -= quantity;
  }

  public void increaseStock(Integer quantity) {
    this.stock += quantity;
  }

  public boolean haveInStock(Integer quantity) {
    return this.stock >= quantity;
  }
}
