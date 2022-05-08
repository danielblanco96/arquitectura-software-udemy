INSERT INTO product_service.product(id, name, description, price, stock)
VALUES (1, 'Computer', 'Good computer', 4000, 10)
ON CONFLICT DO NOTHING;

INSERT INTO product_service.product(id, name, description, price, stock)
VALUES (2, 'Keyboard', 'Simple keyboard', 45, 2)
ON CONFLICT DO NOTHING;

INSERT INTO product_service.product(id, name, description, price, stock)
VALUES (3, 'Monitor', '4K Monitor', 455, 4)
ON CONFLICT DO NOTHING;