package docker.service;

import docker.model.GpsSimulatorRequest;
import docker.model.Point;
import docker.task.GpsSimulator;

import java.util.List;

public interface GpsSimulatorFactory {

    GpsSimulator prepareGpsSimulator(GpsSimulatorRequest gpsSimulatorRequest);

    GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, List<Point> points);
}
