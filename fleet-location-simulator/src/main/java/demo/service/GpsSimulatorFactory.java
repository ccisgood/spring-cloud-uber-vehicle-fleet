package demo.service;

import demo.model.GpsSimulatorRequest;
import demo.model.Point;
import demo.task.GpsSimulator;

import java.util.List;

public interface GpsSimulatorFactory {

    GpsSimulator prepareGpsSimulator(GpsSimulatorRequest gpsSimulatorRequest);

    GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, List<Point> points);
}
