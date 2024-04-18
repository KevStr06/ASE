package de.dhbw.plugin.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.dhbw.domain.aggregateRoots.RentalApartmentUnit;
import de.dhbw.domain.entities.ApartmentComplex;
import de.dhbw.domain.valueObjects.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static String test = "Hello from Domain";
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        // Serialize object to JSON
        var complex = new ApartmentComplex("Rheinstraße", "1", "68163", "Mannheim", LocalDate.of(2000, 10, 3));
        RentalApartmentUnit apartmentUnit = new RentalApartmentUnit(complex, 1,1, Size.squareMeters(new BigDecimal(1)),1);

        String jsonString = null;

        try {
            jsonString = mapper.writeValueAsString(apartmentUnit);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonString);

        RentalApartmentUnit apartmentUnit2 = null;

        try {
            apartmentUnit2 = mapper.readValue(jsonString, RentalApartmentUnit.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Comparing Complexes");
        System.out.println(apartmentUnit.getParentApartmentComplex().equals(apartmentUnit2.getParentApartmentComplex()));
        System.out.println("Comparing Units");
        System.out.println(apartmentUnit.equals(apartmentUnit2));
    }
}