package algs11;

// If you set 
//
//   utilities.Trace.graphvizShowSteps (true);
//
// then you will get a drawing for every step of your program.
// If you only want to see a few specific places, you can add
//
//   utilities.Trace.draw ();
//
// to your code in the places you want a drawing made.
// If you start your program normally, the call to Trace.draw will do nothing.
// However, if start the program with Trace.run, then the call Trace.draw
// will result in a graphviz file being generated.

public class XRunTrace {
    public static void main (String[] args) {
        utilities.Trace.setGraphizOutputFilenamePrefixRelativeToUserHome ("Desktop/trace-");
        utilities.Trace.graphvizShowSteps (true);
//        utilities.Trace.consoleShowStepsVerbose (true);
//        utilities.Trace.showBoxedPrimitivesAsPrimitive (false);
//        utilities.Trace.showStringsAsPrimitive (false);
//        utilities.Trace.graphvizShowBoxedPrimitivesSimply (false);
//        utilities.Trace.graphvizShowFieldNamesInLabels (false);
        
//        utilities.Trace.run (BinarySearch.class);
//        utilities.Trace.run (algs12.YRecursiveRectangles.class);
//        utilities.Trace.run (algs13.XFixedCapacityStack.class);
//        utilities.Trace.run (algs13.XFixedCapacityStackOfStrings.class);
        utilities.Trace.run (algs13.Stack.class);
    }
}
