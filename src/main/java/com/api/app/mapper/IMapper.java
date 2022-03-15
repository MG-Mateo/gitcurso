package com.api.app.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
