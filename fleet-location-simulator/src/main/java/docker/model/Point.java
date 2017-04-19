package docker.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Point {
    private Double latitude;
    private Double longitutde;

    @Override
    public String toString() {
        return "Point [lat/lang:" + latitude + "," + longitutde + "]";
    }
}
