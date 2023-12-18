package com.keyin.DataLoader;

import com.keyin.Admin.Admin;
import com.keyin.Admin.Repository.AdminRepository;
import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.Repository.AircraftRepository;
import com.keyin.Airline.Airline;
import com.keyin.Airline.Repository.AirlineRepository;
import com.keyin.Airport.Airport;
import com.keyin.Airport.Repository.AirportRepository;
import com.keyin.City.City;
import com.keyin.City.Repository.CityRepository;
import com.keyin.Flight.Flight;
import com.keyin.Flight.Repository.FlightRepository;
import com.keyin.Gate.Gate;
import com.keyin.Gate.Repository.GateRepository;
import com.keyin.Passengers.Passengers;
import com.keyin.Passengers.Repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationEvent {

    //    ;Repository - - - -
    private final AdminRepository adminRepository;
    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;
    private final FlightRepository flightRepository;
    private final GateRepository gateRepository;
    private final PassengersRepository passengersRepository;

    @Autowired
    public DataLoader(AircraftRepository aircraftRepository, AdminRepository adminRepository, AirlineRepository airlineRepository, AirportRepository airportRepository, CityRepository cityRepository, FlightRepository flightRepository, GateRepository gateRepository, PassengersRepository passengersRepository) {
        this.adminRepository = adminRepository;
        this.aircraftRepository = aircraftRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
        this.flightRepository = flightRepository;
        this.gateRepository = gateRepository;
        this.passengersRepository = passengersRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadAdminData();
        loadAircraftData();
        loadAirlineData();
        loadAirportData();
        loadCityData();
        loadFlightData();
        loadGateData();
        loadPassengersData();
    }

    // ;Admin Login Info - - - -
    private void loadAdminData() {
        // ;List - - - -
        List<Admin> adminList = new ArrayList<>();

        // ADMIN 1
        Admin admin1 = new Admin();
        admin1.setId(1);
        admin1.setUsername("Admin");
        admin1.setPassword("Adminpass");

        // ;Add to List - - - -
        adminList.add(admin1);

        // ;Save to Repository - - - -
        adminRepository.saveAll(adminList);
    }

    // ;Aircraft Repository - - - -
    private void loadAircraftData() {
        // ;List - - - -
        List<Aircraft> aircraftList = new ArrayList<>();

        // ;Retrieve Relationship Data - - - -
        Airline airline1 = airlineRepository.findById(1L).orElse(new Airline());
        Airline airline2 = airlineRepository.findById(2L).orElse(new Airline());
        Airline airline3 = airlineRepository.findById(3L).orElse(new Airline());
        Airline airline4 = airlineRepository.findById(4L).orElse(new Airline());
        Airline airline5 = airlineRepository.findById(5L).orElse(new Airline());

        Airport airport1 = airportRepository.findById(1L).orElse(new Airport());
        Airport airport2 = airportRepository.findById(2L).orElse(new Airport());
        Airport airport3 = airportRepository.findById(3L).orElse(new Airport());
        Airport airport4 = airportRepository.findById(4L).orElse(new Airport());
        Airport airport5 = airportRepository.findById(5L).orElse(new Airport());

        // AIRCRAFT 1
        Aircraft aircraft1 = new Aircraft();
        aircraft1.setId(1);
        aircraft1.setAirline(airline1);
        aircraft1.setAirports(List.of(airport1, airport2));

        // AIRCRAFT 2
        Aircraft aircraft2 = new Aircraft();
        aircraft2.setId(2);
        aircraft2.setAirline(airline2);
        aircraft2.setAirports(List.of(airport1, airport2, airport4));

        // AIRCRAFT 3
        Aircraft aircraft3 = new Aircraft();
        aircraft3.setId(3);
        aircraft3.setAirline(airline3);
        aircraft3.setAirports(List.of(airport3, airport4));

        // AIRCRAFT 4
        Aircraft aircraft4 = new Aircraft();
        aircraft4.setId(4);
        aircraft4.setAirline(airline4);
        aircraft4.setAirports(List.of(airport1, airport3, airport4));

        // AIRCRAFT 5
        Aircraft aircraft5 = new Aircraft();
        aircraft5.setId(5);
        aircraft5.setAirline(airline5);
        aircraft5.setAirports(List.of(airport2, airport3, airport5));

        // ;Add to List - - - -
        aircraftList.add(aircraft1);
        aircraftList.add(aircraft2);
        aircraftList.add(aircraft3);
        aircraftList.add(aircraft4);
        aircraftList.add(aircraft5);

        // ;Save to Repository - - - -
        aircraftRepository.saveAll(aircraftList);
    }

    // ;Airline Repository - - - -

    private void loadAirlineData() {
        // ;List - - - -
        List<Airline> airlineList = new ArrayList<>();

        // ;Retrieve Relationship Data - - - -
        Aircraft aircraft1 = aircraftRepository.findById(1L).orElse(new Aircraft());
        Aircraft aircraft2 = aircraftRepository.findById(2L).orElse(new Aircraft());
        Aircraft aircraft3 = aircraftRepository.findById(3L).orElse(new Aircraft());
        Aircraft aircraft4 = aircraftRepository.findById(4L).orElse(new Aircraft());
        Aircraft aircraft5 = aircraftRepository.findById(5L).orElse(new Aircraft());

        // AIRLINE 1
        Airline airline1 = new Airline();
        airline1.setId(1);
        airline1.setAirlineName("Air Canada");
        airline1.setContactEmail("contact@aircanada.com");
        airline1.setAircrafts(List.of(aircraft1));

        // AIRLINE 2
        Airline airline2 = new Airline();
        airline2.setId(2);
        airline2.setAirlineName("West Jet");
        airline2.setContactEmail("contact@westjet.com");
        airline2.setAircrafts(List.of(aircraft2));

        // AIRLINE 3
        Airline airline3 = new Airline();
        airline3.setId(3);
        airline3.setAirlineName("JetBlue");
        airline3.setContactEmail("contact@westjet.com");
        airline3.setAircrafts(List.of(aircraft3));

        // AIRLINE 4
        Airline airline4 = new Airline();
        airline4.setId(4);
        airline4.setAirlineName("Southwest Airlines");
        airline4.setContactEmail("contact@southwest.com");
        airline4.setAircrafts(List.of(aircraft4));

        // AIRLINE 5
        Airline airline5 = new Airline();
        airline5.setId(5);
        airline5.setAirlineName("Scandinavian Airlines");
        airline5.setContactEmail("contact@flysas.com");
        airline5.setAircrafts(List.of(aircraft5));

        // ;Add to List - - - -
        airlineList.add(airline1);
        airlineList.add(airline2);
        airlineList.add(airline3);
        airlineList.add(airline4);
        airlineList.add(airline5);

        // ;Save to Repository - - - -
        airlineRepository.saveAll(airlineList);
    }

    // ;Airport Repository - - - -
    private void loadAirportData() {
        // ;List - - - -
        List<Airport> airportList = new ArrayList<>();

        // ;Retrieve Relationship Data - - - -
        City city1 = cityRepository.findById(1L).orElse(new City());
        City city2 = cityRepository.findById(2L).orElse(new City());
        City city3 = cityRepository.findById(3L).orElse(new City());
        City city4 = cityRepository.findById(4L).orElse(new City());
        City city5 = cityRepository.findById(5L).orElse(new City());

        Gate gate1 = gateRepository.findById(1L).orElse(new Gate());
        Gate gate2 = gateRepository.findById(2L).orElse(new Gate());
        Gate gate3 = gateRepository.findById(3L).orElse(new Gate());
        Gate gate4 = gateRepository.findById(4L).orElse(new Gate());
        Gate gate5 = gateRepository.findById(5L).orElse(new Gate());

        // AIRPORT 1
        Airport airport1 = new Airport();
        airport1.setId(1);
        airport1.setName("St. John's Airport");
        airport1.setCode("YYT");
        airport1.setCity(city1);
        airport1.setGates(List.of(gate1));

        // AIRPORT 2
        Airport airport2 = new Airport();
        airport2.setId(2);
        airport2.setName("Toronto Airport");
        airport2.setCode("YYZ");
        airport2.setCity(city2);
        airport2.setGates(List.of(gate2));

        // AIRPORT 3
        Airport airport3 = new Airport();
        airport3.setId(3);
        airport3.setName("Keflavik Airport");
        airport3.setCode("KEF");
        airport3.setCity(city3);
        airport3.setGates(List.of(gate3));

        // AIRPORT 4
        Airport airport4 = new Airport();
        airport4.setId(4);
        airport4.setName("Dulles International Airport");
        airport4.setCode("IAD");
        airport4.setCity(city4);
        airport4.setGates(List.of(gate4));

        // AIRPORT 5
        Airport airport5 = new Airport();
        airport5.setId(5);
        airport5.setName("Stockholm Arlanda Airport");
        airport5.setCode("ARN");
        airport5.setCity(city5);
        airport5.setGates(List.of(gate5));

        // ;Add to List - - - -
        airportList.add(airport1);
        airportList.add(airport2);
        airportList.add(airport3);
        airportList.add(airport4);
        airportList.add(airport5);

        // ;Save to Repository - - - -
        airportRepository.saveAll(airportList);
    }

    // ;City Repository - - - -
    private void loadCityData() {
        // ;List - - - -
        List<City> cityList = new ArrayList<>();

        // ;Retrieve Relationship Data - - - -
        Airport airport1 = airportRepository.findById(1L).orElse(new Airport());
        Airport airport2 = airportRepository.findById(2L).orElse(new Airport());
        Airport airport3 = airportRepository.findById(3L).orElse(new Airport());
        Airport airport4 = airportRepository.findById(4L).orElse(new Airport());
        Airport airport5 = airportRepository.findById(5L).orElse(new Airport());

        // CITY 1
        City city1 = new City();
        city1.setId(1);
        city1.setName("St. John's");
        city1.setCountry("Canada");
        city1.setAirports(List.of(airport1));

        // CITY 2
        City city2 = new City();
        city2.setId(2);
        city2.setName("Toronto");
        city2.setCountry("Canada");
        city2.setAirports(List.of(airport2));

        // CITY 3
        City city3 = new City();
        city3.setId(3);
        city3.setName("Reykjavík");
        city3.setCountry("Iceland");
        city3.setAirports(List.of(airport3));

        // CITY 4
        City city4 = new City();
        city4.setId(4);
        city4.setName("Washington");
        city4.setCountry("America");
        city4.setAirports(List.of(airport4));

        // CITY 5
        City city5 = new City();
        city5.setId(5);
        city5.setName("Stockholm");
        city5.setCountry("Sweden");
        city5.setAirports(List.of(airport5));

        // ;Add to List - - - -
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        cityList.add(city5);

        // ;Save to Repository - - - -
        cityRepository.saveAll(cityList);
    }

    // ;Flight Repository - - - -
    private void loadFlightData() {
        // ;List - - - -
        List<Flight> flightList = new ArrayList<>();

        // ;Retrieve Relationship Data - - - -
        Aircraft aircraft1 = aircraftRepository.findById(1L).orElse(new Aircraft());
        Aircraft aircraft2 = aircraftRepository.findById(2L).orElse(new Aircraft());
        Aircraft aircraft3 = aircraftRepository.findById(3L).orElse(new Aircraft());
        Aircraft aircraft4 = aircraftRepository.findById(4L).orElse(new Aircraft());
        Aircraft aircraft5 = aircraftRepository.findById(5L).orElse(new Aircraft());

        Airline airline1 = airlineRepository.findById(1L).orElse(new Airline());
        Airline airline2 = airlineRepository.findById(2L).orElse(new Airline());
        Airline airline3 = airlineRepository.findById(3L).orElse(new Airline());
        Airline airline4 = airlineRepository.findById(4L).orElse(new Airline());
        Airline airline5 = airlineRepository.findById(5L).orElse(new Airline());

        Airport airport1 = airportRepository.findById(1L).orElse(new Airport());
        Airport airport2 = airportRepository.findById(2L).orElse(new Airport());
        Airport airport3 = airportRepository.findById(3L).orElse(new Airport());
        Airport airport4 = airportRepository.findById(4L).orElse(new Airport());
        Airport airport5 = airportRepository.findById(5L).orElse(new Airport());

        City city1 = cityRepository.findById(1L).orElse(new City());
        City city2 = cityRepository.findById(2L).orElse(new City());
        City city3 = cityRepository.findById(3L).orElse(new City());
        City city4 = cityRepository.findById(4L).orElse(new City());
        City city5 = cityRepository.findById(5L).orElse(new City());

        Gate gate1 = gateRepository.findById(1L).orElse(new Gate());
        Gate gate2 = gateRepository.findById(2L).orElse(new Gate());
        Gate gate3 = gateRepository.findById(3L).orElse(new Gate());
        Gate gate4 = gateRepository.findById(4L).orElse(new Gate());
        Gate gate5 = gateRepository.findById(5L).orElse(new Gate());

        Passengers passenger1 = passengersRepository.findById(1L).orElse(new Passengers());
        Passengers passenger2 = passengersRepository.findById(2L).orElse(new Passengers());
        Passengers passenger3 = passengersRepository.findById(3L).orElse(new Passengers());
        Passengers passenger4 = passengersRepository.findById(4L).orElse(new Passengers());
        Passengers passenger5 = passengersRepository.findById(5L).orElse(new Passengers());
        Passengers passenger6 = passengersRepository.findById(6L).orElse(new Passengers());
        Passengers passenger7 = passengersRepository.findById(7L).orElse(new Passengers());
        Passengers passenger8 = passengersRepository.findById(8L).orElse(new Passengers());
        Passengers passenger9 = passengersRepository.findById(9L).orElse(new Passengers());
        Passengers passenger10 = passengersRepository.findById(10L).orElse(new Passengers());

        // FLIGHT 1
        Flight flight1 = new Flight();
        flight1.setId(1);
        flight1.setFlightStatus("Arriving");
        flight1.setFlightNumber("AC690");
        flight1.setAircraft(aircraft1);
        flight1.setAirline(airline1);
        flight1.setAirport(airport1);
        flight1.setCity(city1);
        flight1.setGate(gate1);
        flight1.setPassengers(List.of(passenger1, passenger2));

        // FLIGHT 2
        Flight flight2 = new Flight();
        flight2.setId(2);
        flight2.setFlightStatus("Departing");
        flight2.setFlightNumber("WJ520");
        flight2.setAircraft(aircraft2);
        flight2.setAirline(airline2);
        flight2.setAirport(airport2);
        flight2.setCity(city2);
        flight2.setGate(gate2);
        flight2.setPassengers(List.of(passenger3, passenger4, passenger5, passenger6));

        // FLIGHT 3
        Flight flight3 = new Flight();
        flight3.setId(3);
        flight3.setFlightStatus("Arriving");
        flight3.setFlightNumber("JB238");
        flight3.setAircraft(aircraft3);
        flight3.setAirline(airline3);
        flight3.setAirport(airport3);
        flight3.setCity(city3);
        flight3.setGate(gate3);
        flight3.setPassengers(List.of(passenger7, passenger8));

        // FLIGHT 4
        Flight flight4 = new Flight();
        flight4.setId(4);
        flight4.setFlightStatus("Departing");
        flight4.setFlightNumber("SW736");
        flight4.setAircraft(aircraft4);
        flight4.setAirline(airline4);
        flight4.setAirport(airport4);
        flight4.setCity(city4);
        flight4.setGate(gate4);
        flight4.setPassengers(List.of(passenger9));

        // FLIGHT 5
        Flight flight5 = new Flight();
        flight5.setId(5);
        flight5.setFlightStatus("Departing");
        flight5.setFlightNumber("SA138");
        flight5.setAircraft(aircraft5);
        flight5.setAirline(airline5);
        flight5.setAirport(airport5);
        flight5.setCity(city5);
        flight5.setGate(gate5);
        flight5.setPassengers(List.of(passenger10));

        // ;Add to List - - - -
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);

        // ;Save to Repository - - - -
        flightRepository.saveAll(flightList);
    }

    // ;Gate Repository - - - -
    private void loadGateData() {
        // ;List - - - -
        List<Gate> gateList = new ArrayList<>();

        // ;Retrieve Relationship Data - - - -
        Airport airport1 = airportRepository.findById(1L).orElse(new Airport());
        Airport airport2 = airportRepository.findById(2L).orElse(new Airport());
        Airport airport3 = airportRepository.findById(3L).orElse(new Airport());
        Airport airport4 = airportRepository.findById(4L).orElse(new Airport());
        Airport airport5 = airportRepository.findById(5L).orElse(new Airport());

        // GATE 1
        Gate gate1 = new Gate();
        gate1.setId(1);
        gate1.setGateNumber("A1");
        gate1.setTerminalNum("T1");
        gate1.setAirport(airport1);

        // GATE 2
        Gate gate2 = new Gate();
        gate2.setId(2);
        gate2.setGateNumber("A2");
        gate2.setTerminalNum("T2");
        gate2.setAirport(airport2);

        // GATE 3
        Gate gate3 = new Gate();
        gate3.setId(3);
        gate3.setGateNumber("B2");
        gate3.setTerminalNum("T3");
        gate3.setAirport(airport3);

        // GATE 4
        Gate gate4 = new Gate();
        gate4.setId(4);
        gate4.setGateNumber("C2");
        gate4.setTerminalNum("T4");
        gate4.setAirport(airport4);

        // GATE 5
        Gate gate5 = new Gate();
        gate5.setId(5);
        gate5.setGateNumber("D2");
        gate5.setTerminalNum("T5");
        gate5.setAirport(airport5);

        // ;Add to List - - - -
        gateList.add(gate1);
        gateList.add(gate2);
        gateList.add(gate3);
        gateList.add(gate4);
        gateList.add(gate5);

        // ;Save to Repository - - - -
        gateRepository.saveAll(gateList);
    }

    // ;Passengers Repository - - - -

    private void loadPassengersData() {
        // ;List - - - -
        List<Passengers> passengersList = new ArrayList<>();

        // PASSENGER 1
        Passengers passenger1 = new Passengers();
        passenger1.setId(1);
        passenger1.setFirstName("Kayleigh");
        passenger1.setLastName("McGrath");
        passenger1.setPhoneNumber("709-123-4567");

        // PASSENGER 2
        Passengers passenger2 = new Passengers();
        passenger2.setId(2);
        passenger2.setFirstName("Jonathan");
        passenger2.setLastName("Ivany");
        passenger2.setPhoneNumber("709-456-7890");

        // PASSENGER 3
        Passengers passenger3 = new Passengers();
        passenger3.setId(3);
        passenger3.setFirstName("Emily");
        passenger3.setLastName("Smith");
        passenger3.setPhoneNumber("555-123-7890");

        // PASSENGER 4
        Passengers passenger4 = new Passengers();
        passenger4.setId(4);
        passenger4.setFirstName("Michael");
        passenger4.setLastName("Johnson");
        passenger4.setPhoneNumber("555-456-2345");

        // PASSENGER 5
        Passengers passenger5 = new Passengers();
        passenger5.setId(5);
        passenger5.setFirstName("Sophia");
        passenger5.setLastName("Brown");
        passenger5.setPhoneNumber("555-789-5678");

        // PASSENGER 6
        Passengers passenger6 = new Passengers();
        passenger6.setId(6);
        passenger6.setFirstName("Ethan");
        passenger6.setLastName("Davis");
        passenger6.setPhoneNumber("555-234-9012");

        // PASSENGER 7
        Passengers passenger7 = new Passengers();
        passenger7.setId(7);
        passenger7.setFirstName("Olivia");
        passenger7.setLastName("Miller");
        passenger7.setPhoneNumber("555-567-3456");

        // PASSENGER 8
        Passengers passenger8 = new Passengers();
        passenger8.setId(8);
        passenger8.setFirstName("Aiden");
        passenger8.setLastName("Anderson");
        passenger8.setPhoneNumber("555-901-6789");

        // PASSENGER 9
        Passengers passenger9 = new Passengers();
        passenger9.setId(9);
        passenger9.setFirstName("Emma");
        passenger9.setLastName("Thomas");
        passenger9.setPhoneNumber("555-345-0123");

        // PASSENGER 10
        Passengers passenger10 = new Passengers();
        passenger10.setId(10);
        passenger10.setFirstName("Noah");
        passenger10.setLastName("Jackson");
        passenger10.setPhoneNumber("555-678-4567");

        // ;Add to List - - - -
        passengersList.add(passenger1);
        passengersList.add(passenger2);
        passengersList.add(passenger3);
        passengersList.add(passenger4);
        passengersList.add(passenger5);
        passengersList.add(passenger6);
        passengersList.add(passenger7);
        passengersList.add(passenger8);
        passengersList.add(passenger9);
        passengersList.add(passenger10);

        // ;Save to Repository - - - -
        passengersRepository.saveAll(passengersList);
    }
}
