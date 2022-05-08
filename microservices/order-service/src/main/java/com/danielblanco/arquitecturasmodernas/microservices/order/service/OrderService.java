package com.danielblanco.arquitecturasmodernas.microservices.order.service;

import com.danielblanco.arquitecturasmodernas.microservices.order.client.ProductServiceClient;
import com.danielblanco.arquitecturasmodernas.microservices.order.client.UserServiceClient;
import com.danielblanco.arquitecturasmodernas.microservices.order.dto.AddressDTO;
import com.danielblanco.arquitecturasmodernas.microservices.order.dto.OrderDTO;
import com.danielblanco.arquitecturasmodernas.microservices.order.dto.OrderLineDTO;
import com.danielblanco.arquitecturasmodernas.microservices.order.dto.ProductDTO;
import com.danielblanco.arquitecturasmodernas.microservices.order.dto.UserDTO;
import com.danielblanco.arquitecturasmodernas.microservices.order.model.Order;
import com.danielblanco.arquitecturasmodernas.microservices.order.model.OrderLine;
import com.danielblanco.arquitecturasmodernas.microservices.order.model.User;
import com.danielblanco.arquitecturasmodernas.microservices.order.repository.OrderRepository;
import com.danielblanco.arquitecturasmodernas.microservices.order.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserServiceClient userServiceClient;

  @Autowired
  private ProductServiceClient productServiceClient;

  public Optional<Order> findById(Long userId) {
    return orderRepository.findById(userId);
  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  @Transactional
  public Order addOrder(OrderDTO orderDto) {
    User user = findAndMapUser(orderDto);
    userRepository.save(user);

    Order order = createOrder(user);
    order = orderRepository.saveAndFlush(order);
    fillOrderLines(order, orderDto);
    return orderRepository.save(order);
  }

  private Order createOrder(User user) {
    Order order = new Order();
    order.setAddressFirstLine(user.getAddressFirstLine());
    order.setAddressSecondLine(user.getAddressSecondLine());
    order.setAddressCountry(user.getAddressCountry());
    order.setAddressPostCode(user.getAddressPostCode());
    order.setOrderDate(new Date());
    order.setUser(user);
    return order;
  }

  private void fillOrderLines(Order order, OrderDTO orderDto) {
    int totalPrice = 0;
    List<OrderLine> orderLines = new ArrayList<>();
    for (OrderLineDTO ol : orderDto.getOrderLines()) {
      OrderLine orderLine = createOrderLine(ol);
      orderLine.setOrderId(order.getId());
      orderLines.add(orderLine);
      totalPrice += orderLine.getLineTotalPrice();
    }
    order.setTotalPrice(totalPrice);
    order.setOrderLines(orderLines);
  }

  
  private OrderLine createOrderLine(OrderLineDTO ol) {
    OrderLine orderLine = new OrderLine();
    orderLine.setProductId(ol.getProductId());
    orderLine.setQuantity(ol.getQuantity());
    ProductDTO product = productServiceClient.removeStock(ol.getProductId(), ol.getQuantity());
    orderLine.setProductName(product.getName());
    orderLine.setProductPrice(product.getPrice());
    int linePrice = product.getPrice() * ol.getQuantity();
    orderLine.setLineTotalPrice(linePrice);
    return orderLine;
  }

  private User findAndMapUser(OrderDTO orderDto) {
    UserDTO userDto = userServiceClient.findUserById(orderDto.getUserId());
    User user = new User();
    user.setId(userDto.getId());
    user.setFullName(userDto.getFullName());
    AddressDTO defaultAddress = userDto.getAddresses().stream().filter(AddressDTO::getDefault)
      .findFirst().orElseThrow();
    user.setAddressFirstLine(defaultAddress.getFirstLine());
    user.setAddressSecondLine(defaultAddress.getSecondLine());
    user.setAddressCountry(defaultAddress.getCountry());
    user.setAddressPostCode(defaultAddress.getPostCode());

    return user;
  }
}
