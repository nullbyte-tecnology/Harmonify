package com.harmonify.backspring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
class BackSpringApplicationTest {

  @Test
  void testMain(CapturedOutput output) {

    BackSpringApplication.main(new String[]{});

    assertTrue(output.toString().contains("Started BackSpringApplication"));
  }
}
