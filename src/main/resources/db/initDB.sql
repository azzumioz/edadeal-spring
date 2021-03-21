drop table IF EXISTS edadeal_db.product;
drop table IF EXISTS edadeal_db.segment;
drop table IF EXISTS edadeal_db.retailer;
drop table IF EXISTS edadeal_db.shop;
Use edadeal_db;

CREATE TABLE segment
(
    id    int NOT NULL AUTO_INCREMENT,
    title varchar(25),
    value varchar(25),
    PRIMARY KEY (id)
);

CREATE TABLE shop
(
    id    int NOT NULL AUTO_INCREMENT,
    title varchar(25),
    value varchar(25),
    retailer_id int,
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            int NOT NULL AUTO_INCREMENT,
    segment_id    int,
    shop_id       int,
    title         varchar(150),
    quantity      varchar(25),
    price_new     DECIMAL(6, 2),
    price_old     DECIMAL(6, 2),
    discount      varchar(20),
    discount_date varchar(20),
    date          datetime,
    PRIMARY KEY (id),
    FOREIGN KEY (segment_id) REFERENCES edadeal_db.segment (id),
    FOREIGN KEY (shop_id) REFERENCES edadeal_db.shop (id)
);

INSERT INTO edadeal_db.segment (title, value)
VALUES ('--- Все категории ---', 'all'),
       ('Продукты', 'food'),
       ('Алкоголь', 'alcohol'),
       ('Для дома', 'home-stuff'),
       ('Косметика и гигиена', 'cosmetics-hygiene'),
       ('Для детей', 'for-kids'),
       ('Подарки', 'gifts'),
       ('Зоотовары', 'pet-supplies'),
       ('Одежда и обувь', 'clothes-footwear'),
       ('Спорт и отдых', 'sport-leisure'),
       ('Канцтовары', 'stationery'),
       ('Электроника', 'electronics');

INSERT INTO edadeal_db.shop (title, value, retailer_id)
VALUES ('Мария-Ра', 'maria-ra', 2),
       ('Пятерочка', '5ka', 2),
       ('Лента Гипермаркет', 'lenta-giper', 2),
       ('Детский мир', 'detmir', 6);
