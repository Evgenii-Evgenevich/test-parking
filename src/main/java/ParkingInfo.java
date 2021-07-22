import java.time.LocalDateTime;

public class ParkingInfo {
    private final LocalDateTime into;

    private LocalDateTime out;

    public ParkingInfo(LocalDateTime into) {
        this.into = into;
    }

    public ParkingInfo(LocalDateTime into, LocalDateTime out) {
        this.into = into;
        this.out = out;
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

    @Override
    public String toString() {
        return "ParkingInfo{" +
                "into=" + into +
                ", out=" + out +
                '}';
    }
}
