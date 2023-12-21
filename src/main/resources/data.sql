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
(5, 'Scandinavian Airlines', 'contact@flysas.com'),
(6, 'British Airways', 'contact@britishairways.com'),
(7, 'Lufthansa', 'contact@lufthansa.com'),
(8, 'Qantas Airways', 'contact@qantas.com.au'),
(9, 'Emirates', 'contact@emirates.com'),
(10, 'All Nippon Airways', 'contact@ana.co.jp'),
(11, 'Delta Airlines', 'contact@delta.com'),
(12, 'Singapore Airlines', 'contact@singaporeair.com'),
(13, 'Cathay Pacific', 'contact@cathaypacific.com'),
(14, 'Korean Air', 'contact@koreanair.com'),
(15, 'Air France', 'contact@airfrance.com');

-- AIRCRAFT
INSERT INTO finalsprint.aircraft (id, airline_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15);

-- CITY
INSERT INTO finalsprint.city (id, name, country) VALUES
(1, 'St. Johns', 'Canada'),
(2, 'Toronto', 'Canada'),
(3, 'Reykjavík', 'Iceland'),
(4, 'Washington', 'USA'),
(5, 'Stockholm', 'Sweden'),
(6, 'London', 'United Kingdom'),
(7, 'Frankfurt', 'Germany'),
(8, 'Sydney', 'Australia'),
(9, 'Dubai', 'UAE'),
(10, 'Tokyo', 'Japan'),
(11, 'Atlanta', 'USA'),
(12, 'Singapore', 'Singapore'),
(13, 'Hong Kong', 'China'),
(14, 'Seoul', 'South Korea'),
(15, 'Paris', 'France');

-- AIRPORT
INSERT INTO finalsprint.airport (id, name, code, city_id) VALUES
(1, 'St. Johns Airport', 'YYT', (SELECT id FROM finalsprint.city WHERE name = 'St. Johns')),
(2, 'Toronto Airport', 'YYZ', (SELECT id FROM finalsprint.city WHERE name = 'Toronto')),
(3, 'Keflavik Airport', 'KEF', (SELECT id FROM finalsprint.city WHERE name = 'Reykjavík')),
(4, 'Dulles International Airport', 'IAD', (SELECT id FROM finalsprint.city WHERE name = 'Washington')),
(5, 'Stockholm Arlanda Airport', 'ARN', (SELECT id FROM finalsprint.city WHERE name = 'Stockholm')),
(6, 'Heathrow Airport', 'LHR', (SELECT id FROM finalsprint.city WHERE name = 'London')),
(7, 'Frankfurt Airport', 'FRA', (SELECT id FROM finalsprint.city WHERE name = 'Frankfurt')),
(8, 'Sydney Airport', 'SYD', (SELECT id FROM finalsprint.city WHERE name = 'Sydney')),
(9, 'Dubai International Airport', 'DXB', (SELECT id FROM finalsprint.city WHERE name = 'Dubai')),
(10, 'Tokyo Haneda Airport', 'HND', (SELECT id FROM finalsprint.city WHERE name = 'Tokyo')),
(11, 'Hartsfield–Jackson Atlanta International Airport', 'ATL', (SELECT id FROM finalsprint.city WHERE name = 'Atlanta')),
(12, 'Changi Airport', 'SIN', (SELECT id FROM finalsprint.city WHERE name = 'Singapore')),
(13, 'Hong Kong International Airport', 'HKG', (SELECT id FROM finalsprint.city WHERE name = 'Hong Kong')),
(14, 'Incheon International Airport', 'ICN', (SELECT id FROM finalsprint.city WHERE name = 'Seoul')),
(15, 'Charles de Gaulle Airport', 'CDG', (SELECT id FROM finalsprint.city WHERE name = 'Paris'));
-- GATE
INSERT INTO finalsprint.gate (id, gate_number, terminal_num, airport_id) VALUES
(1, 'A1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'St. Johns Airport')),
(2, 'B1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Toronto Airport')),
(3, 'C1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Keflavik Airport')),
(4, 'D1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Dulles International Airport')),
(5, 'E1', 'T1', (SELECT id FROM finalsprint.airport WHERE name = 'Stockholm Arlanda Airport')),
(6, 'F1', 'T2', (SELECT id FROM finalsprint.airport WHERE name = 'Heathrow Airport')),
(7, 'G1', 'T2', (SELECT id FROM finalsprint.airport WHERE name = 'Frankfurt Airport')),
(8, 'H1', 'T2', (SELECT id FROM finalsprint.airport WHERE name = 'Sydney Airport')),
(9, 'I1', 'T2', (SELECT id FROM finalsprint.airport WHERE name = 'Dubai International Airport')),
(10, 'J1', 'T2', (SELECT id FROM finalsprint.airport WHERE name = 'Tokyo Haneda Airport')),
(11, 'K1', 'T3', (SELECT id FROM finalsprint.airport WHERE name = 'Hartsfield–Jackson Atlanta International Airport')),
(12, 'L1', 'T3', (SELECT id FROM finalsprint.airport WHERE name = 'Changi Airport')),
(13, 'M1', 'T3', (SELECT id FROM finalsprint.airport WHERE name = 'Hong Kong International Airport')),
(14, 'N1', 'T3', (SELECT id FROM finalsprint.airport WHERE name = 'Incheon International Airport')),
(15, 'O1', 'T3', (SELECT id FROM finalsprint.airport WHERE name = 'Charles de Gaulle Airport'));

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
(10, 'Matthew', 'Moore', '709-890-1234'),
(11, 'Emily', 'Smith', '123-456-7890'),
(12, 'Michael', 'Johnson', '234-567-8901'),
(13, 'Sarah', 'Williams', '345-678-9012'),
(14, 'James', 'Brown', '456-789-0123'),
(15, 'Rachel', 'Jones', '567-890-1234'),
(16, 'Alice', 'Kim', '800-123-4567'),
(17, 'Bob', 'Lee', '800-234-5678'),
(18, 'Charlie', 'Brown', '800-345-6789'),
(19, 'Diana', 'Smith', '800-456-7890'),
(20, 'Edward', 'Johnson', '800-567-8901');

