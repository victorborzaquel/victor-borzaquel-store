package com.ada.victorborzaquelstore.services;

import com.ada.victorborzaquelstore.modules.client.ClientEntity;
import com.ada.victorborzaquelstore.shared.exceptions.ClientNotFoundException;
import com.ada.victorborzaquelstore.modules.employee.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.order.dto.CreateOrderDTO;
import com.ada.victorborzaquelstore.modules.order.dto.ResponseOrderDTO;
import com.ada.victorborzaquelstore.modules.order.OrderEntity;
import com.ada.victorborzaquelstore.modules.order.OrderItemEntity;
import com.ada.victorborzaquelstore.modules.order.OrderStatus;
import com.ada.victorborzaquelstore.shared.exceptions.OrderIsNotOpenException;
import com.ada.victorborzaquelstore.shared.exceptions.OrderNotFoundException;
import com.ada.victorborzaquelstore.modules.order.OrderMapper;
import com.ada.victorborzaquelstore.repositories.OrderItemRepository;
import com.ada.victorborzaquelstore.repositories.OrderRepository;
import com.ada.victorborzaquelstore.modules.product.ProductEntity;
import com.ada.victorborzaquelstore.shared.exceptions.ProductNotFoundException;
import com.ada.victorborzaquelstore.shared.exceptions.ProductNotHaveInStockException;
import com.ada.victorborzaquelstore.modules.user.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;

  private final ProductService productService;

  private final MailTemplateService mailTemplateService;

  private final EmployeeService employeeService;
  private final ClientService clientService;

  @Transactional
  public ResponseOrderDTO buy(UUID id, String sub) {
    OrderEntity order = this.verifyIsOpenOrder(id, sub);

    this.checkOrderStock(order);
    this.decreaseOrderStock(order);
    order.sell();

    OrderEntity response = this.orderRepository.save(order);

    this.sendBuyOrderMail(response);

    return OrderMapper.INSTANCE.toResponse(response);
  }

  private void decreaseOrderStock(OrderEntity order) {
    for (OrderItemEntity item : order.getItems()) {
      item.getProduct().decreaseStock(item.getQuantity());
    }
  }


  private void sendBuyOrderMail(OrderEntity order) {
    this.mailTemplateService.clientBuyOrderEmailToClient(order.getClient().getUser().getEmail());

    for (EmployeeEntity manager : this.employeeService.getAllSalesManagers()) {
      this.mailTemplateService.clientBuyOrderEmailToSalesManager(manager.getUser().getEmail());
    }
  }

  public ResponseOrderDTO removeProduct(UUID id, String sub, UUID productId) {
    OrderEntity order = this.verifyIsOpenOrder(id, sub);

    order.getItems().removeIf(item -> item.getProduct().getId() == productId);

    OrderEntity response = this.orderRepository.save(order);
    return OrderMapper.INSTANCE.toResponse(response);
  }

  private ResponseOrderDTO createOrder(CreateOrderDTO dto) {
    OrderEntity order = OrderMapper.INSTANCE.toEntity(dto);
    OrderEntity response = this.orderRepository.save(order);
    return OrderMapper.INSTANCE.toResponse(response);
  }

  public ResponseOrderDTO addProduct(UUID id, String sub, UUID productId, Integer quantity) {
    System.out.println(sub);
    ClientEntity client = this.clientService.findByUsername(sub);

    if (!this.orderRepository.existsById(id)) {
      this.createOrder(new CreateOrderDTO(client.getId()));
    }

    OrderEntity order = this.verifyIsOpenOrder(id, sub);

    this.productService.checkStock(productId, quantity);

    ProductEntity product = new ProductEntity(productId);

    OrderItemEntity item = new OrderItemEntity();
    item.setProduct(product);
    item.setQuantity(quantity);

    order.addItem(item);

    OrderEntity response = this.orderRepository.save(order);
    return OrderMapper.INSTANCE.toResponse(response);
  }

  private void checkOrderStock(OrderEntity order) {
    for (OrderItemEntity item : order.getItems()) {
      if (!this.productService.checkStock(item.getProduct().getId(), item.getQuantity())) {
        throw new ProductNotHaveInStockException();
      }
    }
  }

  public ResponseOrderDTO increaseProductQuantity(UUID id, String sub, UUID productId, Integer quantity) {
    OrderEntity order = this.verifyIsOpenOrder(id, sub);

    this.productService.checkStock(productId, quantity);

    OrderItemEntity item = this.findOrderItemByProductId(order, productId);

    item.incrementQuantity(quantity);

    OrderEntity response = this.orderRepository.save(order);
    return OrderMapper.INSTANCE.toResponse(response);
  }

  public ResponseOrderDTO decreaseProductQuantity(UUID id, String sub, UUID productId, Integer quantity) {
    OrderEntity order = this.verifyIsOpenOrder(id, sub);

    this.productService.checkStock(productId, quantity);

    OrderItemEntity item = this.findOrderItemByProductId(order, productId);

    item.decrementQuantity(quantity);

    if (item.getQuantity() <= 0) {
      order.getItems().remove(item);
      this.orderItemRepository.delete(item);
    }

    OrderEntity response = this.orderRepository.save(order);
    return OrderMapper.INSTANCE.toResponse(response);
  }

  private OrderItemEntity findOrderItemByProductId(OrderEntity order, UUID productId) {
    return order.getItems()
        .stream()
        .filter(el -> el.getProduct().getId() == productId)
        .findFirst()
        .orElseThrow(ProductNotFoundException::new);
  }


  private OrderEntity verifyIsOpenOrder(UUID id, String sub) {
    OrderEntity order = this.orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);

    ClientEntity client = order.getClient();

    if (client == null) {
      throw new ClientNotFoundException();
    }

    UserEntity clientUser = client.getUser();

    if (clientUser == null) {
      throw new ClientNotFoundException();
    }

    if (!Objects.equals(order.getClient().getUser().getUsername(), sub)) {
      throw new OrderNotFoundException();
    }

    if (order.getItems().isEmpty()) {
      throw new OrderNotFoundException();
    }

    if (order.getStatus() != OrderStatus.OPEN) {
      throw new OrderIsNotOpenException();
    }

    return order;
  }
}
