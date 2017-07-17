import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Pattern2Test {
    
    enum Type{NUMBER, SPACE};
    // {Input 1, Input 2, Expected Output};
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {Type.SPACE, 1,1, "" }, {Type.SPACE, 1, 3, "" }, {Type.SPACE, 3, 4, "  " }, {Type.NUMBER, 2, 5, "1234" }, {Type.NUMBER, 2, 3, "12"}, {Type.NUMBER, 1, 5, "12345"}});
    }

    @Parameter // first data value (0) is default
    public /* NOT private */ Type type;

    @Parameter(1)
    public /* NOT private */ int fInput_1;

    @Parameter(2)
    public int fInput_2;

    @Parameter(3)
    public String fExpected;    

    @Test
    public void testSpace() {
	Assume.assumeTrue(type == Type.SPACE);
	Pattern2Class pc = new Pattern2Class();
        assertEquals(fExpected, pc.space(fInput_1, fInput_2));
    }

    @Test
    public void testNumber() {
	Assume.assumeTrue(type == Type.NUMBER);
	Pattern2Class pc = new Pattern2Class();
        assertEquals(fExpected, pc.number(fInput_1, fInput_2));
    }

}
