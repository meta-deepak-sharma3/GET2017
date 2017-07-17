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
public class PyramidTest {
    
    enum Type{NUMBER, SPACE};
    // {Input 1, Input 2, Expected Output};
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {Type.SPACE, 1,1, "" }, {Type.SPACE, 1, 3, "  " }, {Type.SPACE, 2, 4, " " }, {Type.NUMBER, 1, 5, "1" }, {Type.NUMBER, 2, 5, "121"}, {Type.NUMBER, 6, 5, "1234321"}});
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
	PyramidClass pc = new PyramidClass();
        assertEquals(fExpected, pc.space(fInput_1, fInput_2));
    }

    @Test
    public void testNumber() {
	Assume.assumeTrue(type == Type.NUMBER);
	PyramidClass pc = new PyramidClass();
        assertEquals(fExpected, pc.number(fInput_1, fInput_2));
    }

}