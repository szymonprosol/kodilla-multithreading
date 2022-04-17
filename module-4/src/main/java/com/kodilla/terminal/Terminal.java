package com.kodilla.terminal;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Terminal {

    private static final FlightsProvider flightsProvider = new FlightsProvider();
    private static final CompanyProvider companyProvider = new CompanyProvider();

    public static void main(String[] args) {
        flightsProvider.provideFlights().thenCompose(flights -> {
            final List<CompletableFuture<Flight>> updatedFlights = flights.stream()
                    .map(flight -> companyProvider.provideName(flight.getCompanyId())
                            .thenApply(companyName -> {
                                flight.setCompanyName(companyName);
                                return flight;
                            })).collect(Collectors.toList());

            final CompletableFuture[] updatesFlightsArray = updatedFlights.toArray(new CompletableFuture[0]);
            return CompletableFuture.allOf(updatesFlightsArray)
                    .thenApply(v -> updatedFlights.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList()));
        }).thenAccept(updatedFlights -> {
            System.out.println("----TERMINAL KODILLA----");
            System.out.println(updatedFlights);
        }).join();
    }
}