package docker.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import docker.model.CurrentPosition;
import docker.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DefaultPositionService implements PositionService{

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPositionService.class);

    @Autowired
    private RestTemplate restTemplate;

    public DefaultPositionService() {
        super();
    }

    @HystrixCommand(fallbackMethod = "processPositionInfoFallback")
    @Override
    public void processPositionInfo(long id, CurrentPosition currentPosition, boolean exportPositionToKml, boolean sendPositionToIngestionService) {
        String fleetLocationingest = "http://fleet-location-ingest";
        if (sendPositionToIngestionService) {
            log.info("Simulator is calling ingest REST API");
            this.restTemplate.postForLocation(fleetLocationingest + "/api/locations", currentPosition);
        }
    }

    public void processPositionInfoFallback(long id, CurrentPosition currentPosition, boolean exportPositionToKml, boolean sendPositionToIngestionService) {
        LOGGER.error("Hystrix Fallback Method. Unable to send message for ingestion.");
    }
}
