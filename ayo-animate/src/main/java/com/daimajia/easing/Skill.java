/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.daimajia.easing;

import com.daimajia.easing.back.BackEaseInOut;
import com.daimajia.easing.back.BackEaseOut;
import com.daimajia.easing.bounce.BounceEaseOut;
import com.daimajia.easing.circ.CircEaseInOut;
import com.daimajia.easing.circ.CircEaseOut;
import com.daimajia.easing.cubic.CubicEaseIn;
import com.daimajia.easing.cubic.CubicEaseInOut;
import com.daimajia.easing.linear.Linear;
import com.daimajia.easing.quad.QuadEaseIn;
import com.daimajia.easing.quint.QuintEaseOut;
import com.daimajia.easing.sine.SineEaseIn;
import com.daimajia.easing.sine.SineEaseOut;


public enum  Skill {

    BackEaseIn(com.daimajia.easing.back.BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(com.daimajia.easing.bounce.BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(com.daimajia.easing.bounce.BounceEaseInOut.class),

    CircEaseIn(com.daimajia.easing.circ.CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(com.daimajia.easing.cubic.CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(com.daimajia.easing.elastic.ElasticEaseIn.class),
    ElasticEaseOut(com.daimajia.easing.elastic.ElasticEaseOut.class),

    ExpoEaseIn(com.daimajia.easing.expo.ExpoEaseIn.class),
    ExpoEaseOut(com.daimajia.easing.expo.ExpoEaseOut.class),
    ExpoEaseInOut(com.daimajia.easing.expo.ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(com.daimajia.easing.quad.QuadEaseOut.class),
    QuadEaseInOut(com.daimajia.easing.quad.QuadEaseInOut.class),

    QuintEaseIn(com.daimajia.easing.quint.QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(com.daimajia.easing.quint.QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(com.daimajia.easing.sine.SineEaseInOut.class),

    Linear(Linear.class);


    private Class easingMethod;

    private Skill(Class clazz) {
        easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod)easingMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
