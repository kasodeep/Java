package Interview;

import java.util.HashMap;
import java.util.Map;

enum LoyaltyLevel {

    BRONZE(0.02, 1),
    SILVER(0.05, 1.5),
    GOLD(0.1, 2),
    PLATINUM(0.15, 2.5);

    private final double discount;
    private final double pointsMultiplier;

    LoyaltyLevel(double discount, double pointsMultiplier) {
        this.discount = discount;
        this.pointsMultiplier = pointsMultiplier;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPointsMultiplier() {
        return pointsMultiplier;
    }
}

class LoyaltyProgram {

    private static final Map<String, Double> discountMap = new HashMap<>();
    private static final Map<String, Double> pointsMultiplierMap = new HashMap<>();

    static {
        discountMap.put("BRONZE", 0.02);
        discountMap.put("SILVER", 0.05);
        discountMap.put("GOLD", 0.1);
        discountMap.put("PLATINUM", 0.15);

        pointsMultiplierMap.put("BRONZE", 1.0);
        pointsMultiplierMap.put("SILVER", 1.5);
        pointsMultiplierMap.put("GOLD", 2.0);
        pointsMultiplierMap.put("PLATINUM", 2.5);
    }

    public static double getDiscount(String level) {
        return discountMap.getOrDefault(level, 0.0);
    }

    public static double getPointsMultiplier(String level) {
        return pointsMultiplierMap.getOrDefault(level, 1.0);
    }
}

public class EnumVsMaps {

    public static void main(String[] args) {
        LoyaltyLevel loyaltyLevel = LoyaltyLevel.BRONZE;
        System.out.println(loyaltyLevel + " Discount " + loyaltyLevel.getDiscount());

        String bronze = "BRONZE";
        System.out.println(LoyaltyProgram.getDiscount(bronze));
    }
}


