package docker.task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Future;

@Data
@AllArgsConstructor
public class GpsSimulatorInstance {

    private long instanceId;
    private GpsSimulator gpsSimulator;
    private Future<?> gpsSimulatorTask;

    @Override
    public String toString() {
        return "GpsSimulatorInstance [instanceId=" + instanceId + ", gpsSmulator=" + gpsSimulator
                + ", gpsSimulatorTask=" + gpsSimulatorTask + "]";
    }
}
