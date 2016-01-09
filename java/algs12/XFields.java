package algs12;

import stdlib.StdRandom;

public class XFields {
    public static int classVariable = 42;
    
    public int objectVariable = classVariable++;
    
    public void f(int localVariable1) {
        int localVariable2 = StdRandom.uniform (100);
        if (localVariable1 > 0)
            f (localVariable1 - 1);
    }
    
    public static void main (String[] args) {
        utilities.Trace.graphvizShowSteps (true);
        utilities.Trace.run ();
        
        XFields a = new XFields ();
        XFields b = new XFields ();
        
        a.f(1);
        b.f(1);
    }

}
