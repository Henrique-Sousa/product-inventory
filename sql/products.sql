CREATE TABLE products( 
  product_id BIGSERIAL UNIQUE NOT NULL PRIMARY KEY, 
  name VARCHAR(255), 
  description TEXT, 
  price DECIMAL, 
  quantity BIGINT
);
