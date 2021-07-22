import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingService {
    Set<Car> cars = new HashSet<>();
    Map<String, LinkedList<ParkingInfo>> parkingInfoMap = new HashMap<>();

    public int carsCount() {
        return cars.size();
    }

    public long countByFirma() {
        return cars.stream()
                .filter(Car::isFirma)
                .count();
    }

    public void into(Car car) {
        if (cars.add(car)) {
            LinkedList<ParkingInfo> parkingInfo = parkingInfoMap.computeIfAbsent(car.getId(), k -> new LinkedList<>());
            parkingInfo.addFirst(new ParkingInfo(LocalDateTime.now()));
        }
    }

    public void out(Car car) {
        if (cars.remove(car)) {
            LinkedList<ParkingInfo> parkingInfo = parkingInfoMap.get(car.getId());
            ParkingInfo info = parkingInfo.getFirst();
            info.setOut(LocalDateTime.now());
        }
    }

    public long countByDate(LocalDate date) {
        return parkingInfoMap.values().stream()
                .flatMap(LinkedList::stream)
                .filter(x -> x.getInto().compareTo(date.atStartOfDay()) >= 0)
                .filter(x -> x.getOut().isBefore(date.plusDays(1).atStartOfDay()))
                .count();
    }
}


