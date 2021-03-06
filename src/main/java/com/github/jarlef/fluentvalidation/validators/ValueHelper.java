package com.github.jarlef.fluentvalidation.validators;

import java.util.Collection;
import java.util.Collections;

class ValueHelper {

    static int getLength(Object value) {

        if(value == null) {
            return 0;
        }

        if(value instanceof String) {
            String s = (String) value;
            return s.length();
        }

        if(value instanceof Collections) {
            Collection s = (Collection) value;
            return s.size();
        }

        return value.toString().length();
    }
}
