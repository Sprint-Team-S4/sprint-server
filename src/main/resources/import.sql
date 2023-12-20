--SQL INJECTIONS

--ADMIN
INSERT INTO admin (id, username, password) VALUES
(1, 'Admin', 'Adminpass');

--AIRCRAFT
INSERT INTO aircraft (id) VALUES
(1), (2), (3), (4), (5);

--AIRLINE
INSERT INTO airline (id, airline_name, contact_email) VALUES
(1, 'Air Canada', 'contact@aircanada.com'),
(2, 'West Jet', 'contact@westjet.com'),
(3, 'JetBlue', 'contact@jetblue.com'),
(4, 'Southwest Airlines', 'contact@southwest.com'),
(5, 'Scandinavian Airlines', 'contact@flysas.com');

--CITY
INSERT INTO city (id, name, country) VALUES
(1, 'St. Johns', 'Canada'),
(2, 'Toronto', 'Canada'),
(3, 'Reykjavík', 'Iceland'),
(4, 'Washington', 'USA'),
(5, 'Stockholm', 'Sweden');

--AIRPORT
INSERT INTO airport (id, name, code, city_id) VALUES
(1, 'St. Johns Airport', 'YYT', (SELECT id FROM city WHERE name = 'St. Johns')),
(2, 'Toronto Airport', 'YYZ', (SELECT id FROM city WHERE name = 'Toronto')),
(3, 'Keflavik Airport', 'KEF', (SELECT id FROM city WHERE name = 'Reykjavík')),
(4, 'Dulles International Airport', 'IAD', (SELECT id FROM city WHERE name = 'Washington')),
(5, 'Stockholm Arlanda Airport', 'ARN', (SELECT id FROM city WHERE name = 'Stockholm'));


--GATE
INSERT INTO gate (id, gate_number, terminal_num, airport_id) VALUES
(1, 'A1', 'T1', (SELECT id FROM airport WHERE name = 'St. Johns Airport')),
(2, 'B1', 'T1', (SELECT id FROM airport WHERE name = 'Toronto Airport')),
(3, 'C1', 'T1', (SELECT id FROM airport WHERE name = 'Keflavik Airport')),
(4, 'D1', 'T1', (SELECT id FROM airport WHERE name = 'Dulles International Airport')),
(5, 'E1', 'T1', (SELECT id FROM airport WHERE name = 'Stockholm Arlanda Airport'));


--PASSENGERS
INSERT INTO passengers (id, first_name, last_name, phone_number) VALUES
(1, 'Kayleigh', 'McGrath', '709-123-4567'),
(2, 'Jonathan', 'Ivany', '709-456-7890'),


--FLIGHT
INSERT INTO flight (id, flight_status, flight_number, aircraft_id, airport_id, gate_id) VALUES
(1, 'Arriving', 'AC690', 1, (SELECT id FROM airport WHERE name = 'St. Johns Airport'), (SELECT id FROM gate WHERE gate_number = 'A1')),
(2, 'Departing', 'WJ520', 2, (SELECT id FROM airport WHERE name = 'Toronto Airport'), (SELECT id FROM gate WHERE gate_number = 'B1'));
