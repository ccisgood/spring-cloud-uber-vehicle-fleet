package demo.service.impl;

import demo.model.GpsSimulatorRequest;
import demo.model.Leg;
import demo.model.Point;
import demo.service.GpsSimulatorFactory;
import demo.service.PathService;
import demo.service.PositionService;
import demo.support.NavUtils;
import demo.task.GpsSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DefaultGpsSimulatorFactory implements GpsSimulatorFactory{

    @Autowired
    private PathService pathService;

    @Autowired
    private PositionService positionService;

    private final AtomicLong instanceCounter = new AtomicLong();

    @Override
    public GpsSimulator prepareGpsSimulator(GpsSimulatorRequest gpsSimulatorRequest) {
        final GpsSimulator gpsSimulator = new GpsSimulator(gpsSimulatorRequest);

        gpsSimulator.setPositionInfoService(positionService);
        gpsSimulator.setId(this.instanceCounter.incrementAndGet());

        final List<Point> points = NavUtils.decodePolyline(gpsSimulatorRequest.getPolyline());
        gpsSimulator.setStartPoint(points.iterator().next());

        return prepareGpsSimulator(gpsSimulator, points);
    }

    @Override
    public GpsSimulator prepareGpsSimulator(GpsSimulator gpsSimulator, List<Point> points) {
        gpsSimulator.setCurrentPosition(null);

        final List<Leg> legs = createLegsList(points);
        gpsSimulator.setLegs(legs);
        gpsSimulator.setStartPosition();
        return gpsSimulator;
    }

    /**
     * Creates list of legs in the path.
     * @param points
     * @return
     */
    private List<Leg> createLegsList(List<Point> points) {
        final List<Leg> legs = new ArrayList<>();
        for (int i = 0; i < (points.size() - 1); i++) {
            Leg leg = new Leg();
            leg.setId(i);
            leg.setStartPosition(points.get(i));
            leg.setEndPosition(points.get(i + 1));
            Double length = NavUtils.getDistance(points.get(i), points.get(i + 1));
            leg.setLength(length);
            Double heading = NavUtils.getBearing(points.get(i), points.get(i + 1));
            leg.setHeading(heading);
            legs.add(leg);
        }
        return legs;
    }
}
