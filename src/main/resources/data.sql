INSERT INTO RESTAURANT_ROLES (ROLE)
SELECT *
    FROM(
        VALUES ('ADMIN'),
               ('KITCHEN')
        ) AS t1(ROLE)
    WHERE NOT EXISTS (SELECT * FROM RESTAURANT_ROLES);


INSERT INTO RESTAURANT_USER( PASSWORD, USERNAME, ROLES_ID)
SELECT *
    FROM(
        VALUES ('$2a$12$yqj68AqYLhEmLGSmWrMmNuWEArEcBD07FY3S/ElOc8kxm7ekwc4pC', 'farid', 1),
               ('$2a$12$yqj68AqYLhEmLGSmWrMmNuWEArEcBD07FY3S/ElOc8kxm7ekwc4pC', 'farid2', 2)

        ) AS t2(PASSWORD, USERNAME, ROLES_ID)

    WHERE NOT EXISTS ( SELECT * FROM RESTAURANT_USER);



INSERT INTO ingredients (NAME, ALLERGEN, UNIT, PRICE_PER_UNIT)
SELECT *
        FROM(
            VALUES ('sheep meat', false, 'KG', 18.50),
                   ('beef', false, 'KG', 22.00),
                   ('chicken meat', false, 'KG', 12.00),
                   ('tomato', false, 'KG', 3.50),
                   ('onion', false, 'KG', 2.00),
                   ('eggplant', false, 'KG', 4.50),
                   ('rice', false, 'KG', 4.00),
                   ('flour', true, 'KG', 1.50),
                   ('eggs', true, 'PIECE', 0.30),
                   ('butter', true, 'KG', 20.00),
                   ('greens', false, 'KG', 4.00),
                   ('salt', false, 'KG', 0.80)
            ) AS t3(NAME, ALLERGEN, UNIT, PRICE_PER_UNIT)
        WHERE NOT EXISTS (SELECT * FROM ingredients);


INSERT INTO menu (NAME, PRICE, TAX_TYPE, TAX_RATE, TAX_AMOUNT)
SELECT *
            FROM(
                VALUES ('plov', 15.00, 'VAT', 0.18, 2.70),
                       ('dolma', 12.00, 'VAT', 0.18, 2.16),
                       ('lula kabab', 18.00, 'VAT', 0.18, 3.24),
                       ('gutab', 8.00, 'VAT', 0.18, 1.44),
                       ('dushbara', 10.00, 'TAX_FREE', 0, 0)
                ) AS t4(NAME, PRICE, TAX_TYPE, TAX_RATE, TAX_AMOUNT)
            WHERE NOT EXISTS (SELECT * FROM menu );


INSERT INTO menu_ingredient (MENU_ID, INGREDIENT_ID)
SELECT *
        FROM(
            VALUES (1, 1),
                   (1, 7),
                   (1, 5),
                   (1, 10),
                   (1, 12),
                   (2, 2),
                   (2, 7),
                   (2, 5),
                   (2, 11),
                   (2, 12),
                   (3, 1),
                   (3, 5),
                   (3, 12),
                   (4, 8),
                   (4, 2),
                   (4, 5),
                   (4, 11),
                   (4, 10),
                   (5, 8),
                   (5, 2),
                   (5, 5),
                   (5, 9),
                   (5, 12)
            ) AS t5(MENU_ID, INGREDIENT_ID)
        WHERE NOT EXISTS (SELECT * FROM menu_ingredient);



