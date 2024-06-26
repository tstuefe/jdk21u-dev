/*
 * Copyright (c) 2017, 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */


/*
 * @test
 * @key stress randomness
 *
 * @summary converted from VM Testbase gc/gctests/LargeObjects/large002.
 * VM Testbase keywords: [gc, stress, stressopt, nonconcurrent]
 * VM Testbase readme:
 * DESCRIPTION
 *     The test checks that Garbage Collector correctly does not throw any
 *     unexpected exceptions/errors while allocating large objects (classes
 *     that have more than 65535 fields and classes that have less than 65535
 *     fields). 65535 of fields is a limitation for JVM (see JVM specification
 *     Second edition 4.10).
 *     Since it is impossible to create one class with about 65535 of fields
 *     (javac cannot compile it), a child class extends a parent class, so the
 *     fields are devided into two subsets. However, the child class still has
 *     about 65535 of fields.
 *     The test starts a number of threads. This number is either set in *.cfg
 *     file or is calculated by the test itself based on the machine (see
 *     nsk.share.gc.Algorithms.getThreadsCount() method). As soon as all threads
 *     are started, each thread begins its checking.
 *     There are 13 classes to be loaded by each thread. These classes are
 *     generated by nsk.share.gc.Generator (see its javadoc for more details).
 *     Each class has a huge number of fields, and the number of fields is more than
 *     the JVM limitation.
 *     The test loads the classes with nsk.share.gc.GCClassUnloader class that
 *     extends nsk.share.ClassUnloader and has a bit different algorith of eating
 *     heap. As soon as a class is loaded, the test creates an instance of
 *     it - allocates an object of that type. Then it drops references to the
 *     class and to the instance and tries to unload the class. The test does not
 *     expect any exceptions to be thrown.
 *
 * @library /vmTestbase
 *          /test/lib
 *
 * @comment generate and compile nsk.share.gc.newclass.* classes
 * @run driver nsk.share.gc.GenClassesBuilder
 *
 * @run main/othervm/timeout=300
 *      -XX:-UseGCOverheadLimit
 *      gc.gctests.LargeObjects.large001.large001
 *      -largeClassesPath classes
 *      -isOverLimitFields true
 *      -aggregationDepth 0
 *      -t 1
 */

