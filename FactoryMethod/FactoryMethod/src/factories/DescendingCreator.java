package factories;

import sorters.ArraySorter;
import sorters.DescendingSorter;

public class DescendingCreator extends SorterFactory {
    @Override
    public ArraySorter createSorter() {
        return new DescendingSorter();
    }
}
