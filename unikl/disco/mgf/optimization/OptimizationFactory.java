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

package unikl.disco.mgf.optimization;

import unikl.disco.mgf.Arrival;
import unikl.disco.mgf.network.AbstractAnalysis;
import unikl.disco.mgf.network.Network;

/**
 *
 * @author Sebastian Henningsen
 */
public class OptimizationFactory {
    
    public static AbstractOptimizer getOptimizer(Network nw, Arrival bound, AbstractAnalysis.Boundtype boundtype, OptimizationType type) {
        switch(type) {
            case SIMPLE_OPT:
                return new SimpleOptimizer(bound, boundtype, nw);
            case GRADIENT_OPT:
                return new SimpleGradient(bound, boundtype, nw);
            default:
                throw new IllegalArgumentException("Optimization Type: " + type.toString() + " not known.");
        }
    }
}