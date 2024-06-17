package lld.design.zoomcar.exceptions;

public class VehicleDoesNotExistException extends RuntimeException {
    public VehicleDoesNotExistException(String message) {
        super(message);
    }
}
