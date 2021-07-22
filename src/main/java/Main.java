import org.junit.Assert;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService();

        parkingService.parkingInfoMap.put("", new LinkedList<>(Arrays.asList(
                new ParkingInfo(LocalDate.now().plusDays(1).atStartOfDay().minusHours(30 + new Random().nextInt(16)), LocalDate.now().plusDays(1).atStartOfDay().minusHours(25 + new Random().nextInt(5))),
                new ParkingInfo(LocalDate.now().plusDays(1).atStartOfDay().minusHours(30 + new Random().nextInt(16)), LocalDate.now().plusDays(1).atStartOfDay().minusHours(25 + new Random().nextInt(5))),
                new ParkingInfo(LocalDate.now().plusDays(1).atStartOfDay().minusHours(30 + new Random().nextInt(16)), LocalDate.now().plusDays(1).atStartOfDay().minusHours(25 + new Random().nextInt(5))),
                new ParkingInfo(LocalDate.now().plusDays(1).atStartOfDay().minusHours(30 + new Random().nextInt(16)), LocalDate.now().plusDays(1).atStartOfDay().minusHours(25 + new Random().nextInt(5))),
                new ParkingInfo(LocalDate.now().plusDays(1).atStartOfDay().minusHours(30 + new Random().nextInt(16)), LocalDate.now().plusDays(1).atStartOfDay().minusHours(25 + new Random().nextInt(5))),
                new ParkingInfo(LocalDate.now().plusDays(1).atStartOfDay().minusHours(30 + new Random().nextInt(16)), LocalDate.now().plusDays(1).atStartOfDay().minusHours(25 + new Random().nextInt(5)))
        )));

        Assert.assertEquals(parkingService.carsCount(), 0);

        Car ourCar = new Car("n" + new Random().nextInt(), false);

        parkingService.into(ourCar);

        Assert.assertEquals(parkingService.carsCount(), 1);

        Assert.assertEquals(parkingService.countByFirma(), 0);

        parkingService.into(new Car(ourCar.getId(), ourCar.isFirma()));

        Assert.assertEquals(parkingService.carsCount(), 1);

        Assert.assertEquals(parkingService.countByFirma(), 0);

        parkingService.out(ourCar);

        Assert.assertEquals(parkingService.carsCount(), 0);

        Assert.assertEquals(parkingService.countByFirma(), 0);

        Assert.assertEquals(parkingService.countByDate(LocalDate.now()), 1);

        Assert.assertEquals(parkingService.countByDate(LocalDate.now().minusDays(1)), 6);

        Car firmaCar = new Car("a" + new Random().nextInt(), true);

        parkingService.into(firmaCar);

        Assert.assertEquals(parkingService.countByFirma(), 1);
    }
}
