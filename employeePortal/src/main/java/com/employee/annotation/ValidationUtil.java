package com.employee.annotation;

import io.micrometer.common.util.StringUtils;

public class ValidationUtil {
    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank((String) cs);
    }
}
