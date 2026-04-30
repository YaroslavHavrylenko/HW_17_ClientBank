INSERT INTO customers (name, email, age) VALUES
  ('Yaroslav Havrylenko', 'yaroslav@example.com', 45),
  ('Max Korzh', 'max@example.com', 28),
  ('Ivan Drone', 'ivan@example.com', 35);

INSERT INTO employers (id, name, address) VALUES
  (1, 'Energo Solar LLC', 'Kyiv, Energy Street 10'),
  (2, 'Oschad Bank', 'Lviv, Central Avenue 5'),
  (3, 'Tech Grid Ukraine', 'Dnipro, Industrial Road 21');

INSERT INTO customer_employers (customer_id, employer_id) VALUES
  (1, 1),
  (1, 3),
  (2, 2),
  (3, 1),
  (3, 2);

INSERT INTO accounts (number, balance, currency, customer_id) VALUES
  ('UA00000000000001', 15000.00, 'UAH', 1),
  ('US00000000000002', 1200.50, 'USD', 1),
  ('EU00000000000003', 900.00, 'EUR', 2),
  ('GB00000000000004', 450.00, 'GBP', 3);
