package com.lightstep.tracer.metrics;

import static org.junit.Assert.*;

import org.junit.Test;

public class MetricsProviderImplTest {
  @Test
  public void test() {
    final MetricsProviderImpl provider = new MetricsProviderImpl();
    final SafeMetricsImpl safeMetrics = (SafeMetricsImpl)provider.create();
    assertNotNull(safeMetrics);

    final Thread metricsThread = safeMetrics.createMetricsThread("", "", "v1", "https://localhost", 464);
    assertNotNull(metricsThread);
    assertNotSame(metricsThread, safeMetrics.createMetricsThread("", "", "v1", "https://localhost", 464));
  }
}
