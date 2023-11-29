insert into users (name, surname, email, password, address, phone, role) values ('Marko', 'Marković', 'email1', '123', 'adresa1', '060000000', 0);
insert into users (name, surname, email, password, address, phone, role) values ('Petar', 'Petrović', 'email2', '1234', 'adresa2', '060000001', 1);
insert into users (name, surname, email, password, address, phone, role) values ('Adam', 'Adamović', 'email3', '12345', 'adresa3', '060000002', 0);

-- Inserting data into Accommodation table
INSERT INTO Accommodation (title, description, short_description, address, deadline) VALUES ('Luxury Villa', 'A luxurious villa with stunning views.', 'Luxury villa with pool', '123 Main Street', 30);
INSERT INTO Accommodation (title, description, short_description, address, deadline) VALUES  ('Cozy Cabin', 'A charming cabin in the woods.', 'Rustic cabin retreat', '456 Forest Avenue', 15);
INSERT INTO Accommodation (title, description, short_description, address, deadline) VALUES  ('City Apartment', 'Modern apartment in the heart of the city.', 'Downtown apartment', '789 Urban Street', 20);

INSERT INTO Accommodation_Comment (accommodation_id, guest_id, content, date, reported) VALUES (1, 2, 'Great!', '2023-10-01', false);
-- Inserting additional data into AccommodationComment table
INSERT INTO Accommodation_Comment (accommodation_id, guest_id, content, date, reported)
VALUES
    (1, 3, 'Fantastic experience!', '2023-10-03', false),
    (2, 1, 'Lovely cabin, enjoyed every moment.', '2023-09-25', false),
    (3, 3, 'The city apartment was perfect for our stay.', '2023-10-05', false),
    (1, 1, 'Not as expected, needs improvement.', '2023-10-02', true),
    (2, 2, 'Cozy and charming, highly recommend!', '2023-09-28', false);

INSERT INTO Accommodation_Rating (accommodation_id, guest_id, rate, date, reported) VALUES (1, 2, 4.0, '2023-10-01', false);

-- Inserting additional data into AccommodationRating table
INSERT INTO Accommodation_Rating (accommodation_id, guest_id, rate, date, reported)
VALUES
    (1, 3, 5.0, '2023-10-03', false),
    (2, 1, 4.5, '2023-09-25', false),
    (3, 2, 3.8, '2023-10-05', true);

INSERT INTO Owner_Rating (owner_id, guest_id, rate, date, reported)
VALUES (1, 2, 4.5, '2023-01-01', false);
INSERT INTO Owner_Rating (owner_id, guest_id, rate, date, reported)
VALUES (3, 1, 3.8, '2023-02-15', false);
INSERT INTO Owner_Rating (owner_id, guest_id, rate, date, reported)
VALUES (2, 1, 4.9, '2023-03-10', true);
INSERT INTO Owner_Rating (owner_id, guest_id, rate, date, reported)
VALUES (2, 3, 2.5, '2023-04-20', false);
INSERT INTO Owner_Rating (owner_id, guest_id, rate, date, reported)
VALUES (3, 1, 4.0, '2023-05-05', true);

INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (1, 1000.0, '2023-05-01', '2023-12-31', 0);
INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (2, 500.0, '2023-09-01', '2023-12-01', 1);
-- Example 1
INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (3, 750.0, '2023-06-15', '2023-08-31', 1);

-- Example 2
INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (3, 1200.0, '2023-03-01', '2023-05-31', 0);

-- Example 3
INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (2, 800.0, '2023-10-15', '2023-11-30', 1);

-- Example 4
INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (1, 600.0, '2023-04-01', '2023-06-30', 0);

-- Example 5
INSERT INTO Price(accommodation_id, cost, from_date, to_date, type) VALUES (2, 900.0, '2023-07-01', '2023-09-30', 0);











-- Example 1: Inserting a new OwnerComment with reported set to false
INSERT INTO Owner_Comment (guest_id, owner_id, content, date, reported)
VALUES (1, 2, 'This is a comment.', '2023-01-01', false);

-- Example 2: Inserting another OwnerComment with reported set to true
INSERT INTO Owner_Comment (guest_id, owner_id, content, date, reported)
VALUES (3, 2, 'Another comment.', '2023-02-15', true);