-- FLIGHT
INSERT INTO finalsprint.flight (id, flight_status, flight_number, aircraft_id, airport_id, gate_id, airline_id) VALUES
(1, 'Arriving', 'AC420', 1, (SELECT id FROM finalsprint.airport WHERE name = 'St. Johns Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'A1')), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Air Canada'),
(2, 'Departing', 'WJ420', 2, (SELECT id FROM finalsprint.airport WHERE name = 'Toronto Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'B1')), (SELECT id FROM finalsprint.airline WHERE airline_name = 'West Jet'),
(3, 'Arriving', 'JB420', 3, (SELECT id FROM finalsprint.airport WHERE name = 'Keflavik Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'C1')), (SELECT id FROM finalsprint.airline WHERE airline_name = 'JetBlue'),
(4, 'Departing', 'SW420', 4, (SELECT id FROM finalsprint.airport WHERE name = 'Dulles International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'D1')), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Southwest Airlines'),
(5, 'Arriving', 'SA420', 5, (SELECT id FROM finalsprint.airport WHERE name = 'Stockholm Arlanda Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'E1')), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Scandinavian Airlines'),
(6, 'Departing', 'BA420', 6, (SELECT id FROM finalsprint.airport WHERE name = 'Heathrow Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'F1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'British Airways')),
(7, 'Arriving', 'LH420', 7, (SELECT id FROM finalsprint.airport WHERE name = 'Frankfurt Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'G1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Lufthansa')),
(8, 'Departing', 'QF420', 8, (SELECT id FROM finalsprint.airport WHERE name = 'Sydney Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'H1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Qantas Airways')),
(9, 'Arriving', 'EK420', 9, (SELECT id FROM finalsprint.airport WHERE name = 'Dubai International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'I1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Emirates')),
(10, 'Departing', 'NH420', 10, (SELECT id FROM finalsprint.airport WHERE name = 'Tokyo Haneda Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'J1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'All Nippon Airways')),
(11, 'Arriving', 'DL420', 11, (SELECT id FROM finalsprint.airport WHERE name = 'Hartsfield–Jackson Atlanta International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'K1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Delta Airlines')),
(12, 'Departing', 'SQ420', 12, (SELECT id FROM finalsprint.airport WHERE name = 'Changi Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'L1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Singapore Airlines')),
(13, 'Arriving', 'CX420', 13, (SELECT id FROM finalsprint.airport WHERE name = 'Hong Kong International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'M1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Cathay Pacific')),
(14, 'Departing', 'KE420', 14, (SELECT id FROM finalsprint.airport WHERE name = 'Incheon International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'N1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Korean Air')),
(15, 'Arriving', 'AF420', 15, (SELECT id FROM finalsprint.airport WHERE name = 'Charles de Gaulle Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'O1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Air France')),
(16, 'Departing', 'AC430', 1, (SELECT id FROM finalsprint.airport WHERE name = 'St. Johns Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'A1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Air Canada')),
(17, 'Arriving', 'WJ430', 2, (SELECT id FROM finalsprint.airport WHERE name = 'Toronto Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'B1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'West Jet')),
(18, 'Departing', 'JB430', 3, (SELECT id FROM finalsprint.airport WHERE name = 'Keflavik Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'C1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'JetBlue')),
(19, 'Arriving', 'SW430', 4, (SELECT id FROM finalsprint.airport WHERE name = 'Dulles International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'D1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Southwest Airlines')),
(20, 'Departing', 'SA430', 5, (SELECT id FROM finalsprint.airport WHERE name = 'Stockholm Arlanda Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'E1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Scandinavian Airlines')),
(21, 'Arriving', 'BA430', 6, (SELECT id FROM finalsprint.airport WHERE name = 'Heathrow Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'F1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'British Airways')),
(22, 'Departing', 'LH430', 7, (SELECT id FROM finalsprint.airport WHERE name = 'Frankfurt Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'G1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Lufthansa')),
(23, 'Arriving', 'QF430', 8, (SELECT id FROM finalsprint.airport WHERE name = 'Sydney Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'H1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Qantas Airways')),
(24, 'Departing', 'EK430', 9, (SELECT id FROM finalsprint.airport WHERE name = 'Dubai International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'I1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Emirates')),
(25, 'Arriving', 'NH430', 10, (SELECT id FROM finalsprint.airport WHERE name = 'Tokyo Haneda Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'J1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'All Nippon Airways')),
(26, 'Departing', 'DL430', 11, (SELECT id FROM finalsprint.airport WHERE name = 'Hartsfield–Jackson Atlanta International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'K1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Delta Airlines')),
(27, 'Arriving', 'SQ430', 12, (SELECT id FROM finalsprint.airport WHERE name = 'Changi Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'L1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Singapore Airlines')),
(28, 'Departing', 'CX430', 13, (SELECT id FROM finalsprint.airport WHERE name = 'Hong Kong International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'M1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Cathay Pacific')),
(29, 'Arriving', 'KE430', 14, (SELECT id FROM finalsprint.airport WHERE name = 'Incheon International Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'N1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Korean Air')),
(30, 'Departing', 'AF430', 15, (SELECT id FROM finalsprint.airport WHERE name = 'Charles de Gaulle Airport'), (SELECT id FROM finalsprint.gate WHERE gate_number = 'O1'), (SELECT id FROM finalsprint.airline WHERE airline_name = 'Air France'));