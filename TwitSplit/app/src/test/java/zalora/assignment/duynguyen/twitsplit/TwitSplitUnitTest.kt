package zalora.assignment.duynguyen.twitsplit

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class TwitSplitUnitTest {

    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    @Throws(Exception::class)
    fun splitMessage_isCorrect() {
        val msg = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
        val msg1 = "1/2 I can't believe Tweeter now supports chunking"
        val msg2 = "2/2  my messages, so I don't have to do it myself."
        val expectSize = 2
        val msgList = Utils.splitMessage(msg)
        assertEquals(expectSize, msgList.size)
        assertEquals(msg1, msgList.get(0))
        assertEquals(msg2, msgList.get(1))
    }
}