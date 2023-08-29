package io.littlehorse.sdk.common.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoField;
import org.junit.jupiter.api.Test;

public class TokenStatusTest {

    @Test
    void getExpirationIsNonNull() {
        assertThrows(NullPointerException.class, () -> TokenStatus.builder()
                .clientId("my-client")
                .token("my-token")
                .build());
    }

    @Test
    void getExpired() {
        TokenStatus status = TokenStatus.builder()
                .clientId("my-client")
                .token("my-token")
                .expiration(Instant.MIN)
                .build();
        assertTrue(status.isExpired());
    }

    @Test
    void isExpiredIfNowAndExpirationAreTheSame() {
        TokenStatus status = TokenStatus.builder()
                .clientId("my-client")
                .token("my-token")
                .expiration(Instant.now())
                .build();
        assertTrue(status.isExpired());
    }

    @Test
    void truncatesToSeconds() {
        TokenStatus status = TokenStatus.builder()
                .clientId("my-client")
                .token("my-token")
                .expiration(Instant.now())
                .build();
        assertEquals(status.getExpiration().get(ChronoField.MILLI_OF_SECOND), 0);
    }

    @Test
    void getNotExpired() {
        TokenStatus status = TokenStatus.builder()
                .clientId("my-client")
                .token("my-token")
                .expiration(Instant.MAX)
                .build();
        assertFalse(status.isExpired());
    }
}
