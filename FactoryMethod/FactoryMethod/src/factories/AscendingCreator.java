package factories;

import sorters.ArraySorter;
import sorters.AscendingSorter;

public class AscendingCreator extends SorterFactory {
    @Override
    public ArraySorter createSorter() {
        return new AscendingSorter();
    }
}
