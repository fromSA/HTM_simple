package deus.inside

class Creature (private val brain: Brain, private val eye: Sense){
    fun observe(value: Int) {
        brain.learn(eye.input(value))
    }

}