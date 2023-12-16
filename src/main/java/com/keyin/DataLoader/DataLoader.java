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

        // AIRCRAFT 1
        Aircraft aircraft1 = new Aircraft();
        aircraft1.setId(1);
        aircraft1.setAirlineName("Air Canada");

        // AIRCRAFT 2
        Aircraft aircraft2 = new Aircraft();
        aircraft2.setId(2);
        aircraft2.setAirlineName("West Jet");

        // ;Add to List - - - -
        aircraftList.add(aircraft1);
        aircraftList.add(aircraft2);

        // ;Save to Repository - - - -
        aircraftRepository.saveAll(aircraftList);
    }

    // ;Airline Repository - - - -

    private void loadAirlineData() {
        // ;List - - - -
        List<Airline> airlineList = new ArrayList<>();

        // AIRLINE 1
        Airline airline1 = new Airline();
        airline1.setId(1L);
        airline1.setAirlineName("Air Canada");
        airline1.setContactEmail("contact@aircanada.ca");

        // AIRLINE 2
        Airline airline2 = new Airline();
        airline2.setId(2L);
        airline2.setAirlineName("West Jet");
        airline2.setContactEmail("contact@westjet.com");

        // ;Add to List - - - -
        airlineList.add(airline1);
        airlineList.add(airline2);

        // ;Save to Repository - - - -
        airlineRepository.saveAll(airlineList);
    }

    // ;Airport Repository - - - -
    private void loadAirportData() {
        // ;List - - - -
        List<Airport> airportList = new ArrayList<>();

        // AIRPORT 1
        Airport airport1 = new Airport();
        airport1.setId(1);
        airport1.setName("St. John's Airport");
        airport1.setCode("YYT");

        // AIRPORT 2
        Airport airport2 = new Airport();
        airport2.setId(2);
        airport2.setName("Toronto Airport");
        airport2.setCode("YYZ");

        // ;Add to List - - - -
        airportList.add(airport1);
        airportList.add(airport2);

        // ;Save to Repository - - - -
        airportRepository.saveAll(airportList);
    }

    // ;City Repository - - - -
    private void loadCityData() {
        // ;List - - - -
        List<City> cityList = new ArrayList<>();

        // CITY 1
        City city1 = new City();
        city1.setId(1);
        city1.setName("St. John's");

        // CITY 2
        City city2 = new City();
        city2.setId(1);
        city2.setName("Toronto");

        // ;Add to List - - - -
        cityList.add(city1);
        cityList.add(city2);

        // ;Save to Repository - - - -
        cityRepository.saveAll(cityList);
    }

    // ;Flight Repository - - - -
    private void loadFlightData() {
        // ;List - - - -
        List<Flight> flightList = new ArrayList<>();

        // FLIGHT 1
        Flight flight1 = new Flight();
        flight1.setId(1);
        flight1.setFlightStatus("Arriving");
        flight1.setFlightNumber("AC690");

        // FLIGHT 1
        Flight flight2 = new Flight();
        flight2.setId(2);
        flight2.setFlightStatus("Departing");
        flight2.setFlightNumber("WJ520");

        // ;Add to List - - - -
        flightList.add(flight1);
        flightList.add(flight2);

        // ;Save to Repository - - - -
        flightRepository.saveAll(flightList);
    }

    // ;Gate Repository - - - -
    private void loadGateData() {
        // ;List - - - -
        List<Gate> gateList = new ArrayList<>();

        // GATE 1
        Gate gate1 = new Gate();
        gate1.setId(1L);
        gate1.setGateNumber("A1");
        gate1.setTerminalNum("T1");

        // GATE 2
        Gate gate2 = new Gate();
        gate2.setId(2L);
        gate2.setGateNumber("A2");
        gate2.setTerminalNum("T2");

        // ;Add to List - - - -
        gateList.add(gate1);
        gateList.add(gate2);

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

        // ;Add to List - - - -
        passengersList.add(passenger1);
        passengersList.add(passenger2);

        // ;Save to Repository - - - -
        passengersRepository.saveAll(passengersList);
    }
}
