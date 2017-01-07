/*
 *  (c) 2013 Michael A. Beck, disco | Distributed Computer Systems Lab
 *                                  University of Kaiserslautern, Germany
 *         All Rights Reserved.
 *
 *  This software is work in progress and is released in the hope that it will
 *  be useful to the scientific community. It is provided "as is" without
 *  express or implied warranty, including but not limited to the correctness
 *  of the code or its suitability for any particular purpose.
 *
 *  You are free to use this software for any non-commercial educational or
 *  research purpose, provided that this copyright notice is not removed or
 *  modified. For commercial uses please contact the respective author(s).
 *
 *  If you find our software useful, we would appreciate if you mentioned it
 *  in any publication arising from the use of this software or acknowledge
 *  our work otherwise. We would also like to hear of any fixes or useful
 *  extensions to this software.
 *
 */
package unikl.disco.calculator.symbolic_math;

import unikl.disco.calculator.SNC;
import unikl.disco.calculator.symbolic_math.functions.ConstantFunction;
import unikl.disco.calculator.symbolic_math.functions.ExponentialSigma;

/**
 * A class which builds appropriate (sigma, rho) representations based on the respective arrival parameters.
 * Each arrival type (described in @link ArrivalType) has its own function, thus a new ArrivalType has to be added here as well.
 * @author Sebastian Henningsen
 */
public class ArrivalFactory {
    public static Arrival buildConstantRate(double rate) {
        SymbolicFunction rho = new ConstantFunction(rate);
        SymbolicFunction sigma = new ConstantFunction(0);
        return new Arrival(sigma, rho, SNC.getInstance().getCurrentNetwork());
    }
    
    public static Arrival buildExponentialRate(double rate) throws BadInitializationException {
        SymbolicFunction rho = new ExponentialSigma(rate);
        SymbolicFunction sigma = new ConstantFunction(0);
        return new Arrival(sigma, rho, SNC.getInstance().getCurrentNetwork());
    }
    
    public static Arrival buildPoissonRate() {
        SymbolicFunction sigma = new ConstantFunction(0);
        SymbolicFunction rho = null; // TODO: Fix this.
        return new Arrival(sigma, rho, SNC.getInstance().getCurrentNetwork());
    }
}
