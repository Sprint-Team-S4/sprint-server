package com.keyin;

import com.keyin.Flight.Flight;
import com.keyin.Flight.Service.FlightService;
import com.keyin.Flight.Repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BackendTesting {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindArrivingFlightsByAirport() {
        String airportCode = "XYZ";
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findArrivingFlightsByAirport("Arriving", airportCode)).thenReturn(expectedFlights);

        List<Flight> actualFlights = flightService.findArrivingFlightsByAirport(airportCode);

        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    void testFindDepartingFlightsByAirport() {
        String airportCode = "XYZ";
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findDepartingFlightsByAirport("Departing", airportCode)).thenReturn(expectedFlights);

        List<Flight> actualFlights = flightService.findDepartingFlightsByAirport(airportCode);

        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    void testFindAllArrivingFlights() {
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findAllArrivingFlights()).thenReturn(expectedFlights);

        List<Flight> actualFlights = flightService.findAllArrivingFlights();

        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    void testFindAllDepartingFlights() {
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findAllDepartingFlights()).thenReturn(expectedFlights);

        List<Flight> actualFlights = flightService.findAllDepartingFlights();

        assertEquals(expectedFlights, actualFlights);
    }
}