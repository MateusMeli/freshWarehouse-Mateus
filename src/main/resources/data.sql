use fresh_warehouse_db;

INSERT INTO warehouse(address, city, country, number, state) values('Address 1', 'City 1', 'Country 1', 1, 'State 1');
INSERT INTO section(name, id_warehouse, available_space) values('Fresh', 1, 100);
INSERT INTO seller(name) values('Seller Name');
INSERT INTO buyer(name) VALUES ('Buyer Name');