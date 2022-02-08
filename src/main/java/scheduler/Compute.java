package scheduler;

import java.util.Collection;

public interface Compute<T> {
    String compute(T arg);
}
