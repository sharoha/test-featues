package scheduler;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task implements Compute<Integer> {
    private final Logger log = Logger.getLogger(Task.class.getName());
    @Override
    public String compute(Integer arg) {
        log.log(Level.INFO, String.format("Computing factorial of : %d", arg));
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= arg; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial.toString();
    }
}
