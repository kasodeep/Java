package Interview;

import java.util.UUID;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        for (int i = 0; i < 5; i++) {
            UUID uuid = uuidSupplier.get();
            System.out.println("Generate UUID: " + uuid);
        }
    }
}
