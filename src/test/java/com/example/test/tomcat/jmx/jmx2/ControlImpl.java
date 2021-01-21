package com.example.test.tomcat.jmx.jmx2;

public class ControlImpl implements ControlImplMBean {
    private ControlTarget target;

    public ControlImpl(ControlTarget target) {
        this.target = target;
    }

    @Override
    public long getLength() {
        return target.getLength();
    }

    @Override
    public long getWidth() {
        return target.getWidth();
    }

    @Override
    public long getArea() {
        return target.getLength() * target.getWidth();
    }

    @Override
    public double getLengthWidthRatio() {
        return  target.getLength() * 1.0f / target.getWidth();
    }
}

