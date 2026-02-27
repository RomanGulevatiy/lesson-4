package org.example.lesson4.constant;

import lombok.NoArgsConstructor;

/**
 * Created by Roman Gulevatiy on 27.02.2026.
 * github github.com/gulevatiy-roman
 */
@NoArgsConstructor
public class ValidationConstant {

    public static final class Student {
        public static final int NAME_MIN = 3;
        public static final int NAME_MAX = 50;
        public static final String NAME_REQUIRED_MESSAGE = "Name is required";
        public static final String NAME_SIZE_MESSAGE = "Name must contain between {min} and {max} characters";

        public static final int AGE_MIN_VALUE = 16;
        public static final String AGE_REQUIRED_MESSAGE = "Age is required";
        public static final String AGE_SIZE_MESSAGE = "Age must be greater than or equal to {value}";

        public static final int COURSE_MIN_VALUE = 1;
        public static final int COURSE_MAX_VALUE = 6;
    }
}
