package adpro.b10.epicarcade_functional.jualbeli.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    SUCCESS("SUCCESS"),
    CANCELLED("CANCELLED");

    private final String value;

    private OrderStatus(String value) {
        this.value = value;
    }

    public static boolean contains(String param) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.value.equals(param)) {
                return true;
            }
        }
        return false;
    }
}