package advenced.factory.service;

import advenced.factory.Transport;

public interface TransportService {
    Transport createTransport();

    void drive();
}