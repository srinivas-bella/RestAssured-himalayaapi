enum class sqlQueries(var resource: String) {
    MenuDropTable("drop table if exists items cascade;"),
    MenuUpdateTable("update items set ingredient = 'nuts,orange,caramel' where product_id =100101;"),
    StoreDropTable("drop table if exists store_locations cascade;"),

    MenuClean("delete from item_price;\n" +
            "delete from item_addon;\n" +
            "delete from combo_items;\n" +
            "delete from addon;\n" +
            "delete from combo;\n" +
            "delete from store_specific_products;\n" +
            "delete from items;\n" +
            "delete from product;\n" +
            "delete from menu;"),

    MenuCreateDeletedTable("CREATE TABLE IF NOT EXISTS items\n" +
            "(\n" +
            "    product_id   integer PRIMARY KEY NOT NULL REFERENCES product (id),\n" +
            "    ingredient   varchar(500),\n" +
            "    is_available boolean default false\n" +
            ");" +
            "INSERT INTO items (product_id, ingredient, is_available)\n" +
            "VALUES (100101, '', true),\n" +
            "       (100102, '', true),\n" +
            "       (100103, '', true),\n" +
            "       (100104, '', true),\n" +
            "       (100105, '', true),\n" +
            "       (100106, '', true),\n" +
            "       (200101, '', true),\n" +
            "       (200102, '', true),\n" +
            "       (200103, '', true),\n" +
            "       (300101, '', true),\n" +
            "       (300102, '', true),\n" +
            "       (300103, '', true),\n" +
            "       (300104, '', true),\n" +
            "       (300105, '', true),\n" +
            "       (300106, '', true);"),

    MenuAddAllData("INSERT INTO menu (menu_id, name)\n" +
            "VALUES (1001, 'ICE CREAM'),\n" +
            "       (2001, 'SANDWICHES'),\n" +
            "       (3001, 'DRINKS');\n" +
            "\n" +
            "INSERT INTO product(id, name, product_type, menu_id, is_default, start_time, end_time, service_type)\n" +
            "VALUES (100101, 'Vanilla', 1, 1001, false, '11:00:00', '22:00:00', 'delivery'),\n" +
            "       (100102, 'Chocolate', 1, 1001, false, '11:00:00', '22:00:00', 'pickup'),\n" +
            "       (100103, 'Blackberry', 1, 1001, true, '11:00:00', '22:00:00', 'delivery'),\n" +
            "       (100104, 'Caramel', 1, 1001, false, '11:00:00', '22:00:00', 'pickup'),\n" +
            "       (100105, 'Cookies & Cream', 1, 1001, true, '11:00:00', '22:00:00', 'delivery'),\n" +
            "       (100106, 'Mint chocolate', 1, 1001, true, '11:00:00', '22:00:00', 'pickup'),\n" +
            "       (200101, 'Chocolate Chip Cookie & Vanilla Ice Cream', 1, 2001, true, '16:00:00', '20:00:00', 'delivery'),\n" +
            "       (200102, 'Brownie Cookie & Caramel Ice Cream', 1, 2001, true, '16:00:00', '20:00:00', 'delivery'),\n" +
            "       (200103, 'Honey Cookie & Blackberry Ice Cream', 1, 2001, true, '16:00:00', '20:00:00', 'pickup'),\n" +
            "       (300101, 'Soda', 1, 3001, true, '06:00:00', '22:00:00', 'pickup'),\n" +
            "       (300102, 'Milkshake', 1, 3001, true, '06:00:00', '22:00:00', 'delivery'),\n" +
            "       (300103, 'Flavored water ', 1, 3001, true, '06:00:00', '22:00:00', 'pickup'),\n" +
            "       (300104, 'Ice Tea', 1, 3001, true, '06:00:00', '22:00:00', 'delivery'),\n" +
            "       (300105, 'Iced Coffee', 1, 3001, true, '06:00:00', '22:00:00', 'pickup'),\n" +
            "       (300106, 'Hot Cocoa', 1, 3001, true, '06:00:00', '22:00:00', 'delivery'),\n" +
            "       (116, 'Chocolate Chip Cookie & Vanilla Ice Cream + Brownie Cookie & Caramel Ice Cream', 2, 2001, true,\n" +
            "        '16:00:00', '20:00:00', 'delivery'),\n" +
            "       (117, 'Chocolate Chip Cookie & Vanilla Ice Cream + Honey Cookie & Blackberry Ice Cream', 2, 2001, true,\n" +
            "        '16:00:00', '20:00:00', 'pickup'),\n" +
            "       (118, 'Honey Cookie & Blackberry Ice Cream + Brownie Cookie & Caramel Ice Cream', 2, 2001, true, '16:00:00',\n" +
            "        '20:00:00', 'delivery'),\n" +
            "       (119, 'Vanilla Family Pack + Vanilla Family Pack', 2, 1001, true, '11:00:00', '22:00:00', 'delivery'),\n" +
            "       (120, 'Milkshake + Hot Cocoa', 2, 3001, true, '06:00:00', '22:00:00', 'delivery');\n" +
            "\n" +
            "INSERT INTO items (product_id, ingredient, is_available)\n" +
            "VALUES (100101, '', true),\n" +
            "       (100102, '', true),\n" +
            "       (100103, '', true),\n" +
            "       (100104, '', true),\n" +
            "       (100105, '', true),\n" +
            "       (100106, '', true),\n" +
            "       (200101, '', true),\n" +
            "       (200102, '', true),\n" +
            "       (200103, '', true),\n" +
            "       (300101, '', true),\n" +
            "       (300102, '', true),\n" +
            "       (300103, '', true),\n" +
            "       (300104, '', true),\n" +
            "       (300105, '', true),\n" +
            "       (300106, '', true);\n" +
            "\n" +
            "INSERT INTO item_price (size, price, item_id, is_available, delivery_price)\n" +
            "VALUES ('single scoop', '100', 100101, true, null),\n" +
            "       ('500 ml', '200', 100101, true, 210),\n" +
            "       ('750 ml', '300', 100101, true, 310),\n" +
            "\n" +
            "       ('single scoop', 100.50, 100102, true, 110.50),\n" +
            "       ('500 ml', 200.50, 100102, true, 210.50),\n" +
            "       ('750 ml', 300.50, 100102, true, 310.50),\n" +
            "\n" +
            "       ('single scoop', 100.90, 100103, true, 110.90),\n" +
            "       ('500 ml', 200.10, 100103, true, 210.10),\n" +
            "       ('750 ml', 300.30, 100103, true, 310.30),\n" +
            "\n" +
            "       ('single scoop', 100.50, 100104, true, 101.50),\n" +
            "       ('500 ml', 200.50, 100104, true, 210.50),\n" +
            "       ('750 ml', 300.50, 100104, true, 310.50),\n" +
            "\n" +
            "       ('single scoop', 100.50, 100105, true, null),\n" +
            "       ('500 ml', 200.50, 100105, true, 210.50),\n" +
            "       ('750 ml', 300.50, 100105, true, 310.50),\n" +
            "\n" +
            "       ('single scoop', 100.60, 100106, true, 110.60),\n" +
            "       ('500 ml', 200.87, 100106, true, 210.87),\n" +
            "       ('750 ml', 300.87, 100106, true, 310.87),\n" +
            "\n" +
            "       ('single scoop', 100.50, 200101, true, 110.50),\n" +
            "       ('500 ml', 200.50, 200101, true, 210.50),\n" +
            "       ('750 ml', 300.50, 200101, true, 310.50),\n" +
            "\n" +
            "       ('single scoop', 100, 200102, true, 110),\n" +
            "       ('500 ml', 200, 200102, true, 210),\n" +
            "       ('750 ml', 300, 200102, true, 310),\n" +
            "\n" +
            "       ('single scoop', 100.50, 200103, true, null),\n" +
            "       ('500 ml', 200.50, 200103, true, 220.50),\n" +
            "       ('750 ml', 300.50, 200103, true, 310.50),\n" +
            "\n" +
            "       ('S', 100.50, 300101, true, 110.50),\n" +
            "       ('M', 200.25, 300101, true, 220.25),\n" +
            "       ('L', 300.75, 300101, true, 320.75),\n" +
            "\n" +
            "       ('S', 100.25, 300102, true, 110.25),\n" +
            "       ('M', 200.50, 300102, true, 210.50),\n" +
            "       ('L', 300.75, 300102, true, 310.75),\n" +
            "\n" +
            "       ('S', 100.50, 300103, true, 110.50),\n" +
            "       ('M', 200.25, 300103, true, 210.25),\n" +
            "       ('L', 300.75, 300103, true, 310.75),\n" +
            "\n" +
            "       ('S', 100.15, 300104, true, 110.15),\n" +
            "       ('M', 200.95, 300104, true, 220.95),\n" +
            "       ('L', 300.85, 300104, true, 310.85),\n" +
            "\n" +
            "       ('S', 100.25, 300105, true, 120.25),\n" +
            "       ('M', 200.75, 300105, true, 210.75),\n" +
            "       ('L', 300.50, 300105, true, 280),\n" +
            "\n" +
            "       ('S', 100.60, 300106, true, 120.60),\n" +
            "       ('M', 200.80, 300106, true, 210.80),\n" +
            "       ('L', 300.90, 300106, true, 330.90);\n" +
            "\n" +
            "INSERT INTO addon (id, name, price, is_available)\n" +
            "VALUES (1, 'Cheese', 10, true),\n" +
            "       (2, 'Fruits', 80, true),\n" +
            "       (3, 'Nuts', 110, true),\n" +
            "       (4, 'Choco chips', 10, true),\n" +
            "       (5, 'Choco syrup', 40, true),\n" +
            "       (6, 'whip cream', 60, true);\n" +
            "\n" +
            "INSERT INTO item_addon (item_id, addon_id)\n" +
            "VALUES (100101, 2),\n" +
            "       (100101, 3),\n" +
            "       (100101, 4),\n" +
            "       (100101, 5),\n" +
            "       (100102, 4),\n" +
            "       (100104, 3),\n" +
            "       (100104, 4);\n" +
            "\n" +
            "INSERT INTO combo (product_id, price, is_available)\n" +
            "VALUES (116, 120.20, true),\n" +
            "       (117, 150.75, true),\n" +
            "       (118, 220.00, true),\n" +
            "       (119, 173.00, true),\n" +
            "       (120, 140.50, true);\n" +
            "\n" +
            "INSERT INTO combo_items(combo_item_id, combo_id, size, quantity, name)\n" +
            "VALUES (200101, 116, 's', 1, 'Chocolate Chip Cookie & Vanilla Ice Cream'),\n" +
            "       (200102, 116, 's', 1, 'Brownie Cookie & Caramel Ice Cream'),\n" +
            "       (200101, 117, 's', 2, 'Chocolate Chip Cookie & Vanilla Ice Cream'),\n" +
            "       (200103, 117, 's', 1, 'Honey Cookie & Blackberry Ice Cream'),\n" +
            "       (200103, 118, 's', 1, 'Honey Cookie & Blackberry Ice Cream'),\n" +
            "       (200102, 118, 's', 2, 'Brownie Cookie & Caramel Ice Cream'),\n" +
            "       (100101, 119, '750 ml', 2, 'Vanilla Family Pack'),\n" +
            "       (300102, 120, 'm', 2, 'Milkshake'),\n" +
            "       (300106, 120, 'm', 2, 'Hot Cocoa');\n" +
            "\n" +
            "\n" +
            "INSERT INTO store_specific_products(item_id, store_id)\n" +
            "VALUES (100101,(SELECT store_id from stores WHERE store_name = 'Himalaya Store1')),\n" +
            "       (100101,(SELECT store_id from stores WHERE store_name = 'Himalaya Store2')),\n" +
            "       (100102,(SELECT store_id from stores WHERE store_name = 'Himalaya Store2'));"),

    StoreCreateDeletedTable("CREATE TABLE IF NOT EXISTS store_locations\n" +
            "(\n" +
            "    location_id  SERIAL PRIMARY KEY,\n" +
            "    store_id INT  REFERENCES stores (store_id),\n" +
            "    street_name   varchar(255),\n" +
            "    city     varchar(30)  NOT NULL,\n" +
            "    state   varchar(30)  NOT NULL,\n" +
            "    zip   varchar(30)  NOT NULL,\n" +
            "    latitude double precision,\n" +
            "    longitude double precision,\n" +
            "    distance double precision\n" +
            ");" +
            "INSERT INTO store_locations(store_id, street_name, city, state, zip, latitude, longitude, distance)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), '1637 S. 18th Street', 'St. Louis', 'MO', '63104', 38.6140039,-90.2142088, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), '1210 Manchester Street', 'Lexington', 'KY', '40504', 38.0565296,-84.5215431, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), '88 West Houston Street', 'New York City', 'NY', '10012', 40.727265,-74.0020127, null);"),

    StoreClean("DELETE from store_exception_hours;\n" +
            "DELETE from store_service_type;\n" +
            "DELETE from store_social_info;\n" +
            "DELETE from store_business_hours;\n" +
            "DELETE from store_contact_info;\n" +
            "DELETE from store_locations;\n" +
            "DELETE from stores;"),

    StoreAddAllData("INSERT INTO stores (store_name, polygon)\n" +
            "VALUES('Himalaya Store1', ST_GeometryFromText('POLYGON((38.79408616543471 -89.99820678541347,38.89156391929888 -90.44140849297028,38.64254937638296 -90.81548402244735,38.29482008927104 -90.53685320823895,38.38167449884376 -90.00954969360903,38.79408616543471 -89.99820678541347))')),\n" +
            "      ('Himalaya Store2', ST_GeometryFromText('POLYGON((39.331093261096 -91.10720371819653,38.81065643178234 -91.09992495994774,38.75431811945108 -90.3590473281966,39.30362537917744 -90.50250008971283,39.331093261096 -91.10720371819653))')),\n" +
            "      ('Himalaya Store3', ST_GeometryFromText('POLYGON((39.22727111299906 -89.95994312972059,39.23077265702751 -90.70452084390263,38.69477908140392 -90.56751716986044,38.66194453389424 -89.84307197232177,38.98392332534959 -90.14010505698806,39.22727111299906 -89.95994312972059))'));\n" +
            "\n" +
            "INSERT INTO store_locations(store_id, street_name, city, state, zip, latitude, longitude, distance)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), '1637 S. 18th Street', 'St. Louis', 'MO', '63104', 38.6140039,-90.2142088, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), '1210 Manchester Street', 'Lexington', 'KY', '40504', 38.0565296,-84.5215431, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), '88 West Houston Street', 'New York City', 'NY', '10012', 40.727265,-74.0020127, null);\n" +
            "\n" +
            "INSERT INTO store_contact_info(store_id, manager_name, phone_number, email)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Store 1 Manager', '(314) 819-9960', 'store1@himalaya.com'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Store 2 Manager', '(859) 288-2176', 'store2@himalaya.com'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Store 3 Manager', '(212) 209-7684', 'store3@himalaya.com');\n" +
            "\n" +
            "INSERT INTO store_business_hours(store_id, day_of_the_week, is_open, start_time, end_time)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Monday', true, '18:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Tuesday', true, '18:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Wednesday', true, '18:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Thursday', true, '18:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Friday', true, '18:00:00+0:00', '04:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Saturday', true, '18:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Sunday', true , '18:00:00+0:00', '03:00:00+0:00'),\n" +
            "\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Monday', true, '16:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Tuesday', true, '16:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Wednesday', true, '16:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Thursday', true, '16:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Friday', true, '16:00:00+0:00', '04:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Saturday', true, '16:00:00+0:00', '04:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Sunday', true , '16:00:00+0:00', '03:00:00+0:00'),\n" +
            "\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Monday', true, '17:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Tuesday', true, '17:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Wednesday', true, '17:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Thursday', true, '17:00:00+0:00', '03:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Friday', true, '17:00:00+0:00', '06:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Saturday', true, '17:00:00+0:00', '06:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Sunday', true , '17:00:00+0:00', '03:00:00+0:00');\n" +
            "\n" +
            "\n" +
            "INSERT INTO store_social_info(store_id, web, twitter, facebook, yelp)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'https://HimalayaCreameryStLouis.com', 'https://twitter.com/HimalayaCreameryStLouis', 'https://facebook.com/HimalayaCreameryStLouis', 'https://yelp.com/HimalayaCreameryStLouis'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'https://HimalayaCreameryLexington.com', 'https://twitter.com/HimalayaCreameryLexington', 'https://facebook.com/HimalayaCreameryLexington', 'https://yelp.com/HimalayaCreameryLexington'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'https://HimalayaCreameryNewYork.com', 'https://twitter.com/HimalayaCreameryNewYork', 'https://facebook.com/HimalayaCreameryNewYork', 'https://yelp.com/HimalayaCreameryNewYork');\n" +
            "\n" +
            "INSERT INTO store_service_type(store_id, service_name, order_minimum_value, delivery_fee)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Dine-in', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Delivery', 50, 15),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Take-out', 50.50, 0),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Drive through', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), 'Curb side pick-up', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Dine-in', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Take-out', 50, 0),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Drive through', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), 'Curb side pick-up', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Delivery', 50, 15.75),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Take-out', 50, 0),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), 'Drive through', null, null);\n" +
            "\n" +
            "INSERT INTO store_exception_hours(store_id, start_date_time, end_date_time, is_open, description)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Himalaya Store1'), '12-25-2120T18:00:00+0:00', '12-26-2120T22:00:00+0:00', true, 'Store half-day open on Christmas eve'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store2'), '01-01-2021T00:00:00+0:00', '01-01-2021T06:00:00+0:00', false, 'Store closed on eve of new year celebration'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Himalaya Store3'), '01-02-2021T00:00:00+0:00', '01-05-2021T00:00:00+0:00', false , 'Renovation works');\n" +
            "\n" +
            "UPDATE stores SET delivery_distance = 3.5 WHERE store_name = 'Himalaya Store1';\n" +
            "UPDATE stores SET delivery_distance = 2.25 WHERE store_name = 'Himalaya Store3';\n" +
            "\n" +
            "INSERT INTO store_specific_products(item_id, store_id)\n" +
            "VALUES (100101,(SELECT store_id from stores WHERE store_name = 'Himalaya Store1')),\n" +
            "       (100101,(SELECT store_id from stores WHERE store_name = 'Himalaya Store2')),\n" +
            "       (100102,(SELECT store_id from stores WHERE store_name = 'Himalaya Store2'));"),

    AddStore("INSERT INTO stores (store_name, polygon)\n" +
            "VALUES('Test Store', ST_GeometryFromText('POLYGON ((38.80285118527349 -91.51541170855742, 38.70029459531236 -91.78612040487222, 38.50452810466741 -91.90234910013498, 38.34682701165868 -91.71691388878914, 38.23213152908256 -91.46099715360748, 38.35790789632275 -91.20133749746529, 38.55075570062889 -91.07910436141189, 38.69453915013015 -91.20953907872307, 38.80285118527349 -91.51541170855742))'));\n" +
            "\n" +
            "INSERT INTO store_locations(store_id, street_name, city, state, zip, latitude, longitude, distance)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Test Street', 'Test City', 'TEST', '98765', 38.6140039,-90.2142088, null);\n" +
            "\n" +
            "INSERT INTO store_contact_info(store_id, manager_name, phone_number, email)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Test Store Manager', '(987) 654-3210', 'test@himalaya.com');\n" +
            "\n" +
            "INSERT INTO store_business_hours(store_id, day_of_the_week, is_open, start_time, end_time)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Monday', true, '09:00:00+0:00', '20:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Tuesday', true, '09:00:00+0:00', '20:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Wednesday', true, '09:00:00+0:00', '13:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Thursday', true, '09:00:00+0:00', '20:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Friday', true, '09:00:00+0:00', '23:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Saturday', true, '11:00:00+0:00', '13:00:00+0:00'),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Sunday', true , '10:00:00+0:00', '13:00:00+0:00');\n" +
            "\n" +
            "\n" +
            "INSERT INTO store_social_info(store_id, web, twitter, facebook, yelp)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Test Store'), 'https://testweb.com', 'https://twitter.com/test', 'https://facebook.com/test', 'https://yelp.com/test');\n" +
            "\n" +
            "INSERT INTO store_service_type(store_id, service_name, order_minimum_value, delivery_fee)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Dine-in', null, null),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Delivery', 55, 5),\n" +
            "      ((SELECT store_id from stores WHERE store_name = 'Test Store'), 'Take-out', 10, 0);\n" +
            "\n" +
            "INSERT INTO store_exception_hours(store_id, start_date_time, end_date_time, is_open, description)\n" +
            "VALUES((SELECT store_id from stores WHERE store_name = 'Test Store'), '04-12-2121T18:00:00+0:00', '04-15-2121T22:00:00+0:00', true, 'Holidays');\n" +
            "\n" +
            "UPDATE stores SET delivery_distance = 8.4 WHERE store_name = 'Test Store';"),


    DeleteStore("DELETE from store_exception_hours where store_id =(SELECT store_id from stores WHERE store_name = 'Test Store');\n" +
            "\n" +
            "DELETE from store_service_type where store_id =(SELECT store_id from stores WHERE store_name = 'Test Store');\n" +
            "\n" +
            "DELETE from store_social_info where store_id =(SELECT store_id from stores WHERE store_name = 'Test Store');\n" +
            "\n" +
            "DELETE from store_business_hours where store_id =(SELECT store_id from stores WHERE store_name = 'Test Store');\n" +
            "\n" +
            "DELETE from store_contact_info where store_id =(SELECT store_id from stores WHERE store_name = 'Test Store');\n" +
            "\n" +
            "DELETE from store_locations where store_id =(SELECT store_id from stores WHERE store_name = 'Test Store');\n" +
            "\n" +
            "DELETE from stores where store_name ='Test Store';"),


    AddMenu("INSERT INTO menu (menu_id, name)\n" +
            "VALUES (4001, 'TEST');\n" +
            "\n" +
            "INSERT INTO product(id, name, product_type, menu_id, is_default, start_time, end_time,service_type)\n" +
            "VALUES (400101, 'Test01', 1, 4001, true, '15:00:00', '15:10:00','delivery'),\n" +
            "       (400102, 'Test02', 1, 4001, true, '15:11:00', '15:20:00','pickup'),\n" +
            "       (400103, 'Test03', 1, 4001, true, '15:21:00', '15:30:00','delivery'),\n" +
            "       (400104, 'Test04', 1, 4001, true, '15:20:00', '15:30:00','pickup'),\n" +
            "       (001, 'Test05', 2, 4001, true, '15:00:00', '15:15:00','delivery'),\n" +
            "       (002, 'Test06', 2, 4001, true, '15:16:00', '15:30:00','pickup');\n" +
            "\n" +
            "INSERT INTO items (product_id, ingredient,is_available)\n" +
            "VALUES \t(400101,'TIng1',true),\n" +
            "\t\t(400102,'TIng2',true),\n" +
            "\t\t(400103,'TIng3',true),\n" +
            "\t\t(400104,'TIng4',true);\n" +
            "\n" +
            "INSERT INTO item_price (size, price, is_available, item_id)\n" +
            "VALUES ('single scoop', '100', true, 400101),\n" +
            "       ('500 ml', '200', true, 400101),\n" +
            "       ('750 ml', '300', true, 400101),\n" +
            "\n" +
            "       ('single scoop', 100.50, true, 400102),\n" +
            "       ('500 ml', 200.50, true, 400102),\n" +
            "       ('750 ml', 300.50, true, 400102),\n" +
            "\n" +
            "       ('single scoop', 100.90, true, 400103),\n" +
            "       ('500 ml', 200.10, true, 400103),\n" +
            "       ('750 ml', 300.30, true, 400103),\n" +
            "\n" +
            "       ('single scoop', 100.50, true, 400104),\n" +
            "       ('500 ml', 200.50, true, 400104),\n" +
            "       ('750 ml', 300.50, true, 400104);\n" +
            "\n" +
            "INSERT INTO addon (id, name, price,is_available)\n" +
            "VALUES (7, 'TAddon1', 10,true),\n" +
            "       (8, 'TAddon2', 80,true),\n" +
            "       (9, 'TAddon3', 110,true);\n" +
            "\n" +
            "INSERT INTO item_addon (item_id, addon_id)\n" +
            "VALUES (400101, 7),\n" +
            "       (400101, 8),\n" +
            "       (400101, 9),\n" +
            "       (400102, 7),\n" +
            "       (400102, 8),\n" +
            "       (400103, 7),\n" +
            "       (400104, 9);\n" +
            "\n" +
            "INSERT INTO combo (product_id, price, is_available)\n" +
            "VALUES (001, 120.20, true),\n" +
            "       (002, 150.75, true);\n" +
            "\n" +
            "INSERT INTO combo_items(combo_item_id, combo_id, size, quantity, name)\n" +
            "VALUES (400101, 001, 's', 1, 'Chocolate Chip Cookie & Vanilla Ice Cream'),\n" +
            "       (400102, 001, 's', 1, 'Brownie Cookie & Caramel Ice Cream'),\n" +
            "       (400103, 001, 's', 2, 'Chocolate Chip Cookie & Vanilla Ice Cream'),\n" +
            "       (400103, 002, 's', 1, 'Honey Cookie & Blackberry Ice Cream'),\n" +
            "       (400104, 002, 's', 1, 'Honey Cookie & Blackberry Ice Cream');\n" +
            "      \n" +
            "INSERT INTO store_specific_products(item_id, store_id)\n" +
            "VALUES (400101,(SELECT store_id from stores WHERE store_name = 'Himalaya Store3'));"),

    DeleteMenu("delete from item_price where item_id=400101;\n" +
            "delete from item_price where item_id=400102;\n" +
            "delete from item_price where item_id=400103;\n" +
            "delete from item_price where item_id=400104;\n" +
            "\n" +
            "delete from item_addon where item_id=400101;\n" +
            "delete from item_addon where item_id=400102;\n" +
            "delete from item_addon where item_id=400103;\n" +
            "delete from item_addon where item_id=400104;\n" +
            "\n" +
            "delete from combo_items where combo_item_id =400101;\n" +
            "delete from combo_items where combo_item_id=400102;\n" +
            "delete from combo_items where combo_item_id=400103;\n" +
            "delete from combo_items where combo_item_id=400104;\n" +
            "\n" +
            "delete from addon where name='TAddon1';\n" +
            "delete from addon where name='TAddon2';\n" +
            "delete from addon where name='TAddon3';\n" +
            "\n" +
            "delete from combo where product_id =1;\n" +
            "delete from combo where product_id =2;\n" +
            "\n" +
            "delete from store_specific_products where store_id = (select store_id from stores where store_name='Himalaya Store3');\n" +
            "\n" +
            "delete from items where product_id =400101;\n" +
            "delete from items where product_id=400102;\n" +
            "delete from items where product_id=400103;\n" +
            "delete from items where product_id=400104;\n" +
            "\n" +
            "delete from product where menu_id =4001;\n" +
            "\n" +
            "delete from menu where menu_id=4001;");

    fun sqlQueries(resource: String)
    {
        this.resource = resource
    }

    fun getValue() : String
    {
        return resource
    }

}