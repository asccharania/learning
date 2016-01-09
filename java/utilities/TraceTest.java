package utilities;

public class TraceTest {
    public static void main (String[] args) {
        utilities.Trace.showCallTree(true);
        utilities.Trace.graphvizRemoveGvFiles (true);
        utilities.Trace.showBoxedPrimitivesAsPrimitive (false);
        utilities.Trace.showStringsAsPrimitive (false);
        utilities.Trace.graphvizShowBoxedPrimitivesSimply (false);
        utilities.Trace.graphvizShowFieldNamesInLabels (false);
        utilities.Trace.setGraphizOutputFilenamePrefixRelativeToUserHome ("Desktop/test-");
        utilities.Trace.graphvizShowSteps (true);
        utilities.Trace.run (utilities.TraceTestExample.class);
        utilities.Trace.setGraphizOutputFilenamePrefixRelativeToUserHome ("Desktop/counter-");
        utilities.Trace.run (algs12.Counter.class);
        utilities.Trace.setGraphizOutputFilenamePrefixRelativeToUserHome ("Desktop/date-");
        utilities.Trace.run (algs12.Date.class);
    }
}
