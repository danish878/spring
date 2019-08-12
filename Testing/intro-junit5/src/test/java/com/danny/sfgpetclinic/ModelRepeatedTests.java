package com.danny.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        String message = String.format("Running Test - %s - %s | %s", testInfo.getDisplayName(),
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions());
        System.out.println(message);
    }
}
