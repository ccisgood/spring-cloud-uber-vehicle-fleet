package docker.service;


import docker.model.CurrentPosition;

public interface PositionService {

    void processPositionInfo(long id,
                             CurrentPosition currentPosition,
                             boolean exportPositionToKml,
                             boolean sendPositionToIngestionService);
}
