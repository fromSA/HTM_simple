package deus

import deus.inside.Creature
import deus.outside.DataStream
import deus.inside.Brain
import deus.inside.Eye
import java.util.*
import kotlin.collections.ArrayList

/**
 * Hello world!
 */
object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val source = DataStream();
        val brahman = Creature(brain = Brain(BitSet(0), ArrayList(0), 0),
                eye = Eye());
        brahman.observe(source.next());
        val set = BitSet(4)
        set.set(0)
        set.set(2)
        set.stream().forEach { x: Int -> println(x) }
        /*for (int i = 0; i < set.size(); i = set.nextSetBit(i+1)) {
            System.out.println(i);

        }*/
    }
}