package com.example.formula_keyboard.ui.keyboard;

import com.example.formula_keyboard.R;

public class KeyboardData {
    public static int KEYBOARD_LENGTH = 4;

    public static int KEYBOARD_CALCULATOR = 1;
    public static int KEYBOARD_UNIT = 2;
    public static int KEYBOARD_HIGH_SCHOOL = 3;
    public static int KEYBOARD_ALPHABET = 4;


    public static final String[] KEYBOARD_STRING = {
            "KeyboardCalculator", "KeyboardUnit", "KeyboardHighSchool", "KeyboardAlphabet"
    };
    public static final int[] KEYBOARD_INT = {
            KEYBOARD_CALCULATOR, KEYBOARD_UNIT, KEYBOARD_HIGH_SCHOOL, KEYBOARD_ALPHABET
    };

    public static final int[] KEYBOARD_XML = {
            R.xml.keyboard_calculator, R.xml.keyboard_unit, R.xml.keyboard_high_school, R.xml.keyboard_alphabet_lower_case
    };
    public static final int[] KEYBOARD_IMAGE = {
            R.drawable.keyboard_calculator, R.drawable.keyboard_unit, R.drawable.keyboard_high_school, R.drawable.keyboard_alphabet_lower_case
    };

    public static final int[] KEYBOARD_XML_SHIFT = {
            -1, -1, -1, R.xml.keyboard_alphabet_upper_case
    };
    public static final int[] KEYBOARD_IMAGE_SHIFT = {
            -1, -1, -1, R.drawable.keyboard_alphabet_upper_case
    };

}
