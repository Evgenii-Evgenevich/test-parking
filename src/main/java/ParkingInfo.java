import java.time.LocalDateTime;

public class ParkingInfo {
    private String carId;

    private LocalDateTime into;

    private LocalDateTime out;

    public ParkingInfo(String carId, LocalDateTime into) {
        this.carId = carId;
        this.into = into;
    }

    public ParkingInfo(String carId, LocalDateTime into, LocalDateTime out) {
        this.carId = carId;
        this.into = into;
        this.out = out;
    }

    public String getCarId() {
        return carId;
    }

    public LocalDateTime getInto() {
        return into;
    }

    public LocalDateTime getOut() {
        return out;
    }

    public void setOut(LocalDateTime out) {
        this.out = out;
    }
}
