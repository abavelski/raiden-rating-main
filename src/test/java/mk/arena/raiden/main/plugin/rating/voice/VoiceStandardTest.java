package mk.arena.raiden.main.plugin.rating.voice;

import mk.arena.raiden.api.bean.rating.RatingRequest;
import mk.arena.raiden.main.plugin.rating.RatingPlugin;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

/**
 * User: aba
 * Date: 6/9/13
 */
public class VoiceStandardTest {

    private RatingPlugin voice;
    private RatingRequest request;

    @Before
    public void setup() {
        voice = new VoiceStandard();
        request = new RatingRequest();
    }

    @Test
    public void testZeroSeconds() throws Exception {
        request.setAmount(0);
        assertEquals(BigDecimal.ZERO, voice.calculatePrice(request, BigDecimal.valueOf(0.29)));
    }

    @Test
    public void testRoundingToMinute() throws Exception {
        request.setAmount(2);
        assertEquals(BigDecimal.valueOf(0.29), voice.calculatePrice(request, BigDecimal.valueOf(0.29)));
    }

    @Test
    public void testFullMinute() throws Exception {
        request.setAmount(60);
        assertEquals(BigDecimal.valueOf(0.29), voice.calculatePrice(request, BigDecimal.valueOf(0.29)));
    }

}
