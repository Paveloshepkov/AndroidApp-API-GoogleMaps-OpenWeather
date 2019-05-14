package com.example.tewotv0.Templates.Interfaces;

public interface IServiceBuilder<T> {
    T createService(String url);
}