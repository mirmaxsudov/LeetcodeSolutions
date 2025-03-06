package advenced.factory.service;

import advenced.factory.Transport;

public class Motorcycle implements TransportService {
    @Override
    public Transport createTransport() {
        return new Transport();
    }

    @Override
    public void drive() {
        System.out.println("Motorcycle is driving");
    }
}