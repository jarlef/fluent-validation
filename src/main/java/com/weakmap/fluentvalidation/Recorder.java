package com.weakmap.fluentvalidation;

@SuppressWarnings("all")
class Recorder<T> {

    private T t;
    private RecordingObject recorder;

    Recorder(T t, RecordingObject recorder) {
        this.t = t;
        this.recorder = recorder;
    }

    String getCurrentPropertyName() {
        return recorder.getCurrentPropertyName();
    }

    T getObject() {
        return t;
    }
}