/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package experimento;

import java.io.Serializable;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/**
 * Representation of the fractional numbers field.
 * <p>
 * This class is a singleton.
 * </p>
 * @see Fraction
 * @version $Id: FractionField.java 1416643 2012-12-03 19:37:14Z tn $
 * @since 2.0
 */
public class FractionField implements Field<Fraction>, Serializable  {

    /** Serializable version identifier */
    private static final long serialVersionUID = -1257768487499119313L;

    /** Private constructor for the singleton.
     */
    private FractionField() {
    }

    /** Get the unique instance.
     * @return the unique instance
     */
    public static FractionField getInstance() {
        return LazyHolder.INSTANCE;
    }

    /** {@inheritDoc} */
    public Fraction getOne() {
        return Fraction.ONE;
    }

    /** {@inheritDoc} */
    public Fraction getZero() {
        return Fraction.ZERO;
    }

    /** {@inheritDoc} */
    public Class<? extends FieldElement<Fraction>> getRuntimeClass() {
        return Fraction.class;
    }
    // CHECKSTYLE: stop HideUtilityClassConstructor
    /** Holder for the instance.
     * <p>We use here the Initialization On Demand Holder Idiom.</p>
     */
    private static class LazyHolder {
        /** Cached field instance. */
        private static final FractionField INSTANCE = new FractionField();
    }
    // CHECKSTYLE: resume HideUtilityClassConstructor

    /** Handle deserialization of the singleton.
     * @return the singleton instance
     */
    private Object readResolve() {
        // return the singleton instance
        return LazyHolder.INSTANCE;
    }

}
