package docker.service;


import docker.model.DirectionInput;
import docker.model.Point;
import docker.model.ServiceLocation;
import docker.model.SimulatorFixture;

import java.util.List;

public interface PathService {

    List<DirectionInput> loadDirectionInput();

    SimulatorFixture loadSimulatorFixture();

    List<Point> getCoordinatesFromGoogle(DirectionInput directionInput);

    String getCoordinatesFromGoogleAsPolyline(DirectionInput directionInput);

    List<ServiceLocation> getServiceStations();
}
