package zalora.assignment.duynguyen.twitsplit

import android.widget.Toast
import java.util.ArrayList

/**
 * Created by DUY on 4/1/2018.
 */

public object Utils {

    public fun splitMessage(message: String): ArrayList<String> {
        var oldString = StringBuilder(message)

        val chunkedString = arrayListOf<String>()
        if (!oldString.substring(0, 50).contains(" ")) {
            return chunkedString
        } else {
            val total = oldString.length / 50 + 1
            var count = 1
            oldString = oldString.insert(0, "$count/$total ")
            while (count < total) {
                for (i in 50 downTo 0) {
                    if (oldString.get(i).compareTo(' ') == 0) {
                        chunkedString.add(oldString.substring(0, i))
                        oldString.delete(0, i).insert(0, "${++count}/$total ")
                        break
                    }
                }
            }

            chunkedString.add(oldString.toString())
        }
        return chunkedString
    }
}
