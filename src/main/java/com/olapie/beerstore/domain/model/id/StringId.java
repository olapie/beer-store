package com.olapie.beerstore.domain.model.id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

public abstract class StringId {
    private final String value;

    public StringId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(value, ((StringId) obj).value);
    }

    @Override
    public String toString() {
        return value;
    }
}
