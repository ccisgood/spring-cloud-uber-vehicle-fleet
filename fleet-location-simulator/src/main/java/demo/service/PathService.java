package demo.service;


import demo.model.DirectionInput;
import demo.model.Point;
import demo.model.ServiceLocation;
import demo.model.SimulatorFixture;

import java.util.List;

public interface PathService {

    List<DirectionInput> loadDirectionInput();

    SimulatorFixture loadSimulatorFixture();

    List<Point> getCoordinatesFromGoogle(DirectionInput directionInput);

    String getCoordinatesFromGoogleAsPolyline(DirectionInput directionInput);

    List<ServiceLocation> getServiceStations();
}
