package deus.inside

import java.util.*
import kotlin.collections.ArrayList

class Brain (private val internalView: BitSet?,
             private val sensoryMaps: ArrayList<BitSet>?,
            private val threshold: Int){
    var newInternalView = BitSet()

    fun learn(sensoryInput: BitSet) {
        imprint(sensoryInput) // transforming from one dimension of BitSet to another (smaller, same or larger)
        //compareToWhatIsLearned(); // compare the new data with the predicted data of the previous step
        //predict(); // predict the next step of the input set.
        // unImprint(); // tranfrom from the second dimension to the first again
    }

    private fun imprint(sensoryInput: BitSet) {
        val representation = transformDimensions(sensoryInput)
        //updateMapping(representation, internalView);
    }

    private fun transformDimensions(sensoryInput: BitSet): BitSet? {
        // transform dimensions using a map BitSet for each BitIndex; (i.e. Column)
        this.newInternalView = BitSet()
        internalView!!.stream().forEach { column: Int -> updateInternalView(sensoryInput, column) }
        return null
    }

    private fun updateInternalView(sensoryInput: BitSet, column: Int) {
        val map = sensoryMaps!![column]
        val sensoryInput_clone = sensoryInput.clone() as BitSet
        sensoryInput_clone.and(map)
        if (sensoryInput_clone.cardinality() > threshold) newInternalView.set(column)
    }
}