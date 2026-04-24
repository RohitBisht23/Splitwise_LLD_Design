package Factory;

import Enums.SplitType;
import strategy.SplitStrategy;
import strategy.EqualStrategy;
import strategy.PercentageStrategy;
public class FactoryStrategy {
    public static SplitStrategy getSplitStrategy(SplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualStrategy();
            case PERCENTAGE:
                return new PercentageStrategy();
            default:
                throw new IllegalArgumentException("Invalid split type");
        }
    }
}
