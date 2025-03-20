CREATE TABLE discount_rules (
    id SERIAL PRIMARY KEY,
    user_type VARCHAR(50) NOT NULL,
    product_category VARCHAR(50) NOT NULL,
    min_order_amount DECIMAL(10,2) DEFAULT 0,
    discount_value DECIMAL(5,2) NOT NULL,
    discount_type VARCHAR(20) CHECK (discount_type IN ('PERCENT', 'FIXED')) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
