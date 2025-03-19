INSERT INTO discount_rules (user_type, product_category, min_order_amount, discount_value, discount_type)
VALUES
    ('NEW', 'electronics', 0, 10, 'PERCENT'),
    ('VIP', 'clothing', 50, 15, 'PERCENT'),
    ('REGULAR', 'electronics', 100, 20, 'FIXED');