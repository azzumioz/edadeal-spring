drop table IF EXISTS edadeal_db.product;
drop table IF EXISTS edadeal_db.segment;
Use edadeal_db;

CREATE TABLE segment
(
    id    int NOT NULL AUTO_INCREMENT,
    title varchar(25),
    value varchar(25),
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            int NOT NULL AUTO_INCREMENT,
    segment_id    int,
    title         varchar(150),
    quantity      varchar(25),
    price_new     DECIMAL(6, 2),
    price_old     DECIMAL(6, 2),
    discount      varchar(20),
    discount_date varchar(20),
    shop_name     varchar(25),
    date          datetime,
    PRIMARY KEY (id),
    FOREIGN KEY (segment_id) REFERENCES edadeal_db.segment (id)
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

