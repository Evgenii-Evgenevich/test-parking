import java.util.Objects;

public class Car {
    private String id;
    private boolean firma;

    public Car(String id, boolean firma) {
        this.id = id;
        this.firma = firma;
    }

    public String getId() {
        return id;
    }

    public boolean isFirma() {
        return firma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
