package com.heller.interpreter;

import java.util.Map;

public abstract class Expression {
    abstract int interpreter(Map<String, Integer> var);
}
