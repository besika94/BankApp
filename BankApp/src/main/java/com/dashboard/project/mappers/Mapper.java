package com.dashboard.project.mappers;

public interface Mapper<A,B> {
    B mapTo(A a);

    A mapFrom(B b);
}
