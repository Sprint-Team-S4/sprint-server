-- SQL INJECTIONS

-- ADMIN
INSERT INTO finalsprint.admin (id, username, password)
VALUES (2, 'Admin2', 'Adminpass');

-- AIRLINE
INSERT INTO finalsprint.airline (id, airline_name, contact_email) VALUES
(1, 'Air Canada', 'contact@aircanada.com'),
(2, 'West Jet', 'contact@westjet.com'),
(3, 'JetBlue', 'contact@jetblue.com'),
(4, 'Southwest Airlines', 'contact@southwest.com'),
(5, 'Scandinavian Airlines', 'contact@flysas.com');

-- AIRCRAFT
INSERT INTO finalsprint.aircraft (id, airline_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- CITY
INSERT INTO finalsprint.city (id, name, country) VALUES
(1, 'St. Johns', 'Canada'),
(2, 'Toronto', 'Canada'),
(3, 'Reykjavík', 'Iceland'),
(4, 'Washington', 'USA'),
(5, 'Stockholm', 'Sweden');

-- AIRPORT
INSERT INTO finalsprint.airport (id, name, code, city_id) VALUES
(1, 'St. Johns Airport', 'YYT', (SELECT id FROM finalsprint.city WHERE name = 'St. Johns')),
(2, 'Toronto Airport', 'YYZ', (SELECT id FROM finalsprint.city WHERE name = 'Toronto')),
(3, 'Keflavik Airport', 'KEF', (SELECT id FROM finalsprint.city WHERE name = 'Reykjavík')),
(4, 'Dulles International Airport', 'IAD', (SELECT id FROM finalsprint.city WHERE name = 'Washington')),
(5, 'Stockholm Arlanda Airport', 'ARN', (SELECT id FROM finalsprint.city WHERE name = 'Stockholm'));

-- GATE
INSERT INTO finalsprint.gate (id, gate_number, terminal_num, airport_id) VALUES
(1, 'A1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'St. Johns Airport')),
(2, 'B1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Toronto Airport')),
(3, 'C1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Keflavik Airport')),
(4, 'D1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Dulles International Airport')),
(5, 'E1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Stockholm Arlanda Airport'));

-- PASSENGERS
INSERT INTO finalsprint.passengers (id, first_name, last_name, phone_number) VALUES
(1, 'Kayleigh', 'McGrath', '709-123-4567'),
(2, 'Jonathan', 'Ivany', '709-456-7890'),
(3, 'Tyler', 'Stuckless', '709-987-6543'),
(4, 'Tyler', 'Nolan', '709-567-8901'),
(5, 'Joshua', 'Hayward', '709-234-5678'),
(6, 'David', 'Brown', '709-876-5432'),
(7, 'Jennifer', 'Davis', '709-345-6789'),
(8, 'Daniel', 'Miller', '709-654-3210'),
(9, 'Elizabeth', 'Wilson', '709-432-1098'),
(10, 'Matthew', 'Moore', '709-890-1234');

-- FLIGHT
INSERT INTO finalsprint.flight (id, flight_status, flight_number, aircraft_id, airport_id, gate_id, airline_id) VALUES
(1, 'Arriving', 'AC420', 1, (SELECT id FROM finalsprint.airport WHERE name = 'St. Johns Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'A1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Air Canada')),
(2, 'Departing', 'WJ420', 2, (SELECT id FROM finalsprint.airport WHERE name = 'Toronto Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'B1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'West Jet')),
(3, 'Arriving', 'JB420', 3, (SELECT id FROM finalsprint.airport WHERE name = 'Keflavik Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'C1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'JetBlue')),
(4, 'Departing', 'SW420', 4, (SELECT id FROM finalsprint.airport WHERE name = 'Dulles International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'D1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Southwest Airlines')),
(5, 'Arriving', 'SA420', 5, (SELECT id FROM finalsprint.airport WHERE name = 'Stockholm Arlanda Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'E1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Scandinavian Airlines'));